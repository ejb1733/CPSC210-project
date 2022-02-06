package model;

import java.util.ArrayList;

// Worklist abstraction that represents a student's worklist.
// A worklist has a name and list of courses that a student has chosen.
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
/*    public boolean checkWorklist() {
        return false; // stub
    }*/

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

    // REQUIRES: course given is a real course
    // MODIFIES: this
    // EFFECTS: removes course from worklist
    public void removeCourse(Course course) {
        this.worklist.remove(course);
    }

    // EFFECTS: returns the size of a worklist
    public int getWorklistSize() {
        return this.worklist.size();
    }

    // EFFECTS: returns the name of a worklist
    public String getWorklistName() {
        return this.name;
    }

    // EFFECTS: returns a worklists' course entries
    public ArrayList<Course> getWorklistEntries() {
        return this.worklist;
    }

}
