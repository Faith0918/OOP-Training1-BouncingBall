package server;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public LinkedList<String> getGroupNameList() {
		LinkedList<String> 		groupNameList = new LinkedList<String>();
		
		NodeList groupNamesNodeList=null;
		try {
			groupNamesNodeList = (NodeList)xpath.evaluate("//command/groupName",xmlDoc, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<groupNamesNodeList.getLength();i++) {
			Node groupNameNode = groupNamesNodeList.item(i);
			String groupName = groupNameNode.getTextContent();
			System.out.println(groupName);
			groupNameList.add(groupName);	
		}
		return groupNameList;
	}
}