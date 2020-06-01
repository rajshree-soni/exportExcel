package com.javacode;

public class PatternTest {
	
	public static void main(String[] args) {
		
		
		int a[]={5,2,1,4,3};
		
		for(int i=4;i>=0;i--)
		{
			for(int j=0;j<5;j++)
			{
				if(a[j]>i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
