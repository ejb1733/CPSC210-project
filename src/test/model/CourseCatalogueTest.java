package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseCatalogueTest implements Courses {

    private ArrayList<Course> firstYearCourses;
    private CourseCatalogue firstYear;

    @BeforeEach
    void runBefore() {
        firstYearCourses = new ArrayList<>(firstYears);
        firstYear = new CourseCatalogue("First Year Courses", firstYearCourses);
    }

    @Test
    void constructorTest() {
        assertEquals(cpsc110, firstYear.getCourses().get(0));
        assertEquals("First Year Courses", firstYear.getCatalogueTitle());
        assertEquals("CPSC 110", firstYear.getCourses().get(0).getCourseName());
        assertTrue(firstYear.getCourses().get(0).getPrereqs().isEmpty());
    }

}
