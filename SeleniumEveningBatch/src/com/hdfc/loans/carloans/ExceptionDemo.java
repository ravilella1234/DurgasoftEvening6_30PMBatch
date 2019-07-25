package com.hdfc.loans.carloans;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo 
{

	public static void main(String[] args) 
	{
		int nr,dr,result;
		Scanner sc=new Scanner(System.in);
		
			int i=1;
			do 
			{
				System.out.println("------- " + i  + "  time " + "------- ");
				while (true) 
				{
					System.out.println("Enter the numarator value :");
					nr = sc.nextInt();
					System.out.println("Enter the Denominator value :");
					dr = sc.nextInt();
					try 
					{
						result = nr / dr;
						System.out.println(result);
						break;
					} 
					catch (InputMismatchException e) 
					{
						System.out.println("Number should be a Integer Value...");
					}
					catch (ArithmeticException e)
					{
						System.out.println("Denominator value should be greater than zero....");
					}
					finally 
					{
						System.out.println("iam final block.....");
					}
					
				} 
				i++;
			} while (i<=5); 
	}
}
