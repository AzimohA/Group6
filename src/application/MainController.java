package application;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import javafx.stage.FileChooser;

public class MainController extends Thread implements Initializable {
	@FXML
	public Label myRan;
	@FXML
	private Button load;
	@FXML
	public TextArea textArea;
	@FXML
	private Pane pane;
	@FXML
	private Button draw;
	@FXML
	public RadioButton client;
	@FXML 
	public Button send;
	public Canvas canvas;
	public int count =0;
	UMLmodels md = new UMLmodels();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 canvas = new Canvas(400,400); 
		 md.gc = canvas.getGraphicsContext2D();
		 md.gc1 = canvas.getGraphicsContext2D();
		 md.gc2 = canvas.getGraphicsContext2D();
		 md.gc3 = canvas.getGraphicsContext2D();
		 md.arr = canvas.getGraphicsContext2D();
		 md.arrOpp =canvas.getGraphicsContext2D();
         
         pane.getChildren().add(canvas);
         pane.setStyle("-fx-background-color: white;");
         send.setStyle("-fx-background-color: blue;");
		// TODO Auto-generated method stub
		

		
	for (int i = 0; i <600; i+=10)
		{
		    Line line1 = new Line(i, 0, i, 600);
		    line1.setStroke(Color.LIGHTGREY);
		    Line line2 = new Line(0, i, 600, i);
		    line2.setStroke(Color.LIGHTGREY);
		   // pane.setStyle("-fx-background-color: white;");
		   // pane.getChildren().addAll(line1, line2);
		    pane.getChildren().add(line1);
		    pane.getChildren().add(line2);
		    //drawObjects(gc);
		
		}
	 canvas.toFront();
	}
	
	
	 public void sendFile(ActionEvent event)throws IOException {
		// GraphicsContext gc1 = null;
		//drawObjects1();
		 count++;
		 System.out.println(count);
		 switch (count) {
			case 1: md.drawObjects1( md.gc1);
			        break;
			case 2: md.drawObjects(md.gc);
	                break;
			case 3: md.node3(md.gc2);
					break;
			case 4: md.gc1.fillText("msg1", 145, 120);
			        md.gc1.fillText("msg2", 145, 145);
			        md.drawArrow(md.arr,110, 125,210, 125);
			        break;
			case 5: md.drawArrowOpp(md.arrOpp,110, 150,210, 150);
					break;
			case 6: md.drawArrowOpp(md.arrOpp,220, 185,320, 185);
					break;
			case 7: md.drawArrow(md.arr,220, 210,320, 210);
					break;
			case 8: md.drawArrowOpp(md.arrOpp,110, 245,320, 245);
			break;
			case 9: md.gc.clearRect(-150, -200, canvas.getWidth(), canvas.getHeight());
			        initialize(null, null);
			        count = 0;
	 
			default: break;
			
			}
		
	 }
	
	
	 
	//@SuppressWarnings("unused")
	private Main main;
	public void setMain(Main main) {
		this.main = main;
	}
	
	public Client client1;
	public void setClient(Client client1) {
		this.client1=client1;
	}
	

	 public void drawLine(ActionEvent event) {
		
		  
			
				for (int i = 0; i <600; i+=10)
					{
					    Line line1 = new Line(i, 0, i, 600);
					    line1.setStroke(Color.LIGHTGREY);
					    Line line2 = new Line(0, i, 600, i);
					    line2.setStroke(Color.LIGHTGREY);
					    pane.setStyle("-fx-background-color: white;");
					    pane.getChildren().addAll(line1, line2);
					   
					}
	  }
	 

    
    
 public void generateRandom(ActionEvent event){
	 Random ran = new Random();
	 int rannum = ran.nextInt(50)+1;
	 myRan.setText(Integer.toString(rannum)); 
	 //System.out.println(Integer.toString(rannum));
 }

 
 //Server serve = new Server();
 public void serverConnect(ActionEvent event) {
	
	Platform.runLater(()->{
		
	
	 try {
		
		/* 
			MainController thread = new MainController();
			thread.start();
			thread.setClient(new Client());
		   
			*/
			//new Client();
		 
			// Client cl= new Client();
			// myRan.setSkin(Color.GREEN);
			// myRan.setOpaque(true);
	   //*
			 new Thread(new Runnable() {
				 @Override
				 public void run() {
					
					//Client cl= new Client();
				//	try {
						//new Server().runServer();
					//} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					//}
				 }
			  }).start();
		  //*/
	//	 else {
		//	 serverSocket.close();
		 //}
	
		 //else myRan.setText("server closed!");
	 }catch(Exception e) {
		 
	 }
	});	 
 }
 
 FileChoose fc = new FileChoose();
 public void fileSelect(ActionEvent event){
	 fc.selectFile();
	 if(fc.file != null){
         textArea.setText(fc.readFile(fc.file));
      }
 }

}
