package ru.prgmt.warehouse;

import java.util.List;
import java.util.ArrayList; 

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "Devices")
@XmlAccessorType (XmlAccessType.FIELD)
public class Devices {
    @XmlElement(name = "device")
    private ArrayList<Device> devices = null;
 
    public ArrayList<Device> getDevices() {
        return devices;
    }    

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }
}