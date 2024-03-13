package application;


import javafx.beans.property.SimpleStringProperty;

public class Arma{
	public SimpleStringProperty arma=new SimpleStringProperty();
	public Arma(String arma) {
		this.arma=new SimpleStringProperty(arma);
	}

	
	public String getArma() {
		return arma.get();
	}

	

	public void setArma(String arma) {
		this.arma.set(arma);;
	}
	public String toString() {
		return "["+arma.getValue()+"]";
	}


}
