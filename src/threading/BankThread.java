package threading;

public class BankThread {

	int amount=10000;
	synchronized void withdraw(int amount)
	{
		System.out.println("going to withdraw");
		if(this.amount<amount)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.amount-=amount;
		System.out.println("Withdrawn Completed, remaining balance "+this.amount);
	}
	
	synchronized void deposit(int amount)
	{
		System.out.println("going to Deposit");
		this.amount+=amount;
		System.out.println("Deposit Completed, remaining balance "+ this.amount);
		notify();
	}
	
	public static void main(String[] args) {
		
		
		final BankThread t1=new BankThread();
		
		new Thread(){
			public void run()
			{
				t1.withdraw(10000);
			}
		}.start();
		
		new Thread(){
			public void run()
			{
				t1.deposit(2000);
			}
		}.start();
	}
}
