package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

// tests for the Worklist class
public class WorklistTest implements Courses {

    @BeforeEach
    void runBefore() {

    }

    @Test
    void addRemoveCourseTest() {
        Worklist testWL = new Worklist("2021W2");

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
    void removeCourseTest() {
        Worklist testWL = new Worklist("2052W1");

        testWL.addCourse(cpsc210);
        testWL.addCourse(cpsc121);
    }
}
