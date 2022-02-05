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
    // REQUIRES: course given is a real course
    // MODIFIES: this
    // EFFECTS: adds course to worklist
    public void addCourse(Course course) {
        if (this.worklist.contains(course)) {
            System.out.println("This course cannot be added, as it's already in your worklist!");
        } else {
            this.worklist.add(course);
            System.out.println("Successfully added " + course.getCourseName()
                    + " to your worklist " + getWorklistName());
        }
    }

    // TODO
    // REQUIRES: course given is a real course
    // MODIFIES: this
    // EFFECTS: removes course from worklist
    public void removeCourse(Course course) {
        this.worklist.remove(course);
    }

    public int getWorklistSize() {
        return this.worklist.size();
    }

    public String getWorklistName() {
        return this.name;
    }

    public ArrayList<Course> getWorklistEntries() {
        return this.worklist;
    }

}
