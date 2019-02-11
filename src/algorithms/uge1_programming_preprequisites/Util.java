package algorithms.uge1_programming_preprequisites;

import java.util.HashSet;
import java.util.Random;

public class Util {

    public int[] reverse(int[] array){

        int j = array.length - 1;

        for(int i = 0; i < array.length/2; i++){
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
        }
        return array;
    }

    public int fact(int n){
        int result;
        if(n==1){
            return 1;
        }
        result = fact(n-1)*n; // if 4 , last iteration 6*4
        return result;
    }

    public int flip(int n){
        return new Random().nextInt(n);
    }

    public int findLongestConseqSubseq(int arr[],int n)
    {
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;

        // Hash all the array elements
        for (int i=0; i<n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i]-1))
            {
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length
                // is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
        return ans;
    }
}
