package objComp.fileOperations;

import java.io.*;

public class FileProcessor {

	private FileInputStream fis;
	private BufferedReader br;

	public FileProcessor(String input) {
		try {
			fis = new FileInputStream(input);
			br = new BufferedReader(new InputStreamReader(fis));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void closeInputFile() {
		try {
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String readLineFromFile(){
		String line = null;
		try{
			line = br.readLine();				
		}catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		return line;
	}		
}
