package models;

import java.io.Serializable;
import java.util.ArrayList;

import app.Operations;
import extras.File;
import models.*;

// @SuppressWarnings("all")
public class Supplier extends Person implements Serializable {

    private double prevDues;
    private ArrayList<Product> products;

    public Supplier() {
        super();
        products = new ArrayList<Product>(0);
    }

    public Supplier(String name, String phone, String cnic, double prevDues, ArrayList<Product> arrayList) {
        super(name, phone, cnic);
        this.prevDues = prevDues;
        this.products = arrayList;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getPevDues() {
        return this.prevDues;
    }

    public void setPrevDues(double prevDues) {
        this.prevDues = prevDues;
    }

    @Override
    public String toString() {
        return super.toString() + "Previous Dues: " + getPevDues() + "Products List: " + products.toString() + "\n";
    }

    public static void addNewSupplier(Supplier s) {
        Operations.writeData(s, File.supplier);
    }

    public static ArrayList<Supplier> getAllSuppliers() {
        return Operations.readAllData(File.supplier);
    }

    public static ArrayList<Supplier> searchSupplier(String name) {
        ArrayList<Supplier> suppliers = getAllSuppliers();
        ArrayList<Supplier> temp = new ArrayList<Supplier>();
        for (Supplier supplier : suppliers) {
            if (supplier.getName().equalsIgnoreCase(name)) {
                temp.add(supplier);
            }
        }
        return temp;
    }

    public static boolean deleteSupplier(String cnic) {

        boolean found = false;
        ArrayList<Supplier> supplierList = getAllSuppliers();

        found = supplierList.removeIf((std) -> (std.getCnic().equals(cnic)));

        if (found)
            Operations.writeList(supplierList, File.supplier);

        return found;

    }

    public static Supplier getSupplier(String cnic) {
        ArrayList<Supplier> supplierList = getAllSuppliers();

        for (Supplier supplier : supplierList)
            if (supplier.getCnic().equals(cnic))
                return supplier;

        return null;

    }

    public static void updateSupplier(Supplier s, String cnicSearch) {
        ArrayList<Supplier> supplierList = getAllSuppliers();
        for (Supplier supplier : supplierList)
            if (supplier.getCnic().equals(cnicSearch)) {
                supplier.setName(s.getName());
                supplier.setPhone(s.getPhone());
                supplier.setCninc(s.getCnic());
                supplier.setPrevDues(s.getPevDues());
                break;
            }
        Operations.writeList(supplierList, File.supplier);
    }

}