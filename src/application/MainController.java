package application;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;

public class MainController implements Initializable{
	@FXML
	private Label myRan;
	@FXML
	private Button load;
	@FXML
	private TextArea textArea;
	@FXML
	private Pane pane;
	@FXML
	private Button draw;
	//Pane pane = new Pane();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		Canvas canvas = new Canvas(400,400); 
		GraphicsContext gc = canvas.getGraphicsContext2D();
       
        pane.getChildren().add(canvas);
        pane.setStyle("-fx-background-color: white;");
        
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
	 drawObjects(gc);
		
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
	
	//@SuppressWarnings("unused")
	private void drawObjects(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.GREEN);
		gc.strokeRoundRect(160, 60, 40, 30, 10, 10);
		gc.fillRoundRect(100, 60, 40, 30, 10, 10);
	
        gc.setLineWidth(3);
        gc.strokeLine(120, 90,120, 200);
        gc.strokeLine(180, 90,180, 200);
      //  gc.StrokeDashArray(2d);
        //(x,start,y,length)
    
		
		

		
	}
	
	
	
	
	
	private Main main;
	public void setMain(Main main) {
		this.main = main;
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
 
 public void fileSelect(ActionEvent event){
	 FileChooser fchooser = new FileChooser();
	 
	//Set extension filter
	// File f = fchooser.showOpenDialog(null);
	// String filename = f.getAbsolutePath(); 
   //  FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	 FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
	 fchooser.getExtensionFilters().add(extFilter);
     
     try{
    	// FileReader reader = new FileReader(filename);
    	// BufferedReader br = new BufferedReader(reader);
    	// textArea.read(
    	File file = fchooser.showOpenDialog(null);
    	if(file != null){
           textArea.setText(readFile(file));
          
        }
    	 
    	 
     }catch(Exception e){
    	 
     }
      
 }

private String readFile(File file){
	StringBuilder stringBuff = new StringBuilder();
	BufferedReader br = null;
	try{
		 br = new BufferedReader(new FileReader(file));
         
         String text;
         while ((text = br.readLine()) != null) {
        	 stringBuff.append(text +"\n");
            // stringBuff.append(text);
         }
		br.close();
	}catch(Exception e) {
      //  Logger.getLogger(JavaFX_OpenFile.class.getName()).log(Level.SEVERE, null, ex);
    }
	//finally{
  //  	
   // }
	return stringBuff.toString();
 }



 
 
 

}
