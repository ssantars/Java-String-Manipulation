package com.example.StudentCV;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class latex {

    private static final String INFILE = "Java_Projects";
    private static final String OUTFILE = "output.txt";
    private static final char At = '@';

    private static boolean isDigit(char c)
    {

        {
            if(c == '0' || c == '1' || c == '2')
            {
                return true;
            }
            else if(c == '3' || c == '4' || c == '5')
            {
                return true;
            }
            else if(c == '6' || c == '7' || c == '8' || c == '9')
            {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) throws IOException {  // tells program an exception will occur
        String Student_info = "";
        String School = "";
        String classes = "";
        String research = "";
        String projects = "";
        String achievements = "";




        String load = new String();
        char[] buffer = new char[3];

        int section = 0;



        FileInputStream in = null;
        FileOutputStream out = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Latex Simulator");

        try {

            in = new FileInputStream(INFILE);
            out = new FileOutputStream(OUTFILE);

            //each section of documented is separated by @ symbol which is defined by "At"

            int c;
            int lock =0;

            while ((c = in.read()) != -1) {
                char r = (char) c;



                if ((r == '\r') && (lock == 0)) {
                    buffer[0] = '\r';
                    lock++;
                }
                else if ((buffer[0] == '\r') && (lock == 1))  {
                    buffer[1] = '\n';
                    lock++;
                }
                else if ((buffer[1] == '\n') && (lock == 2))  {
                    buffer[2] = r;
                    lock++;
                }



                if ((buffer[0] == '\r') && (buffer[1] == '\n') && (isDigit(buffer[2]))) {

                    section++;
                    buffer[0] = 0;
                    buffer[1] = 0;
                    buffer[2] = 0;
                    lock =0;
                }
                else if ((buffer[0] == '\r') && (buffer[1] == '\n') && (buffer[2] != '5') && (lock == 3)) {
                    buffer[0] = 0;
                    buffer[1] = 0;
                    buffer[2] = 0;
                    lock =0;
                }

                if (section == 0) {
                    Student_info += r;
                } else if (section == 1) {
                    classes += r;
                } else if (section == 2) {
                    research += r;
                } else if (section == 3) {
                    projects += r;
                } else if (section == 4) {
                    achievements += r;
                }
            }

                /*
               if (r == At) {
                    section++;
                }

                if ((section == 1) && (r != At)) {
                    Student_info += r;
                } else if ((section == 2) && (r != At)) {
                    School += r;
                } else if ((section == 3) && (r != At)) {
                    classes += r;
                } else if ((section == 4) && (r != At)) {
                    research += r;

                } else if ((section == 5) && (r != At)) {
                    projects += r;
                } else if ((section == 6) && (r != At)) {
                    achievements += r;
                }

                */
            //Init Fullname,Phone, and School
            String infoParts[] = Student_info.split("\\r?\\n");
            String StudentPhone[] = infoParts[0].split(", ");
            Student student = new Student(StudentPhone[0],StudentPhone[1],infoParts[1]);
            //Init Courses and GPA
            String classParts[] = classes.split("\\r?\\n");
            student.extractCourses(classParts);
            student.setGPA();
            //Init Research
            String researchParts[] = research.split("\\r?\\n");
            student.extractResearch(researchParts);
            //Init Projects
            String projectParts[] = projects.split("\\r?\\n");
            student.extractProjects(projectParts);
            //Init Awards
            String awardParts[] = achievements.split("\\r?\\n");
            student.extractAwards(awardParts);

            //Make CV
            byte b[] = student.AssembleCV().getBytes();
            out.write(b);




        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }










    }
}