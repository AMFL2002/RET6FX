package application;

import java.io.Serializable;
import java.time.LocalTime;



public class Jugador implements Serializable {
	public String nombre;
	public String arma;
	public String habitacion;
	public LocalTime horaPartida;
	
	public Jugador(String nombre, String arma,String habitacion,LocalTime horaPartida)
	{
		this.nombre=nombre;
		this.arma=arma;
		this.habitacion=habitacion;
		this.horaPartida=horaPartida;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getArma() {
		return arma;
	}
	public void setArma(String arma){
		this.arma=arma;
	}
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habitacion){
		this.habitacion=habitacion;
	}
	public LocalTime getHoraPartida() {
		return horaPartida;
	}
	public void setHoraPartida(LocalTime horaPartida){
		this.horaPartida=horaPartida;
	}
	public String toString() {
		return "Jugador [nombre="+nombre+", arma="+arma+", habitación="+habitacion+", horaPartida="+horaPartida+"]";
	}
}
