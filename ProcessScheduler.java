/*
 * Written by Noah Shaw
 */
public class ProcessScheduler {
	
	//Attributes
	private LinkedListQueue<Process> processes = new LinkedListQueue<Process>();
	private Process currentProcess;
	
	//Methods
	public Process getCurrentProcess()
	{
		return this.currentProcess;
	}
	public void addProcess(Process aProcess)
	{
		if(this.currentProcess == null)
		{
			this.currentProcess = aProcess;
		}
		else
		{
			processes.enqueue(aProcess);
		}
	}
	public void runNextProcess()
	{
		this.currentProcess = processes.dequeue();
	}
	public void cancelCurrentProcess()
	{
		this.currentProcess = null;
		this.currentProcess = processes.dequeue();
	}
	public void printProcessQueue()
	{
		processes.print();
	}

}
