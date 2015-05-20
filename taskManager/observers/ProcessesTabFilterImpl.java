package taskManager.observers;
/*checks if Processes are in the line from file*/
public class ProcessesTabFilterImpl{
	public boolean check(String s){
		boolean cont = false; 
		if(s.contains("Processes")){
			cont = true; 
		}else{
			cont = false; 
		}
		return cont;
	}
}
