/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    
}
