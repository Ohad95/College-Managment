/** Tests some of the services of the College class. */
public class CollegeTest {
	
	public static void main(String []args) {
		
		College c = buildCollege();
		c.coursesList();    // Prints the courses
		c.studentsList();    // Prints the students
		c.removeStudent(0);  // Removes the first student in the list
		c.removeStudent(2);  // Removes the third student in the list
		c.removeStudent(5);  // Removes the last student in the list
		c.studentsList();    // Prints the students after the removals
		c.studentReport(1);	System.out.println();	
		c.studentReport(2); System.out.println();
		c.courseReport(1);	
		c.courseReport(2);
		c.printSize(1);  System.out.println();	
		c.topPerfomerReport(1);
	}
	
	//  Builds a demo college, populated with some demo courses and students. */
	private static College buildCollege() {
		
		College c = new College("The Academy, School of Philosophy");
		
		c.addCourse(1,"Metaphysics");
		c.addCourse(2,"Epistemology");
		c.addCourse(3,"Ethics");
		c.addCourse(4,"Logic");
		c.addCourse(5,"Philosophy of science");

		c.addStudent(0,"Plato");
		c.addStudent(1,"Aristotle");
		c.addStudent(2,"Marcus Aurelius");
		c.addStudent(3,"Friedrich Nietzsche");
		c.addStudent(4,"Immanuel Kant");
		c.addStudent(5,"Ayn Rand");

		c.addCourseTaken(1,1, 80);  c.addCourseTaken(1,2, 90);  c.addCourseTaken(1,3,100);
		c.addCourseTaken(2,1,100);  c.addCourseTaken(2,2, 80);
		c.addCourseTaken(3,1, 80);  c.addCourseTaken(3,3, 70);
		
		return c;
	}
}