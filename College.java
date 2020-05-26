/*
* Represents a college, and college management operations.
 * A college has courses, and students. Students take courses and get grades.
 * (See the Course, Student, and CourseTaken classes for more details).
 */
public class College {
	private static String nl =  System.getProperty("line.separator");
	private String name; // the name of this college
	private LinkedList<Course> courses;
	private LinkedList<Student> students;
	
	/**
	 * Constructs a new college, with empty student and course lists.
	 */
	public College(String name) {
		this.name = name;
		this.courses = new LinkedList<Course>();
		this.students = new LinkedList<Student>();
	}
	
	/** 
	 * Adds the given course to the course list of this college.
	 * @param cid   course id.
	 * @param title course title.
	 */
	public void addCourse(int cid, String title) { // CHECK YOURSELF
		Course newCourse = new Course(cid, title);
		courses.add(newCourse);
	}
	
	/**
	 * Prints a list of all the courses.
	 */
	public void coursesList() {
		System.out.println(courses);
	}

	/** 
	 * If the given course is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  cid the course to remove.
	 * @return True if the course was removed, false if there is no such course. 
	 */
	public boolean removeCourse(int cid) {
		Course courseToRemove = getCourse(cid);
		if (courseToRemove == null) return false;
		ListIterator<Student> itr = studentsWhoTook(courseToRemove).iterator();
		Student student = new Student(100, "ohad");
		if (itr.hasNext()){
		student = itr.next();}
		while(itr.hasNext()){
			student.getCourseList().remove(courseToRemove);
			student = itr.next();
			}
		return courses.remove(courseToRemove);
	}
	
	// Returns the course that has the given id, or null if there is no such course.
	public Course getCourse(int cid) { // UNDERSTAND WORKING WITH THE ITERATOR AND FINISH
		ListIterator<Course> current = (courses.iterator());
		while (current.hasNext()){
			Course course = current.next();
			if (course.getCid() == cid) return course;
		}
		return null;
	}
	
	/** 
	 * Adds the given student to the students list of this college.
	 * @param sid   student id
	 * @param name  student name
	 */
	public void addStudent(int sid, String name) { // CHECK
		Student newStudent = new Student(sid, name);
		students.add(newStudent);
	}
	
		/**
	 * Prints a list of all the students.
	 */
	public void studentsList() {
		System.out.println(students);
	}
	
	/** 
	 * If the given student is in this college, removes it and returns true.
	 * Otherwise returns false.
	 * @param  sid  the student's id.
	 * @return True if the student was removed, false if there is no such student. 
	 */
	public boolean removeStudent(int sid) {
		Student studentToRemove = getStudent(sid);
		return students.remove(studentToRemove);
	}
	
	// Returns the student that has the given id, or null if there is no such student.
	private Student getStudent(int sid) { //SAME AS getCOURSE
		Student student = students.getFirst();
		ListIterator<Student> current = (students.iterator());
		while (current.hasNext()){
			student = current.next();
			if(student.getSid() == sid) return student;
		}
		return null;
	}
	
	/** 
	 * Adds the given course to the course list of the given student.
	 * @param sid   student id
	 * @param cid   course id
	 * @param grade student's grade in the course 
	 */
	public void addCourseTaken(int sid, int cid, int grade) { //CHECK! LINE 3
		Course course = getCourse(cid);
		Student student = getStudent(sid);
		if (course != null && student!=null)
		student.addCourse(course, grade);
	}
	
	/** 
	 * Prints the student report of the given student.
	 * See the Student class for more details.
	 * @param sid  student id
	 */
	public void studentReport(int sid) { //CHECK
		Student student = getStudent(sid);
		if (student != null)
		student.studentReport();
		// Your code should call the student's studentReport method
	}
	
	/**
	 * Prints a list of all the students who took the course with the given cid.
	 * @param cid  the course
	 */
	public void courseReport(int cid) { //USE ITERATOR, ITS NOT FINISHED
		Course course = getCourse(cid);
		if (course != null) {
			ListIterator<Student> current = (students.iterator());
			System.out.println("Course report: " + course.getTitle());
			while (current.hasNext()) {
				Student student = current.next();
				if (student.tookCourse(course)) {
					System.out.println(student.toString());
				}
			}
			System.out.println();
		}
	}
	
	/** 
	 * Prints the number of students in the given course
	 * @param cid  course id
	 */
	public void printSize(int cid) {
		Course course = getCourse(cid);
		if (course != null) {
			int size = 0;
			ListIterator<Student> current = (students.iterator());
			System.out.print(course.toString() + " has ");
			while (current.hasNext()) {
				Student student = current.next();
				if (student.tookCourse(course)) size++;
			}
			System.out.println(size + " students");
		}
	}
	
	// Returns a list of all the students who took the given course
	private LinkedList<Student> studentsWhoTook(Course c) {
		Course course = c;
		LinkedList<Student> list = new LinkedList<Student>();
		ListIterator<Student> current = (students.iterator());
		while (current.hasNext()){
			Student student = current.next();
			if (student.tookCourse(course)) list.add(student);
		}
		return list;
	}
	
	/** 
	 * Prints the student with the highest grade in the given course.
	 * @param cid  course id
	 */
	public void topPerfomerReport(int cid) {
		Course course = getCourse(cid);
		if (course != null) {
			int bestGrade = 0;
			LinkedList<Student> list = studentsWhoTook(course);
			ListIterator<Student> current1 = list.iterator();
			Student checkStudent = new Student(0, "");
			if (current1.hasNext())
				checkStudent = current1.next();
			while (current1.hasNext()) {
				if (checkStudent.gradeInCourse(course) > bestGrade) {
					bestGrade = checkStudent.gradeInCourse(course);
				}
				checkStudent = current1.next();
			}
			ListIterator<Student> current = list.iterator();
			Student best = new Student(0, "");
			if (current.hasNext())
				best = current.next();
			System.out.println("Top performer in " + course.toString() + ":");
			while (current.hasNext()) {
				if (best.gradeInCourse(course) == bestGrade) {
					System.out.println(best.getName());
				}
				best = current.next();
			}
			if (best.gradeInCourse(course) == bestGrade) System.out.println(best.getName());
		}
	}

	/** 
	 * Returns the college name
	 * @return the college name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A textual representation of this college, along with its courses and students.
	 */
	public String toString() {
		String str = name + nl;
		str += "courses:" + nl;
		str += courses.toString() + nl;
		str += "students:" + nl;
		str += students.toString() + nl;
		return str;
	}
}
