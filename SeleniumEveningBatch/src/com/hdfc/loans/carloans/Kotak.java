package com.hdfc.loans.carloans;

public class Kotak implements Rbi
{

	public static void main(String[] args) 
	{
		
		Kotak k=new Kotak();
		k.deposit();
		k.withdrawl();
	}

	@Override
	public void withdrawl() {
		System.out.println("iam overridden withdrawl in Kotak");
		
	}

	@Override
	public void deposit() {
		System.out.println("iam overridden deposit in Kotak");
		
	}

}
