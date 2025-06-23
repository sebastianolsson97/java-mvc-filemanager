package View;


	import java.awt.Color;
	import java.awt.Graphics;

	public class GraphicsUtil {




	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2, int lineWidth, Color c) {
	    System.out.println("Drawing line with color: " + c + " from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
	    if (c == null) {
	        c = Color.BLACK;
	    }
	    
	    Color origColor = g.getColor();
		        g.setColor(c);
		        if (lineWidth == 1) {
		            g.drawLine(x1, y1, x2, y2);
		        } else {
		            double angle = Math.atan2(y2 - y1, x2 - x1) + Math.PI / 2.0;
		            int halfWidth = lineWidth / 2;
		            int xOffset = (int) (halfWidth * Math.cos(angle));
		            int yOffset = (int) (halfWidth * Math.sin(angle));
		            int[] xPoints = {x1 - xOffset, x2 - xOffset, x2 + xOffset, x1 + xOffset};
		            int[] yPoints = {y1 - yOffset, y2 - yOffset, y2 + yOffset, y1 + yOffset};
		            g.fillPolygon(xPoints, yPoints, 4);
		        }
		        g.setColor(origColor);
		    }
		    
	public static void drawRect(Graphics g, int left, int top, int width, int height, int lineWidth, Color c) {
		        Color origColor = g.getColor();
		        g.setColor(c);
		        for (int i = 0; i < lineWidth; i++) {
		            g.drawRect(left + i, top + i, width - 2 * i, height - 2 * i);
		        }
		        g.setColor(origColor);
		    }

		   
	public static void fillRect(Graphics g, int left, int top, int width, int height, Color c) {
		        Color origColor = g.getColor();
		        g.setColor(c);
		        g.fillRect(left, top, width, height);
		        g.setColor(origColor);
		    }

		   
	public static void drawOval(Graphics g, int left, int top, int width, int height, int lineWidth, Color c) {
		        Color origColor = g.getColor();
		        g.setColor(c);
		        for (int i = 0; i < lineWidth; i++) {
		            g.drawOval(left + i, top + i, width - 2 * i, height - 2 * i);
		        }
		        g.setColor(origColor);
		    }

		   
	public static void fillOval(Graphics g, int left, int top, int width, int height, Color c) {
		        Color origColor = g.getColor();
		        g.setColor(c);
		        g.fillOval(left, top, width, height);
		        g.setColor(origColor);
		    }
		}




