package com.example.StudentCV;
import java.util.ArrayList;

public class Student {

    private String FullName;
    private String PhoneNumber;
    private String School;
    private double GPA;
    private ArrayList<Experience> Research;
    private ArrayList<Experience> Projects;
    private ArrayList<Experience> Awards;
    private ArrayList<Courses> Transcript;



    public Student(String fullname, String phonenumber, String school ){

        FullName = fullname;
        PhoneNumber = phonenumber;
        School = school;
    }



    public void setFullName(String name){ FullName = name; }
    public String getFullName(){
        return FullName;
    }

    public void setPhoneNumber(String number){ PhoneNumber = number; }
    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public void setSchool(String college){
        School = college;
    }
    public String getSchool() {return School;}



    //-----------------------------FullName & CellPhone



    //-----------------------------Research Get/Set Functions

    public String getResearch(){
        String explist = "";

        for(Experience obj:Research){

            explist += obj.getTimeline() + "\n" + obj.getResearch() + "\n\n";

        }

        return explist;
    }

    public void extractResearch(String[] Buffer){



        int count = Integer.parseInt(Buffer[0]);

        Research = new ArrayList<Experience>();

        //Description of research and date is separated by a comma ','
        for(int x = 1; x<count+(1); x++){
            String[] parts = Buffer[x].split(", ");

            Experience research = new Experience(parts[0],parts[1]);

            Research.add(research);
        }
    }
//-----------------------------Projects Get/Set Functions

    public String getProjects(){
        String explist = "";

        for(Experience obj:Projects){

            explist += obj.getTimeline() + "\n" + obj.getResearch() + "\n\n";

        }

        return explist;
    }

    public void extractProjects(String[] Buffer){



        int count = Integer.parseInt(Buffer[0]);

        Projects = new ArrayList<Experience>();

        //Description of research and date is separated by a comma ','
        for(int x = 1; x<count+(1); x++){
            String[] parts = Buffer[x].split(", ");

            Experience project = new Experience(parts[0],parts[1]);

            Projects.add(project);
        }
    }
    //-----------------------------Awards Get/Set Functions

    public String getAwards(){
        String explist = "";

        for(Experience obj:Awards){

            explist += obj.getTimeline() + "\n" + obj.getResearch() + "\n\n";

        }

        return explist;
    }

    public void extractAwards(String[] Buffer){



        int count = Integer.parseInt(Buffer[0]);

        Awards = new ArrayList<Experience>();

        //Description of research and date is separated by a comma ','
        for(int x = 1; x<count+(1); x++){
            String[] parts = Buffer[x].split(", ");

            Experience award = new Experience(parts[0],parts[1]);

            Awards.add(award);
        }
    }
    //----------------------------Courses Get/Set Functions
    public void extractCourses(String[] Buffer){



        int count = Integer.parseInt(Buffer[0]);
        double Gradept;

        Transcript = new ArrayList<Courses>();

        //Description of research and date is separated by a comma ','
        for(int x = 1; x<count+(1); x++){
            String[] parts = Buffer[x].split(": ");

            Courses course = new Courses(parts[0],parts[1]);
            course.toGradePts();

            Transcript.add(course);
        }
    }

    public String getTranscript(){
        String Unofficial = "";

        for(Courses obj:Transcript){

            Unofficial += obj.getCourse() + ": " + obj.getLetterGrade() +  "\n";

        }

        return Unofficial;
    }

    //--------------------------------GPA set/get functions
    public String getGPA(){ return String.format("%.2f",GPA);
    }

    public void setGPA(){
        double GradePoints = 0.0;

        for(Courses obj:Transcript){

            GradePoints +=  obj.getGrade();

        }

        GPA = GradePoints/Transcript.size();


    }
//----------------------------------------------Assemble CV
    public String AssembleCV(){

        String Name = "Name: " + this.getFullName() +"\n";
        String Phone = "Phone: " + this.getPhoneNumber() +"\n";
        String Academics = "Academics: \n" + this.getSchool() + "\nGPA: " + this.getGPA() + "\n" + this.getTranscript();
        String Research = "Research: \n" + this.getResearch();
        String Project = "Projects: \n" + this.getProjects();
        String Award = "Awards: \n" + this.getAwards();

        String CV = Name + Phone + Academics + Research + Project + Award;
        return CV;
    }





}