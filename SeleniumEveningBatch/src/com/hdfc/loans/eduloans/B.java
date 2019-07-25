package com.hdfc.loans.eduloans;

public  class B extends A
{
	
	public Number m1(int i)
	{
		System.out.println("Iam overridden m1 in Class B : " + i);
		return i;
	}
	
	public void m2()
	{
		System.out.println("iam m2 from calss B");
	}
	 

	 public static void main(String[] args) 
	 {
	
		B b=new B();
		b.m2();
		b.m1(10000);
	 }
	
}


