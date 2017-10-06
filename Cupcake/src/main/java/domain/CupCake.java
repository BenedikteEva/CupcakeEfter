package domain;

/**
 *
 * @author Ticondrus
 */
public class CupCake {
    
    private int cupcake_id;
    private String cupcakeName;
    private double cupCakePrice;

    /**
     * Oprettes et cupcake id som hver cupcake får tildelt, så man kan gemme bestilling på dem. Cupcaken får også et navn og en pris.
     * @param cupcake_id
     * @param cupcakeName
     * @param cupCakePrice 
     */
    public CupCake(int cupcake_id, String cupcakeName, double cupCakePrice) {
        this.cupcake_id = cupcake_id;
        this.cupcakeName = cupcakeName;
        this.cupCakePrice = cupCakePrice;
    }

    public CupCake() {
        
    }
    
    public int getCupcake_id() {
        return cupcake_id;
    }

    public void setCupcake_id(int cupcake_id) {
        this.cupcake_id = cupcake_id;
    }

    public String getCupcakeName() {
        return cupcakeName;
    }

    public void setCupcakeName(String cupcakeName) {
        this.cupcakeName = cupcakeName;
    }

    public double getCupCakePrice() {
        return cupCakePrice;
    }

    public void setCupCakePrice(double cupCakePrice) {
        this.cupCakePrice = cupCakePrice;
    }

    @Override
    public String toString() {
        return "CupCake{" + "cupcake_id=" + cupcake_id + ", cupcakeName=" + cupcakeName + ", cupCakePrice=" + cupCakePrice + '}';
    }
    
}
