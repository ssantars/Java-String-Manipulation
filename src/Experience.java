package com.example.StudentCV;


public class Experience {

    private String Research;
    private String Timeline;


    public Experience(String research, String Time){
        Research = research;
        Timeline = Time;
    }

    public void setCompany(String name){ Research = name; }
    public String getResearch(){
        return Research;
    }

    public void setTimeline(String time){Timeline = time; }
    public String getTimeline(){
        return Timeline;
    }


}
