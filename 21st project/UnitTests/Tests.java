import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Scanner;
import java.util.ArrayList;

public class Tests {
	
	//Testing class Validator
	
		//in this test, a string with no words is used as input
		@Test
		   public void test_getString1() {
		      System.out.println( "\t" +  "Testing Validator") ;
		      System.out.println("Testing getString1");
		      Scanner sc = new Scanner(System.in);
		      String cur = Validator.getString(sc,"Enter 'java' : ");
		      assertTrue(cur.equals("java"));
		   }
		
		//in this test, a string with spaces is test to verify that the spaces are ignored
		@Test
		   public void test_getString2() {
		      //System.out.println( "\t" +  "Testing Validator") ;
		      System.out.println("Testing getString2");
		      Scanner sc = new Scanner(System.in);
		      String cur = Validator.getString(sc,"Enter 'java 101' : ");
		      assertTrue(cur.equals("java"));
		   }
		
		@Test
		   public void test_getSentence() {
		      //System.out.println( "\t" +  "Testing Validator") ;
		      System.out.println("Testing getSentece");
		      Scanner sc = new Scanner(System.in);
		      String cur = Validator.getSentence(sc,"Enter 'english 202' : ");
		      assertTrue(cur.equals("english 202"));
		   }

		@Test
		   public void test_getInt() {
		      //System.out.println( "\t" +  "Testing Validator") ;
		      System.out.println("Testing getInt");
		      Scanner sc = new Scanner(System.in);
		      int cur = Validator.getInt(sc, "enter int between 1 and 50 : ", 1, 50);
		      assertTrue(cur>0 && cur<51);
		   }
		
		@Test
		public void test_getDouble() {
		      //System.out.println( "\t" +  "Testing Validator") ;
		      System.out.println("Testing getDouble");
		      Scanner sc = new Scanner(System.in);
		      double cur = Validator.getDouble(sc, "enter double between 1 and 50 : ", 1, 50);
		      assertTrue(cur>0 && cur<51);
		   }
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	//Testing class CourseEnrollment
		//each grade has a different gpa value, which is why each grade needs to be tested individually
	@Test
	   public void test_GradeA() {
		  System.out.println();
		  System.out.println();
	      System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing grade A");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setGrade("A");
	      assertTrue(C.getPoints() == 4.00) ;
	   }
	
	
	
	@Test
	   public void test_GradeB() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing grade B");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setGrade("B");
	      assertTrue(C.getPoints() == 3.00) ;
	   }
	
	@Test
	   public void test_GradeC() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing grade C");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setGrade("C");
	      assertTrue(C.getPoints() == 2.00) ;
	   }
	
	@Test
	   public void test_GradeD() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing grade D");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setGrade("D");
	      assertTrue(C.getPoints() == 1.00) ;
	   }
	
	@Test
	   public void test_GradeF() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing grade F");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setGrade("F");
	      assertTrue(C.getPoints() == 0.00) ;
	   }
	
	
	@Test
	   public void test_setCourse_code() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing setCourse_code");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setCourse_code("java");
	      assertTrue(C.getCourse_code().equals("java")) ;
	   }
	
	@Test
	   public void test_setCredits() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing setCredits");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setCredits(3);
	      assertTrue(C.getCredits() == 3) ;
	   }
	
	@Test
	   public void test_setGrade() {
	      //System.out.println( "\t" +  "Testing CourseEnrollment") ;
	      System.out.println("Testing setGrade");
	      CourseEnrollment C = new CourseEnrollment();
	      C.setGrade("A");
	      assertTrue(C.getGrade().equals("A")) ;
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Testing Class Transcript
	@Test
	   public void test_getAddCourse() {
		  System.out.println();
		  System.out.println();
	      System.out.println( "\t" +  "Testing Transcript") ;
	      System.out.println("Testing addCourse");
	      Transcript t = new Transcript();
	      
	      
	      CourseEnrollment course = new CourseEnrollment();
		  course.setCourse_code("java");
		  course.setCredits(3);
		  course.setGrade("A");
		  t.addCourse(course);
		  
		  ArrayList<CourseEnrollment> l = new ArrayList<CourseEnrollment>();
	      l = t.getCourses();
		  
		  assertTrue(l.get(0).getCourse_code().equals("java"));
		  
		  
	      
	      
	      //C.setGrade("F");
	      //assertTrue(C.getPoints() == 0.00) ;
	   }
	
	@Test
	   public void test_getGPA() {
	      //System.out.println( "\t" +  "Testing Transcript") ;
	      System.out.println("Testing addGPA :");
	      
	      Transcript t = new Transcript();
	      
	      
	      CourseEnrollment course = new CourseEnrollment();
		  course.setCourse_code("java");
		  course.setCredits(3);
		  course.setGrade("A");
		  t.addCourse(course);
		  
		  CourseEnrollment course2 = new CourseEnrollment();
		  course2.setCourse_code("english");
		  course2.setCredits(3);
		  course2.setGrade("B");
		  t.addCourse(course2);
		  
		  
		 // ArrayList<CourseEnrollment> l = new ArrayList<CourseEnrollment>();
	      //l = t.getCourses();
		  
		  assertTrue(t.getGPA() == 3.5);
		 
	      //C.setGrade("F");
	      //assertTrue(C.getPoints() == 0.00) ;
	   }
	
	@Test
	   public void test_getFormattedGPA() {
	      //System.out.println( "\t" +  "Testing Transcript") ;
	      System.out.println("Testing getFormattedGPA :");
	      
	      Transcript t = new Transcript();
	      
	      
	      CourseEnrollment course = new CourseEnrollment();
		  course.setCourse_code("java");
		  course.setCredits(3);
		  course.setGrade("A");
		  t.addCourse(course);
		  
		  CourseEnrollment course2 = new CourseEnrollment();
		  course2.setCourse_code("english");
		  course2.setCredits(3);
		  course2.setGrade("B");
		  t.addCourse(course2);
		  
		  //ArrayList<CourseEnrollment> l = new ArrayList<CourseEnrollment>();
	     // l = t.getCourses();
		//  System.out.println("formatted gpa is :" + t.getFormattedGPA());
		  assertTrue(t.getFormattedGPA().equals("3.5"));
		 
	      //C.setGrade("F");
	      //assertTrue(C.getPoints() == 0.00) ;
	   }
	
	
	
	
	
	
	
}
