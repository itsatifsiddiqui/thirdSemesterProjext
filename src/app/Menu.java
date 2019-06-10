package app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu extends JFrame {

    JButton addButton;
    JButton deleteButton;
    JButton displayButton;
    JButton exitButton;

    public Menu() {

        setLayout(new GridLayout(2, 2));

        setSize(640, 480);

        addButton = new JButton("Add Vehicle");
        deleteButton = new JButton("Delete Vehicle");
        displayButton = new JButton("Display");
        exitButton = new JButton("Exit");

        ClickButton actionListener = new ClickButton();

        // addButton.addActionListener(l);

        addButton.addActionListener(actionListener);
        deleteButton.addActionListener(actionListener);
        displayButton.addActionListener(actionListener);
        exitButton.addActionListener(actionListener);

        add(addButton);
        add(deleteButton);
        add(displayButton);
        add(exitButton);

        setVisible(true);

    }

    private class ClickButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Add Vehicle")) {
                AddForm form = new AddForm();
            }

            if (e.getActionCommand().equals("Delete Vehicle")) {
                System.out.println("Delete CLICKED");
            }
            if (e.getActionCommand().equals("Display")) {
                System.out.println("Display CLICKED");
            }
            if (e.getActionCommand().equals("Exit")) {
                System.out.println("Exit CLICKED");
            }

        }
    }

    private class AddForm extends JFrame {

        public AddForm() {

            JLabel addLabel = new JLabel("Enter Car Plate Id");
            JLabel colorLabel = new JLabel("Enter Vehicle Color");
            JLabel doorLabel = new JLabel("Enter Vehicle No of doors");
            JLabel modelLabel = new JLabel("Enter Car Modle");

            JTextField addField = new JTextField();
            JTextField colorField = new JTextField();
            JTextField doorField = new JTextField();
            JTextField modelField = new JTextField();

            setSize(640, 480);

            Panel gridPanel = new Panel();

            gridPanel.setLayout(new GridLayout(4, 2));

            setLayout(new BorderLayout());

            addButton = new JButton("Add Vehicle");
            deleteButton = new JButton("Delete Vehicle");
            displayButton = new JButton("Display");
            exitButton = new JButton("Exit");

            gridPanel.add(addLabel);
            gridPanel.add(addField);
            gridPanel.add(modelLabel);
            gridPanel.add(modelField);
            gridPanel.add(colorLabel);
            gridPanel.add(colorField);
            gridPanel.add(doorLabel);
            gridPanel.add(doorField);

            add(gridPanel, BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);

            addButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {

                    System.out.println(addField.getText());
                    System.out.println(colorField.getText());

                }

                
            });

            setVisible(true);

        }

    }

}