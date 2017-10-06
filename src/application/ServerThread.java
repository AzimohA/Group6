package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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
