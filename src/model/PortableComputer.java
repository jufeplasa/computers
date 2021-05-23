package model;

public class PortableComputer extends Computer {
	//attributes
	private int size;
	
	public PortableComputer (String ip, String re, String bra, int size, double ram) {
		super( ip,  re, bra, ram);
		this.setSize(size);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String toString() {
		String message="";
		message=super.toString()+" y su tama�o es: "+size+"\n";
		return message;
	}
	
	
}