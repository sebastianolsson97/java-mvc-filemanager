package model;


	import java.awt.Color;
	import java.awt.Graphics;
	import java.util.Enumeration;
	import java.util.Vector;
	import View.*;


	public class DrawingContainer implements DrawingComposite, Cloneable {
		private static final long serialVersionUID = 1L;
		
		private Vector<DrawingComposite> v;
		
		
		public DrawingContainer() {
			v=new Vector<DrawingComposite>();
		}
		
		
				
		public void draw(Graphics g) {
			DrawingComposite t;
			Enumeration<DrawingComposite> e=v.elements();
			while(e.hasMoreElements()) {
				t= e.nextElement();
				t.draw(g);
			}
		}
		
		public void add(DrawingComposite s) {
			v.add(s);
		}
		
		
		public void remove(DrawingComposite s) {
			v.remove(s);
		}
		
		
		public DrawingComposite getContainer() {
			return this;
		}
		
		
		public int getX1() {
			
			return 0;
		}

		
		public int getWidth() {
		
			return 0;
		}

		
		public int getY1() {
			
			return 0;
		}

		
		public int getHeight() {
			
			return 0;
		}

		
		public int getLineWidth() {
			
			return 0;
		}

		
		public Color getLineColor() {
			
			return null;
		}


		public Color getAreaColor() {
			
			return null;
		}
		

		public void setDrawingAPI(DrawingUtilInterface di) {
			DrawingComposite t;
			Enumeration<DrawingComposite> e=v.elements();
			while(e.hasMoreElements()) {
				t= e.nextElement();
				t.setDrawingAPI(di);
			}
			
			
		}
		
	}

