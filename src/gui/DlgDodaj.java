package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class DlgDodaj extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	public boolean OK = false;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDodaj dialog = new DlgDodaj();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDodaj() {
		setResizable(false);
		setTitle("Hemela Nenad MH65/2021");
		setBounds(100, 100, 420, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelNorth = new JPanel();
			contentPanel.add(panelNorth, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Unos kruga");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
				panelNorth.add(lblNewLabel);
			}
		}
		{
			JPanel panelCenter = new JPanel();
			contentPanel.add(panelCenter, BorderLayout.CENTER);
			GridBagLayout gbl_panelCenter = new GridBagLayout();
			gbl_panelCenter.columnWidths = new int[]{0, 0, 74, 0, 0};
			gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panelCenter.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panelCenter.setLayout(gbl_panelCenter);
			{
				JLabel lblX = new JLabel("X koordinata centra:");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblX = new GridBagConstraints();
				gbc_lblX.anchor = GridBagConstraints.EAST;
				gbc_lblX.insets = new Insets(0, 0, 5, 5);
				gbc_lblX.gridx = 1;
				gbc_lblX.gridy = 1;
				panelCenter.add(lblX, gbc_lblX);
			}
			{
				textFieldX = new JTextField();
				textFieldX.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldX = new GridBagConstraints();
				gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldX.gridx = 2;
				gbc_textFieldX.gridy = 1;
				panelCenter.add(textFieldX, gbc_textFieldX);
				textFieldX.setColumns(10);
			}
			{
				JLabel lblY = new JLabel("Y koordinata centra:");
				lblY.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblY = new GridBagConstraints();
				gbc_lblY.anchor = GridBagConstraints.EAST;
				gbc_lblY.insets = new Insets(0, 0, 5, 5);
				gbc_lblY.gridx = 1;
				gbc_lblY.gridy = 2;
				panelCenter.add(lblY, gbc_lblY);
			}
			{
				textFieldY = new JTextField();
				textFieldY.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER) {
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldY = new GridBagConstraints();
				gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldY.gridx = 2;
				gbc_textFieldY.gridy = 2;
				panelCenter.add(textFieldY, gbc_textFieldY);
				textFieldY.setColumns(10);
			}
			{
				JLabel lblRadius = new JLabel("Poluprečnik:");
				lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblRadius = new GridBagConstraints();
				gbc_lblRadius.anchor = GridBagConstraints.EAST;
				gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblRadius.gridx = 1;
				gbc_lblRadius.gridy = 3;
				panelCenter.add(lblRadius, gbc_lblRadius);
			}
			{	
				textFieldRadius = new JTextField();
				textFieldRadius.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER) {
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
				gbc_textFieldRadius.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldRadius.gridx = 2;
				gbc_textFieldRadius.gridy = 3;
				panelCenter.add(textFieldRadius, gbc_textFieldRadius);
				textFieldRadius.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if((textFieldX.getText().isBlank() || textFieldY.getText().isBlank() || textFieldRadius.getText().isBlank())) {
							JOptionPane.showMessageDialog(null, "Molimo popunite sva polja.");
						}
						else {
							int  x = Integer.parseInt(textFieldX.getText());
							int  y = Integer.parseInt(textFieldY.getText());
							int  radius = Integer.parseInt(textFieldRadius.getText());
							if(x == 0 || y == 0 || radius == 0) 
								JOptionPane.showMessageDialog(null, "Vrednosti ne smeju biti 0.");
							else {
								setTextFieldX(textFieldX.getText());
								setTextFieldY(textFieldY.getText());
								setTextFieldRadius(textFieldRadius.getText());
								dispose();
								}
						}
						setOK(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldX(String textFieldX) {
	    this.textFieldX.setText(textFieldX);
	}

	public void setTextFieldY(String textFieldY) {
	    this.textFieldY.setText(textFieldY);
	}

	public void setTextFieldRadius(String textFieldRadius) {
	    this.textFieldRadius.setText(textFieldRadius);
	}


	public boolean isOK() {
		return OK;
	}

	public void setOK(boolean cancel) {
		this.OK = cancel;
	}
	
	
	
}
