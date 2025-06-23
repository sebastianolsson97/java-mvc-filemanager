package View;

import java.awt.Graphics;
import java.io.Serializable;
import model.*;


public interface DrawingUtilInterface extends Serializable{

	
	public void drawCircle(DrawingShape d, Graphics g);
	
	public void drawRect(DrawingShape d, Graphics g);
	
	public void drawLine(DrawingShape d, Graphics g);

}
