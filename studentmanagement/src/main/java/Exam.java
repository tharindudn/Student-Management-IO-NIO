/**
 * Created by tharindu on 7/17/17.
 */
public class Exam {
    static String grade(int marks){
        if(marks<=100 &&marks >=95){
            return("EX");
        }else if(marks>=90){
            return("A");
        }else if(marks>=75){
            return("B");
        }else if(marks>=60){
            return("C");
        }else if(marks>=50){
            return("D");
        }else if(marks>=30){
            return("P");
        }else if(marks<30){
            return("F");
        }else{
            return("error...");
        }
    }
}
