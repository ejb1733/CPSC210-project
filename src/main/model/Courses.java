package model;

import java.util.ArrayList;
import java.util.Arrays;

public interface Courses {

    ArrayList<Course> noPrereqs = new ArrayList<>();

    Course cpsc110 = new Course("CPSC 110", noPrereqs);
    ArrayList<Course> prereq121 = new ArrayList<>(Arrays.asList(cpsc110));
    ArrayList<Course> prereq203 = new ArrayList<>(Arrays.asList(cpsc110));
    ArrayList<Course> prereq210 = new ArrayList<>(Arrays.asList(cpsc110));
    Course cpsc121 = new Course("CPSC 121", prereq121);
    Course cpsc210 = new Course("CPSC 210", prereq210);
    ArrayList<Course> prereq213 = new ArrayList<>(Arrays.asList(cpsc121, cpsc210));
    ArrayList<Course> prereq221 = new ArrayList<>(Arrays.asList(cpsc121, cpsc210));
    Course cpsc201 = new Course("CPSC 201", prereq213);
    Course cpsc213 = new Course("CPSC 213", prereq213);
    Course cpsc221 = new Course("CPSC 221", prereq221);

    ArrayList<Course> firstYears = new ArrayList<>(Arrays.asList(cpsc110, cpsc121));
    ArrayList<Course> secondYears = new ArrayList<>(Arrays.asList(cpsc201, cpsc210, cpsc213, cpsc221));

}
