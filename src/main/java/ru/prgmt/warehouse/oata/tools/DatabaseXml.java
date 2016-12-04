package ru.prgmt.warehouse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseXml implements Runnable {

	private File file;

	public ArrayList<Device>allDevices;

	Thread t;

	public DatabaseXml () {							
		t = new Thread(this, "Printing");
		t.start();							
	}

	public ArrayList<Device> getBase() {
		return this.allDevices;
	}

	public void writeBase (Devices devices) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Devices.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();		 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);		     		    
		    jaxbMarshaller.marshal(devices, System.out);		     		    
		    jaxbMarshaller.marshal(devices, new File("src/basetest.xml"));
	    } catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public Devices getList() {
		Devices devices = new Devices();
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Devices.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     		
		    devices = (Devices) jaxbUnmarshaller.unmarshal( new File("src/basetest.xml") );		   		    		    		  

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return devices;

	}


	public void run() {
		File fXmlFile = new File("src/base.xml");	
		Devices devices = new Devices();
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Devices.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     		
		    devices = (Devices) jaxbUnmarshaller.unmarshal( new File("src/basetest.xml") );		   		    		    		  
		    for(Device device : devices.getDevices()) {
		        System.out.println(device.getSku());
		        System.out.println(device.getTitle());
		        System.out.println(device.getDate());
		        System.out.println(device.getTyp());
		        System.out.println(device.getQuantity());
		    }

		} catch (JAXBException e) {
			e.printStackTrace();
		}
			
	}		

}


