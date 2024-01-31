package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperLeft;
	private int width;
	private int height;
	private Color fillColor;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getFillColor());
		g.fillRect(upperLeft.getx(), upperLeft.gety(), width, height);
		g.setColor(getBorderColor());
		g.drawRect(upperLeft.getx(), upperLeft.gety(), width, height);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getx()-3, upperLeft.gety()-3, 6, 6);
			g.drawRect(upperLeft.getx()+width-3, upperLeft.gety()-3, 6, 6);
			g.drawRect(upperLeft.getx()-3, upperLeft.gety()+height-3, 6, 6);
			g.drawRect(upperLeft.getx()+width-3, upperLeft.gety()+height-3, 6, 6);
		}
	}
	
		@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}
	
	public int area() {
		return width*height;
	}
	
	public int circumference() {
		return 2*width+2*height;
	}

	
	public Point getUpperLeft() {
		return upperLeft;
	}
	
//	@Override
//	public String toString() {
//		return "UpperLeft: (" + upperLeft.getx() + "," + upperLeft.gety());
//	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			return area() - temp.area();
		}
		else
			return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			if(width == temp.getWidth() && height == temp.getHeight()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if(x >= upperLeft.getx() && x<= upperLeft.getx() + width && y >= upperLeft.gety() && y <= upperLeft.gety() + height) 
			return true;
		else
			return false;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	

}
