package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course CPSC210;
    private Course CPSC110;
    private ArrayList<Course> emptyArray;

    @BeforeEach
    void runBefore() {

    }

    @Test
    void testConstructor() {
        ArrayList<Course> pr1 = new ArrayList<>();
        CPSC110 = new Course("CPSC 110", emptyArray);
        pr1.add(CPSC110);
        CPSC210 = new Course("CPSC 210", pr1);
        assertEquals("CPSC 210", CPSC210.getName());
        assertEquals(CPSC110, CPSC210.getPrereqs().get(0));
    }

}
