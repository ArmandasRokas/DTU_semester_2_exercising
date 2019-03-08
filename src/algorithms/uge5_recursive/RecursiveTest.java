package algorithms.uge5_recursive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveTest {

    private Recursive recursive;
    private int n1;
    private int n2;
    private int n3;
    @BeforeEach
    void setUp() {
        recursive = new Recursive();
        n1 = 10;
        n2 = 20;
        n3 = 100;
    }

    @Test
    void count() {
        assertEquals(6, recursive.count(n1));
        assertEquals(11, recursive.count(n2));
        assertEquals(51, recursive.count(n3));
    }
}