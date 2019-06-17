package models;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Product implements Serializable {

    String brand, name;
    Category category;
    double purchasePrice, salePrice;
    int quantity;
    Date mfgDate;
    Date expDate;

    public Product() {
    }

    public Product(String brand, String name, Category category, double purchasePrice, double salePrice, int quantity,
            Date mfgDate, Date expDate) {
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
    }

    public boolean equals(Product product) {
        if (this.name.equals(product.name) && this.brand.equals(product.brand)) {
            return true;
        }
        return false;
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

    public static Product searchByName(String name){
        ArrayList<Product> products = Supplier.getAllProducts();
        System.out.println(products);
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name.toLowerCase())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Brand: ").append(getBrand());
        stringBuilder.append("  Name: ").append(getName());
        stringBuilder.append("  Category: ").append(getCategory().toString());
        stringBuilder.append("  Purchase Price: ").append(getPurchasePrice());
        stringBuilder.append("  Sale Price: ").append(getSalePrice());
        stringBuilder.append("  Quantity: ").append(getQuantity());
        stringBuilder.append("  Mfg Date: ").append(getMfgDate().toString());
        stringBuilder.append("  Exp Date: ").append(getExpDate().toString());
        return stringBuilder.toString();

        // return "{" +
        // " brand='" + getBrand() + "'" +
        // ", name='" + getName() + "'" +
        // ", category='" + getCategory() + "'" +
        // ", purchasePrice='" + getPurchasePrice() + "'" +
        // ", salePrice='" + getSalePrice() + "'" +
        // ", quantity='" + getQuantity() + "'" +
        // ", mfgDate='" + getMfgDate() + "'" +
        // ", expDate='" + getExpDate() + "'" +
        // "}";
    }

}