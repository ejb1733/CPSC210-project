package model;

import java.util.ArrayList;

// Course Catalogue abstraction that provides organized course options for students to choose from.
// For example, students can choose from first, second, third, fourth year classes.
// Course Catalogues have a name and a list of courses to choose from.
public class CourseCatalogue {

    private final ArrayList<Course> courses;
    private final String title;

    // MODIFIES: this
    // EFFECTS: constructs a CourseCatalogue with given title and list of courses
    public CourseCatalogue(String title, ArrayList<Course> courses) {
        this.title = title;
        this.courses = courses;
    }

    // EFFECTS: returns the list of courses in a course catalogue
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

}
