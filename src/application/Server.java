package application;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static final int PORT = 2222;
	public static void main(String[] args) throws IOException{
		new Server().runServer();

	}
	
	private void runServer()throws IOException{
		ServerSocket serverSocket = new ServerSocket(PORT);
	    System.out.println("open for connection ...");
	  
	    //accept connection from different clients
	  
	    while (true) {
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
		}
		
		
	}

}
