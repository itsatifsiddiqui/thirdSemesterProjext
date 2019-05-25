package screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Table;
import models.*;

import extras.GUI;
import extras.Styles;

public class SupplierMenu extends GUI {

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

            }
        }).setFont(Styles.heading);

        addButton("Display All Suppliers", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Table<>(Supplier.getAllSuppliers(), new String[] { "Name", "Phone", "CNIC", "Previous Dues" });

            }
        }).setFont(Styles.heading);

        end();

    }

}