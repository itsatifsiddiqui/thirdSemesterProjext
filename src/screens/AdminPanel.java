package screens;

import extras.GUI;
import extras.Styles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// @SuppressWarnings("all")
public class AdminPanel extends GUI {

    public AdminPanel() {

        init("Admin Panel", new GridLayout(2, 2));

        addButton("Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SupplierMenu();

            }
        }).setFont(Styles.heading);

        addButton("Products", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductsMenu();

            }
        }).setFont(Styles.heading);

        end();

    }

}