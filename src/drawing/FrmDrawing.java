package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean point = false;
	private boolean line = false;
	private boolean rectangle = false;
	private boolean circle = false;
	private boolean donut = false;
	private boolean selected = false;
	private int cnt = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setResizable(false);
		setTitle("Hemela Nenad MH65/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorth = new GridBagLayout();
		gbl_panelNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0};
		gbl_panelNorth.rowHeights = new int[]{0, 10, 0, 10, 0};
		gbl_panelNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNorth.setLayout(gbl_panelNorth);
		
		JLabel lblDrawing = new JLabel("Crtanje");
		lblDrawing.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblDrawing = new GridBagConstraints();
		gbc_lblDrawing.anchor = GridBagConstraints.WEST;
		gbc_lblDrawing.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrawing.gridx = 7;
		gbc_lblDrawing.gridy = 0;
		panelNorth.add(lblDrawing, gbc_lblDrawing);
		
		JLabel lblShapes = new JLabel("Oblici: ");
		lblShapes.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblShapes = new GridBagConstraints();
		gbc_lblShapes.anchor = GridBagConstraints.SOUTH;
		gbc_lblShapes.insets = new Insets(0, 0, 5, 5);
		gbc_lblShapes.gridx = 0;
		gbc_lblShapes.gridy = 2;
		panelNorth.add(lblShapes, gbc_lblShapes);
		
		PnlDrawing panelCenter = new PnlDrawing();
		
		JButton btnPoint = new JButton("•");
		JButton btnLine = new JButton("/");
		JButton btnRectangle = new JButton("▭");
		JButton btnCircle = new JButton("○");
		JButton btnDonut = new JButton("◉");
		btnDonut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPoint(false);
				setLine(false);
				setRectangle(false);
				setCircle(false);
				setDonut(true);
				
				btnPoint.setEnabled(true);
				btnLine.setEnabled(true);
				btnRectangle.setEnabled(true);
				btnCircle.setEnabled(true);
				btnDonut.setEnabled(false);
			}
		});
		
		btnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPoint(false);
				setLine(false);
				setRectangle(false);
				setCircle(true);
				setDonut(false);
				
				btnPoint.setEnabled(true);
				btnLine.setEnabled(true);
				btnRectangle.setEnabled(true);
				btnCircle.setEnabled(false);
				btnDonut.setEnabled(true);
			}
		});
		
		btnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPoint(false);
				setLine(false);
				setRectangle(true);
				setCircle(false);
				setDonut(false);
				
				btnPoint.setEnabled(true);
				btnLine.setEnabled(true);
				btnRectangle.setEnabled(false);
				btnCircle.setEnabled(true);
				btnDonut.setEnabled(true);
			}
		});
		
		btnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPoint(false);
				setLine(true);
				setRectangle(false);
				setCircle(false);
				setDonut(false);
				
				btnPoint.setEnabled(true);
				btnLine.setEnabled(false);
				btnRectangle.setEnabled(true);
				btnCircle.setEnabled(true);
				btnDonut.setEnabled(true);
			}
		});
		
		btnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPoint(true);
				setLine(false);
				setRectangle(false);
				setCircle(false);
				setDonut(false);
				
				btnPoint.setEnabled(false);
				btnLine.setEnabled(true);
				btnRectangle.setEnabled(true);
				btnCircle.setEnabled(true);
				btnDonut.setEnabled(true);
			}
		});
		btnPoint.setToolTipText("Tačka");
		btnPoint.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnPoint = new GridBagConstraints();
		gbc_btnPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_btnPoint.gridx = 1;
		gbc_btnPoint.gridy = 2;
		panelNorth.add(btnPoint, gbc_btnPoint);
		
		//JButton btnLine
		btnLine.setToolTipText("Linija");
		btnLine.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnLine = new GridBagConstraints();
		gbc_btnLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnLine.gridx = 2;
		gbc_btnLine.gridy = 2;
		panelNorth.add(btnLine, gbc_btnLine);
		
		//JButton btnRectangle
		btnRectangle.setToolTipText("Pravougaonik");
		btnRectangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectangle.gridx = 3;
		gbc_btnRectangle.gridy = 2;
		panelNorth.add(btnRectangle, gbc_btnRectangle);
		
		//JButton btnCircle
		btnCircle.setToolTipText("Krug");
		btnCircle.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCircle.gridx = 4;
		gbc_btnCircle.gridy = 2;
		panelNorth.add(btnCircle, gbc_btnCircle);
		
		//JButton btnDonut
		btnDonut.setToolTipText("Krug sa rupom");
		GridBagConstraints gbc_btnDonut = new GridBagConstraints();
		gbc_btnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_btnDonut.gridx = 5;
		gbc_btnDonut.gridy = 2;
		panelNorth.add(btnDonut, gbc_btnDonut);
		
		JButton btnDeselct = new JButton("Poništi izbor");
		btnDeselct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPoint(false);
				setLine(false);
				setRectangle(false);
				setCircle(false);
				setDonut(false);
				
				btnPoint.setEnabled(true);
				btnLine.setEnabled(true);
				{btnRectangle.setEnabled(true);
				btnCircle.setEnabled(true);
				btnDonut.setEnabled(true);
				}
			}
		});
		btnDeselct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDeselct = new GridBagConstraints();
		gbc_btnDeselct.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeselct.gridx = 6;
		gbc_btnDeselct.gridy = 2;
		panelNorth.add(btnDeselct, gbc_btnDeselct);
		
		JButton btnEdit = new JButton("Uredi");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flg = false;
				for(Shape s: panelCenter.getShapes()) {
					if(s.isSelected())
						flg = true;
				}
				if(flg) {
					for(int i = 0; i < panelCenter.getShapes().size(); i++) {
						Shape s = panelCenter.getShapes().get(i);
						if(s.isSelected()) {
							if(s instanceof Point) {
								Point p = (Point) s;
								DlgPoint dijalog = new DlgPoint();
								dijalog.setTextFieldX(Integer.toString(p.getx()));
								dijalog.setTextFieldY(Integer.toString(p.gety()));
								dijalog.setVisible(true);
								dijalog.setModal(true);
								if(dijalog.isOK()) {
									p.moveTo(Integer.parseInt(dijalog.getTextFieldX().getText()), Integer.parseInt(dijalog.getTextFieldY().getText()));
									p.setBorderColor(dijalog.getPanelPointColor().getBackground());
								}
								panelCenter.repaint();
								
							}
							else if(s instanceof Line) {
								Line l = (Line) s;
								DlgLine dijalog = new DlgLine();
								dijalog.setTextFieldX1(Integer.toString(l.getstartPoint().getx()));
								dijalog.setTextFieldY1(Integer.toString(l.getstartPoint().gety()));
								dijalog.setTextFieldX2(Integer.toString(l.getendPoitnt().getx()));
								dijalog.setTextFieldY2(Integer.toString(l.getendPoitnt().gety()));
								dijalog.getPanelLineColor().setBackground(l.getBorderColor());
								dijalog.setVisible(true);
								dijalog.setModal(true);
								if(dijalog.isOK())
								{
									l.setstartPoint(new Point(Integer.parseInt(dijalog.getTextFieldX1().getText()), Integer.parseInt(dijalog.getTextFieldY1().getText())));
									l.setendPoint(new Point(Integer.parseInt(dijalog.getTextFieldX2().getText()), Integer.parseInt(dijalog.getTextFieldY2().getText())));
									l.setBorderColor(dijalog.getPanelLineColor().getBackground());
								}						
								panelCenter.repaint();
							} 
							else if(s instanceof Rectangle) {
								Rectangle r = (Rectangle) s;
								DlgRectangle dijalog = new DlgRectangle();
								dijalog.setTextFieldX(Integer.toString(r.getUpperLeft().getx()));
								dijalog.setTextFieldY(Integer.toString(r.getUpperLeft().gety()));
								dijalog.setTextFieldWidth(Integer.toString(r.getWidth()));
								dijalog.setTextFieldHeight(Integer.toString(r.getHeight()));
								dijalog.getPanelBorderColor().setBackground(r.getBorderColor());
								dijalog.getPanelFillColor().setBackground(r.getFillColor());
								dijalog.setVisible(true);
								dijalog.setModal(true);
								if(!dijalog.isOK())
								{
									r.moveTo(Integer.parseInt(dijalog.getTextFieldX().getText()), Integer.parseInt(dijalog.getTextFieldY().getText()));
									r.setWidth(Integer.parseInt(dijalog.getTextFieldWidth().getText()));
									r.setHeight(Integer.parseInt(dijalog.getTextFieldHeight().getText()));
									r.setBorderColor(dijalog.getPanelBorderColor().getBackground());
									r.setFillColor(dijalog.getPanelFillColor().getBackground());
								}							
								panelCenter.repaint();
							}
							else if(s instanceof Circle) {
								Circle c = (Circle) s;
								DlgCircle dijalog = new DlgCircle();
								dijalog.setTextFieldX(Integer.toString(c.getCenter().getx()));
								dijalog.setTextFieldY(Integer.toString(c.getCenter().gety()));
								dijalog.setTextFieldRadius(Integer.toString(c.getRadius()));
								dijalog.getPanelBorderColor().setBackground(c.getBorderColor());
								dijalog.getPanelFillColor().setBackground(c.getFillColor());
								dijalog.setVisible(true);
								dijalog.setModal(true);
								if(!dijalog.isOK())
								{
									c.moveTo(Integer.parseInt(dijalog.getTextFieldX().getText()), Integer.parseInt(dijalog.getTextFieldY().getText()));
									//c.setRadius(Integer.parseInt(dijalog.getTextFieldRadius().getText()));
									c.setBorderColor(dijalog.getPanelBorderColor().getBackground());
									c.setFillColor(dijalog.getPanelFillColor().getBackground());
								}							
								panelCenter.repaint();
							}
							else if(s instanceof Donut) {
								Donut d = (Donut) s;
								DlgDonut dijalog = new DlgDonut();
								dijalog.setTextFieldX(Integer.toString(d.getCenter().getx()));
								dijalog.setTextFieldY(Integer.toString(d.getCenter().gety()));
								dijalog.setTextFieldRadiusOut(Integer.toString(d.getRadius()));
								dijalog.setTextFieldRadiusIn(Integer.toString(d.getInnerRadius()));
								dijalog.getPanelBorderColor().setBackground(d.getBorderColor());
								dijalog.getPanelFillColor().setBackground(d.getFillColor());
								dijalog.setVisible(true);
								dijalog.setModal(true);
								if(!dijalog.isOK())
								{
									d.moveTo(Integer.parseInt(dijalog.getTextFieldX().getText()), Integer.parseInt(dijalog.getTextFieldY().getText()));
									//d.setRadius(Integer.parseInt(dijalog.getTextFieldRadiusOut().getText()));
									d.setInnerRadius(Integer.parseInt(dijalog.getTextFieldRadiusIn().getText()));
									d.setBorderColor(dijalog.getPanelBorderColor().getBackground());
									d.setFillColor(dijalog.getPanelFillColor().getBackground());
								}							
								panelCenter.repaint();
							}
							else {
								
							}
						}
						
					}
				}
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.anchor = GridBagConstraints.NORTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 8;
		gbc_btnEdit.gridy = 2;
		panelNorth.add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Obriši");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flag = false;
				for(Shape s: panelCenter.getShapes())
				{
					if(s.isSelected())
					{
						flag = true;
					}
				}
				if(flag)
				{
					DlgConfirm dijalog = new DlgConfirm();
					dijalog.setVisible(true);
					dijalog.setModal(true);
					if (dijalog.isOK()) {
					    panelCenter.getShapes().removeIf(Shape::isSelected);
					    panelCenter.repaint();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Morate prvo selektovati objekat koji želite da obrišete");
				}
				panelCenter.repaint();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 9;
		gbc_btnDelete.gridy = 2;
		panelNorth.add(btnDelete, gbc_btnDelete);
		
		panelCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(point) {
					Point point = new Point(e.getX(),e.getY());
					panelCenter.getShapes().add(0, point);
					panelCenter.repaint();
				}
				else if(line) {
					Point point = new Point(e.getX(),e.getY());
					cnt++;
					if(cnt == 1)
						panelCenter.getShapes().add(0, point);
					else if(cnt == 2) {
						panelCenter.getShapes().add(0, point);
						Line line = new Line((Point)panelCenter.getShapes().get(0), (Point)panelCenter.getShapes().get(1));
						panelCenter.getShapes().remove(0);
						panelCenter.getShapes().remove(0);
						panelCenter.getShapes().add(0, line);
						cnt = 0;
					}
					panelCenter.repaint();
					
				}
				else if(rectangle) {
					Point point = new Point(e.getX(),e.getY());
					panelCenter.getShapes().add(0, point);
					panelCenter.repaint();
					DlgRectangle dijalog = new DlgRectangle();
					dijalog.setTextFieldX(Integer.toString(point.getx()));
					dijalog.getTextFieldX().setEditable(false);
					dijalog.setTextFieldY(Integer.toString(point.gety()));
					dijalog.getTextFieldY().setEditable(false);
					dijalog.setVisible(true);
					dijalog.setModal(true);
					if(dijalog.isOK()) {
						Rectangle rectangle = new Rectangle(point, Integer.parseInt(dijalog.getTextFieldWidth().toString()), Integer.parseInt(dijalog.getTextFieldHeight().toString()));
						rectangle.setBorderColor(dijalog.getPanelBorderColor().getBackground());
						rectangle.setFillColor(dijalog.getPanelFillColor().getBackground());

						panelCenter.getShapes().add(0, rectangle);
						panelCenter.getShapes().remove(0);
					}
					else
						panelCenter.getShapes().remove(0);
					panelCenter.repaint();
					}
				else if(circle) {
					Point point = new Point(e.getX(), e.getY());
					panelCenter.getShapes().add(0, point);
					panelCenter.repaint();
					DlgCircle dijalog = new DlgCircle();
					dijalog.setTextFieldX(Integer.toString(point.getx()));
					dijalog.getTextFieldX().setEditable(false);
					dijalog.setTextFieldY(Integer.toString(point.gety()));
					dijalog.getTextFieldY().setEditable(false);
					dijalog.setVisible(true);
					dijalog.setModal(true);
					if(dijalog.isOK()) {
						Circle circle = new Circle(point, Integer.parseInt(dijalog.getTextFieldRadius().toString()));
						circle.setBorderColor(dijalog.getPanelBorderColor().getBackground());
						circle.setFillColor(dijalog.getPanelFillColor().getBackground());
						panelCenter.getShapes().add(0, circle);
						panelCenter.getShapes().remove(0);
					}
					else
						panelCenter.getShapes().remove(0);
				}
				else if(donut) {
					Point point = new Point(e.getX(), e.getY());
					panelCenter.getShapes().add(0, point);
					panelCenter.repaint();
					DlgDonut dijalog = new DlgDonut();
					dijalog.setTextFieldX(Integer.toString(point.getx()));
					dijalog.getTextFieldX().setEditable(false);
					dijalog.setTextFieldY(Integer.toString(point.gety()));
					dijalog.getTextFieldY().setEditable(false);
					dijalog.setVisible(true);
					dijalog.setModal(true);
					if(dijalog.isOK()) {
						Donut donut = new Donut(point, Integer.parseInt(dijalog.getTextFieldRadiusOut().toString()), Integer.parseInt(dijalog.getTextFieldRadiusIn().toString()));
						donut.setBorderColor(dijalog.getPanelBorderColor().getBackground());
						donut.setFillColor(dijalog.getPanelFillColor().getBackground());
						panelCenter.getShapes().add(0, donut);
						panelCenter.getShapes().remove(0);						
					}
					else
						panelCenter.getShapes().remove(0);
				}
				else {
					for(Shape s: panelCenter.getShapes())
						s.setSelected(false);
					for(Shape s: panelCenter.getShapes()) {
						if(s.contains(e.getX(), e.getY())){
							s.setSelected(true);
							break;
							}
					}
					panelCenter.repaint();
				}
			}
		});
		contentPane.add(panelCenter, BorderLayout.CENTER);
	}

	public boolean isPoint() {
		return point;
	}

	public void setPoint(boolean point) {
		this.point = point;
	}

	public boolean isLine() {
		return line;
	}

	public void setLine(boolean line) {
		this.line = line;
	}

	public boolean isRectangle() {
		return rectangle;
	}

	public void setRectangle(boolean rectangle) {
		this.rectangle = rectangle;
	}

	public boolean isCircle() {
		return circle;
	}

	public void setCircle(boolean circle) {
		this.circle = circle;
	}

	public boolean isDonut() {
		return donut;
	}

	public void setDonut(boolean donut) {
		this.donut = donut;
	}

}
