package advanced_programming.generic_method;

public class GenericMethodTest {

    public static <E> void printArray(E[] inputArray){
        for(E element: inputArray){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        Character[] charArray = {'H', 'E', 'L', 'O'};

        System.out.println("Printing int array:");
        printArray(intArray);

        System.out.println("Printing chars");
        printArray(charArray);
    }
}


