package com.hdfc.loans.carloans;

import com.hdfc.loans.eduloans.A;

public class C extends A
{
	public Number m1(int i)
	{
		System.out.println("Iam overridden m1 in Class C : " + i);
		return i;
	}

	 public  void m3() 
	 {
		 System.out.println("iam m3 from class C");
	 }
	 
	 public static void main(String[] args) 
	 {
		 
		
		C c=new C();
		
	}
}
