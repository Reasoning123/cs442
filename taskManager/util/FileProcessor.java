package taskManager.util;
import java.io.*;

public class FileProcessor{
	private int totalFileLines =0;
	private String fileName = null;
	private String outputFileName = null;
	public int getTotalLine(){
		return totalFileLines;
	}
	
	public String getInputFileName(){
		Logger.printToStdout(3,"getInputFileName method");
		return fileName;
	}
	public String getOutputFileName(){
		Logger.printToStdout(3,"getOutputFileName method");
		return fileName;
	}
	public void setTotalLines() throws IOException{
		Logger.printToStdout(3,"setTotalLines method");
		FileInputStream fis = new FileInputStream(fileName);
		BufferedReader br = (new BufferedReader(new InputStreamReader(fis)));
		String hold = null;
		while((hold = br.readLine()) != null){
			totalFileLines++;
		}
		br.close();
	}
	public void setInputFileName(String fileIn){
		Logger.printToStdout(3,"setInputFileName method");
		fileName = fileIn;
	}
	public void setOutputFileName(String fileIn){
		Logger.printToStdout(3,"setOutputFileName method");
		outputFileName = fileIn;
	}
	public void createOutputFile() throws FileNotFoundException{
		Logger.printToStdout(3,"createOuputFile method");
		PrintWriter writer = new PrintWriter(outputFileName);
		writer.close();
	}
	public String readNextLine(int currLine) throws IOException{
		Logger.printToStdout(3,"readNextLine method");
		String line = null;
		try{
			FileInputStream fis = new FileInputStream(fileName);
			BufferedReader br = (new BufferedReader(new InputStreamReader(fis)));
			for(int i=0; i<totalFileLines;i++){
				line = br.readLine();
				if(i == currLine){
					br.close();
					currLine++;
					break;
				}
			} 	
		}catch (Exception e){
			e.printStackTrace();
		}
		return line;
	}	
	public void writeToFile(String line){
		Logger.printToStdout(3,"writeToFile method");
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName, true)));
			out.println(line);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}






}
