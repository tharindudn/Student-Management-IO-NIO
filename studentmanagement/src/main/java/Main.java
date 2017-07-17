import java.util.Scanner;

/**
 * Created by tharindu on 7/17/17.
 */
public class Main {
    public static void  inputMethod() {
        Scanner in = new Scanner(System.in);
        StudentControl studentcontrol=new StudentControl();
        String status="";
        int id;
        boolean stavailable;
        while(!(status.equalsIgnoreCase("exit"))){

            System.out.println("Press 1 to enter student details..");
            System.out.println("Press 2 to enter marks of a student...");
            System.out.println("Press 3 to check marks of a student...");
            System.out.println("Press 4 to print marks list...");
            System.out.println("Press 5 to insert from file...");
            System.out.println("Press 6 to print marks list...using NIO");
            System.out.println("Press 7 to insert from file...using NIO");
            System.out.println("Press 8 Run Watch directory...");
            try {
                int sw = in.nextInt();

                switch (sw) {
                    case 1:
                        Student newstudent = new Student();
                        System.out.println("Enter student id : ");
                        newstudent.setId(in.nextInt());
                        System.out.println("Enter student name : ");
                        newstudent.setName(in.next());
                        studentcontrol.studentDetails(newstudent);
                        break;
                    case 2:
                        System.out.println("Enter student id : ");
                        id = in.nextInt();
                        stavailable = studentcontrol.checkStudent(id);
                        if (stavailable) {
                            int[] marks = new int[2];
                            Student student = studentcontrol.getStudent(id);
                            System.out.println("Student exist...");
                            System.out.println("Enter marks for subject 1...");
                            marks[0] = in.nextInt();
                            System.out.println("Enter marks for subject 2...");
                            marks[1] = in.nextInt();
                            student.setMarks(marks);
                        } else {
                            System.out.println("No student with " + id);
                        }
                        break;
                    case 3:
                        System.out.println("Enter student id to check marks: ");
                        id = in.nextInt();
                        stavailable = studentcontrol.checkStudent(id);
                        if (stavailable) {
                            int[] marks;
                            Student student = studentcontrol.getStudent(id);
                            System.out.println("Student exist...");
                            marks = student.getMarks();
                            System.out.println("NAME     | MARKS | GRADE  |");
                            System.out.println("Subject1 | " + marks[0] + "    |  " + Exam.grade(marks[0]) + "     |");
                            System.out.println("Subject2 | " + marks[1] + "    |  " + Exam.grade(marks[0]) + "     |");

                        } else {
                            System.out.println("No student with " + id);
                        }
                        break;
                    case 4:
                        studentcontrol.printStudentDetailsBfWr();
                        System.out.println("Mark sheet is generated...");
                        break;
                    case 5:
                        System.out.println("Enter file name...");
                        String fname=in.next();
                        studentcontrol.insertfromFile(fname+".txt");
                        break;
                    case 6:
                        studentcontrol.printStudentDetailsNIO();
                        break;
                    case 7:
                        System.out.println("Enter file name...");
                        String file=in.next();
                        studentcontrol.insertfromFileNIO(file+".txt");
                        break;
                    case 8:
                        studentcontrol.watchDir();
                        break;
                    default:System.exit(0);


                }



            }catch (Exception e){
                System.out.println("wrong input... check again...");
            }
            System.out.println("Enter exit to close the program or pres any key to continue...");
            status = in.next();
        }
    }

    public static void main(String[] args) {

        inputMethod();

    }
}
