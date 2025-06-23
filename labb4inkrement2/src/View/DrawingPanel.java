package View;


	
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JPanel;
import model.*;


public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
		
private DrawingComposite dc;
		
		
public void setDc(DrawingComposite dc) {
	System.out.println("DrawingPanel: Updating DrawingContainer to " + dc);
			this.dc = dc;
		    repaint();
		}
		
public DrawingPanel (DrawingComposite dc) {
			this.dc=dc;
			System.out.println("DrawingPanel initialized with model: " + dc);
			
			 if (this.dc == null) {
			        System.err.println("ERROR: DrawingContainer is null in DrawingPanel constructor!");
			    } else {
			        System.out.println("DrawingPanel initialized with a valid DrawingContainer.");
			    }
			}
		
		
@Override
protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.white);
			if (dc != null) {
				System.out.println("DrawingPanel: Repainting shapes...");	
		    dc.draw(g);
		} else {
			System.err.println("DrawingContainer is null in DrawingPanel");
		}
		
	}

}
