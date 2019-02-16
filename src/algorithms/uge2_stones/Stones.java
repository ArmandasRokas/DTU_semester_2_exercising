package algorithms.uge2_stones;

import java.io.*;
import java.util.*;

public class Stones
{
    // This method takes an array with stones weights and
    // two integers that represents number of stones and
    // the maximum weight to be carried.
    // return the maximum number of stones able to carry.
    public int calculateStones(ArrayList<Integer> stoneList, int n, int w) {
        Collections.sort(stoneList); // is it allowed to use Collections? if not, merge sort

        int currentTotalWeight = 0;
        int countStones = 0;

        for(int i = 0; i < stoneList.size(); i++){
            if(currentTotalWeight + stoneList.get(i) <= w){ //if weight after adding a next stone in array is less than maximum allowed weight
                currentTotalWeight += stoneList.get(i);
                countStones++;
            } else{
                break;
            }
        }
        return countStones;
    }


    // ##################################################
    // # You do not need to modify anything below here. #
    // ##################################################

    public static void main(String[] args) throws IOException {
        new Stones().run();
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
        System.out.println(calculateStones(array, n, w));
    }
}