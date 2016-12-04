package ru.prgmt.warehouse;

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
		
	}

	public void rewriteBase () {
		
	}

}


