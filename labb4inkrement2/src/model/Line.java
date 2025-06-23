package model;


	import java.awt.Color;
	import java.awt.Graphics;
	import View.*;

	
	public class Line extends DrawingShape {
		private static final long serialVersionUID = 1L;
		
        private int x2;
        private int y2;
		
		public Line(DrawingUtilInterface di, int x1, int y1, int x2, int y2, int width, Color color) {
			super(di);
			setX1(x1);
			setWidth(x2);
			setY1(y1);
			setHeight(y2);
			setLineWidth(width);
			setLineColor(color);
			setAreaColor(Color.BLACK);
			
		}
		
		@Override
		public void draw(Graphics g) {
		    System.out.println("Drawing Line: start=(" + getX1() + ", " + getY1() + ") end=(" + getX2() + ", " + getY2() + ")");
		    g.setColor(getLineColor());
		    g.drawLine(getX1(), getY1(), getX2(), getY2());
		}

		
		
		public void setX2(int x2) {
			this.x2 = x2;
		}

		public void setY2(int y2) {
	        this.y2 = y2;
	    }

	    public int getX2() {
	        return x2;
	    }

	    public int getY2() {
	        return y2;
	    }
	    
	    @Override
	    public int getWidth() {
	        return getX2(); 
	    }

	    @Override
	    public int getHeight() {
	        return getY2(); 
	    }
	}
