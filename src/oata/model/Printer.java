package oata;

import java.lang.*;
import java.util.*;

public class Printer extends Device {	
	public boolean network;
	public boolean color; 

	public void setNetwork(String param) {
		this.network = Boolean.parseBoolean(param);
	}

	public void setColor(String param) {
		this.color = Boolean.parseBoolean(param);
	}

	public String isNetwork() {		
        return this.network ? "Сетевой" : "Локальный";
	}

	public String getNetwork() {		
        return Boolean.toString(this.network);
	}

	public String getColor() {		
        return Boolean.toString(this.color);
	}

	public String print() {
		String printString = this.getSkuString() + " - " + this.getDate() + " " + this.quantity + " штук Принтер " + this.title + " - " + this.isNetwork() + " - " + this.isColor(this.color);
		return printString;		
	}

	public void addItem(String[] parametersList) {
		for(String item : parametersList) {
			String currentParemeter = item.split(" ")[0].trim();
			String tempParameter = "";			
    		this.setTyp("Printer");
    		Random rand = new Random();
    		this.setSku(Integer.toString(rand.nextInt(9999)));

			switch (currentParemeter) {				
	        	case "name":
	        		tempParameter = item.replace("name","");
	        		this.setTitle(tempParameter.trim());
	        	break;
	        	case "quantity":	
	        		tempParameter = item.replace("quantity","");
	        		this.setQuantity(tempParameter.trim());
	        	break;
	        	case "date":
	        		tempParameter = item.replace("date","");
	        		this.setDate(tempParameter.trim());	
	        	break;
	        	case "color":	
	        		tempParameter = item.replace("color","");
	        		this.setColor(tempParameter.trim());	
	        	break;
	        	case "network":	
	        		tempParameter = item.replace("network","");
	        		this.setNetwork(tempParameter.trim());	
	        	break;	        	
			}
		}
	}

}