package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//Instantiate a socket that would be sending messages to do localhost
		//we also need to keep track of the name of the client connected  to user
		String name = args[0];
		Socket socket = new Socket("localhost", 2222);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);//client write's msg to the server
		printWriter.println(name);
		BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));//read what the client is writing in the cm
        while (true){
			//in a while loop so that the server can keep sending messages while its connected
			String readerIn = bufferedReader.readLine();
			printWriter.println(name + ": " + readerIn);
		}
	}

}
