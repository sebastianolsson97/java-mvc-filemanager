import java.awt.*; 
import javax.swing.*; 
import model.*; 
import View.*;

public class MinimalDraw {
	

public static void main (String[] args) {
JFrame j = new JFrame();
j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

DrawingContainer dc = new DrawingContainer();
DrawingUtil da = new DrawingUtil();
DrawingPanel dp = new DrawingPanel(dc);

dp.setBackground(Color.WHITE);
j.add(dp);
j.setSize(500,500);
j.setVisible(true);

int loadOption = JOptionPane.showConfirmDialog(null, "Do you want to load an existing drawing", "Load File", JOptionPane.YES_NO_OPTION);
if (loadOption == JOptionPane.YES_OPTION) {
	String loadFilename = JOptionPane.showInputDialog("Enter filename to load:");
	if (loadFilename != null && !loadFilename.trim().isEmpty()) {
		DrawingComposite loaded = FileUtil.loadDrawing(loadFilename);
		if (loaded instanceof DrawingContainer) {
			dc = (DrawingContainer) loaded;
			dp.setDc(dc);
			j.repaint();
		}
	}
}

	
boolean addMore = true;

while (addMore) {
	String[] options = {"Line", "Circle", "Rectangle"}; 
	String choice = (String) JOptionPane.showInputDialog(null, "Choose a shape to draw: ", "Shape Selector", JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
	
	if (choice == null)
		break; 
	try { 
		int x1 = Integer.parseInt(JOptionPane.showInputDialog("Enter x1 (start x-coordinate):"));
		int y1 = Integer.parseInt(JOptionPane.showInputDialog("Enter y1 (start y-coordinate):"));
		int width = Integer.parseInt(JOptionPane.showInputDialog("Enter line width:"));
		Color lineColor = JColorChooser.showDialog(null, "Choose line color:", Color.BLACK);
		
		switch (choice) {
		case "Line" -> {
			int x2 = Integer.parseInt(JOptionPane.showInputDialog("Enter x2 (start x-coordinate):"));
			int y2 = Integer.parseInt(JOptionPane.showInputDialog("Enter y2 (start x-coordinate):"));
			dc.add(new Line(da, x1, y1, x2, y2, width, lineColor));
			
		}
		
		case "Circle" -> {
			int radius = Integer.parseInt(JOptionPane.showInputDialog("Enter radius:"));
			Color fillColor = JColorChooser.showDialog(null, "Choose fill color:", null);
			dc.add(new Circle(da, x1, y1, radius * 2, radius * 2, width, lineColor, fillColor)); 
			
		}
		
		case "Rectangle" -> {
			int height = Integer.parseInt(JOptionPane.showInputDialog("Enter height:"));
			int rectWidth = Integer.parseInt(JOptionPane.showInputDialog("Enter width:"));
			Color fillColor = JColorChooser.showDialog(null, "Choose fill color:", null);
			dc.add(new Rect(da, x1, y1, rectWidth, height, width, lineColor, fillColor));
			
		}
		}
		
		j.repaint();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	int result = JOptionPane.showConfirmDialog(null, "Do you want another shape?", "Add More", JOptionPane.YES_NO_OPTION);
	addMore = (result == JOptionPane.YES_OPTION);
}

String saveFilename = JOptionPane.showInputDialog("Enter filename to save: ");
if (saveFilename != null && !saveFilename.trim().isEmpty()) {
	FileUtil.saveDrawing(dc, saveFilename);
	
}

JOptionPane.showMessageDialog(null, "Drawing complete");

}
}

