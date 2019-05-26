package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mdlaf.MaterialLookAndFeel;
import screens.SupplierMenu;

public class APP {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		System.out.println(Operations.readAllData("suppliers.ser"));
		new SupplierMenu();

	}

}
