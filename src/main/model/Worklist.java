package model;

import java.util.ArrayList;

public class Worklist {
    private String name;
    private ArrayList<Course> worklist;

    // EFFECTS: constructs an empty worklist that a student has made with a custom name
    public Worklist(String name) {
        this.name = name;
        this.worklist = new ArrayList<>();
    }

    // TODO
    // EFFECTS: returns true if worklist has no missing pre-requisites
    public boolean checkWorklist() {
        return false; // stub
    }

    // TODO
    // MODIFIES: this
    // EFFECTS: adds course to worklist
    public void addCourse(Course course) {
        this.worklist.add(course);
    }

    // TODO
    // MODIFIES: this
    // EFFECTS: removes course from worklist
    public void removeCourse(Course course) {
        this.worklist.remove(course);
    }

}
