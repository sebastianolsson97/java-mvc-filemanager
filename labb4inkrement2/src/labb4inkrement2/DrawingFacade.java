package labb4inkrement2;
import model.*;
import View.*; 
import java.awt.*;

public class DrawingFacade {

	private DrawingContainer model;
	private DrawingPanel view; 
	
	public DrawingFacade(DrawingContainer model, DrawingPanel view) {
		this.model = model;
		this.view = view; 
		System.out.println("Facade initialized with model: " + model + " and view: " + view);
	
		
		if (this.model == null) {
	        System.err.println("ERROR: Model is null in DrawingFacade!");
	    } else {
	        System.out.println("DrawingFacade initialized with DrawingContainer: " + model);
	    }
	}
	
	public void addShape(DrawingShape shape) {
		model.add(shape);
		view.repaint();
	}
	
	public void printShapes() {
        model.printShapes();
    }
	public DrawingContainer getModel() {
		return model;
		
	}
	
	public DrawingPanel getView() {
		return view;
	}
	
	public void removeShape(DrawingShape shape) {
		model.remove(shape);
		view.repaint();
	}
	
	public void startDrawing(int x1, int y1, String shapeType, Color lineColor, int lineWidth) {
		DrawingShape newShape = switch (shapeType) {
		case "Line" -> new Line(new DrawingUtil(), x1, y1, x1, y1, lineWidth, lineColor);
		case "Circle" -> new Circle(new DrawingUtil(), x1, y1, 0, 0, lineWidth, lineColor, null);
		case "Rectangle" -> new Rect(new DrawingUtil(), x1, y1, 0, 0, lineWidth, lineColor, null);
		default -> null; 
		};
		if (newShape != null) {
			System.out.println("Adding shape to model: " + shapeType);
	        model.add(newShape);
	       
	        model.printShapes();
	        view.setDc(model);
	        view.repaint();
		System.out.println("Repaint triggered");
	        
	}
	}

	public void updateCurrentShape(int x2, int y2) {
		DrawingComposite lastShape = model.getLast();
		if (lastShape instanceof Line line) {
	        line.setX2(x2);
	        line.setY2(y2);
	        System.out.println("Updated Line to (" + line.getX1() + ", " + line.getY1() + 
	                ") -> (" + line.getX2() + ", " + line.getY2() + ")");
	        view.repaint();
	    } else if (lastShape instanceof DrawingShape shape) {
	        shape.setWidth(x2 - shape.getX1());
	        shape.setHeight(y2 - shape.getY1());
	        System.out.println("Updated Shape to width: " + shape.getWidth() + ", height: " + shape.getHeight());
	        view.repaint();
		}
	}

	public void finishDrawing(int x2, int y2) {
		updateCurrentShape(x2, y2);
		System.out.println("Current model state: ");
		model.printShapes();
	}

	public void saveDrawing(String filename) {
		FileUtil.saveDrawing(model, filename);
	}
	
	public void loadDrawing(String filename) {
		DrawingComposite loaded = FileUtil.loadDrawing(filename);
		if (loaded instanceof DrawingContainer container) {
			this.model = container; 
			view.setDc(model);
			view.repaint();
		}
	}
	
	public void repaintView() {
		view.repaint();
	}
}