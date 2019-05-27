package screens;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import app.Operations;
import extras.*;
import models.Category;
import models.Date;
import models.Product;
import models.Supplier;

public class AddProductForm extends GUI {

    JComboBox supplierListBox;

    public AddProductForm() {
        init("Add Product", new GridLayout(11, 1), 800, 600);

        supplierListBox = addComboBox("  Suppliers List",
                Supplier.getSuppliersName().size() == 0 ? new Object[] { "No Supplier Exist" }
                        : Supplier.getSuppliersName().toArray());
        JTextField brand = addTextField("  Product Brand", "");
        JTextField name = addTextField("  Product Name", "");
        JComboBox category = addComboBox("  Suppliers List",
                new Category[] { Category.COSMETIC, Category.FOOD, Category.CROCKERY });
        JTextField purchae = addTextField("  Purchase Price", "");
        JTextField sale = addTextField("  Sale Price", "");
        JTextField quantity = addTextField("  Quantity", "");
        JDateChooser mfgDate = addCalendarBox("  MFG Date");
        JDateChooser expDate = addCalendarBox("  EXP Date");

        JPanel panel = new JPanel(new BorderLayout(1, 1));
        add(panel);

        addButton("Add", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                String temp = supplierListBox.getSelectedItem().toString();
                String cnic = temp.substring(temp.length() - 13, temp.length()).trim();

                String fbrand = brand.getText();
                String fname = name.getText();
                Category fCategory = (Category) category.getSelectedItem();
                String fpurchase = purchae.getText();
                String fsale = sale.getText();
                String fquantity = quantity.getText();
                java.util.Date fmfgDate = mfgDate.getDate();
                java.util.Date fexpDate = expDate.getDate();

                if (fmfgDate == null) {
                    JOptionPane.showMessageDialog(null, "Choose Date from MFG date box.");
                    return;
                }
                if (fexpDate == null) {
                    JOptionPane.showMessageDialog(null, "Choose Date from EXP date box.");
                    return;
                }
                Date emfgDate = null;
                Date eexpDate = null;
                if (fmfgDate.before(fexpDate)) {
                    emfgDate = new Date(fmfgDate.getDay(), fmfgDate.getMonth(), fmfgDate.getYear());
                    eexpDate = new Date(fexpDate.getDay(), fexpDate.getMonth(), fexpDate.getYear());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                    return;
                }

                if (fpurchase.matches(Regex.DOUBLE) && fsale.matches(Regex.DOUBLE) && fquantity.matches(Regex.INTEGER)
                        && !supplierListBox.getSelectedObjects()[0].toString().equalsIgnoreCase("No Supplier Exist")) {

                    Product newProduct = new Product(fbrand, fname, fCategory, Double.parseDouble(fpurchase),
                            Double.parseDouble(fsale), Integer.parseInt(fquantity), emfgDate, eexpDate);
                    Supplier supplier = Supplier.getSupplier(cnic);
                    int index = Supplier.getSupplierIndex(cnic);
                    supplier.getProducts().add(newProduct);

                    ArrayList<Supplier> suppliers = Supplier.getAllSuppliers();

                    suppliers.set(index, supplier);

                    Operations.writeList(suppliers, File.supplier);

                    JOptionPane.showMessageDialog(null, "Product Added Successfully");
                    setVisible(false);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Information Provided");
                    return;
                }

            }
        });

        end();

    }

}