package com.hdfc.loans.eduloans;

import java.util.Scanner;

public class ArrayDemo 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Array Size :");
		int asize = sc.nextInt();
		
		int[] a=new int[asize];
		int sum=0;
		
		System.out.println("Enter the array Elements :");
		for(int i=0;i<a.length;i++)
		{
			System.out.print("a["+i+"]=");
			a[i]=sc.nextInt();
			sum=sum+a[i];
		}
		System.out.println("Sum of the array variables is : " + sum);
		
		/*int[] a= {10,20,30,40,50};
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}*/
	}
}
