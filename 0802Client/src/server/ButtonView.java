package server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;

public class ButtonView {
	private	JFrame	frame;
	private	ButtonPanel	buttonPanel;
	
	public ButtonView() {
		frame = new JFrame();
		buttonPanel = new ButtonPanel();
		frame.setSize(900, 80);;
		frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}

	public void addListener(ActionListener listener) {
		buttonPanel.addActionListener(listener);
		
	}

	public void showView() {
		frame.setVisible(true);
		
	}

	public void setNewGroupColor() {
		buttonPanel.setNewGroupColor();
		
	}

	public void setNewGroupName() {
		buttonPanel.setNewGroupName();
		
	}

	public void addNewGroup() {
		buttonPanel.addGroup();
	}

	public String getNewGroupName() {
		return buttonPanel.getNewGroupName();
	}

	public Color getNewGroupColor() {
		return buttonPanel.getNewGroupColor();
	}

	public void clearNewGroupColor() {
		buttonPanel.clearNewGroupColor();
		
	}

	public void clearNewGroupName() {
		buttonPanel.clearNewGroupName();
		
	}

	public String getGroupColor() {
		return buttonPanel.getColor();
	}

	public void removeGroup() {
		buttonPanel.removeColorInCombo();
		
	}

	public void setGroupNames(LinkedList<String> groupNameList) {
		buttonPanel.resetColorInCombo(groupNameList);
		
		
	}

	public void resetGroupNames(LinkedList<String> groupNameList) {
		buttonPanel.resetColorInCombo(groupNameList);
		
		
	}
	
	
}
