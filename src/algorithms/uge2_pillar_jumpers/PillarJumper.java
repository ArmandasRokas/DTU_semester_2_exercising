package algorithms.uge2_pillar_jumpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class PillarJumper
{

    public int findRequiredStrength(ArrayList<Integer> pillars, int n, int j) {

        int totalStrength = pillars.get(pillars.size()-1) - pillars.get(0); // last pillar - first pillar height
        int avargTotalStrength = (int) Math.ceil((double)totalStrength/j); // find ceiling of totalStrength divided by number of pillars

        // minimum could be too if go trought out the list and check neigborbs.
        int biggestNeighborsDifference = 0; // holds the value of the biggest difference by neighbors elements.

//        for(int i = 0; i < pillars.size()-1; i++){
//            int currDifference = pillars.get(i+1) - pillars.get(i);
//            if(currDifference > biggestNeighborsDifference){
//                biggestNeighborsDifference = currDifference;
//            }
//        }

        // sets miniStrength accordingly the average or biggest neighbors difference is bigger.
        int minStrength = biggestNeighborsDifference > avargTotalStrength ? biggestNeighborsDifference: avargTotalStrength;

        // required strength should be between minimum average strength and the biggest neighbors difference


        int jumpCount = 0;
        int currPos = 0;


        for(int i = 0; i < pillars.size(); i++){

            int subarrayStrengthReq = 0;

            for(int k = i; k<pillars.size(); k++){


                if(pillars.get(k)-pillars.get(i) == minStrength){
                    currPos = k;
                    i = --k;
                    jumpCount++;
                    break;
                } if(pillars.get(k)-pillars.get(i)> minStrength){
                    currPos = k-1;
                    i = k-2;
                    jumpCount++;
                    break;
                }
                // have to find

            }
        }

        if(currPos < pillars.size()-1){
            minStrength++;
        }


    //    System.out.println(jumpCount);







        // remaining power in iteration

        // while is not succied

//        int currPos = 0;
//
//        while(true){
//
//            for(int i = currPos +1; i < s)
//
//
//            if(currPos == n-1){
//                break;
//            }
//        }



        // (int) Math.ceil((double)totalStrength/j)

        return minStrength;

    }


    public int findRequiredStrength1(ArrayList<Integer> pillars, int n, int j){

        int totalStrength = pillars.get(pillars.size()-1) - pillars.get(0); // last pillar - first pillar height
        int avargTotalStrength = (int) Math.ceil((double)totalStrength/j);

        int biggestNeighborsDifference = 0; // holds the value of the biggest difference by neighbors elements.

        for(int i = 0; i < pillars.size()-1; i++){
            int currDifference = pillars.get(i+1) - pillars.get(i);
            if(currDifference > biggestNeighborsDifference){
                biggestNeighborsDifference = currDifference;
            }
        }

        if(biggestNeighborsDifference > avargTotalStrength){
            return biggestNeighborsDifference;
        }


        // subarray ikke lig med 3
        for(int i = pillars.get(pillars.size()-1); i > pillars.get(0);  i -= avargTotalStrength){
            if(!pillars.contains(i)){
                   return ++avargTotalStrength;
            }
        }
        return avargTotalStrength;
    }


    // Generates new array only with differences between height of pillars
    // Splits generated array to j subarrays as equally as possible.
    // Finds a subarray with biggest total and it should be the minimum strength required
    public int findRequiredStrength_by_spliting(ArrayList<Integer> pillars, int n, int j){

        int totalStrength = pillars.get(pillars.size()-1) - pillars.get(0); // last pillar - first pillar height
        int avargTotalStrength = (int) Math.ceil((double)totalStrength/j);

        int biggestNeighborsDifference = 0; // holds the value of the biggest difference by neighbors elements.

        for(int i = 0; i < pillars.size()-1; i++){
            int currDifference = pillars.get(i+1) - pillars.get(i);
            if(currDifference > biggestNeighborsDifference){
                biggestNeighborsDifference = currDifference;
            }
        }

        if (biggestNeighborsDifference == 0){ //checks if all pillars is the same high
            return 1;
        }
        if(biggestNeighborsDifference > avargTotalStrength){

            return biggestNeighborsDifference;
        }
        // is neighbors is bigger than

        if(j%3 == 0 ){
            return 3;
        } else {
            // tjekke om j kan divideres med tre eller 2
            // hvis de kan divideres med 2, så split altid med to.
            // hvis di kan divideres med 3, så split altid til tre

            ArrayList<Integer> differences = new ArrayList<>();

            for (int i = 0; i < pillars.size() - 1; i++) { // makes new array with only differences of pillars height
                int difference = pillars.get(i + 1) - pillars.get(i);
                if (difference > 0) {
                    differences.add(difference);
                }
            }
//        System.out.println("Split: " + findSplitPoint(differences));
            //     System.out.println( "Split: " + findSplitPoint(differences, 0, differences.size()-1, 4));


            return findSplitPoint(differences, 0, differences.size() - 1, j);
        }
    }


    int findSplitPoint(ArrayList<Integer> arr, int start, int end, int n)
    {

        if(n > 1){


            int leftSum = 0;
            for (int i = start ; i < end+1 ; i++)
                leftSum += arr.get(i);

            // again traverse array and compute right sum
            // and also check left_sum equal to right
            // sum or not
            int rightSum = 0;
            for (int i=end; i >= start; i--)
            {
                // add current element to right_sum
                rightSum += arr.get(i);

                // exclude current element to the left_sum
                leftSum -=  arr.get(i) ;

                if (rightSum >= leftSum){

                    int differenceBeforLastMove =(leftSum + arr.get(i)) - (rightSum - arr.get(i));
                    int differenceAfterLastMove = rightSum - leftSum;

                    // checks in which subarray put the middle element.
                    // considering that subarrays total should be as equally as possible
                    if(differenceAfterLastMove<=differenceBeforLastMove){
                        return findSplitPoint(arr, i, end, n/2);
                    } else {
                        return findSplitPoint(arr, start, i, n/2);
                    }


//TODO skal tjekkes om der højre array er større eller venstre array, dvs. om den middeste skal være på venstre eller højre. Returnere den højeste

                    // findSplitPoint


                }
            }
        } else {  // after array divided enough times. get subarray sum total and return
            int count = 0;
            for(int i = start; i <= end; i++){
                count += arr.get(i);
            }
            return count;
        }

        //  return n /= 2;


        //if n er mindre end antal gang kører det hele er calculate the sum


        // traverse array element and compute sum
        // of whole array

        // if it is not possible to split array
        // into two parts.
        return -1;
    }




    // ##################################################
    // # You do not need to modify anything below here. #
    // ##################################################

    public static void main(String[] args) throws IOException {
        new PillarJumper().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(in.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        while (st.hasMoreTokens()){
            array.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(findRequiredStrength_by_spliting(array, n, w));
    }
}