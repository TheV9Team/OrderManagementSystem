/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bimalka
 */
public class Stocks {

    /**
     * @return the itemNO
     */
    public String getItemNO() {
        return itemNO;
    }

    /**
     * @param itemNO the itemNO to set
     */
    public void setItemNO(String itemNO) {
        this.itemNO = itemNO;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    private String itemNO;
    private String description;
    private int qty;
}
