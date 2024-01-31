package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	private JPanel panelBorderColor = new JPanel();
	private JPanel panelFillColor = new JPanel(); 
	public boolean OK = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setResizable(false);
		setTitle("Krug");
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel PnlCenter = new JPanel();
			contentPanel.add(PnlCenter, BorderLayout.CENTER);
			GridBagLayout gbl_PnlCenter = new GridBagLayout();
			gbl_PnlCenter.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
			gbl_PnlCenter.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 10, 0};
			gbl_PnlCenter.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_PnlCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			PnlCenter.setLayout(gbl_PnlCenter);
			{
				JLabel lblX = new JLabel("X koordinata centra:");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblX = new GridBagConstraints();
				gbc_lblX.anchor = GridBagConstraints.EAST;
				gbc_lblX.insets = new Insets(0, 0, 5, 5);
				gbc_lblX.gridx = 1;
				gbc_lblX.gridy = 1;
				PnlCenter.add(lblX, gbc_lblX);
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
				gbc_textFieldX.gridx = 3;
				gbc_textFieldX.gridy = 1;
				PnlCenter.add(textFieldX, gbc_textFieldX);
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
				PnlCenter.add(lblY, gbc_lblY);
			}
			{
				textFieldY = new JTextField();
				textFieldY.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldY = new GridBagConstraints();
				gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldY.gridx = 3;
				gbc_textFieldY.gridy = 2;
				PnlCenter.add(textFieldY, gbc_textFieldY);
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
				PnlCenter.add(lblRadius, gbc_lblRadius);
			}
			{
				textFieldRadius = new JTextField();
				textFieldRadius.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
				gbc_textFieldRadius.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldRadius.gridx = 3;
				gbc_textFieldRadius.gridy = 3;
				PnlCenter.add(textFieldRadius, gbc_textFieldRadius);
				textFieldRadius.setColumns(10);
			}
			{
				JLabel lblFillColor = new JLabel("Boja ispune:");
				lblFillColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblFillColor = new GridBagConstraints();
				gbc_lblFillColor.anchor = GridBagConstraints.EAST;
				gbc_lblFillColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblFillColor.gridx = 1;
				gbc_lblFillColor.gridy = 4;
				PnlCenter.add(lblFillColor, gbc_lblFillColor);
			}

			{
				JPanel panelFillColor = new JPanel();
				panelFillColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Color color = JColorChooser.showDialog(panelFillColor, "Izabrite boju popune", panelFillColor.getBackground());
						panelFillColor.setBackground(color);
					}
				});
				panelFillColor.setBackground(Color.BLACK);
				//panelFillColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				GridBagConstraints gbc_panelFillColor = new GridBagConstraints();
				gbc_panelFillColor.insets = new Insets(0, 0, 5, 5);
				gbc_panelFillColor.fill = GridBagConstraints.BOTH;
				gbc_panelFillColor.gridx = 3;
				gbc_panelFillColor.gridy = 4;
				PnlCenter.add(panelFillColor, gbc_panelFillColor);
			}
			{
				JLabel lblBorderColor = new JLabel("Boja ivica:");
				lblBorderColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
				gbc_lblBorderColor.anchor = GridBagConstraints.EAST;
				gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblBorderColor.gridx = 1;
				gbc_lblBorderColor.gridy = 5;
				PnlCenter.add(lblBorderColor, gbc_lblBorderColor);
			}
			{
				JPanel panelBorderColor = new JPanel();
				panelBorderColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Color color = JColorChooser.showDialog(panelBorderColor, "Izaberite boju ivica:", panelBorderColor.getBackground());
						panelBorderColor.setBackground(color);
					}
				});
				panelBorderColor.setBackground(Color.BLACK);
				//panelBorderColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				GridBagConstraints gbc_panelBorderColor = new GridBagConstraints();
				gbc_panelBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_panelBorderColor.fill = GridBagConstraints.BOTH;
				gbc_panelBorderColor.gridx = 3;
				gbc_panelBorderColor.gridy = 5;
				PnlCenter.add(panelBorderColor, gbc_panelBorderColor);
			}
		}
		{
			JPanel panelNorth = new JPanel();
			contentPanel.add(panelNorth, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Krug");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				panelNorth.add(lblNewLabel);
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

	public void setTextFieldX(String textFieldX) {
		this.textFieldX.setText(textFieldX);
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(String textFieldY) {
		this.textFieldY.setText(textFieldY);
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(String textFieldRadius) {
		this.textFieldRadius.setText(textFieldRadius);
	}

	public boolean isOK() {
		return OK;
	}

	public JPanel getPanelBorderColor() {
		return panelBorderColor;
	}

	public void setPanelBorderColor(JPanel panelBorderColor) {
		this.panelBorderColor = panelBorderColor;
	}

	public JPanel getPanelFillColor() {
		return panelFillColor;
	}

	public void setPanelFillColor(JPanel panelFillColor) {
		this.panelFillColor = panelFillColor;
	}

	public void setOK(boolean oK) {
		OK = oK;
	}

	
}
