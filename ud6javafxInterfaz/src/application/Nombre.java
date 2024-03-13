package application;


import javafx.beans.property.SimpleStringProperty;

public class Nombre{
	public SimpleStringProperty nombre=new SimpleStringProperty();
	public Nombre(String nombre) {
		this.nombre=new SimpleStringProperty(nombre);
	}

	
	public String getNombre() {
		return nombre.get();
	}

	

	public void setNombre(String nombre) {
		this.nombre.set(nombre);;
	}
	public String toString() {
		return "["+nombre.getValue()+"]";
	}
}
