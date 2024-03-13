

package application;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.time.LocalDate;
import java.time.LocalTime;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EscenaMenuController {
	private EscenaPincipalController controlador1;
	private Stage stage;
	ObservableList<Nombre>nombres=FXCollections.observableArrayList();
	ObservableList<Arma>armas=FXCollections.observableArrayList();
	ObservableList<Habitacion>habitacions=FXCollections.observableArrayList();
	ObservableList<Jugador>aux=FXCollections.observableArrayList();
	
	  @FXML
	    private Label txtnom;

	    @FXML
	    private Label txtarm;

	    @FXML
	    private Label txthab;



	    @FXML
	    private TableView<Jugador> tablaBarajados;
	    @FXML
	    private TableColumn<Jugador, Nombre> nombreCL=new TableColumn<>("Nombre");

	    @FXML
	    private TableColumn<Jugador, Arma> armaCL=new TableColumn<>("Arma");

	    @FXML
	    private TableColumn<Jugador, Habitacion> habitacionCL=new TableColumn<>("Habitacion");

	    @FXML
	    private TableColumn<Jugador, LocalTime> horaCL=new TableColumn<>("Hora sistema");

	  
	   
	    @FXML
	    
	    void newBarajar(ActionEvent event) {
	    	
	    	baraja(nombres,armas,habitacions);
	    }
    public void showstage2(ActionEvent event) {
    	
	controlador1.show();
	stage.close();
    	
    	}
    public void pant1(Stage stage, EscenaPincipalController escenaPincipalController)
    {
    	this.controlador1=escenaPincipalController;
    	this.stage=stage;
    }
    public void guardar(ObservableList<Nombre>listaNombres,ObservableList<Arma>listaArmas, ObservableList<Habitacion>listaHabitacions) 
    {
    	this.nombres=listaNombres;
    	this.armas=listaArmas;
    	this.habitacions=listaHabitacions;
    }
    public void baraja(ObservableList<Nombre>listaNombres,ObservableList<Arma>listaArmas, ObservableList<Habitacion>listaHabitacions)
    {
    	nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        habitacionCL.setCellValueFactory(new PropertyValueFactory<>("habitacion"));
        armaCL.setCellValueFactory(new PropertyValueFactory<>("arma"));
        horaCL.setCellValueFactory(new PropertyValueFactory<Jugador,LocalTime>("horaPartida"));
    	int aleatorion=(int)(Math.random()*(listaNombres.size()));
    	txtnom.setText(listaNombres.get(aleatorion).toString());
    	int aleatorioa=(int)(Math.random()*(listaArmas.size()));
    	txtarm.setText(listaArmas.get(aleatorioa).toString());
    	int aleatorioh=(int)(Math.random()*(listaHabitacions.size()));
    	txthab.setText(listaHabitacions.get(aleatorioh).toString());
    	LocalTime hora=LocalTime.now();
    	Jugador jugador=new Jugador(txtnom.getText(), txtarm.getText(), txthab.getText(), hora);
    	tablaBarajados.getItems().add(jugador);
    	aux.add(jugador);
    	
    	
    
    }
    public void fichero(ActionEvent event) {
    	try {
    		String directorio=System.getProperty("user.dir");
    		String rutaString=directorio+File.separator+"Combinaciones.txt";
    		BufferedWriter f=new BufferedWriter(new FileWriter(rutaString,true));
    		
    		ObservableList<Jugador>aux=this.aux;
    		for(int i=0;i<=aux.size()-1;i++)
    		{
    			f.write("Cabecera - Fecha: " +LocalDate.now()+"\n");
    			f.write(aux.get(i).toString()+"\n");

    		}
    		f.close();
		} catch (Exception e) {
System.out.println("Error");
		}
    	
    }
	

}