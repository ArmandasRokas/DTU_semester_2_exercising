package algorithms.uge4_secret_data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataStructureTest {

    private DataStructure dataStructure = new DataStructure();
    private char[] chars1;
    private int[] ints1;
    private char[] chars2;
    private int[] ints2;

    @BeforeEach
    void setUp() {
        chars1 = new char[]{'I','I','I','I','I', 'E','E','E','E','E', };
        ints1 = new int[]{1,2,3,2,1,1,2,3,2,1};
        chars2 = new char[]{'I','I','I','I','I', 'E','E','E','E','E', };
        ints2 = new int[]{1,2,3,4,5,1,2,3,4,5};
    }

    @Test
    void determineDataStructure() {
        String[] output = dataStructure.determineDataStructure(chars1, ints1);
        assertEquals("YES", output[0]);
        assertEquals("YES", output[1]);
        assertEquals("NO", output[2]);
    }

    @Test
    void sample02() {
        String[] output = dataStructure.determineDataStructure(chars2, ints2);
        assertEquals("YES", output[0]);
        assertEquals("NO", output[1]);
        assertEquals("YES", output[2]);
    }
}