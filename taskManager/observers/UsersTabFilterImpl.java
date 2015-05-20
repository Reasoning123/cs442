package taskManager.observers;
/*checks if Users are in the line from file*/
public class UsersTabFilterImpl{
	public boolean check(String s){
		boolean cont = false; 
		if(s.contains("Users")){
			cont = true; 
		}else{
			cont = false; 
		}
		return cont;
	}
}
