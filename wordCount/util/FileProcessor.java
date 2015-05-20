package wordCount.util;

import java.io.*;

public class FileProcessor {
	private String fileName = null;
	private String outputFileName = null;
	public String getInputFileName(){
		return fileName;
	}
	public String getOutputFileName(){
		return fileName;
	}
	public void setInputFileName(String fileIn){
		fileName = fileIn;
	}
	public void setOutputFileName(String fileIn){
		outputFileName = fileIn;
	}
	public void createOutputFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(outputFileName);
		writer.close();
	}
	public void readFile() throws IOException{
		String line = null;
		try{
			FileInputStream fis = new FileInputStream(fileName);
			BufferedReader br = (new BufferedReader(new InputStreamReader(fis)));
			while((line = br.readLine()) != null){
				// do stuff here
			} 	
		}catch (Exception e){
			e.printStackTrace();
		}
	}	
	public void writeToFile(String line){
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName, true)));
			out.println(line);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
