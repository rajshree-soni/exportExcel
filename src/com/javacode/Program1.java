package com.javacode;

public class Program1 {
	
	public static void main(String[] args) {
		
		int num=117935;
		String temp=String.valueOf(num);
		int val[]=new int[temp.length()];
		for(int i=0;i<temp.length();i++)
		{
			val[i]=Integer.parseInt(String.valueOf(temp.charAt(i)));
		}
		for(int i=0;i<val.length;i++)
		{
			for(int j=0;j<val.length;j++)
			{
				if(val[i]>val[j])
				{
					int temp1=val[i];
					val[i]=val[j];
					val[j]=temp1;
				}
			}
		}
		
		for(int i=0;i<val.length;i++)
		{
			System.out.println(val[i]);
		}
		
	}
}
