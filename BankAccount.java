import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class BankAccount {
	String cusId;
	String cusName;
	double balance;
	double transaction;
	
	BankAccount(String CusId, String CusName){
		this.cusId=CusId;
		this.cusName=CusName;
	}
	
	void deposit(double amount)
	{
		if(amount!=0)
		{
			balance+=amount;
			transaction=amount;
			System.out.println("Deposit Successful, Your Balance is "+balance);
		}
		else
		{
			System.out.println("Deposit amount is 0!");
		}
	}
	void withdraw(double amount)
	{
		if(amount!=0 && balance>=amount)
		{
			balance-=amount;
			transaction=amount;
			System.out.println("Withdraw Successful, Your Balance is "+balance);
		}
		else if(balance<amount)
		{
			System.out.println("Balance is not enough");
		}
	}
	void getTranscation()
	{
		if(transaction>0)
		{
			System.out.println("Deposit amount is: "+transaction);
		}
		else if(transaction<0)
		{
			System.out.println("Withdraw amount is: "+transaction);
		}
		else
		{
			System.out.println("No transaction");
		}
	}
	void process()
	{
		Scanner input=new Scanner(System.in);
		char option;
		double amt;
		System.out.println("Your ID: "+cusId+"\nYour Name: "+cusName);
		System.out.println("A. Check Balance.");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Exit\n");
		do {
			System.out.println("Choose an option:");
			option=input.next().toUpperCase().charAt(0);
			System.out.println();
			switch (option) {
			case 'A': 
				System.out.println("Your balance: "+balance);
				break;
				
			case 'B':
				System.out.print("Enter deposit amount: ");
				amt=input.nextDouble();
				deposit(amt);
				break;
	
			case 'C':
				System.out.print("Enter withdraw amount: ");
				amt=input.nextDouble();
				withdraw(amt);
				break;
				
			case 'D':
				System.out.println("Thank you.");
				break;
				
			default:
				System.out.println("Choose an option");
				break;
			}
		}
		while(option!='D');
				
	}
	
}
