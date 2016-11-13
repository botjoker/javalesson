package oata;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.util.ArrayList;

public class Database {

	public ArrayList<Device>allDevices;

	public Database () {
		try {
				ArrayList<Device>devices = new ArrayList<Device>();
				File fXmlFile = new File("src/base.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				// System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				NodeList nList = doc.getElementsByTagName("device");				
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					// System.out.println("\nCurrent Element :" + nNode.getNodeName());
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						String typ = eElement.getAttribute("type");
						switch (typ) {
				        	case "Printer":				             	
				             	Printer printer = new Printer();
				             	printer.setTyp(typ);
        						printer.setSku(eElement.getAttribute("sku"));
        						printer.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
        						printer.setDate(eElement.getElementsByTagName("date").item(0).getTextContent());
        						printer.setQuantity(eElement.getElementsByTagName("quantity").item(0).getTextContent());
        						
        						printer.setNetwork(eElement.getElementsByTagName("network").item(0).getTextContent());
        						printer.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
        						
        						devices.add(printer);
				            break;
				         	case "Monitor":
				         		Monitor monitor = new Monitor();
        						monitor.setTyp(typ);
        						monitor.setSku(eElement.getAttribute("sku"));
        						monitor.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
        						monitor.setDate(eElement.getElementsByTagName("date").item(0).getTextContent());
        						monitor.setQuantity(eElement.getElementsByTagName("quantity").item(0).getTextContent());

        						monitor.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
        						monitor.setSize(eElement.getElementsByTagName("size").item(0).getTextContent());
        						monitor.setKind(eElement.getElementsByTagName("kind").item(0).getTextContent());
        						
        						devices.add(monitor);
				         	break;
				         	case "Scanner":
				         		Scan scan = new Scan();
        						scan.setTyp(typ);
        						scan.setSku(eElement.getAttribute("sku"));
        						scan.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
        						scan.setDate(eElement.getElementsByTagName("date").item(0).getTextContent());
        						scan.setQuantity(eElement.getElementsByTagName("quantity").item(0).getTextContent());

        						scan.setNetwork(eElement.getElementsByTagName("network").item(0).getTextContent());
        						scan.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());

        						devices.add(scan);
				         	break;
				         }						
					}
				}
				allDevices = devices;
    		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	public ArrayList<Device> getBase() {
		return allDevices;
	}

	public void deleteItem (String param) {
		for(Device d : allDevices){
	        if(d.getSkuString() != null && d.getSkuString().contains(param)) {	        	
				this.allDevices.remove(this.allDevices.indexOf(d));
				break;
			}			
	    }	  	
	}
	public void deleteAll() {		
		this.allDevices.clear();
	}

	public void addItem(Device item) {
		this.allDevices.add(item);
	}

	public void rewriteBase () {
		try {	
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	        Document document = documentBuilder.parse("src/base.xml");
	        Element root = document.getDocumentElement();
	        NodeList itemsList = document.getElementsByTagName("device");
	        int itemsCount = itemsList.getLength();
	        
	        for (int i = 0; i<itemsCount; i++) {
	        	Element element = (Element) document.getElementsByTagName("device").item(0);
	        	element.getParentNode().removeChild(element);	
	        }
	        	        
	        for (Device dev : this.allDevices) {
	            String typ = dev.getTyp();

	            Element newDevice = document.createElement("device");

	            newDevice.setAttribute("sku",dev.getSkuString());
	            newDevice.setAttribute("type",typ);

	            Element title = document.createElement("title");
	            title.appendChild(document.createTextNode(dev.getTitle()));
	            newDevice.appendChild(title);

				Element date = document.createElement("date");
	            date.appendChild(document.createTextNode(dev.getDate()));
	            newDevice.appendChild(date);

	            Element quantity = document.createElement("quantity");
	            quantity.appendChild(document.createTextNode(dev.getQuantityString()));
	            newDevice.appendChild(quantity);
	            
	            switch (dev.typ) {
			        	case "Printer":			        		
			        		Element printerNetwork = document.createElement("network");
				            printerNetwork.appendChild(document.createTextNode(((Printer)dev).getNetwork()));
				            newDevice.appendChild(printerNetwork);

				            Element printerColor = document.createElement("color");
				            printerColor.appendChild(document.createTextNode(((Printer)dev).getColor()));
				            newDevice.appendChild(printerColor);

			        	break;
			        	case "Monitor":	
			     			Element monitorColor = document.createElement("color");
				            monitorColor.appendChild(document.createTextNode(((Monitor)dev).getColor()));
				            newDevice.appendChild(monitorColor);

				            Element monitorSize = document.createElement("size");
				            monitorSize.appendChild(document.createTextNode(((Monitor)dev).getSize()));
				            newDevice.appendChild(monitorSize);

				            Element monitorKind = document.createElement("kind");
				            monitorKind.appendChild(document.createTextNode(((Monitor)dev).getKind()));
				            newDevice.appendChild(monitorKind);
			        	break;
			        	case "Scanner":	
			        		Element scannerColor = document.createElement("color");
				            scannerColor.appendChild(document.createTextNode(((Scan)dev).getColor()));
				            newDevice.appendChild(scannerColor);

				            Element scannerNetwork = document.createElement("network");
				            scannerNetwork.appendChild(document.createTextNode(((Scan)dev).getNetwork()));
				            newDevice.appendChild(scannerNetwork);
			        	break;		      
				}
	            root.appendChild(newDevice);
	        }	        
	        DOMSource source = new DOMSource(document);

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        StreamResult result = new StreamResult("src/base.xml");
	        transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}


