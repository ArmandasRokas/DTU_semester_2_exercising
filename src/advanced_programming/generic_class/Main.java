package advanced_programming.generic_class;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GenericClass<String> myString = new GenericClass<>();
        myString.add("Bla");
        myString.add("Ola, mundo!");
        System.out.println(myString.pop());
        System.out.println(myString.pop());

        GenericClass<Integer> myInt = new GenericClass<>();
        myInt.add(1);
        System.out.println(myInt.pop());
    }
}
