package algorithms.uge2_pillar_jumpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PillarJumperTest {

    private PillarJumper pj;
    private int n1;
    private int j1;
    private ArrayList<Integer> array1;
    private int n2;
    private int j2;
    private ArrayList<Integer> array2;
    private int n3;
    private int j3;
    private ArrayList<Integer> array3;
    private int n4;
    private int j4;
    private ArrayList<Integer> array4;


    @BeforeEach
    void setUp() {
        pj = new PillarJumper();
        n1 = 7;
        j1 = 3;
        array1 = new ArrayList<>();
        array1.addAll(Arrays.asList(1, 3, 3, 4, 7, 8, 10));

        n2 = 8;
        j2 = 3;
        array2 = new ArrayList<>();
        array2.addAll(Arrays.asList(1, 3, 3, 4, 7, 8, 10,11));

        n3 = 20;
        j3 = 4;
        array3 = new ArrayList<>();
        array3.addAll(Arrays.asList(1, 2, 5, 5, 14, 20, 25, 29, 36, 39, 39, 40, 40, 41, 41, 41, 42, 42, 45, 50));

        n4 = 8;
        j4 = 4;
        array4 = new ArrayList<>();
        array4.addAll(Arrays.asList(1,2,8,15,26,33,39,44));
    }

    @Test
    void findRequiredStrengthTest(){
  //      assertEquals(3, pj.findRequiredStrength_by_spliting(array1, n1, j1));
        //assertEquals(4, pj.findRequiredStrength(array2, n2, j2));
   //     assertEquals(14, pj.findRequiredStrength_by_spliting(array3, n3, j3));
        assertEquals(14, pj.findRequiredStrength_by_spliting(array4, n4, j4));
    }
}