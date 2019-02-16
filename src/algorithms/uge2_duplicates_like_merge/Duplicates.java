package algorithms.uge2_duplicates_like_merge;

public class Duplicates {

    public void merge(int[] array, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;

     //   int[] left = new int[];


    }

    public void findDuplicates_merge(int[] array, int p, int r){
        if(p < r){
            int q = (p+r)/2;
            findDuplicates_merge(array, p, q);
            findDuplicates_merge(array, q+1, r);
            merge(array, p, q, r);
        }
    }

}
