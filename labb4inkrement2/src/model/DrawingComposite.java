package model;


	import java.awt.Color;
	import java.awt.Graphics;
	import java.io.Serializable;
	import View.*;
		
		public interface DrawingComposite extends Serializable {
		   
		   
		   public void add(DrawingComposite d);
		   
		   
		   public void remove(DrawingComposite d);
		   
		   
		   public void draw(Graphics g); 
		   
		   
		   public void setDrawingAPI(DrawingUtilInterface di);

		  
		   public int getX1();
		   
		  
		   public int getHeight();
		   
		 
		   public int getY1();
		   
		  
		   public int getWidth();
		   
		  
		   public int getLineWidth();
		   
		  
		   public Color getLineColor();
		   
		  
		   public Color getAreaColor();
		   
		   DrawingComposite getContainer();
		}



