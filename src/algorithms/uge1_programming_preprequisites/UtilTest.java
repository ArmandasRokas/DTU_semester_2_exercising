package algorithms.uge1_programming_preprequisites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    Util util;

    @BeforeEach
    void setUp() {
        util = new Util();
    }

    @Test
    void reverseTest_EvenNumberOfElements() {
        int[] array1 = {1,2,3,4};
        assertArrayEquals(new int[]{4,3,2,1}, util.reverse(array1));
    }

    @Test
    void reverseTest_OddNumberOfElements() {
        int[] array1 = {1,2,3,4,5};
        assertArrayEquals(new int[]{5,4,3,2,1}, util.reverse(array1));
    }

    @Test
    void factTest_low_number(){
        int res = util.fact(4);
        assertEquals(24,res);
    }

    @Test
    void flipTest_100times(){
        int heads = 0;
        int trails = 0;

        for(int i=0; i<100;i++){
            int res = util.flip(2);
            if(res==0){
                trails++;
            } else if (res==1){
                heads++;
            } else{
                fail("Wrong result from flip");
            }
        }
        assertEquals(100, trails+heads);
        assertEquals(50, trails, 10);
        assertEquals(50, heads, 10);
    }

    @Test
    void findLongestConseqSubseqTest(){
        int[] array = {100,1,200,4,2,300,3};

        assertEquals(4, util.findLongestConseqSubseq(array, array.length));

    }
}