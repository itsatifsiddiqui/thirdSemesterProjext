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

@SuppressWarnings("all")
public class ProductForm extends GUI {

    JComboBox supplierListBox;

    public ProductForm(String supplierName, Product product) {
        init(product == null ? "Add Product" : "Edit " + product.getName(), new GridLayout(11, 1), 800, 600);

        if (Supplier.getSuppliersName().size() == 0) {
            JOptionPane.showMessageDialog(null, "No Suppliers Exist, First Add Some Suppliers");
            return;
        }

        supplierListBox = addComboBox("  Suppliers List",
                product == null ? Supplier.getSuppliersName().toArray() : new Object[] { supplierName });

        JTextField brand = addTextField("  Product Brand", product == null ? "" : product.getBrand());
        JTextField name = addTextField("  Product Name", product == null ? "" : product.getName());
        JComboBox category = addComboBox("  Suppliers List",
                new Category[] { Category.COSMETIC, Category.FOOD, Category.CROCKERY });
        JTextField purchae = addTextField("  Purchase Price",
                product == null ? "" : String.valueOf(product.getPurchasePrice()));
        JTextField sale = addTextField("  Sale Price", product == null ? "" : String.valueOf(product.getSalePrice()));
        JTextField quantity = addTextField("  Quantity", product == null ? "" : String.valueOf(product.getQuantity()));
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

                    ArrayList<Supplier> suppliers = Supplier.getAllSuppliers();

                    if (product == null) {

                        supplier.getProducts().add(newProduct);

                        suppliers.set(index, supplier);

                        Operations.writeList(suppliers, File.supplier);

                        JOptionPane.showMessageDialog(null, "Product Added Successfully");

                    } else {
                        for (int i = 0; i < supplier.getProducts().size(); i++) {
                            if (supplier.getProducts().get(i).getName().equals(product.getName())) {
                                supplier.getProducts().set(i, newProduct);
                                System.out.println("After " + supplier.getProducts().get(i));
                                Operations.writeList(suppliers, File.supplier);
                                JOptionPane.showMessageDialog(null, "Product Edited Successfully");
                                break;
                            }
                        }
                    }

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