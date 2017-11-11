package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {
	public String readFile(File file){
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
