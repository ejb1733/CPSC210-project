package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public interface Courses {

    ArrayList<Course> noPrereqs = new ArrayList<>();

    Course cpsc110 = new Course("CPSC 110", noPrereqs);
    ArrayList<Course> prereq110 = new ArrayList<>(Collections.singletonList(cpsc110));
    Course cpsc121 = new Course("CPSC 121", prereq110);

    Course cpsc210 = new Course("CPSC 210", prereq110);
    ArrayList<Course> prereq121_210 = new ArrayList<>(Arrays.asList(cpsc121, cpsc210));
    Course cpsc213 = new Course("CPSC 213", prereq121_210);
    Course cpsc221 = new Course("CPSC 221", prereq121_210);

    ArrayList<Course> prereq210 = new ArrayList<>(Collections.singletonList(cpsc210));
    ArrayList<Course> prereq221 = new ArrayList<>(Collections.singletonList(cpsc221));
    ArrayList<Course> prereq213_211 = new ArrayList<>(Arrays.asList(cpsc213, cpsc221));
    Course cpsc302 = new Course("CPSC 302", prereq110);
    Course cpsc303 = new Course("CPSC 303", prereq110);
    Course cpsc304 = new Course("CPSC 304", prereq221);
    Course cpsc310 = new Course("CPSC 310", prereq213_211);
    Course cpsc311 = new Course("CPSC 311", prereq210);
    Course cpsc312 = new Course("CPSC 312", prereq210);
    Course cpsc313 = new Course("CPSC 313", prereq213_211);
    Course cpsc314 = new Course("CPSC 314", prereq221);
    Course cpsc317 = new Course("CPSC 317", prereq213_211);
    ArrayList<Course> prereq310 = new ArrayList<>(Collections.singletonList(cpsc310));
    Course cpsc319 = new Course("CPSC 319", prereq310);
    Course cpsc320 = new Course("CPSC 320", prereq221);
    Course cpsc322 = new Course("CPSC 322", prereq221);
    Course cpsc330 = new Course("CPSC 330", prereq210);
    Course cpsc340 = new Course("CPSC 340", prereq221);
    Course cpsc344 = new Course("CPSC 344", prereq210);


    ArrayList<Course> firstYears = new ArrayList<>(Arrays.asList(cpsc110, cpsc121));
    ArrayList<Course> secondYears = new ArrayList<>(Arrays.asList(cpsc210, cpsc213, cpsc221));
    ArrayList<Course> thirdYears = new ArrayList<>(Arrays.asList(cpsc302, cpsc303, cpsc304, cpsc310, cpsc311, cpsc312,
            cpsc313, cpsc314, cpsc317, cpsc319, cpsc320, cpsc322, cpsc330, cpsc340, cpsc344));

}
