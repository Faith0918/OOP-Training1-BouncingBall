package server;

import java.awt.Color;
import java.awt.event.ActionListener;

public class ClientCore {
	
	private	ButtonView	view;
	private	ActionListener	Listener;
	private	ClientSocketConnector	socket;
	
	public ClientCore() {
		view = new ButtonView();
		Listener = new ButtonListener(this);
		socket = new ClientSocketConnector();
		
		start();
	}
	
	private void start() {
		view.addListener(Listener);
		view.setGroupNames(socket.getGroupNameList());
		view.showView();
		
	}

	public static void main(String[] args) {
		ClientCore core = new ClientCore();
	}
	public void startMove() {
		
		socket.send("start", view.getGroupColor());
		
	}
	public void stopMove() {
		socket.send("stop", view.getGroupColor());
		
	}
	public void addBall() {
		socket.send("add", view.getGroupColor());
		
	}
	public void removeBall() {
		socket.send("remove", view.getGroupColor());
		
	}
	public void setGroupColor() {
		view.setNewGroupColor();
		
	}
	public void setNewGroupName() {
		view.setNewGroupName();
		
	}
	public void addGroup() {
		String newGroupName = view.getNewGroupName();
		Color	newGroupColor = view.getNewGroupColor();
		if(newGroupName != null&&newGroupColor!=null) {
		
		socket.send("addGroup",newGroupName,newGroupColor.getRGB());
		view.resetGroupNames(socket.getGroupNameList());
		view.clearNewGroupColor();
		view.clearNewGroupName();
		}
		
	}
	public void removeGroup() {
		socket.send("removeGroup", view.getGroupColor());
		view.resetGroupNames(socket.getGroupNameList());
	}

	
}
