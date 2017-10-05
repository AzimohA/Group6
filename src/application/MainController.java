package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class MainController {
	@FXML
	private Label myRan;
	@FXML
	private Button load;
	@FXML
	private TextArea textArea;
	
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
     FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
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
