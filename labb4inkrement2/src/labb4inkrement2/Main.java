package labb4inkrement2;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import View.*;
import model.*;

public class Main {
	public static void main(String[] args) {
		DrawingContainer model = new DrawingContainer();
		System.out.println("Model instance: " + model);

        model.printShapes();

		DrawingPanel view = new DrawingPanel(model);
		DrawingFacade facade = new DrawingFacade(model, view);
		

		int loadOption = JOptionPane.showConfirmDialog(null, "Load existing drawing?", "Load File", JOptionPane.YES_NO_OPTION); 
		if (loadOption == JOptionPane.YES_OPTION) {
			String filename = JOptionPane.showInputDialog("Enter filename to load:");
			if (filename != null && !filename.trim().isEmpty()) {
				facade.loadDrawing(filename);
			}
		}
		SwingUtilities.invokeLater(()-> new DrawingFrame(facade));
		
	}

}
