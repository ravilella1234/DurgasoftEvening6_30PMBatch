package com.hdfc.loans.carloans;

import com.hdfc.loans.eduloans.Icici;

public interface Rbi 
{
	public void withdrawl();
	public void deposit();
	
	public static void main(String[] args) {
		Rbi i;
		
		i=new Icici();
		i.deposit();
		i.withdrawl();
		
		i=new Hdfc();
		i.deposit();
		i.withdrawl();
		
		i=new Kotak();
		i.deposit();
		i.withdrawl();
		
	}
	
}
