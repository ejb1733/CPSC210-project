package model;

import java.util.*;

// Abstract class that defines fields and methods for all the CPSC courses
// given from the website in the readme
public abstract class Courses {

    protected static WorklistList wll = new WorklistList("WonderfulWorklists");

    protected static ArrayList<Course> noPrereqs = new ArrayList<>();

    protected static Course cpsc110 = new Course("CPSC 110", noPrereqs);
    protected static ArrayList<Course> prereq110 = new ArrayList<>(Collections.singletonList(cpsc110));
    protected static Course cpsc121 = new Course("CPSC 121", prereq110);

    protected static Course cpsc210 = new Course("CPSC 210", prereq110);
    protected static ArrayList<Course> prereq121210 = new ArrayList<>(Arrays.asList(cpsc121, cpsc210));
    protected static Course cpsc213 = new Course("CPSC 213", prereq121210);
    protected static Course cpsc221 = new Course("CPSC 221", prereq121210);

    protected static ArrayList<Course> prereq210 = new ArrayList<>(Collections.singletonList(cpsc210));
    protected static ArrayList<Course> prereq221 = new ArrayList<>(Collections.singletonList(cpsc221));
    protected static ArrayList<Course> prereq213211 = new ArrayList<>(Arrays.asList(cpsc213, cpsc221));
    protected static Course cpsc302 = new Course("CPSC 302", prereq110);
    protected static Course cpsc303 = new Course("CPSC 303", prereq110);
    protected static Course cpsc304 = new Course("CPSC 304", prereq221);
    protected static Course cpsc310 = new Course("CPSC 310", prereq213211);
    protected static Course cpsc311 = new Course("CPSC 311", prereq210);
    protected static Course cpsc312 = new Course("CPSC 312", prereq210);
    protected static Course cpsc313 = new Course("CPSC 313", prereq213211);
    protected static Course cpsc314 = new Course("CPSC 314", prereq221);
    protected static Course cpsc317 = new Course("CPSC 317", prereq213211);
    protected static ArrayList<Course> prereq310 = new ArrayList<>(Collections.singletonList(cpsc310));
    protected static Course cpsc319 = new Course("CPSC 319", prereq310);
    protected static Course cpsc320 = new Course("CPSC 320", prereq221);
    protected static Course cpsc322 = new Course("CPSC 322", prereq221);
    protected static Course cpsc330 = new Course("CPSC 330", prereq210);
    protected static Course cpsc340 = new Course("CPSC 340", prereq221);
    protected static Course cpsc344 = new Course("CPSC 344", prereq210);

    protected static ArrayList<Course> prereq302 = new ArrayList<>(Collections.singletonList(cpsc302));
    protected static ArrayList<Course> prereq313 = new ArrayList<>(Collections.singletonList(cpsc313));
    protected static ArrayList<Course> prereq314 = new ArrayList<>(Collections.singletonList(cpsc314));
    protected static ArrayList<Course> prereq320 = new ArrayList<>(Collections.singletonList(cpsc320));
    protected static ArrayList<Course> prereq322 = new ArrayList<>(Collections.singletonList(cpsc322));
    protected static ArrayList<Course> prereq213304 = new ArrayList<>(Arrays.asList(cpsc213, cpsc304));
    protected static ArrayList<Course> prereq213221311 = new ArrayList<>(Arrays.asList(cpsc213, cpsc221, cpsc311));
    protected static ArrayList<Course> prereq313317 = new ArrayList<>(Arrays.asList(cpsc313, cpsc317));
    protected static ArrayList<Course> prereq313320 = new ArrayList<>(Arrays.asList(cpsc313, cpsc320));
    protected static ArrayList<Course> prereq221320 = new ArrayList<>(Arrays.asList(cpsc221, cpsc320));
    protected static ArrayList<Course> prereq310344 = new ArrayList<>(Arrays.asList(cpsc310, cpsc344));
    protected static Course cpsc402 = new Course("CPSC 402", prereq302);
    protected static Course cpsc404 = new Course("CPSC 404", prereq213304);
    protected static Course cpsc406 = new Course("CPSC 406", prereq313);
    protected static Course cpsc410 = new Course("CPSC 410", prereq310);
    protected static Course cpsc411 = new Course("CPSC 411", prereq213221311);
    protected static Course cpsc415 = new Course("CPSC 415", prereq313);
    protected static Course cpsc416 = new Course("CPSC 416", prereq313317);
    protected static Course cpsc417 = new Course("CPSC 417", prereq313317);
    protected static Course cpsc418 = new Course("CPSC 418", prereq313320);
    protected static Course cpsc420 = new Course("CPSC 420", prereq320);
    protected static Course cpsc421 = new Course("CPSC 421", prereq221320);
    protected static Course cpsc422 = new Course("CPSC 422", prereq322);
    protected static Course cpsc424 = new Course("CPSC 424", prereq320);
    protected static Course cpsc425 = new Course("CPSC 425", prereq221);
    protected static Course cpsc426 = new Course("CPSC 426", prereq314);
    protected static Course cpsc427 = new Course("CPSC 427", prereq221);
    protected static Course cpsc444 = new Course("CPSC 444", prereq310344);
    protected static Course cpsc445 = new Course("CPSC 445", prereq320);

