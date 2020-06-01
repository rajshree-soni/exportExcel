package com.javacode;


public class Test {
	
	public static void main(String[] args) {
		
	
		System.out.println(reverseData("CALL11565"));
		
		System.out.println((char)91);
	}
	public static String reverseData(String data)
	{
		String res="";
		for(int i=0;i<data.length();i++)
		{
			int temp=data.charAt(i);
			if(temp>=65 && temp<=91)
			{
				if(i==0)
					res=res+"-"+data.charAt(i);
				else
					res=res+""+data.charAt(i);
			}
			else 
				break;
		}
		int index=0;
		if(res.length()>0)
			index=res.length()-1;
		
		return data.substring(index)+res;
	}
}