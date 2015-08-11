import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AccountInfo {

	private int accNo;
	private String name;
	private double balance;
	private Checks c;
	
	//private double check_val;
	//private double debit_val;
	//private double deposit_val;
	//private double withdraw_val;
	
	//ArrayList<Double> checks ;
	
	public AccountInfo()
	{
		accNo = 0;
		name = "";
		balance = 0;
		c = new Checks();
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		
		ArrayList<Check> checks = c.getChecks(); 
		//sort checks based on date
		//for beggining to end
		//	balance = balance - check[i];
		//	if(balance<0)
		//		balance = balance -35;
		
		Collections.sort(checks, new MyCompare());
		
		for(Check c: checks)
		{
			balance = balance - c.getAmount();
			if(balance < 0)
			{
				balance = balance - 35;
			}
		}
		
		
		return balance;
	}

	public void setBalance(double balance) {
	
		this.balance = balance;
	}
	
	public void remove(double val)
	{
		balance = balance - val;
		if(balance < 0 )
		{
			balance = balance - 35;
		}
	}
	
	public void check_remove(Check check)
	{
		c.addCheck(check);			
	}
	
	public void dep(double val)
	{
		balance = balance + val;
	}
	
	public Check prev_check()
	{
		return c.prev_check();
	}
}




class MyCompare implements Comparator<Check>{
	 
    @Override
    public int compare(Check c1, Check c2) {
        if(c1.getTime() < c2.getTime()){
            return 1;
        } else {
            return -1;
        }
    }

}

