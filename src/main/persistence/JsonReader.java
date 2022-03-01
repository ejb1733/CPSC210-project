package persistence;

import model.Course;
import model.Worklist;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Worklist read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorklist(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Worklist parseWorklist(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Worklist wl = new Worklist(name);
        addCourses(wl, jsonObject);
        return wl;
    }

    // MODIFIES: wl
    // EFFECTS: parses courses from JSON object and adds them to worklist
    private void addCourses(Worklist wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("courses");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addCourse(wl, nextThingy);
        }
    }

    // MODIFIES: wl
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addCourse(Worklist wl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ArrayList<Course> emptyForNow = new ArrayList<>();
        Course course = new Course(name, emptyForNow);
        wl.addCourse(course);
    }

}