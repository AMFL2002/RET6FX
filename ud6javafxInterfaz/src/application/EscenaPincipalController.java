
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EscenaPincipalController implements Initializable{

    @FXML
    private Button perbt;
    private Stage stage;

    @FXML
    private Button armbt;

    @FXML
    private Button habbtn;

    @FXML
    private Button barabtn;
    
    @FXML
    private TextField txnpers;

    @FXML
    private TextField txtnarm;

    @FXML
    private TextField txtnhab;
    @FXML
    private TableView<Nombre> tablaNombre;
    @FXML
    private TableColumn<Nombre,String>nombreCL;
    @FXML
    private TableView<Arma> tablaArma;
    @FXML
    private TableColumn<Arma,String> armaCL;
    @FXML
    private TableView<Habitacion> tablaHabitacion;
    @FXML
    private TableColumn<Habitacion,String> habitacionCL;
	
	ObservableList<Nombre>nombres=FXCollections.observableArrayList(new Nombre("Amapola"),
			new Nombre("Celeste"),new Nombre("Prado"),new Nombre("Mora"),new Nombre("Rubio"),new Nombre("Blanco"));
    ObservableList<Arma>armas=FXCollections.observableArrayList(new Arma("bate"),
    		new Arma("pistola"),new Arma("candelabro"),new Arma("cuchillo"),new Arma("cuerda"),new Arma("hacha"),
    		new Arma("pesa"),new Arma("veneno"),new Arma("trofeo"));
    ObservableList<Habitacion>habitaciones=FXCollections.observableArrayList(new Habitacion("casa de invitados"),
    		new Habitacion("teatro"),new Habitacion("spa"),new Habitacion("observatorio"),new Habitacion("comedor"),
    		new Habitacion("terraza"),new Habitacion("salon"),new Habitacion("cocina"),new Habitacion("vestíbulo"));
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	    habitacionCL.setCellValueFactory(new PropertyValueFactory<>("habitacion"));
	    armaCL.setCellValueFactory(new PropertyValueFactory<>("arma"));
	    
		
		tablaNombre.getItems().addAll(nombres);
		tablaArma.getItems().addAll(armas);
		tablaHabitacion.getItems().addAll(habitaciones);
		
	}
    
    

    @FXML
    void btnBarajar(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("EscenaMenu.fxml"));
		Parent rootParent=loader.load();
		EscenaMenuController controller=loader.getController();
		Scene scene=new Scene(rootParent);
		Stage stage=new Stage();
		stage.setScene(scene);
		controller.guardar(nombres,armas,habitaciones);
		controller.baraja(nombres, armas, habitaciones);
		controller.pant1(stage, this);
		
		stage.show();
		this.stage.close();;
    }
//
    @FXML
    void btnnewArm(ActionEvent event) {
    	Arma a=new Arma(txtnarm.getText());
    	tablaArma.getItems().add(a);
    	armas.add(a);
    	txtnarm.setText("");
    }

    @FXML
    void btnnewHab(ActionEvent event) {
    	Habitacion h=new Habitacion(txtnhab.getText());
    	tablaHabitacion.getItems().add(h);
    	habitaciones.add(h);
    	txtnhab.setText("");
    }

    @FXML
    void btnnewPers(ActionEvent event) {
    	Nombre n=new Nombre(txnpers.getText());
    	tablaNombre.getItems().add(n);
    	nombres.add(n);
    	txnpers.setText("");
    }
    public void setStage(Stage primaryStage) {
		stage =primaryStage;
	}
    public void show() {
    	stage.show();
    }
    

}

