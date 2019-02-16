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


    /**
     * Finds and return the peak in recursive way in logarithm time.
     */

    public int findTopPointRecrusive(int[] array, int firstIndex, int lastIndex){
        int m = (firstIndex+lastIndex)/2; //finds the middle index

        if(m == 0 && array[0] < array[1]){
            return -1;              // return -1 if we reached the start of array, but element in index 0 is not the peak
        } else if(m == 0 && array[0] >= array[m+1]){
            return 0;               // returns 0 if the peak is the element in index 0
        }

        if(m == array.length-1 && array[array.length-1] < array[array.length-2]){
            return -1;              // return -1 if we reached the end of array, but the element is not the peak
        } else if(m == array.length-1 && array[array.length-1] >= array[array.length-2]){
            return array.length-1;  // returns the index of last element, if the last element is a peak.
        }


        if(array[m] >= array[m-1] && array[m] >= array[m+1]){
            return m;                                                     // return current index, if the element is a peak.
        } else if(array[m-1] > array[m]){
            return findTopPointRecrusive(array, firstIndex, m-1); // repeats with a sub array on the LEFT
        } else if(array[m]<array[m+1]){
            return findTopPointRecrusive(array, m+1, lastIndex);  // repeats with a sub array on the RIGHT
        }
        return -1; // should neven reach this line.
    }

    /**
     * Finds and return the index of the peak in logarithm time iterative.
     */

    public int findTopPointIterative(int[] array){

        int m;
        int firstIndex = 0;
        int lastIndex = array.length-1;

        while(true){
            m = (firstIndex+lastIndex)/2; // find the middle element in sub array


            if(m == 0 && array[0] < array[1]){
                return -1;              // return -1 if we reached the start of array, but element in index 0 is not the peak
            } else if(m == 0 && array[0] >= array[m+1]){
                return 0;               // returns 0 if the peak is the element in index 0
            }

            if(m == array.length-1 && array[array.length-1] < array[array.length-2]){
                return -1;              // return -1 if we reached the end of array, but the element is not the peak
            } else if(m == array.length-1 && array[array.length-1] >= array[array.length-2]){
                return array.length-1;  // returns the index of last element, if the last element is a peak.
            }


            if(array[m] >= array[m-1] && array[m] >= array[m+1]){
                return m;   // The peak is found and returns index
            } else if(array[m-1] > array[m]){ // if element on LEFT is higher
                lastIndex = m-1;  // set the last index in the subarray for next iteration
            } else if(array[m]<array[m+1]){ // if element on RIGHT is higher
                firstIndex = m+1; // set the first index in the subarray for next iteration
            }
        }
    }

    /**
     * Finds and returns a row index and a column index of the peak in 2D-array by finding max number in n*n time.
     */

    public int[] findTopPoint2D_max(int[][] array){

        int peakRowIndex = 0;
        int peakColumnIndex = 0;

        for(int i = 0; i < array.length; i++){  // defines loop for each row
            for(int j = 0; j< array[i].length; j++){ //defines loop for each column
                if(array[peakRowIndex][peakColumnIndex] < array[i][j] ){ // checks if current element in array higher than current max number
                     peakRowIndex = i;      // defines new current max number by saving his row index
                     peakColumnIndex = j;   // and column index
                }
            }
        }

        return new int[]{peakRowIndex,peakColumnIndex};
    }

    /**
     * Finds and return a row index and a column index of the peak in 2D-array in n*log(n) time
     */

    public int[] findTopPoint2D_recursively(int[][] array, int minColumn, int maxColumn){

        //find the maximum number in the center column


        int j = maxColumn/2;
        int i = findMaxnumberInCenterColumn_2D(array, j);
        //check if the maximum number in the center column is the peak
        if(array[i][j]>= array[i-1][j] && array[i][j]>= array[i][j-1]
                && array[i][j]>= array[i+1][j] && array[i][j]>= array[i][j+1]) { // checks if the current number is higher than N E S W neighbors
            return new int[]{i,j}; // the peak is found
        }
        // else find the highest neighbor and go this direction in the middle


        // neighbor on left is higher
        if(array[i][j]< array[i][j-1]){
            return findTopPoint2D_recursively(array, minColumn, j-1); //HAVE TO RETURN HERE BECAUSE OF RECURSION. if not it continues to -1 -1, although the peak is found
        }


        return new int[]{-1,-1};
    }

    /**
     * Function searches the maximum number only in the center column
     * Return row number , takes column
     */
    public int findMaxnumberInCenterColumn_2D(int[][] array, int columnNumber){

        int currMaxNumberRowIndex = 0;

        for(int i = 0; i < array.length; i++){ //loops through the rows in the array

            if(array[i][columnNumber] > array[currMaxNumberRowIndex][columnNumber]){ // checks if the number in the current row and in the center column is the higher than the current max number
                currMaxNumberRowIndex = i;
            }
        }
        return currMaxNumberRowIndex;
    }
}
