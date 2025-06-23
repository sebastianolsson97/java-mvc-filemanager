package View;

	
	
import java.awt.Graphics;
import javax.swing.JPanel;
import model.*;


public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
		
private DrawingComposite dc;
		
		
public void setDc(DrawingComposite dc) {
			this.dc = dc;
		}
		
public DrawingPanel (DrawingComposite dc) {
			this.dc=dc;
		}
		
		
public void paintComponent(Graphics g) {
			super.paintComponent(g);
			dc.draw(g);
		}
		
	}


