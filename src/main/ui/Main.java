package ui;

import model.Courses;

// Main method to run the project
public class Main extends Courses {

    // EFFECTS: initializes the UI and console
    public static void main(String[] args) {
        new WelcomePage();
        new WonderfulWorklists();
    }
}
