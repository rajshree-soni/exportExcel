package com.javacode;

public class DuplicateCharRemove {
	
	public static void main(String[] args) {
		
		String name = "Java is easy and interesting";
		
		
		for (int i = 0; i < name.length(); i++) {
			
			for (int j = 0; j < name.length(); j++) {
				
				if(String.valueOf(name.charAt(i)).equalsIgnoreCase(String.valueOf(name.charAt(j)))) 
					
					name = name.substring(0, j)+name.substring(j+1);
			}
		}
		
		System.out.println(name);
		
	}
}
