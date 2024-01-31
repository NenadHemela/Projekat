package drawing;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {

	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i = shapes.size(); i-- > 0;)
		{
			shapes.get(i).draw(g);
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	

}
