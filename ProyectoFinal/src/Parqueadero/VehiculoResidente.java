package Parqueadero;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class VehiculoResidente extends Vehiculo{
	
	int tiempoAcumulado = 0;
	int basePrecioMinuto = 25;
	ArrayList<Estancia> estancias = new ArrayList<Estancia>();
	public VehiculoResidente(String matricula) {
		super(matricula);
	}
	
	@Override
	public void finEstancia() {
		estancias.get(estancias.size()-1).horaSalida = obtenerHoraActual();
		for (Estancia est : estancias) {
			tiempoAcumulado += ChronoUnit.MINUTES.between(est.horaEntrada, est.horaSalida);
		}
	}
	
	public double pagoMes() {
		int totalMin = 0;
		for (Estancia est : estancias) {
			totalMin += ChronoUnit.MINUTES.between(est.horaEntrada, est.horaSalida);
		}
		
		double totalMes = totalMin * basePrecioMinuto;
		return totalMes;
	}
	
	@Override
	public void comienzaMes() {
		tiempoAcumulado = 0;
		estancias.clear();
	}

	public int getTiempoAcumulado() {
		
		return tiempoAcumulado;
	}

	public static LocalDateTime obtenerHoraActual() {
		LocalDateTime horaActual = LocalDateTime.now();
		return horaActual;
	}
}
