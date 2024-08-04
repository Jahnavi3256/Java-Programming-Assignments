public class GradingSystem {
    Student[] students;
    Grade[] grades;
    int[] courseCredits;
    int studentCount;
    int gradeCount;

    public GradingSystem(int maxStudents, int maxGrades, int maxCourses) {
        students = new Student[maxStudents];
        grades = new Grade[maxGrades];
        courseCredits = new int[maxCourses];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student student) {
        students[studentCount++] = student;
    }

    public void addGrade(Grade grade) {
        grades[gradeCount++] = grade;
    }

    public void addCourseCredits(int courseID, int credits) {
        courseCredits[courseID] = credits;
    }

    public double calculateGPA(int studentID) {
        int totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentID() == studentID) {
                totalPoints += gradeToPoints(grades[i].getGrade()) * courseCredits[grades[i].getCourseID()];
                totalCredits += courseCredits[grades[i].getCourseID()];
            }
        }

        return (double) totalPoints / totalCredits;
    }

    private int gradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }
}
