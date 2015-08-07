import java.util.Scanner;
import java.util.ArrayList;


public class TranscriptApp {
	
	public static void main(String[] args) {
		
		System.out.println("welcome to transcript application");
		System.out.println();
		
		Transcript transcript = new Transcript();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y"))
		{
			//enter course
			String course_code = Validator.getSentence(sc, "Enter course : ");
			int credits = Validator.getInt(sc, "Enter credits : "); 
			String grade = Validator.getString(sc, "Enter grade : ");
				
			CourseEnrollment course = new CourseEnrollment();
			course.setCourse_code(course_code);
			course.setCredits(credits);
			course.setGrade(grade);
			
			transcript.addCourse(course);
			
			//check if user wants to continue
			System.out.print("Continue? (y/n) :");
			choice = sc.nextLine();	
		
		}
		
		System.out.printf("%-15s %15s %20s %20s", "Course", "Credits", "Grade", "Quality Points");
		System.out.println();
		System.out.printf("%-15s %15s %20s %20s", "_ _ _ _", "_ _ _ _", "_ _ _", "_ _ _ _ _ _ _ _" + "\n" + "\n");
		
		
		ArrayList<CourseEnrollment> list = new ArrayList<CourseEnrollment>();
		list = transcript.getCourses();
		for(CourseEnrollment cur: list)
		{
			
			
			System.out.printf("%-15s %15s %20s %20s",cur.getCourse_code(), cur.getCredits() 
					, cur.getGrade(),  cur.getPoints());
			System.out.println();
		
		}
		
		System.out.println();
		System.out.printf("%75s %2s","GPA :", transcript.getFormattedGPA());
		
	}

}
