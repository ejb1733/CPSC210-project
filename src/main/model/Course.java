package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// a Course which has a name and list of pre-requisites
public class Course implements Writable {
    private final String name;
    private final ArrayList<Course> prereqs;

    // MODIFIES: this
    // EFFECTS: constructs a Course with given name and list of its pre-requisite classes
    public Course(String name, ArrayList<Course> prereqs) {
        this.name = name;
        this.prereqs = prereqs;
    }

    // EFFECTS: returns a Course's name
    public String getCourseName() {
        return this.name;
    }

    // EFFECTS: returns a course's pre-requisites
    public ArrayList<Course> getPrereqs() {
        return this.prereqs;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("courseName", name);
        json.put("prereqs", prereqs);
        return json;
    }
}
