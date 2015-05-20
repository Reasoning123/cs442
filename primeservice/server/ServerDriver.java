//http://stackoverflow.com/questions/2189684/run-multiple-java-main-methods-in-eclipse
package primeservice.server;
import primeservice.util.Debug;
import primeservice.socket.PrimeServerSocket;
import primeservice.socket.PrimeServerWorker;
import java.net.*;
import java.io.*;
/**
calls the server menu and handles input
@param args the command line arguments 
@param a the databse class
**/
public class ServerDriver {
    public static void main(String[] args, AllPrimeQueries a) throws IOException {
	Debug.printToStdout("ServerDriver called");
        boolean con = true;
	String name = "";
	while(con == true){
		ServerMenu.menu();
		name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		if(name.equals("1")){
			ServerMenu.first();
			name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			a.print(name);
		}
		if(name.equals("2")){System.out.println(a.toString());}
		if(name.equals("3")){con = false;}
	}
    }
}

