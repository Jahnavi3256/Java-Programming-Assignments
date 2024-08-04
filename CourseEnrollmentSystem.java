//Here is a simple Java code for the Course Enrollment System:


import java.util.Scanner;

class Course {
    int courseID;
    String courseName;
    int credits;

    public Course(int courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + ", Name: " + courseName + ", Credits: " + credits;
    }
}

class Enrollment {
    int[][] studentCourses;
    int[] count;

    public Enrollment(int numStudents, int numCourses) {
        studentCourses = new int[numStudents][numCourses];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID) {
        studentCourses[studentID][count[studentID]++] = courseID;
    }

    public void drop(int studentID, int courseID) {
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseID) {
                studentCourses[studentID][i] = studentCourses[studentID][--count[studentID]];
                break;
            }
        }
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Enrolled Courses:");
        for (int i = 0; i < count[studentID]; i++) {
            for (Course course : courseCatalog) {
                if (course.getCourseID() == studentCourses[studentID][i]) {
                    System.out.println(course.toString());
                }
            }
        }
    }
}

public class CourseEnrollmentSystem {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course[] courseCatalog = new Course[5];
        courseCatalog[0] = new Course(1, "Math", 3);
        courseCatalog[1] = new Course(2, "Science", 4);
        courseCatalog[2] = new Course(3, "English", 3);
        courseCatalog[3] = new Course(4, "History", 4);
        courseCatalog[4] = new Course(5, "Computer Science", 4);

        Enrollment enrollment = new Enrollment(10, 5);
        System.out.println("courses");
        System.out.println("1) Math");
        System.out.println("2) science");
        System.out.println("3) English");
        System.out.println("4) History");
        System.out.println("Computer Science");

        while (true) {
            System.out.println("1. Enroll in a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View enrolled courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    enrollment.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    courseID = scanner.nextInt();
                    enrollment.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    enrollment.getEnrolledCourses(studentID, courseCatalog);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


//This code provides a simple console-based interface for enrolling students in courses, dropping courses, and viewing enrolled courses.