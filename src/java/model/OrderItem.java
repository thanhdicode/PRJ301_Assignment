
package model;


public class OrderItem {
    private int quantity;
    private double price;
    private Product product;
    private int orderID;

    public OrderItem() {
    }

    
    
    public OrderItem(int quantity, double price, Product product, int orderID) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productID) {
        this.product = productID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
}
