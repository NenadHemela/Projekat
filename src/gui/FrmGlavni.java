package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class FrmGlavni extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Circle> circle = new ArrayList<Circle>();
	ArrayList<Circle> circleOrder = new ArrayList<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGlavni frame = new FrmGlavni();
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
	public FrmGlavni() {
		setTitle("Hemela Nenad MH65/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 20, 0, 20, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		
		
		JButton btnAdd = new JButton("Dodaj novi krug");
		btnAdd.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        DlgDodaj dijalog = new DlgDodaj();
		        dijalog.setModal(true);
		        dijalog.setVisible(true);
				circle.add(0, new Circle(new Point(Integer.parseInt(dijalog.getTextFieldX().getText()) ,Integer.parseInt(dijalog.getTextFieldY().getText())), Integer.parseInt(dijalog.getTextFieldRadius().getText())));
				circleOrder.add(0, new Circle(new Point(Integer.parseInt(dijalog.getTextFieldX().getText()) ,Integer.parseInt(dijalog.getTextFieldY().getText())), Integer.parseInt(dijalog.getTextFieldRadius().getText())));
				listInputNoDuplicates(circle.get(0).toString(), dlm);
		    }    
		});
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 1;
		panel.add(btnAdd, gbc_btnAdd);
		
		JButton btnDelete = new JButton("Ukloni krug");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!dlm.isEmpty())
				{
					DlgDodaj dijalog = new DlgDodaj();
					
					dijalog.setTextFieldX(Integer.toString(circleOrder.get(0).getCenter().getx()));
					dijalog.setTextFieldY(Integer.toString(circleOrder.get(0).getCenter().gety()));
					dijalog.setTextFieldRadius(Integer.toString(circleOrder.get(0).getRadius()));
					dijalog.getTextFieldX().setEditable(false);
					dijalog.getTextFieldY().setEditable(false);
					dijalog.getTextFieldRadius().setEditable(false);
					dijalog.setModal(true);
					dijalog.setVisible(true);
					if(dijalog.isOK())
					{
						for(int i = 0; i < circle.size(); i++) {
							if(circle.get(i).equals(circleOrder.get(0))) {
								circle.remove(i);
								dlm.remove(i);
							}
									
						}
						circleOrder.remove(0);
					}
					
				}
				else
					JOptionPane.showMessageDialog(null, "Lista krugova je prazna.");
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 3;
		panel.add(btnDelete, gbc_btnDelete);
		
		JButton btnSort = new JButton("Soriraj ");
		btnSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!dlm.isEmpty()) {
					circle.sort(new Comparator<Circle>() {
						@Override
						public int compare(Circle c1, Circle c2) {
							return (int) (c1.area() - c2.area());
						}
					});
					dlm.removeAllElements();
					for(Circle c: circle) {
						listInputNoDuplicates(c.toString(),dlm);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Lista krugova je prazna.");
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSort.insets = new Insets(0, 0, 5, 5);
		gbc_btnSort.gridx = 1;
		gbc_btnSort.gridy = 5;
		panel.add(btnSort, gbc_btnSort);
	}
	
	public void listInputNoDuplicates(String input,  DefaultListModel<String> dlm) {
		if(dlm.contains(input) || input.isBlank()) {
			return;
		}
		else {
			dlm.add(0, input);
		}
	}
}
