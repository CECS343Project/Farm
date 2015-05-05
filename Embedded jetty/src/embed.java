import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class embed 
{
	public static void main(String[] args) throws Throwable
	{
		Server server = new Server(8888);
		
		WebAppContext handler = new WebAppContext();
		handler.setContextPath("/");
	    handler.setWar("FarmWebApp.war");
	    
	    server.setHandler(handler);
	    server.setThreadPool(new QueuedThreadPool(20));
	    server.start();
	    server.join();
	}

}
