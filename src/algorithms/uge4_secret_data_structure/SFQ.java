package algorithms.uge4_secret_data_structure;

public class SFQ {

    private int zeros = 0;
    private int ones = 0;
    private int twos = 0;
    private int threes = 0;
    private int four = 0;
    private int fives = 0;
    private int sixes = 0;
    private int sevens = 0;
    private int eights = 0;
    private int nines = 0;
    private int tens = 0;

    public void add(int i){
        switch (i){
            case 0:
                zeros++;
                break;
            case 1:
                ones++;
                break;
            case 2:
                twos++;
                break;
            case 3:
                threes++;
                break;
            case 4:
                four++;
                break;
            case 5:
                fives++;
                break;
            case 6:
                sixes++;
                break;
            case 7:
                sevens++;
                break;
            case 8:
                eights++;
                break;
            case 9:
                nines++;
                break;
            case 10:
                tens++;
                break;
        }
    }


    public int remove(int i){
        if(zeros>0){
            zeros--;
            return 0;
        } else if(ones>0){
            ones--;
            return 1;
        }
        else if(twos>0){
            twos--;
            return 2;
        }
        else if(threes>0){
            threes--;
            return 3;
        }
        else if(four>0){
            four--;
            return 4;
        }
        else if(fives>0){
            fives--;
            return 5;
        }
        else if(sixes>0){
            sixes--;
            return 6;
        }
        else if(sevens>0){
            sevens--;
            return 7;
        }
        else if(eights>0){
            eights--;
            return 8;
        }
        else if(nines>0){
            nines--;
            return 9;
        }
        else if(tens>0){
            tens--;
            return 10;
        } else {
            return -1;
        }

    }
}
