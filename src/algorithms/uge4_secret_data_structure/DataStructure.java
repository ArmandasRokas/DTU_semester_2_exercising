package algorithms.uge4_secret_data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DataStructure {

    public String[] determineDataStructure(char[] chars, int[] ints) {

        SFQ sfq = new SFQ();


        String[] output = new String[]{"YES", // queue
                "YES", // stack
                "YES"}; // smallestFirstQueue

        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> smallestFirstQueue = new LinkedList<>(); // lave sin egen datastructure
                                                                // som har 9 arrays for hver værdi

        LinkedList<Integer> inserts = new LinkedList<>();

        int countE = 0;


        for(int i = 0; i < chars.length; i++){

            if(chars[i] == 'I'){
                queue.addLast(ints[i]);
                stack.addLast(ints[i]);

                 smallestFirstQueue.addLast(ints[i]);
                 inserts.add(ints[i]);
            } else { // Checks if the extract elements equals to expected element to be extracted

                if(output[0] == "YES"){
                    if(queue.removeFirst() != ints[i]){
                        output[0] = "NO";
                    }
                }

                if (output[1] == "YES"){
                    if(stack.removeLast() != ints[i]){
                        output[1] = "NO";
                    }
                }

                if (output[2] == "YES"){

                    Collections.sort(inserts);
                    int smallest = inserts.get(0);


                    if(smallest != ints[i]){
                        output[2] = "NO";
                    } else {
                        inserts.remove(0);
                        smallestFirstQueue.remove(smallest);
                    }

                }
                countE++;  // tests extracted elements for 50 times due to time limits
                if(countE > 50){
                    break;
                }

            }
        }
        return output;
    }


    // ##################################################
    // # You do not need to modify anything below here. #
    // ##################################################

    public static void main(String[] args) throws IOException {
        new DataStructure().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());


        char[] chars = new char[n];
        int[] ints = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            chars[i] = st.nextToken().charAt(0);
            ints[i] = Integer.parseInt(st.nextToken());
        }

        String[] output = determineDataStructure(chars, ints);
        for(int i = 0; i < output.length; i++){
            System.out.println(output[i]);
        }
    }
}
