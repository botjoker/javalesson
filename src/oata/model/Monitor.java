package oata;

import java.util.Random;

public class Monitor extends Device {

	enum Kind { TUBE, LCD, PROJECTOR }

	public boolean color;
	public int size;
	public Kind kind;		

	public void setColor(String param) {
		this.color = Boolean.parseBoolean(param);
	}

	public void setSize(String param) {
		this.size = Integer.parseInt(param);
	}

	public void setKind(String param) {
		this.kind = Kind.valueOf(param);
	}

	public String getColor() {
		return Boolean.toString(this.color);
	}

	public String getSize() {
		return String.valueOf(this.size);		 
	}

	public String getKind() {
		return this.kind.toString();
	}

	public String print() {
		String printString = this.getSkuString() + " - " + this.getDate() + " " + this.quantity + " штук Монитор " + this.title + " - " + this.isColor(this.color) + " - " + this.getKind() + " - " + this.getSize() + "'";
		return printString;		
	}

	public void addItem(String[] parametersList) {
		for(String item : parametersList) {
			String currentParemeter = item.split(" ")[0].trim();
			String tempParameter = "";			
    		this.setTyp("Monitor");
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
	        	case "kind":	
	        		tempParameter = item.replace("kind","");
	        		this.setKind(tempParameter.trim());	
	        	break;	        	
			}
		}
	}
	
}