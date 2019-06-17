package screens;

import extras.GUI;
import extras.Regex;
import models.Cart;
import models.Product;
import models.Supplier;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SalePanel extends GUI {

    JComboBox<String> productsListBox;
    JLabel productListLabel;
    JButton addToCartBtn;
    JButton removeFromCartBtn;
    JLabel productDetailLabel;
    JList<Object> productsList;
    ArrayList<String> products;
    JScrollPane scrollPane;
    Product activeProduct;
    int selectedQuantity;
    ArrayList<Cart> cartItems = new ArrayList<Cart>(0);

    public SalePanel() {
        init("Operator Panel", null, 1050, 768);
        initComponents();
        initBounds();

        productsListBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String productName = productsListBox.getSelectedItem().toString();
                activeProduct = Product.searchByName(productName);

                productDetailLabel.setText(activeProduct.toString());
            }
        });

        addButton("Add To Cart", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                String productName = productsListBox.getSelectedItem().toString();
                String qiantity = JOptionPane.showInputDialog("Enter Quantity");
                if (qiantity.matches(Regex.INTEGER)) {
                    selectedQuantity = Integer.parseInt(qiantity);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Some Quantity");
                    return;
                }
                double price = activeProduct.getSalePrice() * selectedQuantity;
                System.out.println(cartItems);
                if (activeProduct.getQuantity() < selectedQuantity || selectedQuantity <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid Quantity");
                    return;
                }
                cartItems.add(new Cart(productName, selectedQuantity, price));

                products.add(String.format("%-110s %-97s %s", productName, selectedQuantity, selectedQuantity
                        * (activeProduct.getSalePrice())));

                activeProduct.setQuantity(activeProduct.getQuantity() - selectedQuantity);
                productDetailLabel.setText(activeProduct.toString());

                productsList.setListData(products.toArray());
            }
        }).setBounds(670, 60, 150, 40);

        addButton("Remove From Cart", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productsListBox.getSelectedItem().toString();
                cartItems.removeIf(((cart) -> cart.getProductName().equals(productName)));
                System.out.println(cartItems);
                products.removeIf((product) -> product.substring(0, productName.length()).equals(productName));
                activeProduct.setQuantity(activeProduct.getQuantity() + selectedQuantity);
                productDetailLabel.setText(activeProduct.toString());
                productsList.setListData(products.toArray());
            }
        }).setBounds(840, 60, 180, 40);

        addButton("Generate Invoice", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (cartItems.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Please Add Some Products To Cart Before Checking Out");
                    return;
                }

                new Invoice(cartItems);
                dispose();

            }
        }).setBounds(600, 650, 400, 50);

        addComponents(new Component[] { productsListBox, productListLabel, productDetailLabel, scrollPane });

        end();
    }

    public void initComponents() {

        productListLabel = new JLabel("Products List");
        ArrayList<Product> plist

                = Supplier.getAllProducts();

        String[] productsArray = new String[plist.size()];
        for (int i = 0; i < plist.size(); i++) {
            productsArray[i] = plist.get(i).getName();
        }

        productsListBox = new JComboBox<>(productsArray);

        AutoCompleteDecorator.decorate(productsListBox);

        String productName = productsListBox.getSelectedItem().toString();
        System.out.println(productName);
        activeProduct = Product.searchByName(productName.toLowerCase());

        System.out.println(activeProduct);

        productDetailLabel = new JLabel(activeProduct.toString());

        products = new ArrayList<String>(0);

        products.add(String.format("%-50s %50s %90s ", "Products Name", "Quantity", "Price"));
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