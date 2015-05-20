package primeservice.util;

public class CheckPrime{

	public static String isPrime(int n){
		Debug.printToStdout("isPrime method");
		if(n % 2 == 0){
			return "Not Prime";
		}
		for(int i = 3; i * i <= n; i+= 2){
			if(n % i == 0){
				return "Not Prime";
			}
		}	
		return "Is Prime";
	}
	

}
