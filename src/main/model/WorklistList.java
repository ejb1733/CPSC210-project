package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;
import persistence.JsonWriter;
import persistence.Writable;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WorklistList implements Writable {
    String name;
    ArrayList<Worklist> wll;
    private static final String JSON_STORE = "./data/yourWorklists.json";

    public WorklistList(String name) {
        this.name = name;
        this.wll = new ArrayList<>();
    }

    public void add(Worklist worklist) {
        this.wll.add(worklist);
    }

    public boolean isEmpty() {
        return this.wll.isEmpty();
    }

    public int size() {
        return this.wll.size();
    }

    public Worklist get(int i) {
        return this.wll.get(i);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Worklist> getWll() {
        return this.wll;
    }

    public void removeWorklist(Worklist w) {
        this.wll.remove(w);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("worklists", worklistsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray worklistsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Worklist w : wll) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;
    }

    public boolean displayWorklists() {
        if (this.wll.isEmpty()) {
            System.out.println("You've got no worklists, silly!");
            return true;
        } else {
            System.out.println("Please select from your worklists:");
            for (int i = 1; i <= this.wll.size(); i++) {
                System.out.println(i + " -> " + wll.get(i - 1).getWorklistName());
            }
        }
        return false;
    }

}
