package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.Operations;
import extras.GUI;
import extras.Regex;
import extras.Styles;
import models.Supplier;

public class SupplierForm extends GUI {

    public SupplierForm(Supplier supplier) {
        init((supplier == null) ? "Add Supplier" : "Edit " + supplier.getName(), new GridLayout(5, 1), 640, 300);

        JTextField name = addTextField("   Name", (supplier == null) ? "" : supplier.getName());
        JTextField phone = addTextField("   Phone", (supplier == null) ? "" : supplier.getPhone());
        JTextField cnic = addTextField("   CNIC", (supplier == null) ? "" : supplier.getCnic());
        JTextField dues = addTextField("   Prev", (supplier == null) ? "0" : String.valueOf(supplier.getPevDues()));
        addButton("Add Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (name.getText().matches(Regex.NAME) && phone.getText().matches(Regex.PHONE)
                        && cnic.getText().matches(Regex.CNIC) && dues.getText().matches(Regex.DOUBLE)) {
                    Supplier supplier = new Supplier(name.getText().toLowerCase(), phone.getText().toLowerCase(), cnic.getText().toLowerCase(),
                            Double.parseDouble(dues.getText()));
                    ArrayList<Supplier> suppliers = Operations.readAllData("suppliers.ser");

                    for (Supplier s : suppliers) {
                        if (s.getPhone().equalsIgnoreCase(supplier.getName()) || s.getPevDues() == supplier.getPevDues()) {
                            JOptionPane.showMessageDialog(null, "Supplier Already Exist");
                            return;
                        }
                    }
                    Operations.writeData(supplier, "suppliers.ser");
                    JOptionPane.showMessageDialog(null, "Supplier Added Successfully");
                    setVisible(false);
                    dispose();
                } else
                    JOptionPane.showMessageDialog(null, "Incorrect Data Entered");

            }

        }).setFont(Styles.button);

        end();
    }

}