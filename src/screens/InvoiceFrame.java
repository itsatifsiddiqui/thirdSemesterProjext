package screens;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.Table;
import extras.GUI;
import models.Product;
import models.Supplier;

public class InvoiceFrame extends GUI {

    JTable table;
    JLabel lable;

    public <T> InvoiceFrame(ArrayList<T> list, Object[] columnNames) {

        init("HELLo", new GridLayout(2, 1));

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        ArrayList<Supplier> suppliersList = (ArrayList<Supplier>) list;

        for (Supplier supplier : suppliersList) {
            Object[] x = { supplier.getName(), supplier.getPhone(), supplier.getCnic(), supplier.getPevDues(),
                    supplier.getProducts().size() };
            tableModel.addRow(x);
        }
        table.setPreferredScrollableViewportSize(new Dimension(640, 480));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        lable = new JLabel("HELLO WORLD");
        add(scrollPane);
        addlabelsRow("Total Price", "0");

        setResizable(false);
        setVisible(true);

    }

}