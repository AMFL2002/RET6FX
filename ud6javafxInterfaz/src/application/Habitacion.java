package application;


import javafx.beans.property.SimpleStringProperty;

public class Habitacion{
	public SimpleStringProperty habitacion=new SimpleStringProperty();
	public Habitacion(String habitacion) {
		this.habitacion=new SimpleStringProperty(habitacion);
	}

	
	public String getHabitacion() {
		return habitacion.get();
	}

	

	public void setHabitacion(String habitacion) {
		this.habitacion.set(habitacion);;
	}
	public String toString() {
		return "["+habitacion.getValue()+"]";
	}


}
