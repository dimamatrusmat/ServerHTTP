import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.*;

public class ServerHTTP {
	
	public ServerHTTP(int portNumber) {
		System.out.println("I am Server http in port " + portNumber);
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			System.out.println("clientSocket: " + clientSocket);
			
			InputStream inputStream = clientSocket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);	
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = bufferedReader.readLine();
			System.out.println(line);
			int count = 0;
			while (line != null) {
				line = bufferedReader.readLine();
				System.out.println(count + ": " + line);
				if (count == 6) {
					break;
				}
				count++;
			}
			

			System.out.println("Close");
			
			OutputStream outputStream = clientSocket.getOutputStream();
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
			
			PrintWriter printWriter = new PrintWriter(outputStreamWriter);
			printWriter.println();
			printWriter.println("<h1>Hello My View This My First HTTP App</h1>");
			printWriter.println();
			printWriter.flush();
			clientSocket.close();
			
		} catch (IOException ioe) {
			
			System.out.println(ioe);
		}
	}
	
	
}