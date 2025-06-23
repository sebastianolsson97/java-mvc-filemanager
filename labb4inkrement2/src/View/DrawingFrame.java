package View;

import java.awt.*;
import javax.swing.*;
import labb4inkrement2.DrawingFacade;
import controller.DrawingController;


public class DrawingFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private DrawingPanel drawingPanel; 
	private ToolPanel toolPanel; 
	
public DrawingFrame(DrawingFacade facade) {
	setTitle("Drawing Application");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(800, 600);
	
	toolPanel = new ToolPanel(facade);
	add(toolPanel, BorderLayout.NORTH);
	
	drawingPanel = new DrawingPanel(facade.getModel());
	drawingPanel.setBackground(Color.WHITE);
	System.out.println("DrawingPanel created with model: " + facade.getModel());
		
	DrawingController controller = new DrawingController(facade, toolPanel);
	drawingPanel.addMouseListener(controller);
	
	add(drawingPanel, BorderLayout.CENTER);
	setVisible(true);
	
}
	

}
