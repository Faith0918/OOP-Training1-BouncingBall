package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;



public class ServerSocketConnector extends Thread{
	private ServerCore core;
	private ServerSocket	serverSocket;
	private	Socket	socket;
	private BufferedReader in;
	private	PrintWriter	out;
	private XMLManager	xmlParser;
	public ServerSocketConnector(ServerCore core) {
		this.core = core;
		xmlParser = new XMLManager();
		try {
			serverSocket = new ServerSocket(8000);
            
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("run");
			try {
				
				socket = serverSocket.accept();
				System.out.println("connect with client");
				
				in = new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	                    
				out = new PrintWriter(socket.getOutputStream());
				
				LinkedList<String> initialKeys = core.getGroupNames();
				send(initialKeys);
				

				
				while(true) {
				if(in!=null) {
					String string = in.readLine();
					while(in.ready()) {
						string = string.concat(in.readLine());
						System.out.println("in.ready()");
						System.out.println(string);
						string = string.replaceAll(System.getProperty("line.separator"),"");
					}	
					System.out.println(string+"+");
					xmlParser.xmlToCommand(string);
					
					
					if(xmlParser.getCommand().getCommandName().equals("start")) {
						core.startMove(xmlParser.getCommand().getGroupName());
					}
					if(xmlParser.getCommand().getCommandName().equals("stop")) {
						core.stopMove(xmlParser.getCommand().getGroupName());
					}
					if(xmlParser.getCommand().getCommandName().equals("add")) {
						core.addBall(xmlParser.getCommand().getGroupName());
					}
					if(xmlParser.getCommand().getCommandName().equals("remove")) {
						core.removeBall(xmlParser.getCommand().getGroupName());
					}
					if(xmlParser.getCommand().getCommandName().equals("removeGroup")) {
						core.removeGroup(xmlParser.getCommand().getGroupName());
					}
					if(xmlParser.getCommand().getCommandName().equals("addGroup")) {
						core.addGroup(xmlParser.getCommand().getNewGroupName(),xmlParser.getCommand().getNewGroupColor());
					}
						
					
					
				}
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
				
				}
			
		}catch (IOException e1) {
			System.out.println("server exception");
			e1.printStackTrace();
		}
	}

	public void send(LinkedList<String> groupNames) {
		LinkedList<String> keys = groupNames;
		String	command = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><command>";
		for(int i=0; i<keys.size();i++) {
			command = command.concat("<groupName>").concat(keys.get(i)).concat("</groupName>");
		}
		command = command.concat("</command>");
		String xml = command;
		
		out.println(xml);
		out.flush();
		
	}
}
