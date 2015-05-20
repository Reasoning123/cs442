package taskManager.util;
import java.util.*;
import java.io.*;

public class Logger{
	private static int value=0;
	
	public static void printToStdout(int level, String debugMessage){
		if(value == 1 && level == 1){
			System.out.println(debugMessage);
		}else if(value == 2 && level == 2){
			System.out.println(debugMessage);
		}else if(value == 3 && level == 3){
			System.out.println(debugMessage);
		}
	}
	public static void setValue(int level){value = level;}

	public String toString() {
		String retValue = "\n Debug Class \n";
		return retValue;
    	}

}
