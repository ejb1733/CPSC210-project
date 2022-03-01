package persistence;

import org.json.JSONObject;
import org.json.JSONArray;

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJsonObject();

    // EFFECTS: returns this as JSON array
    JSONArray toJsonArray();
}
