package com.javacode;

public class SingletonClassExample {
	
	
	private SingletonClassExample ()
	{
		
	}
	
	private static SingletonClassExample obj;
	
	static{
		obj=new SingletonClassExample();
	}
	
	public void callMe()
	{
		System.out.println("Call me");
	}
	
	public static void main(String[] args) {
		
		obj.callMe();
		
	}

}

