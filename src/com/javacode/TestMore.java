package com.javacode;

public class TestMore {
	
	/*1
	11
	21
	1211
	111221
	312211
	13112221*/
	
	
	public static void main(String[] args) {
		
		
		/*String res="1";
		
		for(int i=0;i<17;i++)
		{
			System.out.println(res);
			res=getRow(res);
		}*/
		
		String num = "1"; 
		 
		for (int i=1;i<=10;i++) {
			System.out.println(num);
			num = lookandsay(num);             
		}
	}
	
	public static String lookandsay(String number){
		StringBuilder result= new StringBuilder();
	 
		char repeat= number.charAt(0);
		number= number.substring(1) + " ";
		int times= 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat = actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}
	
	public static String getRow(String data)
	{
		String result="";
		for(int i=0;i<data.length();i++)
		{
			int len=1;
			for(int j=i+1;j<data.length();j++)
			{
				if(data.charAt(i)==data.charAt(j))
					len++;
				else
					break;
			}
			result=result+String.valueOf(len)+String.valueOf(data.charAt(i));
			i=i+len-1;
		}
		
		return result;
	}
}

