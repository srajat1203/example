
import java.util.Date;
import java.util.GregorianCalendar;

public class Check {

	private int month;
	private int day;
	private int year;
	private double amount;
	GregorianCalendar gc;
	
	public Check(int year, int month, int day, double amount)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		this.amount = amount;
		gc = new GregorianCalendar(year, (month - 1), day);
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setDate(int year, int month, int day)
	{
		gc.set(year, (month - 1), day);
	}
	
	public int getTime()
	{
		GregorianCalendar odate = new GregorianCalendar(year, month, day);
		GregorianCalendar now = new GregorianCalendar();
		
		Date startDate = odate.getTime();
		Date endDate = now.getTime();
		long startDateMS = startDate.getTime();
		long endDateMS = endDate.getTime();
		long elapsedMS = endDateMS - startDateMS;
		long elapsedDays = elapsedMS / (24*60*60*1000);
		
		int days = (int)elapsedDays;
		return  days;
	}
	    
	
	
}
