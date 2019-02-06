package advanced_programming.uge1_interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStakTest {

    private Stak stak;

    @BeforeEach
    void setUp() {
        stak = new LinkedStak();
    }

    @Test
    void push() {
        stak.push("a");
        stak.push("b");
        stak.push("c");
        assertArrayEquals(new String[]{"c","b","a"}, stak.show());
    }

    @Test
    void push_one_element() {
        stak.push("a");
        assertArrayEquals(new String[]{"a"}, stak.show());
    }

    @Test
    void pop_not_empty() {
        stak.push("a");
        stak.push("b");
        stak.push("c");
        stak.pop();
        assertArrayEquals(new String[]{"b","a"}, stak.show());
    }


    @Test
    void pop_empty(){
        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.pop();
                });
    }

    @Test
    void pop_empty_after_pushing(){
        stak.push("a");
        stak.pop();
        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.pop();
                });
    }


    @Test
    void isEmpty() {
        assertTrue(stak.isEmpty());
    }

    @Test
    void isFull() {
        for (int i = 0; i<100000; i++){
            stak.push("a");
        }
        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.push("a");
                });
    }

    @Test
    void show_empty_list(){
        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.show();
                });
    }
}