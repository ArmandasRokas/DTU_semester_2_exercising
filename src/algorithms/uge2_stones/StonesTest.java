package algorithms.uge2_stones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StonesTest {

    private Stones stones;
    private int n1;
    private int w1;
    private ArrayList<Integer> array1;


    @BeforeEach
    void setUp() {
        stones = new Stones();
        n1 = 8;
        w1 = 15;
        array1 = new ArrayList<>();
        array1.addAll(Arrays.asList(2, 5, 3, 1, 8, 4, 5, 7));
    }

    @Test
    void calculateStones() {

        assertEquals(5, stones.calculateStones(array1, n1, w1));

    }
}