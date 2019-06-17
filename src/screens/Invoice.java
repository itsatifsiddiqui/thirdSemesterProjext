package screens;

import app.Operations;
import extras.File;
import extras.GUI;
import models.Cart;
import models.Product;
import models.Supplier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Invoice extends GUI {

    private JList<Object> productsList;
    private ArrayList<String> products;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JScrollPane scrollPane;
    private double bill = 0;
    private double totalQuantity = 0;

    public Invoice(List<Cart> cartItems) {
        init("Sales Invoice", null, 800, 600);
        products = new ArrayList<String>(0);
        products.add(String.format("%-40s %30s %60s ", "Products Name", "Quantity", "Price"));

        for (Cart cart : cartItems) {
            products.add(String.format("%-40s %60s %77s", cart.getProductName(), cart.getQuantity(), cart.getPrice()

            ));
            bill += cart.getPrice();
            totalQuantity += cart.getQuantity();
        }

        priceLabel = new JLabel("Total Price: " + bill);
        quantityLabel = new JLabel("Total Quantity: " + (totalQuantity));
        productsList = new JList<Object>(products.toArray());
        scrollPane = new JScrollPane(productsList);
        add(scrollPane);
        add(priceLabel);
        add(quantityLabel);
        scrollPane.setBounds(10, 10, 800, 400);
        JButton button = addButton("Checkout", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Supplier> suppliers = Supplier.getAllSuppliers();

                for (Supplier supplier : suppliers) {
                    for (Product product : supplier.getProducts()) {
                        for (Cart cart : cartItems) {
                            if (product.getName().equalsIgnoreCase(cart.getProductName())) {
                                product.setQuantity(product.getQuantity() - cart.getQuantity());
                            }
                        }
                    }
                }


                Operations.writeList(suppliers, File.supplier);

                dispose();
                new SalePanel();

            }
        });
        button.setBounds(580, 500, 200, 40);
        priceLabel.setBounds(650, 420, 250, 40);
        quantityLabel.setBounds(350, 420, 250, 40);
        end();
    }


}
