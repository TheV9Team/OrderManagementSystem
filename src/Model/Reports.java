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
public class Reports {

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the itemno
     */
    public String getItemno() {
        return itemno;
    }

    /**
     * @param itemno the itemno to set
     */
    public void setItemno(String itemno) {
        this.itemno = itemno;
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
    private String date;
    private String itemno;
    private int qty;
}
