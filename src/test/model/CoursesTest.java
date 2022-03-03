package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// tests for the Courses class
public class CoursesTest extends Courses {
    Worklist testWL = new Worklist("my awesome worklist");

    @Test
    void constructorTest() {
        assertEquals("CPSC 110", cpsc110.getCourseName());
        assertEquals("CPSC 210", cpsc210.getCourseName());
        assertEquals(prereq110, cpsc121.getPrereqs());
        assertEquals(prereq110, cpsc210.getPrereqs());
        assertEquals(prereq313317, cpsc416.getPrereqs());
        assertTrue(cpsc110.getPrereqs().isEmpty());
    }

    @Test
    void testPrintMethods() {
        menu();
        printOptions();
        editOptions(testWL);
        for (int i = 1; i < 6; i++) {
            selectYearOptions(i);
        }
    }

}
