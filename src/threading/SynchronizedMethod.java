package threading;

public class SynchronizedMethod{
	
	
	public void printTable(int n)
	{
		
		System.out.println(Thread.currentThread().getName());
		
		synchronized (this) {
			for(int i=1;i<=5;i++)
			{
				System.out.println(n*i);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		SynchronizedMethod s=new SynchronizedMethod();
		
		Thread1 t1=new Thread1(s);
		Thread2 t2=new Thread2(s);
		
		t1.start();
		/*try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		t2.start();
	}
}
class Thread1 extends Thread
{
	 SynchronizedMethod s;
	public Thread1(SynchronizedMethod t)
	{
		this.s=t;
	}
	
	@Override
	public void run() {
		
		s.printTable(5);
		
	}
}
class Thread2 extends Thread
{
	 SynchronizedMethod s;
	public Thread2(SynchronizedMethod t)
	{
		this.s=t;
	}
	
	@Override
	public void run() {
		
		s.printTable(12);
		
	}
}