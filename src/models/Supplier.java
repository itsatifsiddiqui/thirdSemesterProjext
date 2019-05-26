package models;

import java.io.Serializable;
import java.util.ArrayList;

import app.Operations;

public class Supplier extends Person implements Serializable {

    double prevDues;
    public static String fileName = "suppliers.ser";

    public Supplier() {
        super();
    }

    public Supplier(String name, String phone, String cnic, double prevDues) {
        super(name, phone, cnic);
        this.prevDues = prevDues;
    }

    public double getPevDues() {
        return this.prevDues;
    }

    public void setPrevDues(int prevDues) {
        this.prevDues = prevDues;
    }

    @Override
    public String toString() {
        return super.toString() + "Previous Dues: " + getPevDues() + "\n";
    }

    public static void addNewSupplier(Supplier s) {
        Operations.writeData(s, fileName);
        System.out.println("Written");
    }

    public static ArrayList<Supplier> getAllSuppliers() {
        return Operations.readAllData(fileName);
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
            Operations.writeList(supplierList, fileName);

        return found;

    }

}