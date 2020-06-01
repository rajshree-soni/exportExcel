package com.javacode;

public class Program3 {
	
	
	public static void main(String[] args) {
		
		
		String data="AAABBBBCCAAAAAAA";
		String res="";
		int count=1;
		for(int i=0;i<data.length();i++)
		{
			for(int j=i+1;j<data.length();j++)
			{
				if(data.charAt(i)==data.charAt(j))
					count++;
				else
					break;
			}
			res+=count+String.valueOf(data.charAt(i));
			i=i+count-1;
			count=1;
		}
		
		System.out.println(res);
		
	}

}
