package server;

import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import command.generated.*;
public class XMLManager {
	
	public String generateXML(String string, String newGroupName, String newGroupColor) {
//		System.out.println("generateXML");
		String xml = null;
		ObjectFactory factory = new ObjectFactory();
		Command command = factory.createCommand();
		command.setCommandName(string);
		command.setNewGroupName(newGroupName);
		command.setNewGroupColor(newGroupColor);
		
		try {
			JAXBContext jContext = JAXBContext.newInstance(Command.class);
			Marshaller marshaller = jContext.createMarshaller();
			  //setting the property to show xml format output
      		  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      		  StringWriter sw = new StringWriter();
      		  marshaller.marshal(command, sw);
      		  xml = sw.toString();
      		  
      		  
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(xml);
		return xml;
		
		
	}

	public String generateXML(String string, String groupColor) {
//		System.out.println("generateXML");
		ObjectFactory factory = new ObjectFactory();
		Command command = factory.createCommand();
		command.setCommandName(string);
//		System.out.println(string);
		command.setGroupName(groupColor);
//		System.out.println(groupColor);
		String xml = null;
		try {
			JAXBContext jContext = JAXBContext.newInstance(Command.class);
			Marshaller marshaller = jContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			StringWriter sw = new StringWriter();
			marshaller.marshal(command, sw);
			xml = sw.toString();
			
		}catch (Exception e) {
			System.out.println("exception");
		}
		//¿ﬂ ¿€µøµ 
		return xml;
	}

}
