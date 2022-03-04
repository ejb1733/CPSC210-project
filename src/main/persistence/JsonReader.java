package persistence;

import model.Course;
import model.Courses;
import model.Worklist;
import model.WorklistList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader extends Courses {
    private String source;
    private ArrayList<Course> emptyForNow = new ArrayList<>();

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorklistList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorklistList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses WorklistList from JSON object and returns it
    private WorklistList parseWorklistList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorklistList wll = new WorklistList(name);
        addWorklists(wll, jsonObject);
        return wll;
    }

    // MODIFIES: wll
    // EFFECTS: parses courses from JSON object and adds them to worklist
    private void addWorklists(WorklistList wll, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("worklists");
        for (Object json : jsonArray) {
            JSONObject nextWorklist = (JSONObject) json;
            addWorklist(wll, nextWorklist);
        }
    }

    // MODIFIES: wll
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addWorklist(WorklistList wll, JSONObject jsonObject) {
        String name = jsonObject.getString("worklistName");
        Worklist worklist = new Worklist(name);
        addCourses(worklist, wll, jsonObject);
        wll.add(worklist);
    }

    // MODIFIES: wll, worklist
    // EFFECTS: parses courses from JSON object and adds them to worklist
    private void addCourses(Worklist worklist, WorklistList wll, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("courses");
        for (Object json : jsonArray) {
            JSONObject nextCourse = (JSONObject) json;
            addCourse(worklist, nextCourse);
        }
    }

    // MODIFIES: worklist
    // EFFECTS: parses courses from JSON object and adds it to worklist
    private void addCourse(Worklist worklist, JSONObject jsonObject) {
        String name = jsonObject.getString("courseName");
        Course c = new Course(name, emptyForNow);
        worklist.addCourse(c);
    }
}