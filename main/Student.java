/*
Assignment number : 8
File name : student.java
Name : Ohad Ben tzvi
Student ID : 316298256
Email : ohadbt95@gmail.com
*/
/**
 * Represents a student.
 */
public class Student {
	private int sid;                             
	private String name;                         
	private LinkedList<CourseTaken> courseList;
	
	/** 
	 * Constructs a new student with the given sid and name, and an empty course list.
	 * @param sid  the student's sid
	 * @param name the student's name
	 */
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
		courseList = new LinkedList<CourseTaken>();
	}
	
	/** 
	 * Returns the sid of this student.
	 * @return the sid of this student.
	 */
	public int getSid() {
		return sid;
	}
	
	/** 
	 * Returns the name of this student.
	 * @return the name of this student.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the list of course taken by this student.
	 * @return the course list of this student.
	 */
	public LinkedList getCourseList(){
		return courseList;
	}
	
	/** 
	 * Adds the given course and grade to the course list of this student.
	 * @param c     the course to add
	 * @param grade the grade in the added course 
	 */
	public void addCourse(Course c, int grade) {
		//if (courseList.remove())
		if (tookCourse(c)) {
			ListIterator<CourseTaken> itr = courseList.iterator();
			CourseTaken course = itr.next();
			while (itr.hasNext()){
				if (course.getCourse() == c) {
					courseList.remove(course);
					break;
				}
			}
		}
		CourseTaken course = new CourseTaken(c,grade);
		courseList.add(course);
	}
	
	/** 
	 * Removes the given course from the course list of this student.
	 * @param c     the course to remove
	 */
	public void removeCourse(Course c) {
		ListIterator <CourseTaken> itr = courseList.iterator();
		while(itr.hasNext()) {
			CourseTaken current = itr.next();
			if(c.equals(current.getCourse())) courseList.remove(current);
		}
	}
	
	/** 
	 * Returns the grade that this student got in the given course, 
	 *  or -1 if the course was not taken by this student.
	 * @param c - the returned grade will be the grade in this course.
	 * @return the grade that this student got in the given course
	 */
	public int gradeInCourse(Course c) {
			ListIterator<CourseTaken> itr = courseList.iterator();
			while (itr.hasNext()) {
				CourseTaken current = itr.next();
				if (c == current.getCourse()){
					return current.getGrade();
				}
			}
		return -1;
	}
	
	/** 
	 * Returns true if this student took the given course, false otherwise.
	 * @param c  the course we want to know whether or not the student took.
	 * @return true if this student took the given course, false otherwise.
	 */
	public boolean tookCourse(Course c) {
		ListIterator<CourseTaken> itr = courseList.iterator();
		while (itr.hasNext()) {
			CourseTaken current = itr.next();
			if (c == current.getCourse()){
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints this student, all the courses that s/he took, and the grade point average.
	 */
	public void studentReport() {
		ListIterator<CourseTaken> itr = courseList.iterator();
		int numOfCourses = 0;
		int sumOfGrades = 0;
		System.out.println(getName() + ":");
		while (itr.hasNext()) {
			CourseTaken current = itr.next();
			sumOfGrades += current.getGrade();
			numOfCourses++;
			System.out.println(current.getCourse().toString()+", grade: "+current.getGrade());
			}
			double avg = (double) sumOfGrades/numOfCourses;
			System.out.println("Grade average: " + avg);
		}
	
	/**
	 * Textual representation of this student.
	 */
	public String toString() {
		return "Student " + sid + ": " + name;
	}
}