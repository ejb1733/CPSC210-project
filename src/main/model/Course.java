package model;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Course> prereqs;

    // EFFECTS: constructs a Course with given name and list of its pre-requisite classes
    public Course(String name, ArrayList<Course> prereqs) {
        this.name = name;
        this.prereqs = prereqs;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Course> getPrereqs() {
        return this.prereqs;
    }
}
