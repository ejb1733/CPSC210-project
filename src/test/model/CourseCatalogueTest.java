package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// tests for the CourseCatalogue class
public class CourseCatalogueTest extends Courses {

    private CourseCatalogue firstYear;

    @BeforeEach
    void runBefore() {
        firstYear = new CourseCatalogue("First Year Courses", firstYears);
    }

    @Test
    void constructorTest() {
        assertEquals(cpsc110, firstYear.getCourses().get(0));
        assertEquals("CPSC 110", firstYear.getCourses().get(0).getCourseName());
        assertTrue(firstYear.getCourses().get(0).getPrereqs().isEmpty());
    }

}
