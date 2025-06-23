package model;


	import java.awt.Color;
	import java.awt.Graphics;
	import View.*;

		public class DrawingShape implements DrawingComposite {
			private static final long serialVersionUID = 1L;
			
			DrawingUtilInterface di;
			
			int width;
			
			int x1;
			
			int y1;
			
			int height;
		
			int lineWidth;
			
			Color lineColor;
			
			Color areaColor;
			
			
			public DrawingShape(DrawingUtilInterface di) {
				this.di=di;
			}
			
			public void setDrawingAPI (DrawingUtilInterface di) {
				this.di=di;
			}
			
			public int getX1() {
				return x1;
			}

			public void setX1(int x1) {
				this.x1 = x1;
			}

			public int getWidth() {
				return x1 + width;
			}

			public void setWidth(int w) {
				this.width = w;
			}

			public int getY1() {
				return y1;
			}

			public void setY1(int y1) {
				this.y1 = y1;
			}

			public int getHeight() {
				return y1 + height;
			}
			
			public void setHeight(int height) {
				this.height = height;
			}

			public void setLineWidth(int w) {
				lineWidth=w;
			}

			public int getLineWidth() {
				return lineWidth;
			}

			public void setLineColor(Color c) {
				lineColor=c;
			}

			public void setAreaColor(Color c) {
				areaColor=c;
			}

			public Color getLineColor() {
				return lineColor;
			}

			public Color getAreaColor() {
				return areaColor;
			}

			public void add(DrawingComposite d) {
				
			}
		
			public void remove(DrawingComposite d) {
					
			}

			public void draw(Graphics g) {
				
			}
			
			public DrawingComposite getContainer() {
		        return null;
					
			}
			
		}



