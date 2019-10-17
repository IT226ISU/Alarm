import java.util.Date;
import java.io.IOException;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;


public class Saver {
	
	String message;
	Date time;
	int snooze;
	public Saver(Date time, String message, int snooze) {
		this.message = message;
		this.time = time;
		this.snooze = snooze;
		toXML();
	}
	
	public Saver(Date time, String message) {
		this.message = message;
		this.time = time;
		this.snooze = 0;
		toXML();
	}
	
	public Saver(Date time) {
		this.message = "";
		this.time = time;
		this.snooze = 0;
		toXML();
	}
	public void toXML() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        	Document document = documentBuilder.parse("Alarm.xml");
        	Element root = document.getDocumentElement();


            Element newSaver = document.createElement("alarm");

            Element date = document.createElement("date");
            date.appendChild(document.createTextNode(time.toString()));
            newSaver.appendChild(date);

            Element msg = document.createElement("message");
            msg.appendChild(document.createTextNode(message));
            newSaver.appendChild(msg);
            
            Element snz = document.createElement("numSnooze");
            snz.appendChild(document.createTextNode(Integer.toString(snooze)));
            newSaver.appendChild(snz);

            root.appendChild(newSaver);

        	DOMSource source = new DOMSource(document);

        	TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	Transformer transformer = transformerFactory.newTransformer();
        	StreamResult result = new StreamResult("Alarm.xml");
        	transformer.transform(source, result);
       	} catch (ParserConfigurationException pce) {
       		pce.printStackTrace();
       	} catch (TransformerException tfe) {
       		tfe.printStackTrace();
       	} catch (IOException ioe) {
       		ioe.printStackTrace();
       	} catch (SAXException sae) {
       		sae.printStackTrace();
	   }
    }
}
