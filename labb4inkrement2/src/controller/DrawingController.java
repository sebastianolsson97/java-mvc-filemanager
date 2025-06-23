package controller;

import View.*;
import java.awt.event.*;
import labb4inkrement2.DrawingFacade;

public class DrawingController implements MouseListener {
	private DrawingFacade facade;
	private ToolPanel toolPanel;
	private int startX = -1;
	private int startY = -1; 
	
	public DrawingController(DrawingFacade facade, ToolPanel toolPanel) {
		this.facade = facade; 
		this.toolPanel = toolPanel; 
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
		if (toolPanel == null) {
			System.err.println("ToolPanel is null");
			return; 
		}
	
		if (startX == -1 && startY == -1) {
			startX = e.getX();
			startY = e.getY();
			System.out.println("Start point set at: (" + startX + ", " + startY + ")");
		} else {
			int endX = e.getX();
			int endY = e.getY();
			System.out.println("End point set at: (" + endX + ", " + endY + ")");
			
			if("Line".equals(toolPanel.getSelectedShape())) {
				facade.startDrawing(startX, startY, toolPanel.getSelectedShape(), toolPanel.getSelectedColor(), toolPanel.getSelectedLineWidth());
				facade.updateCurrentShape(endX, endY);
				facade.finishDrawing(endX, endY);
				facade.repaintView();
			}
			
			startX = -1;
			startY = -1;
		}
		}

	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	
	
}

/*

@Override
public void mousePressed(MouseEvent e) {
	System.out.println("Mouse pressed at: " + e.getX() + ", " + e.getY());
	if (toolPanel != null) {
	facade.startDrawing(e.getX(), e.getY(),
			toolPanel.getSelectedShape(),
			toolPanel.getSelectedColor(),
			toolPanel.getSelectedLineWidth());
} else {
	System.err.println("ToolPanel is null");
}
}
@Override
public void mouseDragged(MouseEvent e) {
	System.out.println("Mouse dragged to: " + e.getX() + ", " + e.getY());
	facade.updateCurrentShape(e.getX(), e.getY());
	facade.repaintView();
}
@Override
public void mouseReleased(MouseEvent e) {
	System.out.println("Mouse released at: " + e.getX() + ", " + e.getY());
	facade.finishDrawing(e.getX(), e.getY());
}

@Override public void mouseClicked(MouseEvent e) {}
@Override public void mouseEntered(MouseEvent e) {}
@Override public void mouseExited(MouseEvent e) {}
@Override public void mouseMoved(MouseEvent e) {}

	*/
