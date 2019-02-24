package algorithms.uge4_maxSubArray;

public class MaxSubArray {

    public int findMaxSubArray(int[] arr){

        int max = 0; // keeps the value of the max subarray

        for(int i = 0; i < arr.length; i++){

            int currSubSum = 0; // keeps the value of the current subarray sum

            for(int j = i; j < arr.length; j++){
                currSubSum += arr[j];  // adds current element to sum total
                if(currSubSum > max){
                    max = currSubSum; // if curr sum is higher than max,  set a new max.
                }
            }
        }
        return max;
    }

    /** Kadane's algorithm
     *
     * Can be alternatively implemented with Dynamic Programming
     */

    public int findMaxSubArray_linear_time(int[] arr){

        int maxSum = 0;
        int currSum = 0;

        for(int i = 0; i < arr.length; i++){

            currSum += arr[i];

            if(currSum < 0){
                currSum = 0;  // set counter to 0 if curr sum below 0
            } else if(currSum>maxSum){
                maxSum = currSum; // the new max is and sets it to max variable
            }
        }
        return maxSum;
    }

}
