package algorithms.uge2_binary_search;

public class BinarySearch {

    public boolean search(int[] array, int i, int j, int x){

        if(j < i) return false;  // number not found

        int m = (i+j)/2;         // finds the middle index of the array

        if(array[m] == x) return true; // number is found

        else if (array[m] < x) return search(array, m+1, j, x);   //if the wanted element is higher than the middle element.
                                                                    // call recursively search with subarray on the right side
        else return search(array, i, m-1,x); // the last case must be that the wanted element is smaller than
                                                // the middle element. So it must call search recursively with a
                                                // subarray on the left.
    }
}
