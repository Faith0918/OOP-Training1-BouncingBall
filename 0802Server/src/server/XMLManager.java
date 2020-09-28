package server;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import command.generated.Command;

public class XMLManager {

	private Command command;
	
	public void xmlToCommand(String xml) {
		try {
		JAXBContext jaxbContext 	= JAXBContext.newInstance( Command.class );
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StringReader sr = new StringReader(xml);
		command = (Command) jaxbUnmarshaller.unmarshal(sr);}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Command getCommand() {
		return command;
	}

}
