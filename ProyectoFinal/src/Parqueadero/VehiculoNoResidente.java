package Parqueadero;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class VehiculoNoResidente extends Vehiculo{
	static int basePrecioMinuto = 50;
	ArrayList<Estancia> estancias = new ArrayList<Estancia>();

	public VehiculoNoResidente(String matricula) {
		super(matricula);
	}

	public void finEstancia(ArrayList<Estancia> estancias) {
		estancias.get(estancias.size()-1).setHoraSalida(obtenerHoraActual());
		System.out.println("El valor a cancelar por el servicio es: " + pagoEstancia(estancias));
	}
	
	public static double pagoEstancia(ArrayList<Estancia> estancias) {
		int totalMin = 0;
		totalMin += ChronoUnit.MINUTES.between(estancias.get(estancias.size()-1).horaEntrada,estancias.get(estancias.size()-1).horaSalida);
		double totalPago = totalMin * basePrecioMinuto;
		return totalPago;
	}

	public static LocalDateTime obtenerHoraActual() {
		LocalDateTime horaActual = LocalDateTime.now();
		return horaActual;
	}
}
