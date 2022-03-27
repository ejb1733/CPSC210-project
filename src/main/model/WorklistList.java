package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Abstraction to represent a list of worklists
// a WorklistList has a name and list of worklists
public class WorklistList implements Writable {
    String name;
    ArrayList<Worklist> wll;

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

    // MODIFIES: this
    // EFFECTS: removes Worklist w from the worklist list. If Worklist w doesn't exist in the worklist list,
    //          does nothing and prints a message
    public void removeWorklist(Worklist w) {
        if (this.wll.contains(w)) {
            this.wll.remove(w);
            System.out.println(" ");
            EventLog.getInstance().logEvent(new Event("Worklist - " + w.getWorklistName() + " - was deleted"));
            System.out.println(w.getWorklistName() + " has been successfully deleted");
        } else {
            System.out.println("Cannot remove " + w.getWorklistName() + " because it doesn't exist!");
        }
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

    // EFFECTS: displays all worklists
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
