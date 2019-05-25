package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import extras.GUI;
import extras.Styles;;

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
                new OperatorPanel();

            }
        }).setFont(Styles.heading);


        end();

    }

}