import java.util.ArrayList;
import java.text.NumberFormat;

public class Transcript {

	ArrayList<CourseEnrollment> list;
	
	public Transcript()
	{
		list = new ArrayList<CourseEnrollment>();
	}
	
	void addCourse(CourseEnrollment courseenrollment)
	{
		list.add(courseenrollment);
	}
	
	public ArrayList<CourseEnrollment> getCourses()
	{
		return list;
	}
	
	public double getGPA()
	{
		String S = new String("Arithmetic exception") ;
		double total_points = 0 ;
		double total_credits = 0;
		double gpa;
		
		for(CourseEnrollment ce: list)
		{
			total_points = total_points + (ce.getPoints())*(ce.getCredits());
			total_credits = total_credits + ce.getCredits();
		}
	
		// If zero credits are entered, then an arithmetic exception occurs
		int tp = (int) total_points;
		int tc = (int) total_credits;
		try
		{
			int res = tp/tc;
		}
	
		catch(Exception e)
		{
		    S = new String("Arithemetic exception occurred");
		    System.out.println(S);
			total_credits = 1;
			total_points = 0;
		}
		//finally used here
		finally
		{
			gpa = total_points/total_credits;
		}
		return gpa;
		
	}
	
	public String getFormattedGPA()
	{
		double gpa = getGPA();
		NumberFormat num = NumberFormat.getInstance();
		String formatted_gpa = num.format(gpa);
		return formatted_gpa;
		
	}

}
