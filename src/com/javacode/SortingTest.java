package com.javacode;

public class SortingTest {
	
	public static void main(String[] args) {
		
		
		int arr[]={23,34,12,1,4,67,3,5,60};
		int temp=0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ,");
		}
	}
}
