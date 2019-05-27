package app;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import extras.File;
import mdlaf.MaterialLookAndFeel;
import models.Category;
import models.Date;
import models.Product;
import models.Supplier;
import screens.AddProductForm;
import screens.MainMenu;
import screens.SupplierMenu;

public class APP {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		// ArrayList<Product> p = new ArrayList<Product>();
		// p.add(new Product("HELLO", "HELL", Category.COSMETIC, 200, 100, 20, new
		// Date(2, 3, 2019),
		// new Date(2, 5, 2019)));

		// Supplier.add(new Supplier("Atif", "03456643045", "3430174715357", 200, p));

		System.out.println(Operations.readAllData(File.supplier));
		new SupplierMenu();

	}

}
