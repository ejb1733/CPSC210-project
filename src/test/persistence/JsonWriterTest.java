package persistence;

import model.Course;
import model.Worklist;
import model.Courses;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends Courses {

    private final ArrayList<Course> emptyForNow = new ArrayList<>();

    @Test
    void testWriterInvalidFile() {
        try {
            Worklist wl = new Worklist("randomWorklistNameLol");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass (shouldn't)
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Worklist wl = new Worklist("Empty test worklist");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorklist.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorklist.json");
            wl = reader.read();
            assertEquals("Empty test worklist", wl.getWorklistName());
            assertEquals(0, wl.getWorklistSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Worklist wl = new Worklist("Some general worklist");
            wl.addCourse(cpsc210);
            wl.addCourse(cpsc121);
            wl.addCourse(cpsc445);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorklist.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorklist.json");
            wl = reader.read();
            assertEquals("Some general worklist", wl.getWorklistName());
            ArrayList<Course> courses = wl.getWorklistEntries();
            assertEquals(3, courses.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
