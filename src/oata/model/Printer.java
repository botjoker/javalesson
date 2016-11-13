package oata;

import java.lang.*;

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

	public String print() {
		String printString = " " + this.getDate() + " " + this.quantity + " штук Принтер " + this.title + " - " + this.isNetwork() + this.isColor(this.color);
		return printString;		
	}

}