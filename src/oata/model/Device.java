package oata;

import java.text.*;
import java.util.Date;

public class Device {
	int sku;
	int quantity;
	String typ;
	String title;
	Date date;

	public String getTitle() {
		return this.title;
	}

	public String getSkuString() {
		return Integer.toString(this.sku);
	}

	public String getQuantityString() {
		return Integer.toString(this.quantity);
	}

	public void setSku(String param) {
		this.sku = Integer.parseInt(param);
	}

	public void setQuantity(String param) {
		this.quantity = Integer.parseInt(param);
	}

	public void setTyp(String param) {
		this.typ = param;
	}

	public void setTitle(String param) {
		this.title = param;	
	}

	public void setDate(String param) {		
		DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
		try {
			this.date = format.parse(param);
		}
		catch (Exception e) {
		 	this.date = null;	
		}	
	}

	public String getDate() {
		DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
		return format.format(this.date);
	}

	public String isColor(Boolean param) {		
        return param ? "Цветной" : "Ч.б.";
	}

	public String getTyp() {
		return typ; 
	}
}