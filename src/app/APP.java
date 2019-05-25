package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import extras.Regex;
import mdlaf.MaterialLookAndFeel;
import screens.MainMenu;
import screens.OperatorPanel;
import screens.SupplierForm;
import screens.SupplierMenu;

public class APP {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		new SupplierMenu();
	}

}
