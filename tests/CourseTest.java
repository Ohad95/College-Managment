
public class CourseTest {

public static void main(String []args) {
		//  Creates some demo courses 	
		Course course1 = new Course(1, "Metaphysics");
		Course course2 = new Course(2, "Epistemology");
		Course course3 = new Course(3, "Ethics");
		Course course4 = new Course(4, "Logic");
		Course course5 = new Course(5, "Math");
		
		// Prints each course ID and name
		System.out.println(course1.getCid() + " " + course1.getTitle() );
		System.out.println(course2.getCid() + " " + course2.getTitle() );
		System.out.println(course3.getCid() + " " + course3.getTitle() );
		System.out.println(course4.getCid() + " " + course4.getTitle() );
		System.out.println(course5.getCid() + " " + course5.getTitle() );
		
		// Test toString function for some of the courses
		System.out.println(course1.toString());
		System.out.println(course4.toString());
		System.out.println(course5.toString());	
	}

}
