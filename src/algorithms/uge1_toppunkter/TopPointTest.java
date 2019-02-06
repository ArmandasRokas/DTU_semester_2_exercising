package algorithms.uge1_toppunkter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopPointTest {

    private TopPoint tp;
    int[] index0TopPoint = {36,4,7,9,1};
    int[] index1TopPoint = {0,3,3,3,3,99};
    int[] lastIndexTopPoint = {1,2,3,4,5,6};
    int[] array4 = {7,6,5,4,3,2,1};
    int[] array5 = {1,2,3,4,5,6,7,8,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8};
    int[] array6 = {10,9,8,8,7,6,5,4,3,2,1};

    @BeforeEach
    void setUp(){
        tp = new TopPoint();

    }


    @Test
    void findTopPointTest() {

        //Arrange

        //Act
        int topPoint0 = tp.findTopPoint(index0TopPoint);
        int topPoint1 = tp.findTopPoint(index1TopPoint);
        int topPointLast = tp.findTopPoint(lastIndexTopPoint);

        //Assert
        assertEquals(0, topPoint0);
        assertEquals(1, topPoint1);
        assertEquals(lastIndexTopPoint.length-1, topPointLast);

    }



    @Test
    void findTopPointRecrusiveTest() {

        //Arrange

        //Act
        int topPoint3 = tp.findTopPointRecrusive(index0TopPoint, 0,index0TopPoint.length-1);
        int topPoint2 = tp.findTopPointRecrusive(index1TopPoint, 0, index1TopPoint.length-1);
        int topPointLast = tp.findTopPointRecrusive(lastIndexTopPoint, 0, lastIndexTopPoint.length-1);
        int topPoint0 = tp.findTopPointRecrusive(array4, 0, array4.length-1);
        int findInArray5 = tp.findTopPointRecrusive(array5, 0, array5.length-1);
        int findInArray6 = tp.findTopPointRecrusive(array6, 0, array6.length-1);

        //Assert
        assertEquals(3, topPoint3);
        assertEquals(2, topPoint2);
        assertEquals(lastIndexTopPoint.length-1, topPointLast);
        assertEquals(0, topPoint0);
        assertEquals(8, findInArray5);
        assertEquals(0, findInArray6);

    }

}