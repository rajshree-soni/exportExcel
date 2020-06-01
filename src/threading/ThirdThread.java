package threading;

public class ThirdThread extends Thread {
	
	@Override
	public void run() {
		
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException exc)
			{
				exc.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		
		ThirdThread t1=new ThirdThread();
		ThirdThread t2=new ThirdThread();
		
		t1.start();t2.start();
	}

}
