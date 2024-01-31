package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;
	private Color fillColor;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, boolean selected, int innerRadius) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getx()-innerRadius, getCenter().gety()-innerRadius, 2*innerRadius, 2*innerRadius);
		g.setColor(getBorderColor());
		g.drawOval(getCenter().getx()-innerRadius, getCenter().gety()-innerRadius, 2*innerRadius, 2*innerRadius);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getx()-innerRadius-3, center.gety()-3, 6, 6);
			g.drawRect(center.getx()+innerRadius-3, center.gety()-3, 6, 6);
			g.drawRect(center.getx()-3, center.gety()-innerRadius-3, 6, 6);
			g.drawRect(center.getx()-3, center.gety()+innerRadius-3, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && getCenter().distance(new Point(x, y)) >= innerRadius;
	}
	
	@Override
	public boolean contains(Point p) {
		return contains(p.getx(),p.gety());
	}
	
	@Override
	public double area() {
		return super.area() - (Math.PI * innerRadius * innerRadius);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut) o;
			return (int) (area() - temp.area());
		}
		else
			return 0;
	}
	
//	@Override
//	public boolean equals(Object o) {
//		if(o instanceof Donut) {
//			Donut temp = (Donut) o;
//			if(getCenter().equals(temp.getCenter() && getRadius() == temp.getRadius() && innerRadius == temp.getInnerRadius())){
//				return true;
//			}
//		}
//	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
}