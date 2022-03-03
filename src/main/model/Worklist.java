package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Worklist abstraction that represents a student's worklist.
// A worklist has a name and list of courses that a student has chosen.
public class Worklist implements Writable {
    private String name;
    private ArrayList<Course> worklist;
    private ArrayList<Worklist> worklistArrayList;

    // EFFECTS: constructs an empty worklist that a student has made with a custom name
    public Worklist(String name) {
        this.name = name;
        this.worklist = new ArrayList<>();
    }

    // REQUIRES: course given is a real course
    // MODIFIES: this
    // EFFECTS: adds course to worklist
    public void addCourse(Course course) {
        if (this.worklist.contains(course)) {
            System.out.println(course.getCourseName() + " cannot be added, as it's already in your worklist!");
        } else {
            this.worklist.add(course);
            System.out.println(course.getCourseName() + " has been successfully added to " + getWorklistName());
        }
    }

    // REQUIRES: course given is a real course
    // MODIFIES: this
    // EFFECTS: removes course from worklist
    public void removeCourse(Course course) {
        System.out.println(course.getCourseName() + " has been successfully removed from "
                + getWorklistName());
        this.worklist.remove(course);
    }

    // MODIFIES: this
    // EFFECTS: takes a user's course choice and adds it to their worklist
    public void takeAddRequest(ArrayList<Course> year, int num) {
        for (int i = 0; i < year.size(); i++) {
            if (num - 1 == i) {
                addCourse(year.get(num - 1));
            }
        }
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

    // MODIFIES: this
    // EFFECTS: changes this Worklist's name to the given name
    public void setWorklistName(String setName) {
        this.name = setName;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("worklistName", this.name);
        json.put("courses", coursesToJson());
        return json;
    }

    // EFFECTS: returns courses from each worklist as a JSON array
    public JSONArray coursesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Course c : worklist) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }
}