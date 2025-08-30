package org.example;

public class Product {
    private String name;
    private String type;
    private String place;
    private int warranty;

    public Product() {
    }

    public Product(String name, String type, String place, int warranty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getWarranty() {
        return this.warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String toString() {
        return "Product{name='" + this.name + "', type='" + this.type + "', place='" + this.place + "', warranty=" + this.warranty + "}";
    }
}
