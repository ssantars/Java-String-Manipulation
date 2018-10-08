package com.example.StudentCV;



public class Courses {

    private String Course;
    private String LetterGrade;
    private double Grade;
    //private double CummGPA;

    public Courses(String course,String grade){

        Course = course;
        LetterGrade = grade;
        //Exp[0] = Experience;
    }

    public void setCourse(String course){Course = course;}
    public String getCourse(){return Course;}

    public void setLetterGrade(String letterGrade){LetterGrade = letterGrade;}
    public String getLetterGrade(){return LetterGrade;}

    public void setGrade(double grade){Grade = grade;}
    public double getGrade(){return Grade;}

    public void toGradePts(){

        if (LetterGrade.equals("A+")){
            Grade = 4.0;
        }
        else if (LetterGrade.equals("A")){
            Grade = 4.0;
        }
        else if (LetterGrade.equals("A-")){
            Grade = 3.7;
        }
        else if (LetterGrade.equals("B+")){
            Grade = 3.3;
        }
        else if (LetterGrade.equals("B")){
            Grade = 3.0;
        }
        else if (LetterGrade.equals("B-")){
            Grade = 2.7;
        }
        else if (LetterGrade.equals("C+")){
            Grade = 2.3;
        }
        else if (LetterGrade.equals("C")){
            Grade = 2.0;
        }
        else if (LetterGrade.equals("C-")){
            Grade = 1.7;
        }
        else if (LetterGrade.equals("D+")){
            Grade = 1.3;
        }
        else if (LetterGrade.equals("D")){
            Grade = 1.0;
        }
        else if (LetterGrade.equals("D-")){
            Grade = 0.7;
        }
        else if (LetterGrade.equals("F")){
            Grade = 0.0;
        }
        //if return 10 then string had error

    }



}
