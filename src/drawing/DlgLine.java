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

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX2;
	private JTextField textFieldY2;
	public boolean OK = false;
	private JTextField textFieldX1;
	private JTextField textFieldY1;
	private JPanel panelLineColor = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setResizable(false);
		setTitle("Linija");
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
			gbl_PnlCenter.rowHeights = new int[]{0, 0, 10, 0, 0, 0, 10, 0};
			gbl_PnlCenter.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_PnlCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			PnlCenter.setLayout(gbl_PnlCenter);
			{
				JLabel lblX1 = new JLabel("X koordinata prve tačke:");
				lblX1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblX1 = new GridBagConstraints();
				gbc_lblX1.insets = new Insets(0, 0, 5, 5);
				gbc_lblX1.gridx = 1;
				gbc_lblX1.gridy = 1;
				PnlCenter.add(lblX1, gbc_lblX1);
			}
			{
				textFieldX1 = new JTextField();
				textFieldX1.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldX1 = new GridBagConstraints();
				gbc_textFieldX1.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldX1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldX1.gridx = 3;
				gbc_textFieldX1.gridy = 1;
				PnlCenter.add(textFieldX1, gbc_textFieldX1);
				textFieldX1.setColumns(10);
			}
			{
				JLabel lblY1 = new JLabel("Y koordinata prve tačke:");
				lblY1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblY1 = new GridBagConstraints();
				gbc_lblY1.insets = new Insets(0, 0, 5, 5);
				gbc_lblY1.gridx = 1;
				gbc_lblY1.gridy = 2;
				PnlCenter.add(lblY1, gbc_lblY1);
			}
			{
				textFieldY1 = new JTextField();
				textFieldY1.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldY1 = new GridBagConstraints();
				gbc_textFieldY1.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldY1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldY1.gridx = 3;
				gbc_textFieldY1.gridy = 2;
				PnlCenter.add(textFieldY1, gbc_textFieldY1);
				textFieldY1.setColumns(10);
			}
			{
				JLabel lblX2 = new JLabel("X koordinata druge tačke:");
				lblX2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblX2 = new GridBagConstraints();
				gbc_lblX2.anchor = GridBagConstraints.EAST;
				gbc_lblX2.insets = new Insets(0, 0, 5, 5);
				gbc_lblX2.gridx = 1;
				gbc_lblX2.gridy = 3;
				PnlCenter.add(lblX2, gbc_lblX2);
			}
			{
				textFieldX2 = new JTextField();
				textFieldX2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldX2 = new GridBagConstraints();
				gbc_textFieldX2.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldX2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldX2.gridx = 3;
				gbc_textFieldX2.gridy = 3;
				PnlCenter.add(textFieldX2, gbc_textFieldX2);
				textFieldX2.setColumns(10);
			}
			{
				JLabel lblY2 = new JLabel("Y koordinata druge tačke:");
				lblY2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblY2 = new GridBagConstraints();
				gbc_lblY2.anchor = GridBagConstraints.EAST;
				gbc_lblY2.insets = new Insets(0, 0, 5, 5);
				gbc_lblY2.gridx = 1;
				gbc_lblY2.gridy = 4;
				PnlCenter.add(lblY2, gbc_lblY2);
			}
			{
				textFieldY2 = new JTextField();
				textFieldY2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldY2 = new GridBagConstraints();
				gbc_textFieldY2.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldY2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldY2.gridx = 3;
				gbc_textFieldY2.gridy = 4;
				PnlCenter.add(textFieldY2, gbc_textFieldY2);
				textFieldY2.setColumns(10);
			}
			{
				JLabel lblColor = new JLabel("Boja linije:");
				lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblColor = new GridBagConstraints();
				gbc_lblColor.anchor = GridBagConstraints.EAST;
				gbc_lblColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblColor.gridx = 1;
				gbc_lblColor.gridy = 5;
				PnlCenter.add(lblColor, gbc_lblColor);
			}
			{
				JPanel panelColor = new JPanel();
				panelColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Color color = JColorChooser.showDialog(panelColor, "Izaberite boju ivica:", panelColor.getBackground());
						panelColor.setBackground(color);
					}
				});
				panelColor.setBackground(Color.BLACK);
				//panelBorderColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				GridBagConstraints gbc_panelColor = new GridBagConstraints();
				gbc_panelColor.insets = new Insets(0, 0, 5, 5);
				gbc_panelColor.fill = GridBagConstraints.BOTH;
				gbc_panelColor.gridx = 3;
				gbc_panelColor.gridy = 5;
				PnlCenter.add(panelColor, gbc_panelColor);
			}
		}
		{
			JPanel panelNorth = new JPanel();
			contentPanel.add(panelNorth, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Linija");
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
						if((textFieldX1.getText().isBlank() || textFieldY1.getText().isBlank() || textFieldX2.getText().isBlank() || textFieldY2.getText().isBlank())) {
							JOptionPane.showMessageDialog(null, "Molimo popunite sva polja.");
						}
						else {
							int  x1 = Integer.parseInt(textFieldX1.getText());
							int  y1 = Integer.parseInt(textFieldY1.getText());
							int  x2 = Integer.parseInt(textFieldX2.getText());
							int  y2 = Integer.parseInt(textFieldY2.getText());
							if(x1 == 0 || y1 == 0 || x2 == 0 || y2 == 0) 
								JOptionPane.showMessageDialog(null, "Vrednosti ne smeju biti 0.");
							else {
								setTextFieldX1(textFieldX1.getText());
								setTextFieldY1(textFieldY1.getText());
								setTextFieldX2(textFieldX2.getText());
								setTextFieldY2(textFieldY2.getText());
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

	public JTextField getTextFieldX2() {
		return textFieldX2;
	}

	public void setTextFieldX2(String textFieldX2) {
		this.textFieldX2.setText(textFieldX2);
	}

	public JTextField getTextFieldY2() {
		return textFieldY2;
	}

	public void setTextFieldY2(String textFieldY2) {
		this.textFieldY2.setText(textFieldY2);
	}

	public JTextField getTextFieldX1() {
		return textFieldX1;
	}

	public void setTextFieldX1(String textFieldX1) {
		this.textFieldX1.setText(textFieldX1);
	}

	public JTextField getTextFieldY1() {
		return textFieldY1;
	}

	public void setTextFieldY1(String textFieldY1) {
		this.textFieldY1.setText(textFieldY1);
	}
	
	

	public JPanel getPanelLineColor() {
		return panelLineColor;
	}

	public void setPanelLineColor(JPanel panelLineColor) {
		this.panelLineColor = panelLineColor;
	}

	public boolean isOK() {
		return OK;
	}

	public void setOK(boolean oK) {
		OK = oK;
	}

	
}
