package app;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Product;
import models.Supplier;

// @SuppressWarnings("all")
public class Table<StudentTaTbleModel> extends JFrame {

    JTable table;

    public <T> Table(ArrayList<T> list, String[] columnNames) {

        setSize(800, 600);

        if (list.size() == 0) {
            JOptionPane.showMessageDialog(null, "No Record Exist Try Adding Some");
            return;
        }

        setTitle(list.get(0).getClass().getSimpleName() + " Records");

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);

        if (list.get(0) instanceof Supplier) {
            ArrayList<Supplier> suppliersList = (ArrayList<Supplier>) list;
            for (Supplier supplier : suppliersList) {
                Object[] x = { supplier.getName(), supplier.getPhone(), supplier.getCnic(), supplier.getPevDues(),
                        supplier.getProducts().size() };
                tableModel.addRow(x);
            }
        }

        if (list.get(0) instanceof Product) {
            ArrayList<Product> productsList = (ArrayList<Product>) list;

            if (productsList.size() != Supplier.getAllProducts().size()) {
                for (Product product : productsList) {
                    Object[] x = { product.getBrand(), product.getName(), product.getBrand(),
                            product.getPurchasePrice(), product.getSalePrice(), product.getQuantity(),
                            product.getMfgDate().toString(), product.getExpDate().toString() };
                    tableModel.addRow(x);
                }
            } else
                for (Supplier supplier : Supplier.getAllSuppliers()) {
                    for (Product product : supplier.getProducts()) {
                        Object[] x = { supplier.getName(), product.getBrand(), product.getName(), product.getBrand(),
                                product.getPurchasePrice(), product.getSalePrice(), product.getQuantity(),
                                product.getMfgDate().toString(), product.getExpDate().toString() };
                        tableModel.addRow(x);
                    }
                }

        }

        table.setPreferredScrollableViewportSize(new Dimension(640, 480));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        setResizable(false);
        setVisible(true);
    }

}