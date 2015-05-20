package taskManager.driver;
import java.io.*;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;
import taskManager.subject.DashboardSubject;

public class Driver{
	public static void main(String args[]) throws IOException{
		int numLines=0;
		int currLine=0;
		if(args.length == 3){
			String fileName = args[0];
			String outfileName = args[1];
			Logger.setValue(Integer.parseInt(args[2]));
			FileProcessor a = new FileProcessor();
			a.setInputFileName(fileName);
			a.setOutputFileName(outfileName);
			a.setTotalLines();
			a.createOutputFile();

			DashboardSubject subject = new DashboardSubject(a);
			subject.registerAllObservers();
			subject.start();
		}else{
			System.out.println("you need three arguments");
		}
	}

}
