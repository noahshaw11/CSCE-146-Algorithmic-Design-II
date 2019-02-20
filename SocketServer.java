import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
public class SocketServer {
	private GenLL<Socket> connections;
	private Thread connectionThread;
	private ServerSocket socket;
	private QueueInterface<String> msgQ;
	public static final int PORT = 5280;
	public static final int MAX_USERS = 1;
	public static final int MAX_Q_SIZE = 10;
	public static final Semaphore MUTEX = new Semaphore(MAX_USERS);
	public SocketServer()
	{
		init();
	}
	public void init()
	{
		try
		{
			connections = new GenLL<Socket>();
			msgQ = new LLQueue<String>();
			socket = new ServerSocket(PORT);
			connectionThread = new Thread()
				{
					public void run()
					{
						while(true)
						{
							try
							{
								Socket newS = socket.accept();
								System.out.println("Client connect");
								while(!MUTEX.tryAcquire());
								connections.insert(newS);
								BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(newS.getOutputStream()));
								for(String s : msgQ)
								{
									writer.write(s);
									writer.newLine();
								}
								writer.flush();
								MUTEX.release();
								System.out.println("Client has connected");
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
						}
					}
				};
				connectionThread.start();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void serverRun()
	{
		BufferedReader reader;
		while(true)
		{
			try
			{
				if(!MUTEX.tryAcquire())
				{
					Thread.sleep(100);
					continue;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

}
