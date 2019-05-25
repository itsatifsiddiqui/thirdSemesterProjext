package models;

import java.io.Serializable;

public class Product implements Serializable {

    String brand,name;
    Category category;
    double purchasePrice, salePrice;
    int quantity;
    Date mfgDate;
    Date expDate;


    public Product() {
    }

    public Product(String brand, String name, Category category, double purchasePrice, double salePrice, int quantity, Date mfgDate, Date expDate) {
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getMfgDate() {
        return this.mfgDate;
    }

    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Date getExpDate() {
        return this.expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nBrand: ").append(getBrand());
        stringBuilder.append("\nname: ").append(getName());
        stringBuilder.append("\ncategory: ").append(getCategory().toString());
        stringBuilder.append("\npurchasePrice: ").append(getPurchasePrice());
        stringBuilder.append("\nsalePrice: ").append(getSalePrice());
        stringBuilder.append("\nquantity: ").append(getQuantity());
        stringBuilder.append("\nmfgDate: ").append(getMfgDate().toString());
        stringBuilder.append("\nexpDate: ").append(getExpDate().toString());
        return stringBuilder.toString();

        // return "{" +
        //     " brand='" + getBrand() + "'" +
        //     ", name='" + getName() + "'" +
        //     ", category='" + getCategory() + "'" +
        //     ", purchasePrice='" + getPurchasePrice() + "'" +
        //     ", salePrice='" + getSalePrice() + "'" +
        //     ", quantity='" + getQuantity() + "'" +
        //     ", mfgDate='" + getMfgDate() + "'" +
        //     ", expDate='" + getExpDate() + "'" +
        //     "}";
    }

}