package domain;

/**
 *
 * @author Bo Henriksen
 */
public class InfoToAdmin {
    
    private int invoiceId;

    public InfoToAdmin(int invoiceId) {
        this.invoiceId = invoiceId;
    }
    
    public InfoToAdmin () {
        
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "InfoToAdmin{" + "invoiceId=" + invoiceId + '}';
    }
    
    
    
}
