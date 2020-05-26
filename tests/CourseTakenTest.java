public class CourseTakenTest {

	public static void main(String[] args) {
		
		//  Creates demo courses.
		Course course1 = new Course(1, "Math");
		Course course2 = new Course(2, "Logic");
		CourseTaken coursetaken1 = new CourseTaken(course1, 96);
		CourseTaken coursetaken2 = new CourseTaken(course2, 95);
		
		//We will define a new "taken course" and activate the existing functions on it
		Course tempcourse = coursetaken1.getCourse();
		Course tempcourse2 = coursetaken2.getCourse();
		System.out.println(tempcourse.toString());
		System.out.println(coursetaken1.getGrade());
		System.out.println(tempcourse2.toString());
		System.out.println(coursetaken2.getGrade());
	}
}
