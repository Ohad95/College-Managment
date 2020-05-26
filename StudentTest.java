

public class StudentTest {

	public static void main(String[] args) {
		
		// Builds some demo students
		Student student1 = new Student(1234567, "Plato");
		Student student2 = new Student(2222333, "Ayn Rand");
		Student student3 = new Student(3123906, "Muhamad Ali");
		
		// Add some courses to each student's course list
		Course course1 = new Course(1, "Logic");
		Course course2 = new Course(2, "Math");
		Course course3 = new Course(3, "Boxing");
		Course course4 = new Course(4, "Science");
		Course course5 = new Course(5, "English");
		Course course6 = new Course(6, "Physics");
		
		// Define courses that can be taken
		student1.addCourse(course1, 90);
		student1.addCourse(course4, 85);
		student1.addCourse(course5, 91);
		
		student2.addCourse(course1, 88);
		student2.addCourse(course2, 85);
		student2.addCourse(course3, 56);
		student2.addCourse(course6, 82);
		
		student3.addCourse(course1, 52);
		student3.addCourse(course2, 44);
		student3.addCourse(course4, 100);
		student3.addCourse(course5, 80);
		student3.addCourse(course6, 11);
		
		// We will use the "get" function
		System.out.println(student1.getName() + ", " + student2.getName() + ", " + student3.getName());
		System.out.println(student1.getSid() + ", " + student2.getSid() + ", " + student3.getSid());
		System.out.println();

		// We will print the students grades in course number 1
		System.out.println("Students grades in " + course1.getTitle() + " course are:");
		System.out.println(student1.gradeInCourse(course1));
		System.out.println(student2.gradeInCourse(course1));
		System.out.println(student3.gradeInCourse(course1));
		System.out.println();

		// We will use the "tookCourse" function to find out if some student took a course or not
		if(student1.tookCourse(course5)) System.out.println(student1.getName() + " grade in " + course5.getTitle()
		+ " is: " + student1.gradeInCourse(course5));
		else System.out.println("didnt took this course.");
		System.out.println();
		
		// Print the student report (a list of courses that he took, his grades and etc.). 
		student2.studentReport();
		System.out.println();
		
		// We will try some negative tests and see what the output of those tests will be
		student2.gradeInCourse(course2);
		// We will remove course2 from student2 list and we will try to print his grade in it.
		student2.removeCourse(course2);
		student2.gradeInCourse(course2);
		System.out.println();
		
		// After we removed course number 2 from the student list we will print his 
		// report and see if the course still there
		student2.studentReport();		
	}
}
