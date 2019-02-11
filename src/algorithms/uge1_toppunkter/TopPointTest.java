package algorithms.uge1_toppunkter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TopPointTest {

    private TopPoint tp;
    private int[] array1 = {36,4,7,9,1};
    private int[] array2 = {0,3,3,3,3,99};
    private int[] array3 = {1,2,3,4,5,6};
    private int[] array4 = {7,6,5,4,3,2,1};
    private int[] array5 = {1,2,3,4,5,6,7,8,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8};
    private int[] array6 = {10,9,8,8,7,6,5,4,3,2,1};
    private int[][] array7_2D =     {{1,2,3,4,5},
                                     {6,7,8,9,10},
                                     {11,12,13,14},
                                     {15,16,17,18,19},
                                     {20,21,22,23,24}};
    private int[][] array8_2D =     {{1,2,3,4,5},
                                     {6,7,8,7,4}, // peak candidate is 8 at [1][2]
                                     {11,12,7,3},
                                     {15,16,6,18,19},
                                     {20,21,4,23,24}};

    private int[][] array9_2D =    {{1,1,1,1,1},
                                    {4,4,1,1,1}, // peak candidate
                                    {3,3,2,1,1},
                                    {4,4,1,1,1},
                                    {1,1,1,1,1}};

    private int[][] array10_2D =    {{1,1,1,1,1,1,1},
                                     {1,1,1,1,1,1,1},
                                     {1,4,3,2,1,1,1}, // peak candidate 4 at [2][1].
                                     {1,1,1,1,1,1,1},
                                     {1,1,1,1,1,1,1}};


    @BeforeEach
    void setUp(){
        tp = new TopPoint();

    }


    @Test
    void findTopPointTest() {

        //Arrange

        //Act
        int topPoint0 = tp.findTopPoint(array1);
        int topPoint1 = tp.findTopPoint(array2);
        int topPointLast = tp.findTopPoint(array3);

        //Assert
        assertEquals(0, topPoint0);
        assertEquals(1, topPoint1);
        assertEquals(array3.length-1, topPointLast);

    }



    @Test
    void findTopPointRecrusiveTest() {

        //Arrange

        //Act
        int topPoint3 = tp.findTopPointRecrusive(array1, 0, array1.length-1);
        int topPoint2 = tp.findTopPointRecrusive(array2, 0, array2.length-1);
        int topPointLast = tp.findTopPointRecrusive(array3, 0, array3.length-1);
        int topPoint0 = tp.findTopPointRecrusive(array4, 0, array4.length-1);
        int findInArray5 = tp.findTopPointRecrusive(array5, 0, array5.length-1);
        int findInArray6 = tp.findTopPointRecrusive(array6, 0, array6.length-1);

        //Assert
        assertEquals(3, topPoint3);
        assertEquals(2, topPoint2);
        assertEquals(array3.length-1, topPointLast);
        assertEquals(0, topPoint0);
        assertEquals(8, findInArray5);
        assertEquals(0, findInArray6);

    }

    @Test
    void findTopPointIterativeTest(){

        assertEquals(3, tp.findTopPointIterative(array1));
        assertEquals(2, tp.findTopPointIterative(array2));
        assertEquals(5, tp.findTopPointIterative(array3));
        assertEquals(0, tp.findTopPointIterative(array4));
        assertEquals(8, tp.findTopPointIterative(array5));
        assertEquals(0, tp.findTopPointIterative(array6));

    }

    @Test
    void findTopPoint2D_maxTest(){
        assertArrayEquals(new int[]{4,4}, tp.findTopPoint2D_max(array7_2D));
    }

    @Test
    void findMaxnumberInCenterColumn_2DTest(){
        assertEquals(1, tp.findMaxnumberInCenterColumn_2D(array8_2D,array8_2D[0].length/2));
        assertEquals(2, tp.findMaxnumberInCenterColumn_2D(array10_2D,array10_2D[0].length/2));
    }


    @Test
    void findTopPoint2D_recursivelyTest(){
        assertArrayEquals(new int[]{2,1}, tp.findTopPoint2D_recursively(array10_2D, 0, array10_2D[0].length)); // the peak is max number in the center column
    }

}