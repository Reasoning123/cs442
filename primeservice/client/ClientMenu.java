package primeservice.client;	
import primeservice.util.Debug;

public class ClientMenu{
/**
prints out the menu
**/
	public static void menu(){
		System.out.println("[1] Set Client Name");
		System.out.println("[2] Enter number to query for prime");
		System.out.println("[3] Whats server response on the last number");
		System.out.println("[4] Quit");
	}
/**
prints out the command for user to enter their name
**/
	public static void first(){
		Debug.printToStdout("first method");
		System.out.println("Enter name to add:");
	}
/**
prints out the command for user to enter the number
**/
	public static void second(){
		Debug.printToStdout("second method");
		System.out.println("Enter number to add:");
	}
}
