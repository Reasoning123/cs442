package taskManager.observers;
import taskManager.display.DisplayFile;
import taskManager.util.Logger;
public class ProcessesTab implements Observer, DisplayFile{
	/*@param info part of the line that has to do with Processes
	gets the part of the string that has to do with performance and formats it*/
	public String parseInfo(String info){
		Logger.printToStdout(3,"parseInfo method");
		String[] names = info.split("-");
		String list = "---PROCESSES---\n PID COMMAND		USER	%CPU %MEM\n";
		for(int i=1;i<names.length;i++){
			String[] split = names[i].split(":");
			list += split[0] + " " + split[1] + "		" + split[2] + "    " + split[3] + "   " + split[4] + "\n";
		}
		Logger.printToStdout(2, list);
		return list;
	}
}
