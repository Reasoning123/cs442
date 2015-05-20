
 // http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
package primeservice.client;
import primeservice.socket.PrimeClientWorker;
import primeservice.server.AllPrimeQueries;
import java.io.*;
import java.net.*;
/**	
Connect to the port the server is using 
@param args the arguments from the command line
**/
public class ClientDriver {
	public static void main(String[] args, AllPrimeQueries a) throws IOException {
		PrimeClientWorker.run(args);
    }
}
