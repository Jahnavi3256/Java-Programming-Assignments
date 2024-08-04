import java.util.Scanner;
public class StudentRecordMGMT {
    public static void main(String[] args) {
        StudentRecordSystem  Record =new StudentRecordSystem(1000);
        Scanner Input=new Scanner(System.in);
        int a=0;
        while(a==0){
            System.out.println("Choose Appropriate operation");
            System.out.println("1) Add new  Student Information");
            System.out.println("2) Get Student Information");
            System.out.println("3) Dispaly All Students");
            System.out.println("4)Exit");
            System.out.println("Enter your Choice");
            int choice=Input.nextInt();
            switch(choice){
                case 1:
                System.out.print("Enter Student ID: ");
                int studentID = Input.nextInt();
                Input.nextLine();  // Consume newline
                System.out.print("Enter Name: ");
                String name = Input.nextLine();
                System.out.print("Enter Age: ");
                int age = Input.nextInt();
                Input.nextLine();  // Consume newline
                System.out.print("Enter Department: ");
                String department = Input.nextLine();
                Student stud = new Student(studentID, name, age, department);
                Record.addStudent(stud);
                break; 
                
                case 2:
                System.out.print("Enter Student ID: ");
                int id = Input.nextInt();
                Student StudentInfo = Record.getStudent(id);
                if (StudentInfo != null) {
                    System.out.println(StudentInfo);
                } else {
                    System.out.println("Student not found.");
                }
                break; 

                case 3:
                    Record.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    Input.close();
                    a++;
                    break;

                default: System.out.println("Invalid Choice");
                        
            }
            

        }
    }
    
}
