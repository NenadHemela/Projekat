package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	protected int radius;
	protected Point center;
	private Color fillColor;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getFillColor());
		g.fillOval(center.getx()-radius, center.gety()-radius, 2*radius, 2*radius);
		g.setColor(getBorderColor());
		g.drawOval(center.getx()-radius, center.gety()-radius, 2*radius, 2*radius);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getx()-3, center.gety()-3, 6, 6);
			g.drawRect(center.getx()+radius-3, center.gety()-3, 6, 6);
			g.drawRect(center.getx()-radius-3, center.gety()-3, 6, 6);
			g.drawRect(center.getx()-3, center.gety()+radius-3, 6, 6);
			g.drawRect(center.getx()-3, center.gety()-radius-3, 6, 6);
		}
	}
	
		@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	
	public double area() {
		return Math.PI*Math.pow(radius, radius);
	}
	
	public double circumference() {
		return Math.PI*2*radius;
	}
	
	@Override
	public String toString() {
		return "Center: (" + this.center.getx() + ", " + this.center.gety() + "), radius = " + this.radius;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle) o;
			return (int) (area() - temp.area());
		}
		else
			return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle) o;
			if(radius == temp.getRadius() && center.equals(temp.getCenter())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if(center.distance(new Point(x, y)) <= radius)
			return true;
		else
			return false;
	}
	
	public boolean contains(Point p) {
		return contains(p.getx(),p.gety());
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {
		if(radius < 1)
			throw new Exception("Radius ne moze biti manji od 1.");
		else
			this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	

}
