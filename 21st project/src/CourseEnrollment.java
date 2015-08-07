
public class CourseEnrollment {

	private String course_code;
	private int credits;
	private String grade;
	
	public CourseEnrollment()
	{
		course_code = "";
		credits = 0;
		grade = "";
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public double getPoints()
	{
		double points = 0;
		
		if(grade.equalsIgnoreCase("A"))
		{
			points = 4.0;
		}
		else if((grade.equalsIgnoreCase("B")))
		{
			points = 3.0;
		}
		else if(grade.equalsIgnoreCase("C"))
		{
			points = 2.0;
		}
		else if(grade.equalsIgnoreCase("D"))
		{
			points = 1.0;
		}
		else
		{
			points = 0.0;
		}
		return points;	
	}
	
	
}
