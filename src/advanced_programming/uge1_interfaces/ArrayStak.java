package advanced_programming.uge1_interfaces;

public class ArrayStak implements Stak {

    private String[] stak;
    private int numOfElements;
    private static final int MAX_VALUE = 100000;


    public ArrayStak(){
        numOfElements = 0;
        stak = new String[numOfElements];
    }

    @Override
    public void push(String e) {
        if(numOfElements >= MAX_VALUE){
            throw new UnsupportedOperationException("The \"stak\" is full.");
        }

        String[] temp = stak;
        stak = new String[++numOfElements];

        stak[0] = e;
        for(int i=0; i<temp.length; i++){
          stak[i+1] = temp[i];
        }
    }

    @Override
    public String pop(){

        if(numOfElements < 1){
            throw new UnsupportedOperationException("The \"stak\" is empty");
        }

        String[] temp = stak;
        stak = new String[--numOfElements];
        for(int i = 1; i < temp.length; i++){
            stak[i-1] = temp[i];
        }
        return temp[0];
    }

    @Override
    public boolean isEmpty() {
        return numOfElements < 1;
    }

    @Override
    public boolean isFull() {
        return numOfElements>=MAX_VALUE;
    }

    @Override
    public String[] show() {
        String res = "";
        for(int i = 0; i < stak.length; i++){
            res += stak[i];
        }
        System.out.println(res);

        return stak;
    }
}
