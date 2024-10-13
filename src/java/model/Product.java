
package model;

import java.util.Date;



public class Product {
      private int id;
    private String name, description;
    private int stock, unitSold;
    private String[] images, colors, size;
    private Date releasedate;
    private double discount, price, salePrice;
    private boolean status;
    private Category category;
    private Supplier supplier;
    private Type type;

    public Product() {
    }

    public Product(int id, String name, String description, int stock, int unitSold, String[] images,
            String[] colors, String[] size, Date releasedate, double discount, double price, boolean status, Category category, Supplier supplier, Type type) {
        this.salePrice = price;
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.unitSold = unitSold;
        this.images = images;
        this.colors = colors;
        this.size = size;
        this.releasedate = releasedate;
        this.discount = discount;
        this.price = price;
        this.status = status;
        this.category = category;
        this.supplier = supplier;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(int unitSold) {
        this.unitSold = unitSold;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String[] getSize() {
        return size;
    }

    public void setSize(String[] size) {
        this.size = size;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSalePrice() {
        double salePrice = price - Math.round(price * discount * 100) / 100.0;
        salePrice = Math.round(salePrice * 100.0) / 100.0;
        if (discount > 0) {
            return salePrice;
        } else {
            return price;
        }
    }

}


