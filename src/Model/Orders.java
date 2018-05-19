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
public class Orders {

    /**
     * @return the dailyTarget
     */
    public int getDailyTarget() {
        return dailyTarget;
    }

    /**
     * @param dailyTarget the dailyTarget to set
     */
    public void setDailyTarget(int dailyTarget) {
        this.dailyTarget = dailyTarget;
    }

    /**
     * @return the requestNumber
     */
    public int getRequestNumber() {
        return requestNumber;
    }

    /**
     * @param requestNumber the requestNumber to set
     */
    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
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
     * @return the itemNo
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * @param itemNo the itemNo to set
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the jobNumber
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * @param jobNumber the jobNumber to set
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the toBeCast
     */
    public int getToBeCast() {
        return toBeCast;
    }

    /**
     * @param toBeCast the toBeCast to set
     */
    public void setToBeCast(int toBeCast) {
        this.toBeCast = toBeCast;
    }

    /**
     * @return the deliveredQuantity
     */
    public int getDeliveredQuantity() {
        return deliveredQuantity;
    }

    /**
     * @param deliveredQuantity the deliveredQuantity to set
     */
    public void setDeliveredQuantity(int deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    /**
     * @return the toBeDeliver
     */
    public int getToBeDeliver() {
        return toBeDeliver;
    }

    /**
     * @param toBeDeliver the toBeDeliver to set
     */
    public void setToBeDeliver(int toBeDeliver) {
        this.toBeDeliver = toBeDeliver;
    }

    /**
     * @return the isDeleted
     */
    public int getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
    private String description;
    private String itemNo;
    private String client;
    private String orderDate;
    private String jobNumber;
    private String location;
    private int quantity;
    private String deadline;
    private int toBeCast;
    private int deliveredQuantity;
    private int toBeDeliver;
    private int isDeleted;
    private int requestNumber;
    private int dailyTarget;
    
}
