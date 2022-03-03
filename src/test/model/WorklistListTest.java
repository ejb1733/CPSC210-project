package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorklistListTest {
    WorklistList testWLL;
    Worklist testWL;

    @BeforeEach
    void runBefore() {
        testWLL = new WorklistList("Gregor's Worklists");
        testWL = new Worklist("2024 W2");
    }

    @Test
    void testConstructor() {
        assertEquals("Gregor's Worklists", testWLL.getName());
        assertEquals(0, testWLL.size());
    }

    @Test
    void testDisplayWorklists() {
        WorklistList testWLL = new WorklistList("Test WLL");
        assertTrue(testWLL.isEmpty());
        assertTrue(testWLL.displayWorklists());

        testWLL.add(testWL);
        assertFalse(testWLL.displayWorklists());
    }

    @Test
    void testRemoveWorklistCantFindAndCanFind() {
        testWLL.add(testWL);
        assertEquals(1, testWLL.size());

        testWLL.removeWorklist(testWL);
        assertEquals(0, testWLL.size());

        testWLL.removeWorklist(testWL);
        assertEquals(0, testWLL.size());
    }
}
