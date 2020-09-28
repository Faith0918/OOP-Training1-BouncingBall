package server;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLDOMParser {

	private DocumentBuilderFactory f;
	private DocumentBuilder parser;
	private Document xmlDoc;
	
	public XMLDOMParser() {
		
		f = DocumentBuilderFactory.newInstance();
		try {
			parser = f.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xmlDoc = null;
	}
	
	public void putXML(String xml) {
		try {
			xmlDoc = parser.parse(new InputSource(new StringReader(xml)));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getCommandName() {
		String commandName=null;
		
		Element command = xmlDoc.getDocumentElement();
		NodeList commandNameList = command.getElementsByTagName("commandName");
		Node commandNameNode = commandNameList.item(0);
		commandName = commandNameNode.getTextContent();		
		return commandName;
		
	}
	public String getGroupName() {
		String groupName=null;		
		Element command = xmlDoc.getDocumentElement();
		NodeList groupNameList = command.getElementsByTagName("groupName");
		Node groupNameNode = groupNameList.item(0);
		groupName = groupNameNode.getTextContent();
		System.out.println(groupName);
		return groupName;
	}
	
	public String getNewGroupName() {
		String newGroupName=null;
		
		Element command = xmlDoc.getDocumentElement();
		NodeList newGroupNameList = command.getElementsByTagName("newGroupName");
		Node newGroupNameNode = newGroupNameList.item(0);
		newGroupName = newGroupNameNode.getTextContent();
		System.out.println(newGroupName);
		
		return newGroupName;
	}
	public String getNewGroupColor() {
		String newGroupColor=null;
		
		Element command = xmlDoc.getDocumentElement();
		NodeList newGroupColorList = command.getElementsByTagName("newGroupColor");
		Node newGroupColorNode = newGroupColorList.item(0);
		newGroupColor = newGroupColorNode.getTextContent();
		System.out.println(newGroupColor);
		
		return newGroupColor;
	}	
	

}
