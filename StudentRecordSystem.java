public class StudentRecordSystem{
    private Student [] students;
    private int count;

    public StudentRecordSystem(int maxStudents){
        students=new Student [maxStudents];
        count=0;
    }

    public void  addStudent(Student student){
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Number of students has surpass the maximum limit ");
        }

    }
    public Student getStudent(int studentID){
        for (int i = 0; i <count; i++) {
            if ((students[i].getStudentID())==(studentID)) {
                return students[i];
            }
        }
        return null;
    }

    public void displayAllStudents(){
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }

    }

}