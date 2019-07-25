package com.hdfc.loans.eduloans;

public class Employee 
{
	public int eno;
	public String ename;
	public float sal;
	
	/*public Employee()
    {
		System.out.println("Iam default no argument constructor...");
		
		System.out.println(this.eno);
		System.out.println(this.ename);
		System.out.println(this.sal);
    }*/
	
	public Employee(int eno) 
	{
		//this();
		this.eno=eno;
		
		System.out.println(this.eno);
		System.out.println(this.ename);
		System.out.println(this.sal);
	}
	
	public Employee(int eno, String ename) 
	{
		this(1743);
		this.eno=eno;
		this.ename=ename;
		
		System.out.println(this.eno);
		System.out.println(this.ename);
		System.out.println(this.sal);
	}

	
	public Employee(int eno, String ename, float sal) 
	{
		this(1744,"ravilella");
		this.eno=eno;
		this.ename=ename;
		this.sal=sal;
		
		System.out.println(this.eno);
		System.out.println(this.ename);
		System.out.println(this.sal);
	}

	public static void main(String[] args) 
	{		
		Employee e4=new Employee(1745,"saikeerthan",12000.00f);
		
	}

}
