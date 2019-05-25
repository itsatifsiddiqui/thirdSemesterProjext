package screens;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import extras.*;

public class OperatorPanel extends GUI {

    JComboBox<String> productsListBox;
    JLabel productListLabel;
    JButton addToCartBtn;
    JButton removeFromCartBtn;
    JLabel productDetailLabel;
    JList<Object> productsList;
    ArrayList<String> products;
    JScrollPane scrollPane;

    public OperatorPanel() {

        init("Operator Panel", null, 1050, 768);
        initComponents();
        initBounds();

        productsListBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                productDetailLabel.setText(productsListBox.getSelectedItem().toString()
                        + " asdhjksahdsa hjadskh dsajkhsad kjsadh jkdsah sakjasdh kjas hasjaskh skj sk");
            }
        });

        addButton("Add To Cart", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String text = productsListBox.getSelectedItem().toString();
                products.add(text);
                System.err.println(products);
                productsList.setListData(products.toArray());
            }
        }).setBounds(670, 60, 150, 40);

        addButton("Remove From Cart", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = productsListBox.getSelectedItem().toString();
                products.remove(text);
                System.err.println(products);
                productsList.setListData(products.toArray());
            }
        }).setBounds(840, 60, 180, 40);

        addButton("Generate Invoice", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                
            }
        }).setBounds(600, 650, 400, 50);

        addComponents(new Component[] { productsListBox, productListLabel, productDetailLabel, scrollPane });

        end();
    }

    public void initComponents() {

        productListLabel = new JLabel("Products List");

        productsListBox = new JComboBox<>(new String[] { "Hello", "who are you", "jewwelt", "PRODUCT4", "PRODUCT5",
                "PRODUCT6", "Hello", "who are you", "jewwelt", "PRODUCT4", "PRODUCT5", "PRODUCT6", "Hello",
                "who are you", "jewwelt", "PRODUCT4", "PRODUCT5", "PRODUCT6", "Hello", "who are you", "jewwelt",
                "PRODUCT4", "PRODUCT5", "PRODUCT6", "Hello", "who are you", "jewwelt", "PRODUCT4", "PRODUCT5",
                "PRODUCT6", "Hello", "who are you", "jewwelt", "PRODUCT4", "PRODUCT5", "PRODUCT6", "Hello",
                "who are you", "jewwelt", "PRODUCT4", "PRODUCT5", "PRODUCT6" });

        AutoCompleteDecorator.decorate(productsListBox);

        productDetailLabel = new JLabel(productsListBox.getSelectedItem().toString()
                + " asdhjksahdsa hjadskh dsajkhsad kjsadh jkdsah sakjasdh kjas hasjaskh skj sk");

        products = new ArrayList<String>(0);

        productsList = new JList<Object>(products.toArray());

        scrollPane = new JScrollPane(productsList);

    }

    public void initBounds() {

        productListLabel.setBounds(20, 60, 400, 40);

        productsListBox.setBounds(140, 60, 500, 40);

        productDetailLabel.setBounds(20, 110, 1000, 40);

        scrollPane.setBounds(10, 180, 1000, 450);

    }

}