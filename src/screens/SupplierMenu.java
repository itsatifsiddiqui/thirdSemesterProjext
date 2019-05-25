package screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import app.Table;
import models.*;

import extras.GUI;
import extras.Regex;
import extras.Styles;

public class SupplierMenu extends GUI {

    String[] columnName = new String[] { "Name", "Phone", "CNIC", "Previous Dues" };

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

            }
        }).setFont(Styles.heading);

        addButton("Edit A Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }).setFont(Styles.heading);

        addButton("Delete A Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cnic = JOptionPane.showInputDialog("Enter Supplier CNIC To Search").trim();

                if (!cnic.matches(Regex.CNIC)) {
                    JOptionPane.showMessageDialog(null, "Invalid CNIC");
                    return;
                }

                ArrayList<Supplier> suppliers = Supplier.searchSupplier(cnic);
                if (suppliers == null) {
                    JOptionPane.showMessageDialog(null, "Supplier Not Found");
                } else {
                    new Table(suppliers, columnName);
                }

            }
        }).setFont(Styles.heading);

        addButton("Display All Suppliers", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Table(Supplier.getAllSuppliers(), columnName);

            }
        }).setFont(Styles.heading);

        end();

    }

}