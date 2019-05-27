package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import extras.File;
import mdlaf.MaterialLookAndFeel;
import screens.MainMenu;
import screens.SupplierMenu;

public class APP {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		System.out.println(Operations.readAllData(File.supplier));
		new MainMenu();

	}

}
