package taskManager.subject;

public interface Subject{
	public void registerAllObservers();
	public void notifyObservers(String[] tabs);
	public void start();
}
