package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;



public class ClientSocketConnector {
	
	private XMLManager xmlManager;
	private XMLXpathParser parser;
	private	Socket	socket;
	private BufferedReader in;
    private PrintWriter out;
    
	public ClientSocketConnector() {
		parser = new XMLXpathParser();
		xmlManager= new XMLManager();
		try {
            // 서버에 요청 보내기
        	String ip="127.0.0.1";
        	int	port=8000;
            socket = new Socket(ip, port);
            

            // 통로 뚫기
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            
            

        } catch (IOException e) {
//            System.out.println(e.getMessage());
        }
		 
	}

	public void send(String string, String newGroupName, int newGroupColor) {
		  String command = null;
		  command = xmlManager.generateXML(string, newGroupName,Integer.toString(newGroupColor));
	      out.println(command);
	      out.flush();
		
	}

	public void send(String string, String groupColor){
		  if(groupColor.length()>0) {
			  String command = null;
			  command = xmlManager.generateXML(string, groupColor);
			  out.println(command);
		      out.flush();
		  }
	}
	
	public LinkedList<String> getGroupNameList() {
		LinkedList<String> groupNameList = new LinkedList<String>();
		try {
			String string = in.readLine();
			while(in.ready()) {
				string = string.concat(in.readLine());
				string = string.replaceAll(System.getProperty("line.separator"),"");
			}
			parser.putXML(string);
			groupNameList=parser.getGroupNameList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return groupNameList;
	}

}
