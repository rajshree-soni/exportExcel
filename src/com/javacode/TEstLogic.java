package com.javacode;

public class TEstLogic {
	
	public static void main(String[] args) {
		
		
		
		String value="G0434";
		
		
		int len=value.length();
		String first=value.substring(len-4);
		String second=value.substring(0,len-4);
		
		System.out.println(first+"-"+second);
		
		
		
		
	}
	
	
}
