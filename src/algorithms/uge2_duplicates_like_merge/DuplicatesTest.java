package algorithms.uge2_duplicates_like_merge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatesTest {

    private Duplicates dp;
    private int[] array1;

    @BeforeEach
    void setup(){
        dp = new Duplicates();
        array1 = new int[]{1,2,3,4,5,6,7,8};
    }

    @Test
    void findDuplicates_merge() {
        dp.findDuplicates_merge(array1,0,array1.length-1);
        fail("Not implemented");
    }
}