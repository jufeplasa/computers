package ui;
import model.ComputersInventory;
import java.util.Scanner;
public class Main {
	private static final Scanner leer=new Scanner (System.in);
	private static ComputersInventory planet=new ComputersInventory();

	public static void main(String[] args) {
	
		int b=0;
		int opcion=0;
		int c=0;
		while (b==0) {
			showMenu();
			c=0;
			while (c==0) {
				opcion=leer.nextInt();
				leer.nextLine();	
				if (opcion>8) {
					System.out.println("Esa opcion no esta permitidad, por favor elija una nuevamente");
				}
				else {
					c++;
				}
			}
			switch(opcion){
			
				case 1:
					int elejido=0;
					String ip=""; 
					String re="";
					String brand="";
					int size=0;
					String accesories="";
					double ram=0;
					String message="";
					System.out.println("El computador que vas a elejir es: (1: escritorio; 2: portatil)");
					elejido=leer.nextInt();
					leer.nextLine();	
					if(elejido==1) {
						System.out.println("Introduzca la IP del computador");
						ip=leer.next();
						System.out.println("Introduzca el registro del computador");
						re=leer.next();
						System.out.println("Introduzca la marca del computador (LENOVO, DELL, MAC, HP, ASUS, ACER)");
						brand=leer.next().toUpperCase();
						System.out.println("Introduzca el accesorio del computador");
						accesories=leer.next();
						System.out.println("Introduzca la memoria ram del computador");
						ram=leer.nextDouble();
						leer.nextLine();
						message=planet.addComputer(ip, re, brand,accesories,ram);
						System.out.println(message);
					}
					else if(elejido==2){
						System.out.println("Introduzca la IP del computador");
						ip=leer.next();
						System.out.println("Introduzca el registro del computador");
						re=leer.next();
						System.out.println("Introduzca la marca del computador (LENOVO, DELL, MAC, HP, ASUS, ACER)");
						brand=leer.next().toUpperCase();
						System.out.println("Introduzca el size del computador");
						size=leer.nextInt();
						leer.nextLine();
						System.out.println("Introduzca la memoria ram del computador");
						ram=leer.nextDouble();
						leer.nextLine();
						message=planet.addComputer(ip, re, brand,size,ram);
						System.out.println(message);
					}
				break;
				
				case 2:
					boolean eliminado;
					System.out.println("Introduzca el registro del computador que desea eliminar");
					re=leer.next();
					eliminado=planet.removeComputer(re);
					if(eliminado) {
						System.out.println("El computador se ha eliminado con exito");
					}
					else {
						System.out.println("El computador no se ha logrado eliminadar");
					}
				break;
					
				case 3:
					System.out.println("Ingrese la IP del pc que desea prender");
					ip=leer.next();
					System.out.println("Introduzca el registro del computador");
					re=leer.next();
					message=planet.turnOn(re,ip);
					System.out.println(message);
				break;
					
				case 4:
					System.out.println("Ingrese la IP del pc que desea prender");
					ip=leer.next();
					System.out.println("Introduzca el registro del computador");
					re=leer.next();
					message=planet.turnOnManual(re,ip);
					System.out.println(message);
				break;
					
				case 5:
					System.out.println("Ingrese la IP del pc que desea apagar");
					ip=leer.next();
					System.out.println("Introduzca el registro del computador");
					re=leer.next();
					message=planet.turnOff(re,ip);
					System.out.println(message);
				break;
					
				case 6:
				break;
				
				case 7:
				break;	
				
				case 8: b=1;
					System.out.println("HAS SALIDO DEL PROGRAMA \n");
				break;
					
			}
		}
		
	}
	private static void showMenu() {
		System.out.println("\n Por favor elija una opcion: \n");
		System.out.println("1: Adicionar un computador");
		System.out.println("2: Eliminar un computador");
		System.out.println("3: Prender de forma remota (computador de escritorio)");
		System.out.println("4: Prender de forma manual");
		System.out.println("5: Apagar computador ");
		System.out.println("6: (QUIZ) Calcular promedio de de memoria de los computadores");
		System.out.println("7: (QUIZ) Desplegar informacion de los computadores existentes");
		System.out.println("8: Salir del programa \n");
	}
}
