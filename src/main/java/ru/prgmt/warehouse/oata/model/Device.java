package ru.prgmt.warehouse;

import java.text.*;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "device")
@XmlAccessorType (XmlAccessType.FIELD)
public class Device {
	private int sku;
	private int quantity;
	private String typ;
	private String title;
	private Date date;
	
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

	public String getTitle() {
		return this.title;
	}

	public String getQuantity() {
		return this.title;
	}

	public String getSku() {
		return Integer.toString(this.sku);
	}

	public String getSkuString() {
		return Integer.toString(this.sku);
	}

	public String getQuantityString() {
		return Integer.toString(this.quantity);
	}

	public String getTyp() {
		return typ; 
	}

	public String getDate() {
		DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
		return format.format(this.date);
	}

	public String isColor(Boolean param) {		
        return param ? "Цветной" : "Ч.б.";
	}
	
}