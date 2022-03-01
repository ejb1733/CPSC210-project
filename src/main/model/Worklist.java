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

    // EFFECTS: returns a list of worklists
    public ArrayList<Worklist> getWorklists() {
        return this.worklistArrayList;
    }

    public void displayWorklists() {
        if (this.worklistArrayList.isEmpty()) {
            System.out.println("You've got no worklists, silly!");
        } else {
            System.out.println("Please select from your worklists:");
            for (int i = 1; i <= this.worklistArrayList.size(); i++) {
                System.out.println(i + worklistArrayList.get(i).getWorklistName());
            }
        }
    }

    public void setWorklistName(String setName) {
        this.name = setName;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("courses", coursesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray coursesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Course c : worklist) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}