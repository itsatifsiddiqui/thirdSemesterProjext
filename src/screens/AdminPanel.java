package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import extras.GUI;
import extras.Styles;;

@SuppressWarnings("all")
public class AdminPanel extends GUI {

    public AdminPanel() {

        init("Admin Panel", new GridLayout(1, 3));

        addButton("Inventory", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ADD");
            }
        }).setFont(Styles.heading);

        addButton("Purchase", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Operator Panel");

            }
        }).setFont(Styles.heading);

        addButton("Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SupplierMenu();

            }
        }).setFont(Styles.heading);

        end();

    }

}