    protected static ArrayList<Course> firstYears = new ArrayList<>(Arrays.asList(cpsc110, cpsc121));
    protected static ArrayList<Course> secondYears = new ArrayList<>(Arrays.asList(cpsc210, cpsc213, cpsc221));
    protected static ArrayList<Course> thirdYears = new ArrayList<>(Arrays.asList(cpsc302, cpsc303, cpsc304, cpsc310,
            cpsc311, cpsc312, cpsc313, cpsc314, cpsc317, cpsc319, cpsc320, cpsc322, cpsc330, cpsc340, cpsc344));
    protected static ArrayList<Course> fourthYears = new ArrayList<>(Arrays.asList(cpsc402, cpsc404, cpsc406, cpsc410,
            cpsc411, cpsc415, cpsc416, cpsc417, cpsc418, cpsc420, cpsc421, cpsc422, cpsc424, cpsc425, cpsc426, cpsc427,
            cpsc444, cpsc445));
    protected static ArrayList<Course> customs = new ArrayList<>();

    protected static ArrayList<Course> allCourses = new ArrayList<>(Arrays.asList(cpsc110, cpsc121,
            cpsc210, cpsc213, cpsc221,

            cpsc302, cpsc303, cpsc304, cpsc310,
            cpsc311, cpsc312, cpsc313, cpsc314, cpsc317, cpsc319, cpsc320, cpsc322, cpsc330, cpsc340, cpsc344,

            cpsc402, cpsc404, cpsc406, cpsc410,
            cpsc411, cpsc415, cpsc416, cpsc417, cpsc418, cpsc420, cpsc421, cpsc422, cpsc424, cpsc425, cpsc426, cpsc427,
            cpsc444, cpsc445));

    protected static Map<String, Course> kappa = new HashMap<>();

    protected static ArrayList<String> yearOptions = new ArrayList<>(Arrays.asList("First Year", "Second Year",
            "Third Year", "Fourth Year"));

    // EFFECTS: print a list of options to console
    public void menu() {
//        System.out.println();
//        System.out.println("Welcome to UBC WonderfulWorklists!");
//        System.out.println("Please select from the following options:");
//        System.out.println("\n\tN -> Create a New Worklist");
//        System.out.println("\tC -> Create a New Course");
//        System.out.println("\tE -> Edit your Worklists");
//        System.out.println(" ");
//        System.out.println("\tL -> Load your Worklists");
//        System.out.println("\tS -> Save your Worklists");
//        System.out.println("\n\tQ -> Quit");
        System.out.println();
    }

    // EFFECTS: prints year options to console
    public void printOptions() {
        System.out.println("\t1 -> first year");
        System.out.println("\t2 -> second year");
        System.out.println("\t3 -> third year");
        System.out.println("\t4 -> fourth year");
    }

    // EFFECTS: prints out options for how one can edit a worklist
    public void editOptions(Worklist w) {
        System.out.println("\nWhat would you like to do with " + w.getWorklistName() + "?");
        System.out.println("\t1 -> View courses ");
        System.out.println("\t2 -> Add a course ");
        System.out.println("\t3 -> Remove a course");
        System.out.println("\t4 -> Edit " + w.getWorklistName() + "'s name");
        System.out.println("\t5 -> Delete this Worklist");
    }

    // EFFECTS: forwards selected year to printYearOptions with proper course catalogue
    public void selectYearOptions(int year) {
        if (year == 1) {
            printYearOptions(firstYears);
        } else if (year == 2) {
            printYearOptions(secondYears);
        } else if (year == 3) {
            printYearOptions(thirdYears);
        } else if (year == 4) {
            printYearOptions(fourthYears);
        }
    }

    // EFFECTS: prints all the courses from a given year. Super cool method
    public void printYearOptions(ArrayList<Course> catalogue) {
        System.out.println("Please select from the following courses:");
        for (int c = 0; c < catalogue.size(); c++) {
            System.out.println("\t" + (c + 1) + " - > " + catalogue.get(c).getCourseName());
        }
    }

    public void putCourse() {
        for (Course c : allCourses) {
            kappa.put(c.getCourseName(), c);
        }
    }

    public boolean isACustomCourse(String courseName) {
        return !kappa.containsKey(courseName);
    }


}
