package screens;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import app.Operations;
import app.Table;
import extras.*;
import models.Product;
import models.Supplier;

public class ProductsMenu extends GUI {

    public ProductsMenu() {

        init("Products Menu", new GridLayout(5, 1));

        addButton("Add Products", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ProductForm(null, null);

            }
        }).setFont(Styles.heading);

        addButton("Edit Product", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Supplier> suppliers = Supplier.getAllSuppliers();

                ArrayList<String> list = new ArrayList<String>();

                for (Supplier supplier : suppliers)
                    list.add(supplier.getName() + " : " + supplier.getCnic());

                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No Record To Delete");
                    return;
                }

                JComboBox supplierListBox = showSearchBox(list, "Select Supplier To Edit Product");

                String temp = supplierListBox.getSelectedItem().toString();
                String cnic = temp.substring(temp.length() - 13, temp.length()).trim();

                Supplier supplier = Supplier.getSupplier(cnic);

                ArrayList<String> productsList = new ArrayList<String>();

                for (Product product : supplier.getProducts())
                    productsList.add(product.getName());

                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No Product To Delete");
                    return;
                }

                JComboBox productsListBox = showSearchBox(productsList, "Select Supplier To Edit Product");

                for (Product prodct : supplier.getProducts()) {
                    if (prodct.getName().equals(productsListBox.getSelectedItem().toString())) {
                        new ProductForm(supplier.getName() + " : " + supplier.getCnic(), prodct);
                    }
                }

            }
        }).setFont(Styles.heading);

        addButton("Delete Product", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Supplier> suppliers = Supplier.getAllSuppliers();

                ArrayList<String> list = new ArrayList<String>();

                for (Supplier supplier : suppliers)
                    list.add(supplier.getName() + " : " + supplier.getCnic());

                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No Record To Delete");
                    return;
                }

                JComboBox supplierListBox = showSearchBox(list, "Select Supplier To Edit Product");

                String temp = supplierListBox.getSelectedItem().toString();
                String cnic = temp.substring(temp.length() - 13, temp.length()).trim();

                Supplier supplier = Supplier.getSupplier(cnic);

                ArrayList<String> productsList = new ArrayList<String>();

                for (Product product : supplier.getProducts())
                    productsList.add(product.getName());

                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No Product To Delete");
                    return;
                }

                JComboBox productsListBox = showSearchBox(productsList, "Select Product To Edit");

                for (int i = 0; i < supplier.getProducts().size(); i++) {
                    if (supplier.getProducts().get(i).getName().equals(productsListBox.getSelectedItem().toString())) {
                        System.out.println(supplier.getProducts());
                        supplier.getProducts().remove(i);
                        System.out.println(supplier.getProducts());
                        Operations.writeList(suppliers, File.supplier);
                        JOptionPane.showMessageDialog(null, "Product Deleted");
                        // setVisible(false);
                    }
                }

            }
        }).setFont(Styles.heading);

        addButton("Search Products", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = JOptionPane.showInputDialog("Enter Product Name To Search").trim();

                ArrayList<Product> products = new ArrayList<Product>(0);
                System.out.println(products);

                for (Supplier supplier : Supplier.getAllSuppliers()) {
                    for (Product product : supplier.getProducts()) {
                        if (product.getName().equalsIgnoreCase(name.toString())) {
                            System.out.println("IN IFF");
                            products.add(product);
                        }
                    }
                }
                System.out.println(products);

                new Table<>(products, new String[] { "Brand", "Name", "Category", "Purchase Price", "Sale Price",
                        "Quantity", "MFG DATE", "EXP DATE" });

            }
        }).setFont(Styles.heading);

        addButton("Display All Products", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Product> products = new ArrayList<Product>(0);

                for (Supplier supplier : Supplier.getAllSuppliers()) {
                    products.addAll(supplier.getProducts());
                }

                new Table<>(products, new String[] { "Supplier", "Brand", "Name", "Category", "Purchase Price",
                        "Sale Price", "Quantity", "MFG DATE", "EXP DATE" });

            }
        }).setFont(Styles.heading);

        end();
    }
}
