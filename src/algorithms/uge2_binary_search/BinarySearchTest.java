package algorithms.uge2_binary_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch bs;
    private int[] array1;
    private int wanted1;
    private int wanted2;
    private int wanted3;
    private int wanted4;
    private int wanted5;


    @BeforeEach
    void setUp() {
        bs = new BinarySearch();
        array1 = new int[]{1,7,9,21,30,35,37,40};
        wanted1 = 1;
        wanted2 = 40;
        wanted3 = 7;
        wanted4 = 35;
        wanted5 = 99;
    }

    @Test
    void search_first() {
        assertTrue(bs.search(array1,0, array1.length-1, wanted1));
    }
    @Test
    void search_last() {
        assertTrue(bs.search(array1,0, array1.length-1, wanted2));
    }
    @Test
    void search_firsthalf() {
        assertTrue(bs.search(array1,0, array1.length-1, wanted3));
    }
    @Test
    void search_lasthalf() {
        assertTrue(bs.search(array1,0, array1.length-1, wanted4));
    }
    @Test
    void search_not_exists(){
        assertFalse(bs.search(array1,0, array1.length-1, wanted5));
    }
}