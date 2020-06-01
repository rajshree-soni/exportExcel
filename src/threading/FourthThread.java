package threading;

public class FourthThread extends Thread {
	
	@Override
	public void run() {
		
		for(int i=0;i<5;i++)
		{
			System.out.println(Thread.currentThread().getName()+"- "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
	
		
		FourthThread t1=new FourthThread();
		FourthThread t2=new FourthThread();
		FourthThread t3=new FourthThread();
		
		
	//	t2.setPriority(MAX_PRIORITY);
		
		t1.start();
		try{
			t1.join(1500);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		t2.start();
		t3.start();
		
		
	}
}
