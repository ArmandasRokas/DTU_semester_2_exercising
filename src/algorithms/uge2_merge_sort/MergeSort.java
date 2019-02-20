package algorithms.uge2_merge_sort;

public class MergeSort {


    /**
     *
     * @param array the sorting array
     * @param p the first index of the current subarray
     * @param q the index of middle split point
     * @param r the last index of the current subarray
     */
    public void merge(int[] array, int p, int q, int r){

        int leftLength = q - p + 1;
        int rightLength = r - q;

        int[] left = new int[leftLength+1];
        int[] right= new int[rightLength+1];

        for(int i = 0; i < leftLength; i++){ //computes array[p..q]
            left[i] = array[p+i];
        }
        for(int j = 0; j < rightLength; j++){ //computes array[q+1..r]
            right[j] = array[q+j+1];
        }

        // puts sentinels at the end of the arrays
        left[leftLength] = Integer.MAX_VALUE;
        right[rightLength] = Integer.MAX_VALUE;

        int i = 0; // current element for left array
        int j = 0; // current element for right array

        for(int k = p; k <= r; k++){
            if(left[i] <= right[j]){ //if current element in left array is smaller or equals to current element in rigth array
                array[k] = left[i]; // add element from left array to original array
                i++;    // prepares a index for left array for next iteration
            } else { // must be that element in the right array is smaller
                array[k] = right[j]; // add element from left array to original array
                j++;   // prepares a index for right array for next iteration
            }
        }
    }

    public void mergeSort(int[] array, int i, int j){
        if (i < j){  // if there are more than one element in the subarray
            int m = (i+j)/2; // find the middle element
            mergeSort(array, i, m); // call recursively with left subarray
            mergeSort(array, m+1, j); // cal recursively with right subarray
            merge(array, i, m, j); // start merging when subarray with two elements reached
        }
    }
}
