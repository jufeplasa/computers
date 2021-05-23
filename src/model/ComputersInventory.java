package model;

public class ComputersInventory  {

	public static final int MAXPC=20;

	//relations
	Computer[] computers;

	public ComputersInventory() {
		computers= new Computer[MAXPC];
	}

	public Computer searchIp(String ip) {
		Computer find=null;
		boolean continuar=true;
		for(int i=0;i<MAXPC && continuar;i++) {
			if(computers[i]!=null&&computers[i].getIpAddress().equalsIgnoreCase(ip)) {
				find=computers[i];
				continuar=false;
			}	
		}
		return find;
	}
	
	public String addComputer(String ip, String re, String bra, int size, double ram) {
		boolean continuar=true;
		String message="";
		Computer found=searchIp(ip);
		if (found!=null) {
			message="Error. ya existe un computador con este IP";
		}
		else {
			for(int i=0;i<MAXPC&&continuar;i++) {
				if(computers[i]==null) {
					computers[i]=new PortableComputer(ip,  re, bra, size ,ram);
					continuar=false;
					message="El computador portatil se ha ingresado con exito";
				}	
			}
			if(continuar) {
				message="Se ha llegado a la maxima capacidad de computadores";
			}
		}
		return message;
	}

	public String addComputer(String ip, String re, String bra, String accesories, double ram) {
		boolean continuar=true;
		String message="";
		Computer found=searchIp(ip);
		if (found!=null) {
			message="Error. ya existe un computador con este IP";
		}
		else {
			for(int i=0;i<MAXPC&&continuar;i++) {
				if(computers[i]==null) {
					computers[i]=new DesktopComputer(ip,  re, bra, accesories, ram);
					continuar=false;
					message="El computador de escritorio se ha ingresado con exito";
				}	
			}
			if(continuar) {
				message="Se ha llegado a la maxima capacidad de computadores";
			}
		}
		return message;
	}

	public String turnOn(String re,String ip) {
		boolean prendido=true;
		String message="";
		for(int i=0;i<MAXPC && prendido;i++) {
			if(computers[i] instanceof DesktopComputer) {
				if (computers[i]!=null&&computers[i].getReference().equalsIgnoreCase(re)&&computers[i].getIpAddress().equalsIgnoreCase(ip)) {
					if(computers[i].getTurnOn()) {
						message="Error. el computador ya esta prendido";
						prendido=false;
					}
					else {
						DesktopComputer deskComputer=(DesktopComputer) computers[i];
						deskComputer.turnOn(ip);
						prendido=false;
						message="El computador de escritorio de ip: "+ip+" se ha prendido";
					}
				}
			}
		}
		return message;
	}
	
	public String turnOnManual(String re,String ip) {
		boolean prendido=true;
		String message="";
		for(int i=0;i<MAXPC && prendido;i++) {
			if(computers[i] instanceof DesktopComputer) {
				if (computers[i]!=null&&computers[i].getReference().equalsIgnoreCase(re)&&computers[i].getIpAddress().equalsIgnoreCase(ip)) {
					if(computers[i].getTurnOn()) {
						message="Error. el computador ya esta prendido";
						prendido=false;
					}
					else {
						computers[i].setTurnOn(true);
						prendido=false;
						message="El computador de escritorio de ip: "+ip+" se ha prendido de manera manual";
					}
				}
			}
			else if(computers[i] instanceof PortableComputer) {
				if(computers[i]!=null&&computers[i].getReference().equalsIgnoreCase(re)&&computers[i].getIpAddress().equalsIgnoreCase(ip)) {
					if(computers[i].getTurnOn()) {
						message="Error. el computador ya esta prendido";
						prendido=false;
					}
					else {
						computers[i].setTurnOn(true);
						prendido=false;
						message="El computador portatil de ip: "+ip+" se ha prendido de manera manual";
						
					}
				}
			}
		}
		return message;
	}

	public String turnOff(String re,String ip) {
		boolean apagado=true;
		String message="";
		for(int i=0;i<MAXPC && apagado;i++) {
			if(computers[i] instanceof DesktopComputer) {
				if (computers[i]!=null&&computers[i].getReference().equalsIgnoreCase(re)&&computers[i].getIpAddress().equalsIgnoreCase(ip)) {
					if(computers[i].getTurnOn()) {
						DesktopComputer deskComputer=(DesktopComputer) computers[i];
						deskComputer.turnOff(ip);
						apagado=false;
						message="El computador de escritorio de ip: "+ip+" se ha apagado";
						
					}
					else {
						message="Error. el computador ya esta apagado";
						apagado=false;
					}
				}
			}
			else if(computers[i] instanceof PortableComputer) {
				if(computers[i]!=null&&computers[i].getReference().equalsIgnoreCase(re)&&computers[i].getIpAddress().equalsIgnoreCase(ip)) {
					if(computers[i].getTurnOn()) {
						computers[i].setTurnOn(false);
						apagado=false;
						message="El computador portatil de ip: "+ip+" se ha apagado";
					}
					else {
						message="Error. el computador ya esta apagado";
						apagado=false;
					}
				}
			}
		}
		return message;
	}

	public boolean removeComputer(String reference) {
		boolean eliminado=true;
		for(int i=0;i<MAXPC&&eliminado;i++) {
			if(computers[i]!=null && computers[i].getReference().equalsIgnoreCase(reference) ){
				computers[i]=null;
				eliminado=false;
			}
		}
		if(eliminado) {
			return false;
		}
		else {
			return true;
		}
	}

}

