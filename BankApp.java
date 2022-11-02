import java.util.Scanner;

public class BankApp {
	public static void main(String [] args)
	{
		String id,name;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id: ");
		id=sc.nextLine();
		System.out.println("Enter Name: ");
		name=sc.nextLine();
		BankAccount acc=new BankAccount(id, name);
		if(id!=null && name!=null)
		{
			acc.process();
		}
		else
		{
			System.out.println("Fill Id Or Name!");
			while(id!=null && name!=null)
			{
				System.out.println("Enter Id: ");
				id=sc.next();
				System.out.println("Enter Name: ");
				name=sc.nextLine();
			}
		}
	}

}
