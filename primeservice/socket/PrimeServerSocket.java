package primeservice.socket;
import primeservice.client.ClientMenu;
import primeservice.server.AllPrimeQueries;
import primeservice.util.CheckPrime;
import primeservice.util.Debug;
import java.net.*;
import java.io.*;
/**
opens a socket a listens for a client to conect to it then handles the input from the user. 
@param args commend line arguments
@param q the database class that handles database manipulation
**/
public class PrimeServerSocket{
	// http://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
	public static void run(String[] args, AllPrimeQueries q) throws IOException {
		Debug.printToStdout("run method in the server");
        	int portNumber = Integer.parseInt(args[1]);
		ServerSocket serverSocket = new ServerSocket(portNumber);

		while(true){
			Socket clientSocket = serverSocket.accept();
			Thread serverThread = new Thread() {
				public void run() {		    
					try (
		       			 	PrintWriter out =
		            				new PrintWriter(clientSocket.getOutputStream(), true);
		        			BufferedReader in = new BufferedReader(
		            				new InputStreamReader(clientSocket.getInputStream()));
		   			 ) {
		    
		        			String inputLine, outputLine,name;
						ClientMenu.menu();
						out.println("Welcome to the server");

						while (((inputLine = in.readLine()) != null)) {
							if(inputLine.equals("1")){
								ClientMenu.first();
								name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
								q.addName(name);
							}
							if(inputLine.equals("2")){
								ClientMenu.second();
								name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
								q.addNum(name);
							}
							if(inputLine.equals("3")){System.out.println(CheckPrime.isPrime(q.returnNum()));}
							if(inputLine.equals("4")){inputLine = "Bye.";}
							out.println(inputLine);
							ClientMenu.menu();
						}
					}catch (IOException e) {
						System.out.println("Exception caught when trying to listen on port "
				    		+ portNumber + " or listening for a connection");
				    		System.out.println(e.getMessage());
					}
				}
			};serverThread.start();
		}
	}
}
