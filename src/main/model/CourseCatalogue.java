package model;

import java.util.ArrayList;

public class CourseCatalogue {

    private ArrayList<Course> courses;
    private String title;

    public CourseCatalogue(String title, ArrayList<Course> courses) {
        this.title = title;
        this.courses = courses;
    }

    public String getCatalogueTitle() {
        return this.title;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

}
