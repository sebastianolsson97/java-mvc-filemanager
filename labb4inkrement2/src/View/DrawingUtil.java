package View;


	import java.awt.*;
	import model.*;

	public class DrawingUtil implements DrawingUtilInterface {
		private static final long serialVersionUID = 1L;
		
		
		public void drawCircle(DrawingShape d, Graphics g) {
			if (d.getAreaColor()!=null) {
				GraphicsUtil.fillOval(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(), d.getAreaColor());
			}
			GraphicsUtil.drawOval(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(),
	                d.getLineWidth(), d.getLineColor());
		}

		
		public void drawRect(DrawingShape d,  Graphics g) {
			if (d.getAreaColor()!=null) {
				GraphicsUtil.fillRect(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(), d.getAreaColor());
			}
			GraphicsUtil.drawRect(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(),
	                d.getLineWidth(), d.getLineColor());
		}
		
		 
		public void drawLine(DrawingShape d, Graphics g) {
			GraphicsUtil.drawLine(g, d.getX1(), d.getY1(), d.getWidth(), d.getHeight(),
	                d.getLineWidth(), d.getLineColor());
		}

	}


