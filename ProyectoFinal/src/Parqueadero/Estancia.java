package Parqueadero;


import java.time.LocalDateTime;

public class Estancia {


	LocalDateTime horaEntrada;
	LocalDateTime horaSalida;

	
	public Estancia(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	
	
}
