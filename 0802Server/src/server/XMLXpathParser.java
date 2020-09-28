package server;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Node;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLXpathParser {

	private DocumentBuilderFactory f;
	private DocumentBuilder parser;
	private Document xmlDoc;
	private XPath	xpath;
	
	public XMLXpathParser() {
		
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
			xpath = XPathFactory.newInstance().newXPath();
			
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
		Node commandNameNode=null;
		try {
			commandNameNode = (Node)xpath.evaluate("//command/commandName", xmlDoc,XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		commandName = commandNameNode.getTextContent();
		return commandName;
		
	}
	public String getGroupName() {
		String groupName=null;	
		Node groupNameNode=null;
		try {
			groupNameNode = (Node)xpath.evaluate("//command/groupName", xmlDoc,XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		groupName = groupNameNode.getTextContent();
		return groupName;
	}
	
	public String getNewGroupName() {
		String newGroupName=null;
		Node newGroupNameNode = null;
		try {
			newGroupNameNode = (Node)xpath.evaluate("//command/newGroupName", xmlDoc,XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		newGroupName = newGroupNameNode.getTextContent();
//		System.out.println(newGroupName);
		
		return newGroupName;
	}
	public String getNewGroupColor() {
		String newGroupColor=null;
		Node newGroupColorNode = null;
		try {
			newGroupColorNode = (Node)xpath.evaluate("//command/newGroupColor", xmlDoc,XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		newGroupColor = newGroupColorNode.getTextContent();
		return newGroupColor;
	}	
	

}
