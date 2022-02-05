package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private String name;
    private ArrayList<Course> prereqs;

    private final ArrayList<Course> noPrereqs = new ArrayList<>();

    // EFFECTS: constructs a Course with given name and list of its pre-requisite classes
    public Course(String name, ArrayList<Course> prereqs) {
        this.name = name;
        this.prereqs = prereqs;
    }

    public String getCourseName() {
        return this.name;
    }

    public ArrayList<Course> getPrereqs() {
        return this.prereqs;
    }
}
