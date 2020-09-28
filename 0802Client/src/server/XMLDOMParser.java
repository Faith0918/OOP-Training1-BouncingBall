package server;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

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
	
	public LinkedList<String> getGroupNameList() {
		LinkedList<String> 		groupNameList = new LinkedList<String>();
		Element command = xmlDoc.getDocumentElement();
		NodeList groupNamesNodeList = command.getElementsByTagName("groupName");
		for(int i=0;i<groupNamesNodeList.getLength();i++) {
			Node groupNameNode = groupNamesNodeList.item(i);
			String groupName = groupNameNode.getTextContent();
			System.out.println(groupName);
			groupNameList.add(groupName);	
		}
		return groupNameList;
	}
	
	
}