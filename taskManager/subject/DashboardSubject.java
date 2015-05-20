package taskManager.subject;
import java.util.*;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;
import taskManager.observers.UsersTab;
import taskManager.observers.ProcessesTab;
import taskManager.observers.PerformanceTab;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.PerformanceTabFilterImpl;
public class DashboardSubject implements Subject{
	Object[] obs = new Object[6];	
	UsersTab a = new UsersTab();
	UsersTabFilterImpl aFilter = new UsersTabFilterImpl();
	ProcessesTab b = new ProcessesTab();
	ProcessesTabFilterImpl bFilter = new ProcessesTabFilterImpl();
	PerformanceTab c = new PerformanceTab();
	PerformanceTabFilterImpl cFilter = new PerformanceTabFilterImpl();
	FileProcessor file;
	/*@param in is the fileprocessor instantiated in the driver code*/
	public DashboardSubject(FileProcessor in){
		file = in;
	}
	/* registers the observers in the vector*/
	public void registerAllObservers(){
		Logger.printToStdout(3,"registerAllObservers method");
		obs[0] = a;
	 	obs[1] = aFilter;
		obs[2] = b;
		obs[3] = bFilter;
		obs[4] = c;
		obs[5] = cFilter;	
	}
	/*@param tabs are the different tabs that each line has.It get checked by the the observer filters and then implemented by the right observers*/
	public void notifyObservers(String[] tabs){
		Logger.printToStdout(3,"notifyObservers method");
		boolean user, proc, perf;
		file.writeToFile("---TAB(s) BEGIN---");
		for(int i=0; i<tabs.length;i++){
				Logger.printToStdout(1, tabs[i]);
				user = aFilter.check(tabs[i]);
				proc = bFilter.check(tabs[i]);
				perf = cFilter.check(tabs[i]);
				if(user == true){
					file.writeToFile(a.parseInfo(tabs[i]));
				}if(proc == true){
					file.writeToFile(b.parseInfo(tabs[i]));
				}if(perf == true){
					file.writeToFile(c.parseInfo(tabs[i]));
				}
		}
		file.writeToFile("---TAB(s) END---");
	}
	/*reads each line that then get passed to the observers*/
	public void start(){
		Logger.printToStdout(3,"start method");
		int end = file.getTotalLine();
		String[] tabs;
		String line;
		for(int start=0; start < end; start++){		
			try{
				line = "";
				line = file.readNextLine(start);
				tabs = line.split("\\*");
				notifyObservers(tabs);
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
}
