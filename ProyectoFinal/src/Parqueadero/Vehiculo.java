package Parqueadero;

import java.sql.Time;

public abstract class Vehiculo {
	String matricula;
	Time hora;
	
	public Vehiculo(String matricula) {
		super();
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public Time getHora() {
		return hora;
	}	
	
	public void comienzaMes() {
		
	}
	
	public void finEstancia() {
		
	}
	
	public void comienzaEstancia() {
		
	}

}
