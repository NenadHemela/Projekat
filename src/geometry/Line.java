package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

		private Point startPoint;
		private Point endPoint;

		public Line() {
			
		}
		
		public Line(Point startPoint, Point endPoint) {
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		}
		
		public Line(Point startPoint, Point endPoint, boolean selected) {
			this(startPoint, endPoint);
			this.selected = selected;
		}
		
		@Override
		public void draw(Graphics g) {
			g.setColor(getBorderColor());
			g.drawLine(startPoint.getx(), startPoint.gety(), endPoint.getx(), endPoint.gety());
			if(selected) {
				g.setColor(Color.BLUE);
				g.drawRect(startPoint.getx()-3, startPoint.gety()-3, 6, 6);
				g.drawRect(endPoint.getx()-3, endPoint.gety()-3, 6, 6);
			}
		}
		
		@Override
		public void moveTo(int x, int y) {
			
			
		}

		@Override
		public void moveBy(int byX, int byY) {
			startPoint.moveBy(byX, byY);
			endPoint.moveBy(byX, byY);
			
		}
		
		public double length(Line l1) {
			return startPoint.distance(endPoint);
		}
		
		@Override
		public String toString() {
			return ("(" + startPoint.getx() + "," + startPoint.gety() + ")-->(" + endPoint.getx() + "," + endPoint.gety() + ")");
		}
		
		@Override
		public int compareTo(Object o) {
			if(o instanceof Line) {
				Line temp = (Line) o;
				return (int) (length(null) - temp.length(temp));
			}
			else
				return 0;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Line) {
				Line temp = (Line) o;
				if(this.startPoint.equals(temp.getstartPoint()) && this.endPoint.equals(temp.getendPoitnt())); 
				//this moze a i ne mora ovde jer nema 2 promenljive sa istim imenom
			}
			return false;
		}
		
		public boolean contains(int x, int y) {
			return (length(this) - startPoint.distance(new Point(x, y)) - endPoint.distance(new Point(x, y))) <= 3;
		}
		
		public Point getstartPoint() {
			return startPoint;
		}
		
		public Point getendPoitnt() {
			return endPoint;
		}
		
		
		
		public void setstartPoint(Point startPoint) {
			this.startPoint = startPoint;
		}
		
		public void setendPoint(Point endPoint) {
			this.endPoint = endPoint;
		}


	}

