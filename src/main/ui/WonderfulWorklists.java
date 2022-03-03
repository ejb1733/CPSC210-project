package ui;

import exceptions.EmptyWorklistException;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// UI methods for UBC WonderfulWorklists
public class WonderfulWorklists extends Courses {
    private static final String JSON_STORE = "./data/yourWorklists.json";

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Worklist worklist;
    private WorklistList wll = new WorklistList("WonderfulWorklists");

    private Scanner input;

    private final ArrayList<Course> newCoursePrereqs = new ArrayList<>();

    // EFFECTS: runs the program!
    public WonderfulWorklists() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
                System.out.println("Would you like to save your worklists before you quit?");
                System.out.println("\t Y -> Save");
                System.out.println("\t Q -> Quit without saving");
                String choice = input.next();
                choice = choice.toLowerCase();
                if (choice.equals("y")) {
                    saveWorklistList(wll);
                }
                running = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nUntil next time!");
    }

    // MODIFIES: this
    // EFFECTS: executes user command
    private void processCommand(String command) {
        if (command.equals("n")) {
            takeName();
            createWorklist();
        } else if (command.equals("c")) {
            createNewCourse();
        } else if (command.equals("e")) {
            editWorklists();
        } else if (command.equals("l")) {
            loadWorklist();
        } else if (command.equals("s")) {
            saveWorklistList(wll);
        } else {
            System.out.println("Please choose from a selection above");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes CourseCatalogues and a scanner
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: executes helper methods
    private void createWorklist() {
        printWorklistOptions(this.worklist.getWorklistName());
        takeInput(this.worklist);
        addMore();
        this.wll.add(this.worklist);
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
        printOptions();
    }

    // EFFECTS: registers the input of a student's desired course catalogue
    private void takeInput(Worklist w) {
        Scanner inputInt = new Scanner(System.in);
        int num = inputInt.nextInt();
        selectYearOptions(num);
        int num2 = inputInt.nextInt();
        if (num == 1) {
            w.takeAddRequest(firstYears, num2);
        } else if (num == 2) {
            w.takeAddRequest(secondYears, num2);
        } else if (num == 3) {
            w.takeAddRequest(thirdYears, num2);
        } else if (num == 4) {
            w.takeAddRequest(fourthYears, num2);
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
            printWorklistOptions(this.worklist.getWorklistName());
            takeInput(this.worklist);
            addMore();
        } else if (command.equals("n")) {
            this.viewWorklist(this.worklist);
        }
    }

    private void viewWorklist(Worklist w) {
        System.out.println("\n" + w.getWorklistName());
        for (int i = 0; i < w.getWorklistSize(); i++) {
            System.out.println("\t- " + w.getWorklistEntries().get(w.getWorklistSize()
                    - 1 - i).getCourseName());
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new course for the user. It has a custom name and list of pre-requisites.
    private void createNewCourse() {
        System.out.println("\nWhat would you like to name your course?");
        String name = input.next();
        System.out.println("\nWould you like to give your course pre-requisites?");
        System.out.println("\tY -> add pre-requisites");
        System.out.println("\tN -> no pre-requisites");
        String cmd = input.next();
        cmd = cmd.toLowerCase();
        Course newCourse;
        if (cmd.equals("y")) {
            newCoursePrereqs.addAll(addPrereqs());
            newCourse = new Course(name, newCoursePrereqs);
        } else {
            newCourse = new Course(name, noPrereqs);
        }
        selectCourseYear().add(newCourse);
        System.out.println("Your course - " + name + " - has been created successfully! Try adding it to a worklist.");
    }

    // MODIFIES: this
    // EFFECTS: returns selected pre-requisites for new course.
    private ArrayList<Course> addPrereqs() {
        System.out.println("What year can you find this pre-req in?");
        printOptions();
        int year = input.nextInt();
        if (year == 1) {
            selectYearOptions(1);
            return takeAddRequestForPrereqs(firstYears);
        } else if (year == 2) {
            selectYearOptions(2);
            return takeAddRequestForPrereqs(secondYears);
        } else if (year == 3) {
            selectYearOptions(3);
            return takeAddRequestForPrereqs(thirdYears);
        } else if (year == 4) {
            selectYearOptions(4);
            return takeAddRequestForPrereqs(fourthYears);
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: takes a user's course choice and adds it to their worklist
    private ArrayList<Course> takeAddRequestForPrereqs(ArrayList<Course> year) {
        ArrayList<Course> addList = new ArrayList<>();
        Scanner inputInt = new Scanner(System.in);
        int num = inputInt.nextInt();
        for (int i = 0; i < year.size(); i++) {
            if (num - 1 == i) {
                addList.add(year.get(i));
            }
        }
        System.out.println("Would you like to add more pre-requisites?");
        System.out.println("\tY -> add more pre-requisites");
        System.out.println("\tN -> no more pre-requisites");
        String answer = input.next();
        if (answer.equals("y")) {
            addPrereqs();
        }
        return addList;
    }

    // EFFECTS: returns the user's selected year for their new course to be classified as.
    private ArrayList<Course> selectCourseYear() {
        System.out.println("\nWhat year would you like your course to be listed as?");
        printOptions();
        int year = input.nextInt();
        if (year == 1) {
            return firstYears;
        } else if (year == 2) {
            return secondYears;
        } else if (year == 3) {
            return thirdYears;
        } else if (year == 4) {
            return fourthYears;
        } else {
            System.out.println("Please enter a valid entry");
            selectCourseYear();
        }
        return null;
    }

    // EFFECTS: selects the worklist that a user enters and calls it in editWorklistOptions
    private void editWorklists() {
        if (wll.displayWorklists()) {
            runWorklist();
        }
        int choice = input.nextInt();
        Worklist selected;
        for (int i = 0; i < wll.size(); i++) {
            if (choice - 1 == i) {
                selected = wll.get(i);
                editWorklistOptions(selected);
            }
        }
    }

    // MODIFIES: w
    // EFFECTS: displays a user's options for how they'd like to edit their worklist
    private void editWorklistOptions(Worklist w) {
        editOptions(w);
        int choice = input.nextInt();
        if (choice == 1) {
            viewWorklist(w);
        } else if (choice == 2) {
            printWorklistOptions(w.getWorklistName());
            takeInput(w);
        } else if (choice == 3) {
            try {
                removeCourses(w);
            } catch (EmptyWorklistException e) {
                System.out.println("Cannot remove any courses, as " + w.getWorklistName() + " is empty!");
            }
        } else if (choice == 4) {
            modifyName(w);
        } else if (choice == 5) {
            this.wll.removeWorklist(w);
        }
    }

    // MODIFIES: this, w
    // EFFECTS: removes a Worklist w from the WorklistList
    private void removeCourses(Worklist w) throws EmptyWorklistException {
        if (w.getWorklistSize() == 0) {
            throw new EmptyWorklistException();
        } else {
            System.out.println("Please select a course to remove:");
            for (int i = 0; i < w.getWorklistSize(); i++) {
                System.out.println("\t" + (i + 1) + " -> "
                        + w.getWorklistEntries().get(i).getCourseName());
            }
            int selection = input.nextInt();
            w.removeCourse(w.getWorklistEntries().get(selection - 1));
        }
    }

    // MODIFIES: w
    // EFFECTS: changes the name of w to the user's input
    private void modifyName(Worklist w) {
        System.out.println("What would you like to change " + w.getWorklistName() + "'s name to?");
        String newName = input.next();
        w.setWorklistName(newName);
        System.out.println("Successfully changed your worklists' name to " + w.getWorklistName() + "!");
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorklist() {
        try {
            WorklistList importedWll = jsonReader.read();
            this.wll = importedWll;
            System.out.println("");
            System.out.println("Loaded (" + wll.size() + ") worklists from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: saves the workroom to file
    private void saveWorklistList(WorklistList wll) {
        try {
            jsonWriter.open();
            jsonWriter.write(wll);
            jsonWriter.close();
            System.out.println("Saved (" + wll.size() + ") worklists to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

}
