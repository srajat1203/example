import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class BankApp {

	public static void main(String[] args) {
		
		Accounts accounts = new Accounts();
		//double curr_balance = 0;
		
		
		//Reading accouts from file
		String filename = (System.getProperty("user.dir") + File.separatorChar +"Bank14.txt");
		
		File f = new File(filename);
		if(f.isFile())
		{
			try
			{
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				String line = reader.readLine();
				
				while(line != null)
				{
					AccountInfo curr = new AccountInfo();
					
					curr.setAccNo(Integer.parseInt(line));
					line = reader.readLine();
					curr.setName(line);
					line = reader.readLine();	
					curr.setBalance(Double.parseDouble(line));
					line = reader.readLine();	
					
					accounts.addAccount(curr);
				}
			
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	
		//testing
		/*
		System.out.println("Reading from bank");
		ArrayList<AccountInfo> templist = accounts.getAccounts();
		for(AccountInfo a: templist)
		{	
			double curr_balance = a.getBalance();
			System.out.println("The balance for the account " + a.getAccNo() + " is " + curr_balance);
		}
		*/
		
		//testing over
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		String choice1 = "y";
		
		System.out.println("Welcome to Evil Corp Saving and Loan");
		System.out.println("Please create the user account(s)");
		
		while(choice1.equalsIgnoreCase("y"))
		{
			
				//Only enter if a new account is to be created
				System.out.print("Enter an account # to create an account or -1 to stop entering accounts : ");
				int accno = sc.nextInt();
				if(accno == -1)
				{
					break;
				}
				System.out.print("Enter the name for acct # " + accno + " : ");
				String name = sc.next();
				System.out.print("Enter the balance for acct " + accno + " : ");
				double balance = sc.nextDouble();
				
				AccountInfo acc = new AccountInfo();
				acc.setAccNo(accno);
				acc.setName(name);
				acc.setBalance(balance);
				
				accounts.addAccount(acc);
				
				System.out.println();
				
			
		}
		
		System.out.println();
		
		AccountInfo curr = null;
		int acc_num = 0;
		String choice2 = "y";
		
		
		while(choice2.equalsIgnoreCase("y"))
		{
			System.out.print("Enter a transaction type (Check (C), Debit card(DC), Deposit(D), Withdrawal(W), or Close(CL) or -1 to finish : ");
			String des = sc.next();
			if(des.equalsIgnoreCase("-1"))
			{
				
				break;
			}
			
			System.out.print("Enter the account # : ");
			acc_num = sc.nextInt();
			curr = accounts.getAccount(acc_num);
			
			if(curr == null)
			{
				System.out.println("no such accout exists! Exiting program");
				break;
			}
			
			
			double curr_balance =curr.getBalance();
			System.out.println("The balance is this account is : " + curr_balance);
			
			//This step is needed in order to maintain a consistent balance between before the balance is shown and after it is shown 
			Check prev = curr.prev_check();
			if(prev != null)
			{
				double am = prev.getAmount();
				curr.dep(am);
			}
			
			
			if(des.equalsIgnoreCase("CL"))
			{
				if(curr_balance!= 0)
				{
					System.out.println("You cannot close the account since your balance is not zero");
				}
				else
				{
					System.out.println("Account has been deleted");
					accounts.deleteAccount(curr);
				}
			}
			
			else if(des.equalsIgnoreCase("C"))
			{
				/*
				System.out.print("Enter the amount of the check : ");
				double amount = sc.nextDouble();
				System.out.print("Enter year of check : ");
				int year = sc.nextInt();
				System.out.print("Enter the month of the check : ");
				int month = sc.nextInt();
				System.out.print("Enter the day of the check : ");
				int day = sc.nextInt();
				/*
				 */
				
				double amount = Validator.getDouble(sc, "Enter the amount of the check : ");
				int year = Validator.getyear(sc, "Enter the year of the check : ");
				int month = Validator.getmonth(sc, "Enter the month of the check : ");
				int day = Validator.getday(sc, "Enter the day of the check : ");
				
				System.out.println();
				
				Check check = new Check(year, month, day, amount);
				curr.check_remove(check);
			}
			
			else if(des.equalsIgnoreCase("DC"))
			{
				//System.out.print("Enter the amount for debit card : ");
				double debit = Validator.getDouble(sc,"Enter the amount for the debit card : ");
				curr.remove(debit);
			}
			
			else if(des.equalsIgnoreCase("D"))
			{
				//System.out.print("Enter amount to be deposited : ");
				double deposit =  Validator.getDouble(sc,"Enter amount to be deposited : ");
				curr.dep(deposit);
			}
			
			else if(des.equalsIgnoreCase("W"))
			{
				//System.out.print("Enter amount to be withdrawn : ");
				double withdrawn =  Validator.getDouble(sc,"Enter amount to be withdrawn : ");
				curr.remove(withdrawn);
			}
			
			
		}
		
		//ArrayList<AccountInfo> finalList = accounts.getAccounts();
			//for(AccountInfo a: finalList)
			//{	
				//double curr_balance = a.getBalance();
				//System.out.println("The balance for the account " + a.getAccNo() + " is " + curr_balance);
			//}
		
		//Writing accounts to file	
			
		
		PrintWriter writer = null;	
		
		ArrayList<AccountInfo> bankList = accounts.getAccounts();
		try 
		{	writer = new PrintWriter(new File(filename));
		    for (AccountInfo curr_account: bankList)
		    {
		    	int accNo = curr_account.getAccNo();
		    	double accBal = curr_account.getBalance();
		    	System.out.println("The balance for the account " + accNo + " is " + accBal);
		    	String accName = curr_account.getName();
		    	writer.println(accNo);
		    	writer.println(accName);
		    	writer.println(accBal);
		    	
		    }	
		}
		catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		finally
		{
			writer.close();
		}
			
	}
}	

