package com.hdfc.loans.carloans;

public interface Rbi 
{
	public void withdrawl();
	public void deposit();
	
	public static void main(String[] args) {
		Rbi i;
				
		i=new Hdfc();
		i.deposit();
		i.withdrawl();
		
		i=new Kotak();
		i.deposit();
		i.withdrawl();
		
	}
	
}
