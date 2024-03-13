package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	
	public void start(Stage primaryStage) throws IOException {
	FXMLLoader loader=new FXMLLoader(getClass().getResource("EscenaPincipal.fxml"));
	Parent root=loader.load();
	Scene escenaScene=new Scene(root);
	primaryStage.setScene(escenaScene);
	EscenaPincipalController controller=loader.getController();
	controller.setStage(primaryStage);
	primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
