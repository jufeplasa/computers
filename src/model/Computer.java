package model;

public class Computer {
	//Attributes
	private String ipAddress;
	private String reference;
	private boolean turnOn;
	private double ram;
	//relations
	private Brand brand;
	
	public Computer(String ip, String re, String bra,double ram) {
		ipAddress=ip;
		reference=re;
		brand=Brand.valueOf(bra);
		turnOn=false;
		this.setRam(ram);
	}
	
	public String toString() {
		String message="Su ip es: "+ipAddress+", la referencia es: "+reference+", su marca es: "+brand+", su ram es de: "+ram;
		return message;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public boolean getTurnOn() {
		return turnOn;
	}

	public void setTurnOn(boolean turnOn) {
		this.turnOn = turnOn;
	}

	public double getRam(){
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}
}
