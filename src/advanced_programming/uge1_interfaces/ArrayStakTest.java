package advanced_programming.uge1_interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStakTest {

    private Stak stak;

    @BeforeEach
    void setUp() {
        stak = new ArrayStak();
    }

    @Test
    void push_abcde() {
        stak.push("a");
        stak.push("b");
        stak.push("c");
        stak.push("d");
        stak.push("e");
        assertArrayEquals(new String[]{"e","d","c","b", "a"}, stak.show());
    }

    @Test
    void push_to_maximum(){
        for(int i = 0; i < 100; i++){
            stak.push("a");
        }

        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.push("a");
                });
    }

    @Test
    void pop_on_empty_stak() {
        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.pop();
                });
    }

    @Test
    void pop_on_empty_after_pushing() {

        stak.push("a");
        stak.pop();

        assertThrows(UnsupportedOperationException.class,
                ()->{
                    stak.pop();
                });
    }

    @Test
    void pop_check_if_last_removed_and_length() {
        stak.push("a");
        stak.push("b");
        stak.push("c");
        String poped = stak.pop();
        assertEquals("c", poped);
        assertEquals(2, stak.show().length);
    }


    @Test
    void isEmpty() {
        assertTrue(stak.isEmpty());
    }

    @Test
    void isFull() {
        for(int i = 0; i < 100000; i++){
            stak.push("a");
        }
        assertTrue(stak.isFull());
    }

}