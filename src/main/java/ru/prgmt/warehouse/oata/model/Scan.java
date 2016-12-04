package ru.prgmt.warehouse;

import java.util.*;


public class Scan extends Device {	

	enum Network { ETHERNET, WIFI };

	private ArrayList<Network> network = new ArrayList<Network>();
	private boolean color; 

	public void setColor(String param) {
		this.color = Boolean.parseBoolean(param);
	}
	public void setNetwork(String param) {		
		ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(param.split(",")));
		for(String item : tempList) {
			network.add(Network.valueOf(item));
		}
	}
	
	public String isNetwork() {		
        return "yes";
	}

	public String getNetwork() {		
		String result = new String();
		for(Network item : this.network)
			result = result + item.toString() + ",";
        return result;
	}

	public String getColor() {		
        return Boolean.toString(this.color);
	}

	public String print() {
		String printString = this.getSkuString() + " - " + this.getDate() + " " + this.getQuantityString() + " штук Сканнер " + this.getTitle() + " - " + this.getNetwork() + " - " + this.isColor(this.color);
		return printString;		
	}

	public void addItem(String[] parametersList) {
		for(String item : parametersList) {
			String currentParemeter = item.split(" ")[0].trim();
			String tempParameter = "";			
    		this.setTyp("Scanner");
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