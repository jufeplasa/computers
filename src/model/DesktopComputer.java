package model;

public class DesktopComputer extends Computer implements Operable{
	
	//Attributes
	private String accesories;
	private double memoryShare;
	
	public DesktopComputer(String ip, String re, String bra, String accesories, double ram) {
		super( ip,  re, bra, ram);
		this.accesories=accesories;
		memoryShare=0;
	}

	public String getAccesories() {
		return accesories;
	}

	public void setAccesories(String accesories) {
		this.accesories = accesories;
	}

	public double getMemoryShare() {
		return memoryShare;
	}

	public void setMemoryShare(double memoryShare) {
		this.memoryShare = memoryShare;
	}
	
	public void turnOn(String ip) {
		setTurnOn(true);
		if(ip.equals(getIpAddress())){
			memoryShare=500;
		}
	}
	
	public void turnOff(String ip) {
		setTurnOn(false);
		if(ip.equals(getIpAddress())){
			memoryShare=0;
		}
	}
	
	public String toString() {
		String message="";
		message=super.toString()+" "+accesories+", "+memoryShare;
		return message;
	}
}
