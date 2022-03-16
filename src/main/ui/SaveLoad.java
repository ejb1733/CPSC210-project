package ui;

import model.Courses;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveLoad extends Courses {
    private static final String JSON_STORE = "./data/yourWorklists.json";
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;

    SaveLoad(String var) {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        if (var.equals("save")) {
            save();
        } else if (var.equals("load")) {
            load();
        }
    }

    void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(wll);
            jsonWriter.close();
            System.out.println("Saved (" + wll.size() + ") worklists to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    void load() {
        try {
            wll = jsonReader.read();
            System.out.println(" ");
            System.out.println("Loaded (" + wll.size() + ") worklists from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
