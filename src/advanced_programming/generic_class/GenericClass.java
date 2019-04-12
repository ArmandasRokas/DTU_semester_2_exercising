package advanced_programming.generic_class;

import java.util.ArrayList;

public class GenericClass <T> {
    private Object[] objects= new Object[10];
    private int size = 0;

    public void add(T obj) {
        objects[size] = obj;
        size++;
    }

    public T pop(){
        return (T) objects[--size];
    }
}
