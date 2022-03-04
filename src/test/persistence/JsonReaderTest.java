package persistence;

import model.Worklist;
import model.WorklistList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// tests for the JsonReader class
public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/heheheThisDoesNotExist.json");
        try {
            WorklistList wll = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorklist() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorklistList.json");
        try {
            WorklistList wll = reader.read();
            assertEquals("This is an empty test save file!", wll.getName());
            assertEquals(0, wll.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorklist() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorklistList.json");
        try {
            WorklistList wll = reader.read();
            assertEquals("A general test worklist!", wll.getName());
            ArrayList<Worklist> worklists = wll.getWll();
            assertEquals(2, worklists.size());

            Worklist wl1 = wll.get(0);
            assertEquals("testWL1", wl1.getWorklistName());
            assertEquals(2, wl1.getWorklistSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
