
package model;

import java.util.Date;

public class Order {
     private int orderID;
    private Date orderDate;
    private double totalPrice;
    private Payment paymentMethod;
    private User user;
    private boolean status;
    private String note;
    public Order() {
    }
    

    public Order(int orderID, Date orderDate, double totalPrice, Payment paymentMethod, User user, boolean status, String note) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.status = status;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
