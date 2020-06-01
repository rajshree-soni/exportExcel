package threading;

public class DaemonThread extends Thread {
	
	
	@Override
	public void run() {

		
		if(Thread.currentThread().isDaemon())
			System.out.println("Daemon Thread");
		else
		{
			System.out.println("Regular Thread");
		}
		
	}
	public static void main(String[] args) {
		
		DaemonThread t1=new DaemonThread();
		DaemonThread t2=new DaemonThread();
		DaemonThread t3=new DaemonThread();
		
		t2.setDaemon(true);
		t1.start();t2.start();t3.start();
		
	}
	

}
