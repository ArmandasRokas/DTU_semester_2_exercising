package advanced_programming.uge2_3lag.functionality;


import advanced_programming.uge2_3lag.data.IData;

public class Funktionalitet implements IFunktionalitet {

    IData data;

    public Funktionalitet(IData data){
        this.data = data;
    }

    @Override
    public double getBMI(String cpr) {
        return data.getVaegt(cpr)/Math.pow(data.getHoejde(cpr), 2);
    }

    @Override
    public String getTextualBMI(String cpr) {
        return null;
    }

    @Override
    public String getNavn(String cpr) {
        return null;
    }
}
