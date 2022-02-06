package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Interface that defines fields for all the CPSC courses
// given from the website in the readme
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

    ArrayList<Course> prereq302 = new ArrayList<>(Collections.singletonList(cpsc302));
    ArrayList<Course> prereq313 = new ArrayList<>(Collections.singletonList(cpsc313));
    ArrayList<Course> prereq314 = new ArrayList<>(Collections.singletonList(cpsc314));
    ArrayList<Course> prereq320 = new ArrayList<>(Collections.singletonList(cpsc320));
    ArrayList<Course> prereq322 = new ArrayList<>(Collections.singletonList(cpsc322));
    ArrayList<Course> prereq213_304 = new ArrayList<>(Arrays.asList(cpsc213, cpsc304));
    ArrayList<Course> prereq213_221_311 = new ArrayList<>(Arrays.asList(cpsc213, cpsc221, cpsc311));
    ArrayList<Course> prereq313_317 = new ArrayList<>(Arrays.asList(cpsc313, cpsc317));
    ArrayList<Course> prereq313_320 = new ArrayList<>(Arrays.asList(cpsc313, cpsc320));
    ArrayList<Course> prereq221_320 = new ArrayList<>(Arrays.asList(cpsc221, cpsc320));
    ArrayList<Course> prereq310_344 = new ArrayList<>(Arrays.asList(cpsc310, cpsc344));
    Course cpsc402 = new Course("CPSC 402", prereq302);
    Course cpsc404 = new Course("CPSC 404", prereq213_304);
    Course cpsc406 = new Course("CPSC 406", prereq313);
    Course cpsc410 = new Course("CPSC 410", prereq310);
    Course cpsc411 = new Course("CPSC 411", prereq213_221_311);
    Course cpsc415 = new Course("CPSC 415", prereq313);
    Course cpsc416 = new Course("CPSC 416", prereq313_317);
    Course cpsc417 = new Course("CPSC 417", prereq313_317);
    Course cpsc418 = new Course("CPSC 418", prereq313_320);
    Course cpsc420 = new Course("CPSC 420", prereq320);
    Course cpsc421 = new Course("CPSC 421", prereq221_320);
    Course cpsc422 = new Course("CPSC 422", prereq322);
    Course cpsc424 = new Course("CPSC 424", prereq320);
    Course cpsc425 = new Course("CPSC 425", prereq221);
    Course cpsc426 = new Course("CPSC 426", prereq314);
    Course cpsc427 = new Course("CPSC 427", prereq221);
    Course cpsc444 = new Course("CPSC 444", prereq310_344);
    Course cpsc445 = new Course("CPSC 445", prereq320);

    ArrayList<Course> firstYears = new ArrayList<>(Arrays.asList(cpsc110, cpsc121));
    ArrayList<Course> secondYears = new ArrayList<>(Arrays.asList(cpsc210, cpsc213, cpsc221));
    ArrayList<Course> thirdYears = new ArrayList<>(Arrays.asList(cpsc302, cpsc303, cpsc304, cpsc310, cpsc311, cpsc312,
            cpsc313, cpsc314, cpsc317, cpsc319, cpsc320, cpsc322, cpsc330, cpsc340, cpsc344));
    ArrayList<Course> fourthYears = new ArrayList<>(Arrays.asList(cpsc402, cpsc404, cpsc406, cpsc410, cpsc411, cpsc415,
            cpsc416, cpsc417, cpsc418, cpsc420, cpsc421, cpsc422,
            cpsc424, cpsc425, cpsc426, cpsc427, cpsc444, cpsc445));

}
