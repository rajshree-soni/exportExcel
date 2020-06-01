package threading;

public class FirstThread extends Thread {
	
	
	@Override
	public void run() {
		System.out.println("called");
	}

	public static void main(String[] args) {
		
		FirstThread f=new FirstThread();
		f.start();
		
	}
}
