package com.javacode;

public class Program2 {
	
	public static void main(String[] args) {
		
		new Program2().add(12, 45);
	}
	
	public void add(int a,int b)
	{
		System.out.println("First- "+a+b);
	}
	
	public void add(int a,long b)
	{
		System.out.println("Second- "+a+b);
	}
	
	public void add(long a,long b)
	{
		System.out.println("third- "+a+b);
	}
	
	public void add(long a,int b)
	{
		System.out.println("Fourth- "+a+b);
	}
}
