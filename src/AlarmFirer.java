import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AlarmFirer extends TimerTask {
	NodeList alarms;
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    	Document document = documentBuilder.parse("Alarm.xml");
    	alarms = document.getElementsByTagName("alarm");
    	
    	//root.getChildNodes();
    	//
		}catch(Exception e) {}
		for(int i=0;i<alarms.getLength();i++) {
    		Node temp=alarms.item(i);
    		Element element = (Element) temp;
    		Date d=new Date();
    		
    		DateFormat df = new SimpleDateFormat();
    		Date alarmTime;
    		try {
    		alarmTime=df.parse(element.getElementsByTagName("date").item(0).getTextContent());
    		}
    		catch(Exception e) {
    			alarmTime=new Date(element.getElementsByTagName("date").item(0).getTextContent());
    		}
    		
    		if (alarmTime.compareTo(d)<1) {
    			Run.callAlarmSetOff(
    					element.getElementsByTagName("message").item(0).getTextContent(),
    					Integer.parseInt(element.getElementsByTagName("numSnooze").item(0).getTextContent()));
    			removeElement(i);
    		}
    		
    	}
		
	}
	private void removeElement(int i) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    	Document document = documentBuilder.parse("Alarm.xml");
	    	alarms = document.getElementsByTagName("alarm");
	    	Node temp=alarms.item(i);
	    	temp.getParentNode().removeChild(temp);
	    	DOMSource source = new DOMSource(document);
	    	
	    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    	Transformer transformer = transformerFactory.newTransformer();
	    	StreamResult result = new StreamResult("Alarm.xml");
	    	transformer.transform(source, result);
		}catch (Exception e) {e.printStackTrace();}
	}
}
