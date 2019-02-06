package algorithms.uge1_maksimalt_tal;

public class Main {

    public static void main(String[] args) {

        System.out.println(findMaxNumber(new int[]{5,1,2,4,7}));

        System.out.println(findMaxNumberExFromSlides(new int[]{0,-1,-2,-4,2}));
    }

    public static int findMaxNumber(int[] array){

        int currMaxNumber = array[0];

        for (int i = 1; i < array.length; i++){

            if ( array[i] > currMaxNumber){
                currMaxNumber = array[i];
            }
        }
        return currMaxNumber;

    }

    public static int findMaxNumberExFromSlides(int[] array){

        int max = 0;

        for (int i = 1; i < array.length; i++){ // optimering. i=1 i stedet for i=0

            if ( array[i] > array[max]){
                max = i;
            }
        }
        return max;

    }

}
