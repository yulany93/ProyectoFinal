package Parqueadero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Aparcamiento {
	ArrayList<VehiculoNoResidente> vehiculos = new ArrayList<VehiculoNoResidente>();
	ArrayList<VehiculoOficial> vehOficiales = new ArrayList<VehiculoOficial>();
	ArrayList<VehiculoResidente> vehResidente = new ArrayList<VehiculoResidente>();
	// String matriculaVehiculo;

	public Aparcamiento() {

	}

	public VehiculoOficial EncontrarMatricula(String matricula) {
		if (vehOficiales != null) {
			for (VehiculoOficial vehi : vehOficiales) {

				if (vehi.getMatricula() == matricula) {
					return vehi;
				}
			}
		}
		return null;
	}

	public static LocalDateTime obtenerHoraActual() {
		LocalDateTime horaActual = LocalDateTime.now();
		return horaActual;
	}

	public void comienzaMes() {
		vehiculos.clear();
		for (VehiculoOficial vehOf : vehOficiales) {
			vehOf.comienzaMes();
		}
		for (VehiculoResidente vehRes : vehResidente) {
			vehRes.comienzaMes();
		}
	}

	public void registraOficial(String matriculaN, Estancia e) {
		VehiculoOficial v = new VehiculoOficial(matriculaN);
		v.estancias.add(e);
		vehOficiales.add(v);
	}

	public void registraResidente(String matriculaN, Estancia e) {
		VehiculoResidente v = new VehiculoResidente(matriculaN);
		v.estancias.add(e);
		vehResidente.add(v);
	}

	public void entra(String matriculaN, int opcion) {
		LocalDateTime horaActual = obtenerHoraActual();
		Estancia est = new Estancia(horaActual, horaActual);

		switch (opcion) {
		case 1:
			try {
				if (vehOficiales.size() == 0) {
					registraOficial(matriculaN, est);
				} else {
					boolean igual = false;
					for (int i = 0; i < vehOficiales.size(); i++) {
						if (vehOficiales.get(i).matricula.equals(matriculaN)) {
							vehOficiales.get(i).estancias.add(est);
							i = vehOficiales.size();
							igual = true;
						}
					}
					if (igual = false) {
						registraOficial(matriculaN, est);
					}
				}
			} catch (Exception ex) {
				// TODO: handle exception
				System.out.println("se ha presentado error");
				System.out.println("error" + ex);
			}
			break;

		case 2:
			try {
				if (vehResidente.size() == 0) {
					registraResidente(matriculaN, est);
				} else {
					boolean igual = false;
					for (int i = 0; i < vehResidente.size(); i++) {
						if (vehResidente.get(i).matricula.equals(matriculaN)) {
							vehResidente.get(i).estancias.add(est);
							i = vehResidente.size();
							igual = true;
						}
					}
					if (igual == false) {
						registraResidente(matriculaN, est);
					}

				}
			} catch (Exception ex) {
				// TODO: handle exception
				System.out.println("se ha presentado error");
				System.out.println("error" + ex);
			}
			break;
		case 3:
			VehiculoNoResidente v = new VehiculoNoResidente(matriculaN);
			v.estancias.add(est);
			vehiculos.add(v);
			break;
		default:
			break;
		}

	}

	public void sale(String matriculaN) {
		for (VehiculoOficial vehOf : vehOficiales) {
			if (vehOf.matricula.equals(matriculaN)) {
				vehOf.finEstancia();
			}
		}
		for (VehiculoResidente vehRes : vehResidente) {
			if (vehRes.matricula.equals(matriculaN)) {
				vehRes.finEstancia();
			}
		}
		for (VehiculoNoResidente vehNoR : vehiculos) {
			if (vehNoR.matricula.equals(matriculaN)) {
				vehNoR.finEstancia(vehNoR.estancias);
			}
		}
	}

	public void generaInformePagosResidentes() {
		try {
			FileWriter archivo = new FileWriter("InformeMesActual.txt");
			BufferedWriter contenido = new BufferedWriter(archivo);
			contenido.write("Matricula          ");
			contenido.write("Tiempo Acumulado(Min)        ");
			contenido.write("Valor a pagar");

			for (VehiculoResidente vehRes : vehResidente) {
				contenido.newLine();
				contenido.write(vehRes.matricula + "                ");
				contenido.write(vehRes.tiempoAcumulado + "                              ");
				contenido.write(String.valueOf(vehRes.pagoMes()));
			}
			contenido.close();
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
