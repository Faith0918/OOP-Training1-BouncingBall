package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	private	ClientCore	core;
	public	ButtonListener(ClientCore core) {
		this.core = core;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("start")) {
			core.startMove();
		}
		if(e.getActionCommand().equals("stop")) {
			core.stopMove();
		}
		if(e.getActionCommand().equals("add")) {
			core.addBall();
		}
		if(e.getActionCommand().equals("remove")) {
			core.removeBall();
		}
		if(e.getActionCommand().equals("groupColor")) {
			core.setGroupColor();
		}
		if(e.getActionCommand().equals("groupName")) {
			core.setNewGroupName();
		}
		if(e.getActionCommand().equals("addGroup")) {
			core.addGroup();
		}
		if(e.getActionCommand().equals("removeGroup")) {
			core.removeGroup();
		}
	}
}
