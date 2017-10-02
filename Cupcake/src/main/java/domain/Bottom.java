package domain;

/**
 *
 * @author Bo Henriksen
 */
public class Bottom {

    private int bot_id;
    private String botName;
    private double bot_Price;

    public Bottom(int bot_id, String botName, double bot_Price) {
        this.bot_id = bot_id;
        this.botName = botName;
        this.bot_Price = bot_Price;
    }

    public Bottom() {
    }

    @Override
    public String toString() {
        return "Bottom{" + "bot_id=" + bot_id + ", botName=" + botName + ", bot_Price=" + bot_Price + '}';
    }
    
    public int getBot_id() {
        return bot_id;
    }

    public String getBotName() {
        return botName;
    }

    public double getBot_Price() {
        return bot_Price;
    }

    public void setBot_id(int bot_id) {
        this.bot_id = bot_id;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setBot_Price(double bot_Price) {
        this.bot_Price = bot_Price;
    }
   
 }
