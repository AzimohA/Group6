package application;

import java.io.File;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransfer extends Server{
	//Client client = new Client();
	public FileInputStream fis = null;
	 public BufferedInputStream bis = null;
	 //OutputStream os = socket.getOutputStream();
	public OutputStream os =null;
	 public final static int SOCKET_PORT = 2222;  // you may change this
 public final static String FILE_TO_SEND ="C:/Users/Toshiba/Documents/JSONfiles/jtest.json";
 String counter;
 
	
	public FileTransfer() throws IOException{
		
		
	//	pFileInputStream fis = null;
	  //  BufferedInputStream bis = null;
	    //OutputStream os = null;
	    //ServerSocket servsock = null;
	   Socket socket = null;
	    try {
	     // servsock = new ServerSocket(SOCKET_PORT);
	  //    while (true) {
	        System.out.println("Waiting...");
	        try {
	       // new Thread(()->{
	          //sock = servsock.accept();
	          System.out.println("Accepted connection : " + socket);
	          // send file
	          File myFile = new File (FILE_TO_SEND);
	          byte [] mybytearray  = new byte [(int)myFile.length()];
	          try {
				fis = new FileInputStream(myFile);
				  bis = new BufferedInputStream(fis);
				  bis.read(mybytearray,0,mybytearray.length);
      
					
						  OutputStream	os = socket.getOutputStream();
						  System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
				          os.write(mybytearray,0,mybytearray.length);
				          os.flush();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	         
	          
	          
	          System.out.println("Done.");
	       // }).start();
	        }
	        
	        finally {
	          if (bis != null) bis.close();
	          if (os != null) os.close();
	         // if (sock!=null) sock.close();
	        }
	 //     }
	    }
	    finally {
	     // if (servsock != null) servsock.close();
	    }
	}
	
}
