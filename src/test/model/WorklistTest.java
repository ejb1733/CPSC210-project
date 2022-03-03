package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// tests for the Worklist class
public class WorklistTest extends Courses {
    Worklist testWL;

    @BeforeEach
    void runBefore() {
        testWL = new Worklist("Gregor's Worklist");
    }

    @Test
    void testConstructor() {
        assertEquals("Gregor's Worklist", testWL.getWorklistName());
        assertEquals(0, testWL.getWorklistSize());
    }

    @Test
    void addRemoveCourseTest() {
        testWL.addCourse(cpsc210);
        assertEquals(1, testWL.getWorklistSize());

        testWL.addCourse(cpsc210);
        assertEquals(1, testWL.getWorklistSize());

        testWL.addCourse(cpsc310);
        assertEquals(2, testWL.getWorklistSize());

        testWL.removeCourse(cpsc210);
        assertEquals(1, testWL.getWorklistSize());

        assertEquals("CPSC 310", testWL.getWorklistEntries().get(0).getCourseName());
    }

    @Test
    void testTakeAddRequest() {
        testWL.takeAddRequest(firstYears, 2);
        assertEquals(cpsc121, testWL.getWorklistEntries().get(0));

        testWL.takeAddRequest(fourthYears, 10);
        assertEquals(cpsc420, testWL.getWorklistEntries().get(1));
    }

    @Test
    void testSetWorklistName() {
        testWL.setWorklistName("Carter's Worklist");
        assertEquals("Carter's Worklist", testWL.getWorklistName());
    }
}
