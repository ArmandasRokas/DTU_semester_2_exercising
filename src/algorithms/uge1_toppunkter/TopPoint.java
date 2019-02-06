package algorithms.uge1_toppunkter;

public class TopPoint {


    public int findTopPoint(int[] array){


        if(array[0] >= array[1]){
            return 0;
        }

        for(int i = 1; i < array.length-1; i++){

            if(array[i-1] <= array[i] && array[i] >= array[i+1]){
                return i;
            }
        }

        if(array[array.length-2] <= array[array.length-1]){
            return array.length-1;
        }

        return -1;
    }

    public int findTopPointRecrusive(int[] array, int firstIndex, int lastIndex){
        int m = (firstIndex+lastIndex)/2;

        if(m == 0 && array[0] < array[1]){
            return -1;
        } else if(m == 0 && array[0] >= array[m+1]){
            return firstIndex;
        }

        if(m == array.length-1 && array[array.length-1] < array[array.length-2]){
            return -1;
        } else if(m == array.length-1 && array[array.length-1] >= array[array.length-2]){
            return array.length-1;
        }


        if(array[m] >= array[m-1] && array[m] >= array[m+1]){
            return m;
        } else if(array[m-1] > array[m]){
            return findTopPointRecrusive(array, firstIndex, m-1);
        } else if(array[m]<array[m+1]){
            return findTopPointRecrusive(array, m+1, lastIndex);
        }
        return -1;
    }
}
