# college-managment
College management is a Java project designed to help academic institutions to manage operations – it deals with students, courses, grades etc. using object-oriented programming. It is implemented with linked list.

This program is focused on managing three main objects – Courses, Students, and CourseTaken as detailed below.

Course ( Course.java ): A typical college offers hundreds of courses, and each can be represented as an instance of this class. Typically, a course is characterized by a course id, course title, course instructor (an instance of an Instructor class), capacity, room (an instance of a Room class), etc. In this project though, the Course class features two fields only: course id, and title.

Student ( Student.java ): Represents students who are enrolled in the college. Each student has a student id, name, address, year, major, course list, and so on. In this project though, the Student class features three fields only: student id, name, and course list. The latter is a list of (course id, grade) pairs, each being an instance of the CourseTaken class.

CourseTaken ( CourseTaken.java ): Represents pairs of the form ( course id , grade ). It would make sense to also keep track of year and semester data, but, to keep things simple, we’ll focus on course id and grade only.
