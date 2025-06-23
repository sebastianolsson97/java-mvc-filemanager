package model;

import java.awt.*;
import java.util.*;
import View.*;

public class DrawingContainer implements DrawingComposite, Cloneable {
	private static final long serialVersionUID = 1L;
	
	private Vector<DrawingComposite> v;

    public DrawingContainer() {
        v = new Vector<>();
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("DrawingContainer: Drawing all shapes...");
        for (DrawingComposite shape : v) {
            System.out.println("Drawing shape: " + shape);
            shape.draw(g); 
        }
    }

    @Override
    public void add(DrawingComposite s) {
        v.add(s);
        System.out.println("Shape added: " + s);
    }

    @Override
    public void remove(DrawingComposite s) {
        v.remove(s);
        System.out.println("Shape removed: " + s);
    }

    @Override
    public DrawingComposite getContainer() {
        return this;
    }

    public DrawingComposite getLast() {
        if (!v.isEmpty()) {
            return v.lastElement();
        }
        return null;
    }

    public void printShapes() {
        System.out.println("Shapes in container:");
        for (DrawingComposite shape : v) {
            System.out.println(shape);
        }
    }

    public Vector<DrawingComposite> getAllShapes() {
        return v;
    }

    @Override
    public int getX1() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getY1() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getLineWidth() {
        return 0;
    }

    @Override
    public Color getLineColor() {
        return null;
    }

    @Override
    public Color getAreaColor() {
        return null;
    }

    @Override
    public void setDrawingAPI(DrawingUtilInterface di) {
        for (DrawingComposite shape : v) {
            shape.setDrawingAPI(di);
        }
    }
}
