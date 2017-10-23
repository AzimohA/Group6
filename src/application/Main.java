package application;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

//allows us to inherit all the javafx funtionlaity into this class
public class Main extends Application {
	public static final int PORT = 2222;
	public static void main(String[] args) {
		//new Main().runServer();
	    launch(args);
	}
	public void runServer()throws IOException{
	
		ServerSocket serverSocket = new ServerSocket(PORT);
	    System.out.println("open for connection ...");
	  
	    //accept connection from different clients
	  
	    while (true) {
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
		}
	}
		
	public class ServerThread extends Thread {
		Socket socket;
		ServerThread(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			//read clients input
			try {
				String message = null;
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("user "+bufferedReader.readLine()+""+" is now conneceted to the server");
				//keep reading while the client is sending a message
				while((message = bufferedReader.readLine())!= null){
					System.out.println("incoming client message: "+message);
				}
				socket.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
	}
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
			//new Main().runServer();
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
