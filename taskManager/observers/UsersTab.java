package taskManager.observers;
import taskManager.display.DisplayFile;
import taskManager.util.Logger;
public class UsersTab implements Observer, DisplayFile{
	/*@param info part of the line that has to do with Users
	gets the part of the string that has to do with performance and formats it*/
	public String parseInfo(String info){
		Logger.printToStdout(3,"parseInfo method");
		String[] names = info.split("-");
		String list = "---USERS---\n";
		for(int i=0;i<names.length;i++){
			String[] split = names[i].split(":");
			list += "User: " + split[0] + "  Status: " + split[1] +"\n";
		}
		Logger.printToStdout(2, list);
		return list;
	}
}
