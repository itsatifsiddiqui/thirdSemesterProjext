package models;

import app.Operations;
import extras.File;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("all")
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

    public static void add(Supplier s) {
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

    public static void delete(String cnic) {

        ArrayList<Supplier> supplierList = getAllSuppliers();

        supplierList.removeIf((std) -> (std.getCnic().equals(cnic)));

        Operations.writeList(supplierList, File.supplier);

    }

    public static Supplier getSupplier(String cnic) {
        ArrayList<Supplier> supplierList = getAllSuppliers();

        for (Supplier supplier : supplierList)
            if (supplier.getCnic().equals(cnic))
                return supplier;

        return null;

    }

    public static int getSupplierIndex(String cnic) {
        ArrayList<Supplier> supplierList = getAllSuppliers();

        for (int i = 0; i < supplierList.size(); i++) {
            if (supplierList.get(i).getCnic().equals(cnic)) {
                return i;
            }
        }

        return -1;

    }

    public static void update(Supplier s, String cnicSearch) {
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

    public static ArrayList<String> getSuppliersName() {

        ArrayList<String> array = new ArrayList<String>();

        getAllSuppliers().forEach((supplier) -> {
            array.add(supplier.getName() + "  :  " + supplier.getCnic());
        });

        return array;
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>(0);
        for (Supplier supplier : Supplier.getAllSuppliers()) {
            for (Product product : supplier.getProducts()) {
                products.add(product);
            }
        }
        return products;
    }

}