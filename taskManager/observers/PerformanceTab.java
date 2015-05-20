package taskManager.observers;
import taskManager.display.DisplayFile;
import taskManager.util.Logger;

public class PerformanceTab implements Observer, DisplayFile{
	/*@param info part of the line that has to do with performance
	gets the part of the string that has to do with performance and formats it*/
	public String parseInfo(String info){
		Logger.printToStdout(3,"parseInfo method");
		String list = "---PERFORMANCE---\n";
			String[] split =info.split(":");
			list += "Memory Total: " + split[0] + " Memory Used: " + split[1] + " Memory Free: " + split[2] + " Memory Cached: " + split[3] + " CPU Idle: " + split[4] + "  CPU User Level: " + split[5] + " CPU System Level: " + split[6] + "\n";
		Logger.printToStdout(2, list);
		return list;
	}
}
