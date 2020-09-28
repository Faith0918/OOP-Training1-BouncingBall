package server;

import java.awt.Color;
import java.awt.event.ActionListener;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonPanel extends	JPanel{
	private	JButton		startButton;
	private	JButton		stopButton;
	private	JButton		addButton;
	private	JButton		removeButton;
	private	JButton		addGroupButton;
	private JButton		removeGroupButton;
	private	JButton		selectNewGroupColorButton;
	private	JButton		writeNewGroupNameButton;
	private	JComboBox<String>	colorComboBox;
	private	JColorChooser colorChooser;
	private Color		newGroupColor=null;
	private	String		newGroupName=null;
	
	public ButtonPanel() {
		startButton = new JButton("start");
		stopButton = new JButton("stop");
		addButton = new JButton("add");
		removeButton = new JButton("remove");
		colorComboBox = new JComboBox<String>();
		selectNewGroupColorButton = new JButton("groupColor");
		writeNewGroupNameButton = new JButton("groupName");
		addGroupButton	=	new JButton("addGroup");
		removeGroupButton = new JButton("removeGroup");
		
		this.add(startButton);
		this.add(stopButton);
		this.add(addButton);
		this.add(removeButton);
		this.add(colorComboBox);
		this.add(selectNewGroupColorButton);
		this.add(writeNewGroupNameButton);
		this.add(addGroupButton);
		this.add(removeGroupButton);
	}
	
	public void addActionListener(ActionListener	Listener) {
		startButton.addActionListener(Listener);
		stopButton.addActionListener(Listener);
		addButton.addActionListener(Listener);
		removeButton.addActionListener(Listener);
		selectNewGroupColorButton.addActionListener(Listener);
		writeNewGroupNameButton.addActionListener(Listener);
		addGroupButton.addActionListener(Listener);
		removeGroupButton.addActionListener(Listener);
	}
	
	public String	getColor() {
		if(colorComboBox.getItemCount()>0) {
			return colorComboBox.getSelectedItem().toString();
		}
		return "";
	}

	public void addColorInCombo(String	groupName) {
		if(groupName.length()>0)
		colorComboBox.addItem(groupName);
		
	}
	public void removeColorInCombo() {
		if(colorComboBox.getItemCount()>0) {
			colorComboBox.removeItem(colorComboBox.getSelectedItem().toString());
		}
	}
	public void setNewGroupColor() {
		newGroupColor = JColorChooser.showDialog(colorChooser, "Choose Group Color", Color.WHITE);
	}
	public void setNewGroupName() {
		newGroupName = JOptionPane.showInputDialog("What is the new group name?");	
		
	}
	public void addGroup() {
		this.addColorInCombo(newGroupName);
		
	}
	public Color getNewGroupColor() {
		return newGroupColor;
	}
	public void clearNewGroupColor() {
		newGroupColor = null;
	}
	public String getNewGroupName() {
		return newGroupName;
	}
	public void clearNewGroupName() {
		newGroupName = null;
	}

	public void removeAllInCombo() {
		if(colorComboBox.getItemCount()>0) {
			colorComboBox.removeAllItems();		}
		
	}

	public void resetColorInCombo(LinkedList<String> groupNameList) {
		removeAllInCombo();
		for(String groupName : groupNameList) {
			addColorInCombo(groupName);
		}
		
		

		
	}

	
	
}
