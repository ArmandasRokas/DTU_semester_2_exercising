package algorithms.uge5_recursive;

public class Recursive {

    public int count(int n){
        if (n<=1){
            return 1;
        } else {
            return 1+count(n-2);
        }
    }

}
