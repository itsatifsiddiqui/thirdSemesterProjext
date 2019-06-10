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
import screens.ProductForm;
import screens.AdminPanel;
import screens.MainMenu;
import screens.ProductsMenu;
import screens.SupplierMenu;

public class APP {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		if (Operations.readAllData(File.supplier).size() == 0) {
			ArrayList<Product> p = new ArrayList<Product>();
			p.add(new Product("HELLO", "hell", Category.COSMETIC, 200, 100, 20, new Date(2, 3, 2019),
					new Date(2, 5, 2019)));
			Supplier.add(new Supplier("Atif", "03456643045", "3430174715351", 200, p));
			Supplier.add(new Supplier("Haris", "03456643045", "3430174715352", 200, p));
			Supplier.add(new Supplier("Ahmed", "03456643045", "3430174715353", 200, p));
			Supplier.add(new Supplier("Haseeb", "03456643045", "3430174715354", 200, p));
			Supplier.add(new Supplier("Faraz", "03456643045", "3430174715355", 200, p));
		}
		// new ProductsMenu();
		new MainMenu();

	}
}
