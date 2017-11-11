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
	//Pane pane = new Pane();
	public GraphicsContext gc, gc1, gc2,gc3, arr,arrOpp;
	public Canvas canvas;
	public int count =0;
	private final int ARR_SIZE = 4;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		 canvas = new Canvas(400,400); 
		 gc = canvas.getGraphicsContext2D();
		 gc1 = canvas.getGraphicsContext2D();
		 gc2 = canvas.getGraphicsContext2D();
		 gc3 = canvas.getGraphicsContext2D();
         arr =canvas.getGraphicsContext2D();
         arrOpp =canvas.getGraphicsContext2D();
         
        pane.getChildren().add(canvas);
        pane.setStyle("-fx-background-color: white;");
        send.setStyle("-fx-background-color: blue;");
		// TODO Auto-generated method stub
		
		//group.getChildren().add(new Circle(0, 0, 10));
		
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
	// drawObjects(gc);
		
	  //life lines
	/*
	Rectangle r2 = new Rectangle(250,25,100,140);
	r2.setStroke(Color.BLACK);
	r2.setFill(null);
	r2.setStrokeWidth(3);
	r2.setArcWidth(25);
	r2.setArcHeight(25);
	// pane.getChildren().add(r2);
   */
	
	}
	
	///@SuppressWarnings("null")
	private void drawObjects1(GraphicsContext gc1) {
	//	GraphicsContext gc1 = null;
		//gc1.setStroke(Color.BLACK);
		
		//gc1.setFill(Color.WHITE);
		gc1.setFill(Color.GREY);
		gc1.fillRoundRect(80, 60, 50, 40, 10, 10);
		//gc1.strokeRoundRect(100, 60, 40, 30, 10, 10);
		gc1.setLineDashes(2);
		gc1.fillRect(100, 110, 10, 50);
		gc1.strokeLine(105, 100,105, 300);
		gc1.fillText("Node A", 85, 50);
		//gc1.fillText("msg1", 145, 120);
		//gc1.fillText("msg2", 145, 145);
		gc1.fillRect(100, 230, 10, 30);
		//gc1.strokeLine(110, 125,210, 125);
		//gc1.fillPolygon(xPoints, yPoints, nPoints);
		//drawArrow(arr,110, 125,210, 125);
	}
	
	public void drawArrow(GraphicsContext arr, int x1, int y1, int x2, int y2) {

	    arr.setFill(Color.BLACK);

	    double dx = x2 - x1, dy = y2 - y1;
	    double angle = Math.atan2(dy, dx);
	    int len = (int) Math.sqrt(dx * dx + dy * dy);

	    Affine affine = new Affine(Affine.translate(x1, y1));
	    affine.createConcatenation(Affine.rotate(angle, 0, 0));
	    arr.setTransform(affine);

	    arr.strokeLine(0, 0, len, 0);
	    arr.fillPolygon(new double[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new double[]{0, -ARR_SIZE, ARR_SIZE, 0},
	            4);

	}
	
	public void drawArrowOpp(GraphicsContext arrOpp,int x2, int y1, int x1, int y2) {
		 arrOpp.setFill(Color.BLACK);

		    double dx = x2 - x1, dy = y2 - y1;
		    double angle = Math.atan2(dy, dx);
		    int len = (int) Math.sqrt(dx * dx + dy * dy);

		    Transform transform = Transform.translate(x1, y1);
		    transform = transform.createConcatenation(Transform.rotate(Math.toDegrees(angle), 0, 0));
		    arrOpp.setTransform(new Affine(transform));

		    arrOpp.strokeLine(0, 0, len, 0);
		    arrOpp.fillPolygon(new double[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new double[]{0, -ARR_SIZE, ARR_SIZE, 0},
		            4);
	}
	
	public void drawObjects(GraphicsContext gc) {
		//gc.setStroke(Color.BLACK);
	
		gc.fillRoundRect(190, 60, 50, 40, 10, 10); 
		gc.fillRect(210, 110, 10, 50);
		gc.fillText("Node B", 195, 50);
		//gc.setLineWidth(1);
   //   gc.strokeLine(120, 90,120, 200);
      gc.strokeLine(215, 100,215, 300);
      gc.fillRect(210, 170, 10, 50);// 2nd message'
      gc.fillText("msg5", 200, 240);
	
	}
	
	public void node3(GraphicsContext gc2) {
		//gc2.setStroke(Color.BLACK);
		gc2.fillRoundRect(300, 60, 50, 40, 10, 10); 
		gc2.fillText("Node C", 305, 50);
		//gc2.setLineWidth(2);
   //   gc.strokeLine(120, 90,120, 200);
		gc2.fillRect(320, 170, 10, 50);
        gc2.strokeLine(325, 100,325, 300);
        gc2.fillRect(320, 230, 10, 30);
        gc1.fillText("msg3", 250, 180);
        gc1.fillText("msg4", 250, 200);
	}
	
	
	
	
	 public void sendFile(ActionEvent event)throws IOException {
		// GraphicsContext gc1 = null;
		//drawObjects1();
		 count++;
		 System.out.println(count);

		 if(count==1) {	 
		 drawObjects1(gc1);
		}
		if(count==2) {
		
			 drawObjects(gc);			
		}
		if(count==3) {
			node3(gc2);
		}
		
		if(count==4) {
			gc1.fillText("msg1", 145, 120);
			gc1.fillText("msg2", 145, 145);
			
			drawArrow(arr,110, 125,210, 125);
			//gc1.fillText("msg1", 145, 120);
		}
		if(count==5) {
			//gc1.fillText("msg2", 145, 145);
			drawArrowOpp(arrOpp,110, 150,210, 150);
			
		}
		
		if(count==6) {
			
			drawArrowOpp(arrOpp,220, 185,320, 185);
		}
		if(count==7) {
			
			drawArrow(arr,220, 210,320, 210);
		}
		if(count==8) {
			
			drawArrowOpp(arrOpp,110, 245,320, 245);
		}
		if(count==9) {
			
			//gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			gc.clearRect(-150, -200, canvas.getWidth(), canvas.getHeight());
			initialize(null, null);
			count = 0;
			//gc1.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		}
        if (count==0) { 
        	
        	//gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		}
		//*/
		 //drawObjects(gc);
		// new FileTransfer();
		//new FileReceive(); 
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
