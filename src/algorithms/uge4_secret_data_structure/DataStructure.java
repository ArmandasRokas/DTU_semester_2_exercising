package algorithms.uge4_secret_data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataStructure {
    // This method takes an array with stones weights and
    // two integers that represents number of stones and
    // the maximum weight to be carried.
    // return the maximum number of stones able to carry.
    public String[] determineDataStructure(char[] chars, int[] ints) {



        return new String[]{"YES", "NO", "YES"};
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
