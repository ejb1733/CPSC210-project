package ui;

import model.Courses;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents the GUI's Save and Load functionality
public class SaveLoad extends Courses {
    private static final String JSON_STORE = "./data/yourWorklists.json";
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;

    // EFFECTS: depending on the button clicked on the Welcome Page, calls the save() or load() method
    SaveLoad(String var) {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        if (var.equals("save")) {
            save();
        } else if (var.equals("load")) {
            load();
        }
    }

    // EFFECTS: saves the WorklistList to file
    void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(wll);
            jsonWriter.close();
            String message = "Saved (" + wll.size() + ") worklists to " + JSON_STORE;
            JOptionPane.showMessageDialog(new JFrame(), message, "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: loads the WorklistList on file
    void load() {
        try {
            wll = jsonReader.read();
            System.out.println(" ");
            String message = "Loaded (" + wll.size() + ") worklists from " + JSON_STORE;
            JOptionPane.showMessageDialog(new JFrame(), message, "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
