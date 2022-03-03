package persistence;

import model.Course;
import model.Worklist;
import model.Courses;
import model.WorklistList;
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
            WorklistList wll = new WorklistList("Empty test worklistlist");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorklistList.json");
            writer.open();
            writer.write(wll);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorklistList.json");
            wll = reader.read();
            assertEquals("Empty test worklistlist", wll.getName());
            assertEquals(0, wll.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            WorklistList wll = new WorklistList("Some general worklist list");
            Worklist wl = new Worklist("testWL1");
            wl.addCourse(cpsc210);
            wl.addCourse(cpsc121);
            wl.addCourse(cpsc445);
            wll.add(wl);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorklistList.json");
            writer.open();
            writer.write(wll);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorklistList.json");
            wll = reader.read();
            assertEquals("Some general worklist list", wll.getName());
            ArrayList<Worklist> worklists = wll.getWll();
            assertEquals(1, wll.size());

            ArrayList<Course> courses = worklists.get(0).getWorklistEntries();
            assertEquals(3, courses.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
