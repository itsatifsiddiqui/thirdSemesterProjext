package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.Operations;
import extras.File;
import extras.GUI;
import extras.Regex;
import extras.Styles;
import models.Product;
import models.Supplier;

@SuppressWarnings("all")
public class SupplierForm extends GUI {

    String cnicSearch;

    public SupplierForm(Supplier supplier) {
        init((supplier == null) ? "Add Supplier" : "Edit " + supplier.getName(), new GridLayout(5, 1), 640, 300);

        if (supplier != null)
            cnicSearch = supplier.getCnic();

        JTextField name = addTextField("   Name", (supplier == null) ? "" : supplier.getName());
        JTextField phone = addTextField("   Phone", (supplier == null) ? "" : supplier.getPhone());
        JTextField cnic = addTextField("   CNIC", (supplier == null) ? "" : supplier.getCnic());
        JTextField dues = addTextField("   Prev", (supplier == null) ? "0" : String.valueOf(supplier.getPevDues()));
        addButton("Add Supplier", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String fname = name.getText().toLowerCase();
                String fphone = phone.getText().toLowerCase();
                String fcnic = cnic.getText().toLowerCase();
                String fdues = dues.getText().toLowerCase();

                if (fname.matches(Regex.NAME) && fphone.matches(Regex.PHONE) && fcnic.matches(Regex.CNIC)
                        && fdues.matches(Regex.DOUBLE)) {

                    System.out.println(fname + " : " + fphone + " : " + fcnic + " : " + fdues);
                    Supplier sup = new Supplier(fname, fphone, fcnic, Double.parseDouble(fdues),new ArrayList<Product>(0));

                    if (supplier == null) {
                        ArrayList<Supplier> suppliers = Operations.readAllData(File.supplier);

                        for (Supplier s : suppliers) {
                            if (s.getPhone().equalsIgnoreCase(sup.getName()) || s.getPevDues() == sup.getPevDues()) {
                                JOptionPane.showMessageDialog(null, "Supplier Already Exist");
                                return;
                            }
                        }
                        Operations.writeData(sup, File.supplier);
                        JOptionPane.showMessageDialog(null, "Supplier Added Successfully");
                    } else {
                        
                        Supplier.updateSupplier(sup, cnicSearch);
                        JOptionPane.showMessageDialog(null, "Supplier Edited Successfully");
                    }

                    setVisible(false);
                    dispose();
                } else
                    JOptionPane.showMessageDialog(null, "Incorrect Data Entered");

            }

        }).setFont(Styles.button);

        end();
    }

}