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
		double total_points = 0 ;
		double total_credits = 0;
		double gpa;
		for(CourseEnrollment ce: list)
		{
			total_points = total_points + (ce.getPoints())*(ce.getCredits());
			total_credits = total_credits + ce.getCredits();
		}
		if(total_credits == 0)
		{
			gpa = 0.0;
		}
		else
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
