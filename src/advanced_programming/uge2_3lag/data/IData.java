package advanced_programming.uge2_3lag.data;

public interface IData {

    public String getNavn(String cpr);

    //Returner personens vægt
    public double getVaegt(String cpr);
    //Returner personens højde
    public double getHoejde(String cpr);
}
