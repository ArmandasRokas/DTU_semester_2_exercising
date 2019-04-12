package advanced_programming.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Comparator<String> comparator =
            (String s1, String s2) ->
            Integer.compare(s1.length(),s2.length());

        List<String> stringList = new ArrayList<>();
        stringList.add("aaaa");
        stringList.add("aa");
        stringList.add("aaa");
        System.out.println(stringList);
        Collections.sort(stringList, comparator);
        System.out.println(stringList);


        new Thread(() -> System.out.println("Hello")).start();

    }
}
