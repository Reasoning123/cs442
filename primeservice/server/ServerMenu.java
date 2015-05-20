package primeservice.server;
import primeservice.util.Debug;

public class ServerMenu{
/**
prints the server menu
**/
	public static void menu(){
		Debug.printToStdout("Server Menu method called");
		System.out.println("[1] Client Name");
		System.out.println("[2] All Client Queries");
		System.out.println("[3] Quit");
	}
/**
prints command to give name of person to check their inputs
**/
	public static void first(){
		Debug.printToStdout("first method called");
		System.out.println("give name of the query: ");
	}
}
