package persistence;

import model.Course;
import model.Courses;
import model.Worklist;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/heheheThisDoesNotExist.json");
        try {
            Worklist wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorklist() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorklist.json");
        try {
            Worklist wl = reader.read();
            assertEquals("An empty test worklist!", wl.getWorklistName());
            assertEquals(0, wl.getWorklistSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorklist() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorklist.json");
        try {
            Worklist wl = reader.read();
            assertEquals("A general test worklist!", wl.getWorklistName());
            ArrayList<Course> courses = wl.getWorklistEntries();
            assertEquals(2, courses.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
