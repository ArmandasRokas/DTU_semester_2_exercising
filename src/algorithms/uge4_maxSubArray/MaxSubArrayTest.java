package algorithms.uge4_maxSubArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    private MaxSubArray msb;
    private int[] arr1;
    private int[] arr2;
    private int[] arr3;
    private int[] arr4;



    @BeforeEach
    void setUp() {
        msb = new MaxSubArray();
        arr1 = new int[]{1,1,1,2,-99,1};
        arr2 = new int[]{-99,1,1,1,1,-99};
        arr3 = new int[]{-1,-1,-6,9,-8};
        arr4 = new int[]{-2,-3,4,-1,-2,1,5,-3};
    }

    @Test
    void findMaxSubArray() {
        assertEquals(5, msb.findMaxSubArray(arr1));
        assertEquals(4, msb.findMaxSubArray(arr2));
        assertEquals(9, msb.findMaxSubArray(arr3));
        assertEquals(7, msb.findMaxSubArray(arr4));
    }

    @Test
    void findMaxSubArray_linea(){
        assertEquals(5, msb.findMaxSubArray_linear_time(arr1));
        assertEquals(4, msb.findMaxSubArray_linear_time(arr2));
        assertEquals(9, msb.findMaxSubArray_linear_time(arr3));
        assertEquals(7, msb.findMaxSubArray_linear_time(arr4));
    }
}