package primeservice.server;
import java.util.*;
import java.util.HashMap;
import primeservice.util.Debug;

public class AllPrimeQueries{
	HashMap<String, Vector> query = new HashMap<>();
	private String names;
	private String numbers; 
	
/**
add nameto the variable 
@param name is the name entered by the user
**/
	public void addName(String name){
		Debug.printToStdout("addName method");
		names = name;
	}
/**
add num to the variable 
@param num is the name entered by the user
**/
	public void addNum(String num){
		Debug.printToStdout("addNum method");
		numbers = num;
		addValues();
	}
/**
adds the name and number to the "database for the user to query 
**/
	private void addValues(){
		Debug.printToStdout("addValues method");
		boolean check = false;
		Vector a = new Vector(); 
		a.addElement(numbers);
		if(query.containsKey(names)){
			query.get(names).addElement(numbers);
		}else{
			query.put(names,a);
		}
	}
/**
returns the number as an int to check if it is prime
**/
	public int returnNum(){
		Debug.printToStdout("returnNum method");
		int a=0;
		try{
			a =  Integer.parseInt(numbers);
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}
/**
prints all numbers added by a specific user
**/
	public void print(String name){
		Debug.printToStdout("print method");
		if(query.containsKey(names)){
			System.out.print(name);
			System.out.println(query.get(name));
		}else{
			System.out.println("Name not in the database");
		}
	}
/**
prints the database
**/
	public String toString(){
		return "Database:" + query + "\n";
	}
}

