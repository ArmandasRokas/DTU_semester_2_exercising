package advanced_programming.uge1_interfaces;

public class LinkedStak implements Stak {

    class Element{
        private String s;
        private Element next;

        public Element(String s, Element next){
            this.s = s;
            this.next = next;
        }
        public Element(String s){
            this.s = s;
            this.next = null;
        }
    }

    private Element first;
    private Element actual;
    private int length;
    public static final int MAX_VALUE = 100000;

    @Override
    public void push(String e) {

        if(isFull()){
            System.out.println("The stak is full");
            throw new UnsupportedOperationException("The stak is full");
        }
        if(first == null){
            first = new Element(e);
        } else{
            Element temp = first;
            first = new Element(e, temp);
        }
        length++;
    }

    @Override
    public String pop() {

        if(first == null){
            System.out.println("The \"stak\" is empty");
            throw new UnsupportedOperationException("The \"stak\" is empty");
        }
        Element temp = first;
        first = first.next;
        length--;

        return temp.s;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean isFull() {
        return length>=MAX_VALUE;
    }

    @Override
    public String[] show() {

        String s = "";

        if(first != null){
            s += first.s;
        } else{
            System.out.println("The \"stak\" is empty");
            throw new UnsupportedOperationException("The \"stak\" is empty");
        }

        actual = first;

        while(actual.next != null){
            actual = actual.next;
            s += actual.s;
        }

        System.out.println(s); // can be deleted. Only for exercising purposes.
        return getArray(length);

    }

    private String[] getArray(int countLength){
        String[] array = new String[countLength];
        array[0] = first.s;
        actual = first;
        for(int i=1; i<array.length; i++){  // no need for out of bounds check, because it assumes, that countLength is correct
            actual = actual.next;
            array[i] = actual.s;
        }
        return array;
    }
}
