package oata;

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

	public String print() {
		String printString = " " + this.getDate() + " " + this.quantity + " штук Сканнер " + this.title + " - " + this.isColor(this.color);
		return printString;		
	}
	
}