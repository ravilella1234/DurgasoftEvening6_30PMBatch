package com.hdfc.loans.carloans;

import java.util.Scanner;

public class ThrowExceptionDemo extends Exception
{

	public ThrowExceptionDemo(String string) 
	{
		super(string);
	}

	public static void main(String[] args) 
	{		
		String str;
		Scanner sc=new Scanner(System.in);
		
		
		while (true) 
		{
			System.out.println("Enter the 10 character String  : ");
			str=sc.nextLine();
			if (str.length() != 10) 
			{
				try 
				{
					throw new ThrowExceptionDemo("String should be 10 Character String...");
				} 
				catch (ThrowExceptionDemo e) 
				{
					System.out.println(e.getMessage());
				}
			} 
			else
			{
				System.out.println(str);
				break;
			}
		}
	
	}

}
