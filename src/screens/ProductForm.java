package screens;

import app.Operations;
import com.toedter.calendar.JDateChooser;
import extras.File;
import extras.GUI;
import extras.Regex;
import models.Category;
import models.Date;
import models.Product;
import models.Supplier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ProductForm extends GUI {

    JComboBox supplierListBox;
    JRadioButton comseticRadioButton;
    JRadioButton foodRadioButton;
    JRadioButton crockeryRadioButton;
    Category category = Category.COSMETIC;

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


        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1, 2));
        JLabel label = new JLabel("Select Category");
        pane.add(label);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3));

        comseticRadioButton = new JRadioButton(Category.COSMETIC.toString(), true);
        foodRadioButton = new JRadioButton(Category.FOOD.toString(), false);
        crockeryRadioButton = new JRadioButton(Category.CROCKERY.toString(), false);

        panel2.add(comseticRadioButton);
        panel2.add(foodRadioButton);
        panel2.add(crockeryRadioButton);
        ButtonGroup bg = new ButtonGroup();
        bg.add(comseticRadioButton);
        bg.add(foodRadioButton);
        bg.add(crockeryRadioButton);
        pane.add(panel2);
        add(pane);
        Listener listener = new Listener();
        comseticRadioButton.addItemListener(listener);
        foodRadioButton.addItemListener(listener);
        crockeryRadioButton.addItemListener(listener);





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
                Category fCategory = (Category) category;
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

                    Product newProduct = new Product(fbrand, fname, category, Double.parseDouble(fpurchase),
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

    private class Listener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (comseticRadioButton.isSelected()) {
                category = Category.COSMETIC;
            } else if (foodRadioButton.isSelected()) {
                category = Category.FOOD;
            } else if (crockeryRadioButton.isSelected()) {
                category = Category.CROCKERY;
            }

        }
    }

}