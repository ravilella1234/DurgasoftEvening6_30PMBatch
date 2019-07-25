package com.hdfc.loans.carloans;

import com.hdfc.loans.eduloans.Employee;

public class ChildClass extends Employee
{
	String city;

	public ChildClass(String city) 
	{
		super(1745,"saikeerthan",12000.00f);
		this.city=city;
		System.out.println(this.city);
	}
	
	public void m1()
	{
		
	}
	
	

	public static void main(String[] args) 
	{
		ChildClass c=new ChildClass("Hyderabad");

	}
}
