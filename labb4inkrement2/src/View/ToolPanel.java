package View;


import javax.swing.*;
import java.awt.*;
import controller.DrawingController;
import labb4inkrement2.DrawingFacade;


public class ToolPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> shapeSelector;
	private JButton colorButton;
	private JSpinner lineWidthSpinner; 

	private Color selectedColor = Color.BLACK;
	private String selectedShape = "Line";
	private int selectedLineWidth = 1;
	
	public ToolPanel(DrawingFacade facade) {
		setLayout(new FlowLayout());
		
		shapeSelector = new JComboBox<>(new String[] { "Line", "Circle", "Rectangle" });
		shapeSelector.addActionListener(e -> selectedShape = (String) shapeSelector.getSelectedItem());
		add(new JLabel("Shape:"));
		add(shapeSelector);
		
		colorButton = new JButton ("Line Color");
		colorButton.addActionListener(e -> {
			Color newColor = JColorChooser.showDialog(this, "Choose line color", selectedColor);
			if (newColor != null) selectedColor = newColor;
		
		});
		add(colorButton);
	
		lineWidthSpinner = new JSpinner (new SpinnerNumberModel(1, 1, 10, 1)); 
		lineWidthSpinner.addChangeListener(e -> selectedLineWidth = (Integer) lineWidthSpinner.getValue());
		add(new JLabel("Line Width:"));
		add(lineWidthSpinner);
		
		DrawingController controller = new DrawingController(facade, this);
		facade.getView().addMouseListener(controller);
		
		
}
	
	public String getSelectedShape() {
		return selectedShape;
	}

	public Color getSelectedColor() {
		return selectedColor;
	}
	
	public int getSelectedLineWidth() {
		return selectedLineWidth;
	}

}
