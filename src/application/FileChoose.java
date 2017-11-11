package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.stage.FileChooser;



public class FileChoose extends ReadFile{
	//fILE
	public File file;
	
	public void selectFile() {
	MainController m = new MainController();
	
	 FileChooser fchooser = new FileChooser();
	 
		 FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
		fchooser.getExtensionFilters().add(extFilter);
	     
	     try{
	    	file = fchooser.showOpenDialog(null);	 
	     }catch(Exception e){
	    	 
	     }
	}

}
