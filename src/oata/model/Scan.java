package oata;

import java.util.*;

public class Scan extends Device {	

	enum Network { ETHERNET, WIFI };

	ArrayList<Network> network = new ArrayList<Network>();
	boolean color; 

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

	public String print() {
		String printString = " " + this.getDate() + " " + this.quantity + " штук Сканнер " + this.title + " - " + this.isNetwork() + this.isColor(this.color);
		return printString;		
	}

}