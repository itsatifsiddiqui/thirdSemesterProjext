package screens;

import extras.GUI;
import extras.Styles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("all")
public class MainMenu extends GUI {

    public MainMenu() {

        init("Main Menu", new GridLayout(1, 3));

        addButton("Admin Panel", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPanel();
            }
        }).setFont(Styles.heading);

        addButton("Operator Panel", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SalePanel();
            }
        }).setFont(Styles.heading);


        end();

    }

}