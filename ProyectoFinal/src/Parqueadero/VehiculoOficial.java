package Parqueadero;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VehiculoOficial extends Vehiculo {
	ArrayList<Estancia> estancias = new ArrayList<Estancia>();

	public VehiculoOficial(String matricula) {
		super(matricula);
	}

	@Override
	public void finEstancia() {
		this.estancias.get(estancias.size()-1).horaSalida = obtenerHoraActual();
	}

	@Override
	public void comienzaMes() {
		estancias.clear();
	}

	public ArrayList<Estancia> getEstancias() {
		return estancias;
	}

	public static LocalDateTime obtenerHoraActual() {
		LocalDateTime horaActual = LocalDateTime.now();
		return horaActual;
	}
	public String getMatricula() {
		return matricula;
	}
}
