package com.hdfc.loans.eduloans;

import com.hdfc.loans.carloans.C;

public  class A 
{
	
	public  Number m1(int i)
	{
		System.out.println(i);
		return i;
	}
	
	
 
	 public static void main(String[] args)  
	 {
		 A a=new A();
		 a.m1(100);
		 
		 A obj;
		 
		 obj=new B();
		 obj.m1(100);
		 
		 obj=new C();
		 obj.m1(200);
		
	 }
}
