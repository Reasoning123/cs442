package objComp.driver;

import java.io.File;

import objComp.util.First;
import objComp.util.Second;
import objComp.util.PopulateObjects;
import objComp.fileOperations.FileProcessor;

/*
public class Driver{
	public static void main(String args[]){
		if(args.length != 3){
			System.out.println("to run its: ant run <input file> <output file> <debug value>");
		System.exit(1);
		}
		try{
			FileProcessor a = new FileProcessor(args[0], args[1]);
			PopulateObjects b = new PopulateObjects(a);
			b.deserObjects();
			System.out.println(b.returnTotalFirst());
			System.out.println(b.returnTotalSecond());
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
*/

public class Driver {

	private static int NUM_ITERATIONS;

	private static void setNumIterations(int n) {
		NUM_ITERATIONS = n;
	}

	public static void main(String args[]) {
		if(args.length != 3) {
			System.err.println("Error: 3 command line arguments must be specified");
			System.err.println("Arguments: input.txt NUM_ITERATIONS DEBUG_VAL");
			System.exit(1);
		}

		File inArg = new File(args[0]);
		if(!inArg.isFile()) {
			System.err.println("Error: Could not locate specified input file");
			System.exit(1);
		}

		try {
			int numIterations = Integer.parseInt(args[1]);
			if(numIterations <= 0) {
				System.err.println("Error: The NUM_ITERATIONS argument must be greater than 0");
				System.exit(1);
			}
			setNumIterations(numIterations);
		} catch (NumberFormatException e) {
			System.err.println("Error: The NUM_ITERATIONS argument needs to be of type int");
			System.exit(1);
		}

		// Check if debugVal argument is of type int and is between 0 and 4
		try {
			int logVal = Integer.parseInt(args[2]);
			if((logVal < 0) || (logVal > 4)) {
				System.err.println("Error: The DEBUG_VAL argument must be between 0 and 4");
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			System.err.println("Error: The DEBUG_VAL argument needs to be of type int");
			System.exit(1);
		}

		String inputFile = args[0];

		FileProcessor fp = new FileProcessor(inputFile);
		PopulateObjects po = new PopulateObjects(fp);

		po.deserObjects();
	}

}