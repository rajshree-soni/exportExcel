package com.javacode;

public class DMDProblem {
	
	public DMDProblem()
	{
		
		System.out.println("Super Class Cons");
	}
	
	public void first()
	{
		System.out.println("Super first");
	}
	public void second()
	{
		System.out.println("super second");
	}
	public void third(int i)
	{
		System.out.println("Super Third ");
	}
}
class Problem2 extends DMDProblem {
	
	public Problem2()
	{
		System.out.println("child Class Cons");
	}
	
	public void first()
	{
		System.out.println("child first");
	}
	public void second()
	{
		System.out.println("child second");
	}
	
	public void third()
	{
		System.out.println("child Third ");
		System.out.println("testing");
	}

	
	
public static void main(String[] args) {
		
		Problem2 t=new Problem2();
		t.first();
		t.second();
		t.third();
		
	}
}