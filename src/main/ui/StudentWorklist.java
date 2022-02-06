package ui;

import model.CourseCatalogue;
import model.Courses;
import model.Worklist;

import java.util.Scanner;

// Student Worklist Program
public class StudentWorklist implements Courses {
    private CourseCatalogue firstYearCourses;
    private CourseCatalogue secondYearCourses;
    private CourseCatalogue thirdYearCourses;
    private CourseCatalogue fourthYearCourses;

    private Worklist worklist;

    private Scanner input;

    // EFFECTS: runs the program!
    public StudentWorklist() {
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
        System.out.println("\nWelcome to UBC WorklistWonders!");
        System.out.println("\nPlease select from the following options:");
        System.out.println("\tN -> Create a New Worklist");
        System.out.println("\tR -> Register a Worklist");
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
    // EFFECTS: initializes CourseCatalogues
    private void init() {
        firstYearCourses = new CourseCatalogue("First Year Courses", firstYears);
        secondYearCourses = new CourseCatalogue("Second Year Courses", secondYears);
        thirdYearCourses = new CourseCatalogue("Third Year Courses", thirdYears);
        fourthYearCourses = new CourseCatalogue("Fourth Year Courses", fourthYears);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // TODO
    private void createWorklist() {
        printWorklistOptions(this.worklist.getWorklistName());
        takeInput();
        addMore();
    }

    private void takeName() {
        System.out.println("Please enter a name for your new worklist:");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        Worklist studentWorkList = new Worklist(name);
        System.out.println("Your worklist - " + studentWorkList.getWorklistName() + " - has been created!");
        this.worklist = studentWorkList;
    }

    private void printWorklistOptions(String name) {
        System.out.println("\nTo add courses to " + name + ", please select from the following:");
        System.out.println("\t1 -> add first year courses");
        System.out.println("\t2 -> add second year courses");
        System.out.println("\t3 -> add third year courses");
        System.out.println("\t4 -> Add fourth year courses");
    }

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

    private void displayFirstYearOptions() {
        System.out.println("\nPlease select from the following first year courses:");
        for (int c = 0; c < firstYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + firstYearCourses.getCourses().get(c).getCourseName());
        }
    }

    private void displaySecondYearOptions() {
        System.out.println("Please select from the following second year courses:");
        for (int c = 0; c < secondYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + secondYearCourses.getCourses().get(c).getCourseName());
        }
    }

    private void displayThirdYearOptions() {
        System.out.println("Please select from the following third year courses:");
        for (int c = 0; c < thirdYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + thirdYearCourses.getCourses().get(c).getCourseName());
        }
    }

    private void displayFourthYearOptions() {
        System.out.println("Please select from the following fourth year courses:");
        for (int c = 0; c < fourthYearCourses.getCourses().size(); c++) {
            System.out.println("\t" + (c + 1) + " -> " + fourthYearCourses.getCourses().get(c).getCourseName());
        }
    }

    private void takeAddRequest(CourseCatalogue year) {
        Scanner inputInt = new Scanner(System.in);
        int num = inputInt.nextInt();
        for (int i = 0; i < year.getCourses().size(); i++) {
            if (num - 1 == i) {
                this.worklist.addCourse(year.getCourses().get(i));
            }
        }
    }

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
