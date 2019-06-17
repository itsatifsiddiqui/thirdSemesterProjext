package app;

import extras.File;
import mdlaf.MaterialLookAndFeel;
import models.Category;
import models.Date;
import models.Product;
import models.Supplier;
import screens.ProductsMenu;

import javax.swing.*;
import java.util.ArrayList;

public class APP {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		if (Operations.readAllData(File.supplier).size() == 0) {
			ArrayList<Product> p = new ArrayList<Product>();
			Product product = new Product("Bold", "Aqua", Category.COSMETIC, 123, 321, 45, new Date(1, 1, 2019), new Date(1, 1, 2019));
			p.add(product);
			Supplier.add(new Supplier("Atif", "03456643045", "3430174715351", 200, p));
			p.remove(0);
			product = new Product("Duo", "Pantene", Category.COSMETIC, 500, 800, 120, new Date(1, 1, 2019), new Date(1, 1, 2019));
			p.add(product);
			Supplier.add(new Supplier("Atif", "03456643045", "3430174715351", 200, p));
			p.remove(0);
			product = new Product("Mitchel", "Eclairs", Category.FOOD, 50, 80, 1200, new Date(1, 1, 2019), new Date(1, 1, 2019));
			p.add(product);
			Supplier.add(new Supplier("Haris", "03456643045", "3430174715352", 200, p));
			p.remove(0);
			product = new Product("Shield", "Pack of 6 glass", Category.CROCKERY, 350, 550, 1200, new Date(1, 1, 2019), new Date(1, 1, 2019));
			p.add(product);
			Supplier.add(new Supplier("Haris", "03456643045", "3430174715352", 200, p));
		}
		new ProductsMenu();

	}
}
