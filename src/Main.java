import java.util.Arrays;
import java.util.Scanner;
class StudentGradeTracker{
    String studentName;
    double [] marks;

    StudentGradeTracker(String studentName,double [] marks){
        this.studentName=studentName;
        this.marks=marks;
    }
    public double getAverage()
    {
        double sum=0;
        for(int i=0;i<marks.length;i++)
        {
            sum+=marks[i];


        }
        return sum/marks.length;

    }
    public static void displayGrades(StudentGradeTracker [] student){
        double highestAvg=student[0].getAverage();
        double lowestAvg=student[0].getAverage();
        for(StudentGradeTracker stud:student) {
           if(stud.getAverage()>highestAvg)
           {
               highestAvg=stud.getAverage();
           }
           if (stud.getAverage() < lowestAvg) {
                lowestAvg = stud.getAverage();
            }
        }
        for(StudentGradeTracker st:student) {
            double avg = st.getAverage();
            if (avg == highestAvg) {
                System.out.println("Highest Marks: " + st.studentName + " (" + avg + ")");
            } else if (avg == lowestAvg) {
                System.out.println("Lowest Marks: " + st.studentName + " (" + avg + ")");
            } else {
                System.out.println("Average Marks: " + st.studentName + " (" + avg + ")");
            }
        }

    }
}
public class Main {
    public static void main(String[] args) {
        String [] subjects={"English","Physis","Maths","Chemistry"};
      Scanner input=new Scanner(System.in);
      System.out.println("How Many Student Do You Enter: ");
      int numOfStudent=input.nextInt();
      input.nextLine();
      StudentGradeTracker [] student=new StudentGradeTracker[numOfStudent];
      //input student data
      for(int i=0;i<numOfStudent;i++) {
          System.out.println("Enter Student Name : ");
          String name = input.nextLine().toUpperCase();

          double [] subMarks =new double [subjects.length];
          for(int j=0;j<subjects.length;j++) {
              System.out.println("Enter "+subjects[j]+ " Marks  ");
              subMarks[j] = input.nextDouble();
          }

          input.nextLine();
          student[i]=new StudentGradeTracker(name,subMarks);
      }
        // Output in table format
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-10s", "Name");
        for (String subject : subjects) {
            System.out.printf("| %-8s", subject);
        }
        System.out.printf("| %-8s", "Average");
        System.out.println("\n-------------------------------------------------------------");

        for (StudentGradeTracker s : student) {
            System.out.printf("%-10s", s.studentName);
            for (double m : s.marks) {
                System.out.printf("| %-8.2f", m);
            }
            System.out.printf("| %-8.2f", s.getAverage());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------");

        StudentGradeTracker.displayGrades(student);

    }
}
