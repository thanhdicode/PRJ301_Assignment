
package model;


public class Payment {
     private int paymentID;
    private String paymentMethod;

    public Payment() {
    }
    
    

    public Payment(int paymentID, String paymentMethod) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
}
