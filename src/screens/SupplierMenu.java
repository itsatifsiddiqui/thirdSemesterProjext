package screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import app.Table;
import models.*;

import extras.GUI;
import extras.Regex;
import extras.Styles;

@SuppressWarnings("all")
public class SupplierMenu extends GUI {

    String[] columnName = new String[] { "Name", "Phone", "CNIC", "Previous Dues", "Products" };

    public SupplierMenu() {

        init("Supplier Menu", new GridLayout(5, 1));
        addButton("Add New Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SupplierForm(null);

            }
        }).setFont(Styles.heading);

        addButton("Search Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = JOptionPane.showInputDialog("Enter Supplier Name To Search").trim();

                if (!name.matches(Regex.NAME)) {
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                    return;
                }

                ArrayList<Supplier> suppliers = Supplier.searchSupplier(name);
                if (suppliers == null) {
                    JOptionPane.showMessageDialog(null, "Supplier Not Found");
                } else {
                    new Table<>(suppliers, columnName);
                }

            }
        }).setFont(Styles.heading);

        addButton("Edit A Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Supplier> suppliers = Supplier.getAllSuppliers();

                ArrayList<String> list = new ArrayList<String>();

                for (Supplier supplier : suppliers)
                    list.add(supplier.getName() + " : " + supplier.getCnic());

                if (list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No Record To Edit");
                    return;
                }
                JComboBox supplierListBox = showSearchBox(list, "Select Supplier To Edit");

                String temp = supplierListBox.getSelectedItem().toString();
                String cnic = temp.substring(temp.length() - 13, temp.length()).trim();

                Supplier supplier = Supplier.getSupplier(cnic);

                new SupplierForm(supplier);

            }

        }).setFont(Styles.heading);

        addButton("Delete A Supplier", new ActionListener() {

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

                JComboBox supplierListBox = showSearchBox(list, "Select Supplier To Delete");

                String temp = supplierListBox.getSelectedItem().toString();
                String cnic = temp.substring(temp.length() - 13, temp.length()).trim();

                Supplier.delete(cnic);
                JOptionPane.showMessageDialog(null, "Supplier Deleted");
            }
        }).setFont(Styles.heading);

        addButton("Display All Suppliers", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Supplier> list = Supplier.getAllSuppliers();
                new Table(list, columnName);

            }
        }).setFont(Styles.heading);

        end();

    }

}