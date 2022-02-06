package ui;

import model.CourseCatalogue;
import model.Courses;
import model.Worklist;

import java.util.Scanner;

// UI methods for UBC WonderfulWorklists
public class WonderfulWorklists implements Courses {
    private CourseCatalogue firstYearCourses;
    private CourseCatalogue secondYearCourses;
    private CourseCatalogue thirdYearCourses;
    private CourseCatalogue fourthYearCourses;

    private Worklist worklist;

    private Scanner input;

    // EFFECTS: runs the program!
    public WonderfulWorklists() {
        runWorklist();
    }

    // MODIFIES: this
    // EFFECTS: processes user inputs
    private void runWorklist() {
        String command;
        boolean running = true;

        init();

        while (running) {
            menu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                running = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nUntil next time!");
    }

    // EFFECTS: print a list of options to console
    private void menu() {
        System.out.println("\nWelcome to UBC WonderfulWorklists!");
        System.out.println("\nPlease select from the following options:");
        System.out.println("\tN -> Create a New Worklist");
        // System.out.println("\tR -> Register a Worklist");
        System.out.println("\tQ -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: executes user command
    private void processCommand(String command) {
        if (command.equals("n")) {
            takeName();
            createWorklist();
        } else if (command.equals("r")) {
            registerWorklist();
        } else {
            System.out.println("Please choose from a selection above");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes CourseCatalogues and a scanner
    private void init() {
        firstYearCourses = new CourseCatalogue("First Year Courses", firstYears);
        secondYearCourses = new CourseCatalogue("Second Year Courses", secondYears);
        thirdYearCourses = new CourseCatalogue("Third Year Courses", thirdYears);
        fourthYearCourses = new CourseCatalogue("Fourth Year Courses", fourthYears);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: executes helper methods
    private void createWorklist() {
        printWorklistOptions(this.worklist.getWorklistName());
        takeInput();
        addMore();
    }

    // EFFECTS: takes the student's input for their worklist name
    private void takeName() {
        System.out.println("Please enter a name for your new worklist:");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        Worklist studentWorkList = new Worklist(name);
        this.worklist = studentWorkList;
        System.out.println("Your worklist - " + studentWorkList.getWorklistName() + " - has been created!");
    }

    // EFFECTS: prints a list of course catalogues to choose from
    private void printWorklistOptions(String name) {
        System.out.println("\nTo add courses to " + name + ", please select from the following:");
        System.out.println("\t1 -> add first year courses");
        System.out.println("\t2 -> add second year courses");
        System.out.println("\t3 -> add third year courses");
        System.out.println("\t4 -> Add fourth year courses");
    }

    // EFFECTS: registers the input of a student's desired course catalogue
    private void takeInput() {
        Scanner inputInt = new Scanner(System.in);
        int num = inputInt.nextInt();
        if (num == 1) {
            displayFirstYearOptions();
            takeAddRequest(firstYearCourses);
        } else if (num == 2) {
            displaySecondYearOptions();
            takeAddRequest(secondYearCourses);
        } else if (num == 3) {
            displayThirdYearOptions();
            takeAddRequest(thirdYearCourses);
        } else if (num == 4) {
            displayFourthYearOptions();
            takeAddRequest(fourthYearCourses);
        }
    }

    // EFFECTS: displays first year course catalogue
    private void displayFirstYearOptions() {
        System.out.println("\nPlease select from the following first year courses:");
        for (int c = 0; c < firstYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + firstYearCourses.getCourses().get(c).getCourseName());
        }
    }

    // EFFECTS: displays second year course catalogue
    private void displaySecondYearOptions() {
        System.out.println("Please select from the following second year courses:");
        for (int c = 0; c < secondYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + secondYearCourses.getCourses().get(c).getCourseName());
        }
    }

    // EFFECTS: displays third year course catalogue
    private void displayThirdYearOptions() {
        System.out.println("Please select from the following third year courses:");
        for (int c = 0; c < thirdYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + thirdYearCourses.getCourses().get(c).getCourseName());
        }
    }

    // EFFECTS: displays fourth year course catalogue
    private void displayFourthYearOptions() {
        System.out.println("Please select from the following fourth year courses:");
        for (int c = 0; c < fourthYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + fourthYearCourses.getCourses().get(c).getCourseName());
        }
    }

    // MODIFIES: this
    // EFFECTS: takes a user's course choice and adds it to their worklist
    private void takeAddRequest(CourseCatalogue year) {
        Scanner inputInt = new Scanner(System.in);
        int num = inputInt.nextInt();
        for (int i = 0; i < year.getCourses().size(); i++) {
            if (num - 1 == i) {
                this.worklist.addCourse(year.getCourses().get(i));
            }
        }
    }

    // EFFECTS: takes user input for if they want to add more courses or exit to the menu.
    //          If they choose to exit to the menu, their worklist full of courses will be displayed.
    private void addMore() {
        System.out.println("\nWould you like to add more courses?");
        System.out.println("\tY -> Add more courses");
        System.out.println("\tN -> View worklist and exit to menu");
        String command = input.next();
        command = command.toLowerCase();
        if (command.equals("y")) {
            createWorklist();
        } else if (command.equals("n")) {
            System.out.println("\n" + this.worklist.getWorklistName());
            for (int i = 0; i < this.worklist.getWorklistSize(); i++) {
                System.out.println("\t- " + worklist.getWorklistEntries().get(worklist.getWorklistSize()
                        - 1 - i).getCourseName());
            }
        }
    }



    private void registerWorklist() {

    }

}
