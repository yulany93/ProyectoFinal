package Parqueadero;

import java.util.Scanner;


public class Menu {
	static Scanner teclado = new Scanner(System.in);
	static Aparcamiento ap = new Aparcamiento();
	
	public static void menuPrincipal() {
		String matricula;
		int opcion = 0;
		System.out.println("Por favor digite la opción deseada");
		System.out.println("(1) Registrar entrada de vehículo");
		System.out.println("(2) Registrar salida de vehículo");
		System.out.println("(3) Generar informe pagos Residentes");
		System.out.println("(4) Iniciar mes");
		System.out.println("(5) Salir");
		opcion = teclado.nextInt();
		switch (opcion) {
		case 1:
			menuVehiculo();
			menuPrincipal();
			break;
		case 2:
			System.out.println("Digite la matricula del vehiculo");
			matricula = teclado.next();
			ap.sale(matricula);
			menuPrincipal();
			break;
		case 3:
			ap.generaInformePagosResidentes();
			menuPrincipal();
			break;
			
		case 4 : 
			ap.comienzaMes();
			menuPrincipal();
			break;
		case 5:
			System.out.println("Feliz resto de día");
			break;

		default:
			menuPrincipal();
			break;
		}
	}

	public static void menuVehiculo() {
		String matricula;
		int opcion;
		System.out.println("Por favor digite la matricula del vehículo");
		matricula = teclado.next();
				
		
		
		System.out.println("Por favor digite el tipo de vehículo que ingresa");
		System.out.println("(1) Vehiculo Oficial");
		System.out.println("(2) Vehiculo Residente");
		System.out.println("(3) Vehiculo No Residente");
		opcion = teclado.nextInt();		
		ap.EncontrarMatricula(matricula);		
		if (ap != null) {				
			System.out.println("El vehiculo ya se encuentra en el parqueadero.");			
			return; 
		}
		//ap.entra(matricula, opcion); 

	}

	public static void main(String[] args) {
		System.out.println("Bienvenido al parqueadero 'El mejor'");
		menuPrincipal();
	}

}
