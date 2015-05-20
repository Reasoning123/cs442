package primeservice.driver;
import java.io.*;
import primeservice.util.CheckPrime;
import primeservice.client.ClientDriver;
import primeservice.server.ServerDriver;
import primeservice.server.AllPrimeQueries;
import primeservice.socket.PrimeServerSocket;
public class PrimeDriver{

/**
 Starts the server and then asks the user whter to use the server or client menu
@param args array of input from the command line
**/
	public static void main(String args[]) throws IOException {	
			AllPrimeQueries a = new AllPrimeQueries();
			Thread serverThread = new Thread() {
		public void run() {
			try{
		        	PrimeServerSocket.run(args, a);
			}catch(Exception e){
				e.printStackTrace();
			}
		   }
			};
			serverThread.start();

		String name = "";
		System.out.println("client, server, quit");
		while(name.equals("")){
			try{
			name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			if(name.toLowerCase().equals("server")){
				try{
		        	ServerDriver.main(args, a);
				System.out.println("inside server");
			}catch(Exception e){
				e.printStackTrace();
			}
			}else if(name.toLowerCase().equals("client")){
				try{
		        	ClientDriver.main(args, a);
				System.out.println("inside client");
			}catch(Exception e){
				e.printStackTrace();
			}
			}else if (name.toLowerCase().equals("quit")){
				System.out.println("quit");
				System.exit(0);
			}
			System.out.println("client, server, quit");
			name ="";
		}
	}
}

