package domain;

/**
 *
 * @author Bo Henriksen
 */
public class LineItem {
    
    private int invoiceId;
    private int top_id;
    private int bot_id;
    private String cupcakeName;
    private int quantity;
    private double pricePrCc;
    private double totalPrice;
    
    
    
    /**
     * Her oprettes et LineItem af en kundes bestilling.
     * @param invoiceId 1
     * @param pricePrCc 2
     * @param totalPrice 3
     * @param quantity  4
     */

    public LineItem(int invoiceId, double pricePrCc, double totalPrice, int quantity) {
        this.invoiceId = invoiceId;
        this.pricePrCc = pricePrCc;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public LineItem(int invoiceId, double pricePrCc, double totalPrice, int quantity, String cupcakeName) {
        this.invoiceId = invoiceId;
        this.pricePrCc = pricePrCc;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.cupcakeName = cupcakeName;
    }

    public LineItem(int invoiceId, int quantity, String cupcakeName, double pricePrCc, double totalPrice ) {
        this.invoiceId = invoiceId;
        this.pricePrCc = pricePrCc;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.cupcakeName = cupcakeName;
    }

    public LineItem(int invoiceId, int top_id, int bot_id, String cupcakeName, int quantity, double pricePrCc, double totalPrice) {
        this.invoiceId = invoiceId;
        this.top_id = top_id;
        this.bot_id = bot_id;
        this.cupcakeName = cupcakeName;
        this.quantity = quantity;
        this.pricePrCc = pricePrCc;
        this.totalPrice = totalPrice;
    }

    public int getTop_id() {
        return top_id;
    }

    public void setTop_id(int top_id) {
        this.top_id = top_id;
    }

    public int getBot_id() {
        return bot_id;
    }

    public void setBot_id(int bot_id) {
        this.bot_id = bot_id;
    }
    
    public LineItem(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LineItem(String cupcakeName) {
        this.cupcakeName = cupcakeName;
    }
    
    public LineItem () {
        
    }

    public double getPricePrCc() {
        return pricePrCc;
    }

    public void setPricePrCc(double pricePrCc) {
        this.pricePrCc = pricePrCc;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCupcakeName() {
        return cupcakeName;
    }

    public void setCupcakeName(String cupcakeName) {
        this.cupcakeName = cupcakeName;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
    
    //Til de nye felter. Det er ikke sikkert vi behøver at bruge den.
//    @Override
//    public String toString() {
//        return "LineItem{" + "invoiceId=" + invoiceId + ", top_id=" + top_id + ", bot_id=" + bot_id + ", cupcakeName=" + cupcakeName + ", quantity=" + quantity + ", pricePrCc=" + pricePrCc + ", totalPrice=" + totalPrice + '}';
//    }

    @Override
    public String toString() {
        return "\n" + quantity + "   " + cupcakeName+"  price a cupcake:  " + pricePrCc + "  totalPrice:  " + totalPrice + "\n\n";
    }
    
    
    public String toString2() {
        
   
     return "InfoToAdmin{" + "invoiceId=" + invoiceId + ", pricePrCc=" + pricePrCc + ", totalPrice=" + totalPrice + ", quantity=" + quantity + ", cupcakeName=" + cupcakeName + '}';
    }


}
