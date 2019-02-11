package advanced_programming.uge2_3lag.functionality;

import advanced_programming.uge2_3lag.data.IData;

public class Dance implements IDance {

    IData data;

    public Dance(IData data){
        this.data = data;
    }
    @Override
    public void dance(String cpr) {
        System.out.println(data.getNavn(cpr) + " dancing");
    }
}
