package threading;

public class SecondThread implements Runnable {

	@Override
	public void run() {
	
		System.out.println("i m called");
		
	}
	
	public static void main(String[] args) {
		
		SecondThread s=new SecondThread();
		Thread t=new Thread(s);
		t.start();
	
	}
}
