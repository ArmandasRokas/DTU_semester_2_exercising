package algorithms.uge2_merge_sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private MergeSort ms;
    private int[] array1;
    private int[] array2;
    private int[] array3;

    @BeforeEach
    void setUp() {
        ms = new MergeSort();
        array1 = new int[]{2,4,6,1,3,5};
        array2 = new int[]{17,3,10};
        array3 = new int[]{44,11,100,1,22,333,1};
    }

    @Test
    void mergeTest() {
        ms.merge(array1,0,2, 5);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, array1);
    }

    @Test
    void mergeSortTest_simpleArray(){
        ms.mergeSort(array2, 0, array2.length-1);
        assertArrayEquals(new int[]{3,10,17}, array2);
    }

    @Test
    void mergeSortTest_complexArray(){
        ms.mergeSort(array3, 0, array3.length-1);
        assertArrayEquals(new int[]{1,1,11,22,44,100,333}, array3);
    }

}