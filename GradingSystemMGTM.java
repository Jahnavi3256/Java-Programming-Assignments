import java.util.Scanner;

public class GradingSystemMGTM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradingSystem gradingSystem = new GradingSystem(10, 20, 5);

        while (true) {
            System.out.println("1. Add student Information");
            System.out.println("2. Add grade of Student ");
            System.out.println("3. Add course credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    gradingSystem.addStudent(new Student(studentID, name));
                    break;
                 case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);
                    gradingSystem.addGrade(new Grade(studentID, courseID, grade));
                    break;
                case 3:
                    System.out.print("Enter course ID: ");
                    courseID = scanner.nextInt();
                    System.out.print("Enter credits: ");
                    int credits = scanner.nextInt();
                    gradingSystem.addCourseCredits(courseID, credits);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextInt();
                    System.out.println("GPA: " + gradingSystem.calculateGPA(studentID));
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    

    
}
