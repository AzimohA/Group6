package application;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

//Inherit'S all the javafx funtionality into this class

public class Main extends Application {
	//public static final int PORT = 2222;
	public static void main(String[] args) {
		launch(args);
	}

	
	/*private Server server;
	public void SetServer (Server server ){
		this.server = server;	
	}*/
 
	@Override
	
	public void start(Stage primaryStage) {
	
		
		
		try {
			//Parent  root = new BorderPane();
			//Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Main.fxml"));
			AnchorPane pane1 = loader.load();
			MainController mainController = loader.getController();
			mainController.setMain(this);
			Scene scene = new Scene(pane1);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	      
			primaryStage.setTitle("ui");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	private MainController mc;
	public void setMC(MainController mc) {
		this.mc = mc;
	}

	
}
