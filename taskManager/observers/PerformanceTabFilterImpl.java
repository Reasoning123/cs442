package taskManager.observers;
/*checks if Performance are in the line from file*/
public class PerformanceTabFilterImpl{
	public boolean check(String s){
		boolean cont = false; 
		if(s.contains("Performance")){
			cont = true; 
		}else{
			cont = false; 
		}
		return cont;
	}
}
