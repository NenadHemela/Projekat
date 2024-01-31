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

public class DlgRectangle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	public boolean OK = false;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JPanel panelBorderColor = new JPanel();
	private JPanel panelFillColor = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setResizable(false);
		setTitle("Pravougaonik");
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
			gbl_PnlCenter.rowHeights = new int[]{0, 0, 10, 0, 0, 0, 20, 20, 0};
			gbl_PnlCenter.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_PnlCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			PnlCenter.setLayout(gbl_PnlCenter);
			{
				JLabel lblX = new JLabel("X koordinata gornje leve tačke:");
				lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblX = new GridBagConstraints();
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
				JLabel lblY = new JLabel("Y koordinata gornje leve tačke:");
				lblY.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblY = new GridBagConstraints();
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
				JLabel lblHeight = new JLabel("Visina pravougaonika:");
				lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblHeight = new GridBagConstraints();
				gbc_lblHeight.anchor = GridBagConstraints.EAST;
				gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHeight.gridx = 1;
				gbc_lblHeight.gridy = 3;
				PnlCenter.add(lblHeight, gbc_lblHeight);
			}
			{
				textFieldHeight = new JTextField();
				textFieldHeight.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
				gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldHeight.gridx = 3;
				gbc_textFieldHeight.gridy = 3;
				PnlCenter.add(textFieldHeight, gbc_textFieldHeight);
				textFieldHeight.setColumns(10);
			}
			{
				JLabel lblWidth = new JLabel("Širina pravougaonika:");
				lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblWidth = new GridBagConstraints();
				gbc_lblWidth.anchor = GridBagConstraints.EAST;
				gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
				gbc_lblWidth.gridx = 1;
				gbc_lblWidth.gridy = 4;
				PnlCenter.add(lblWidth, gbc_lblWidth);
			}
			{
				textFieldWidth = new JTextField();
				textFieldWidth.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER){
						}
						else
							e.consume();
					}
				});
				GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
				gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldWidth.gridx = 3;
				gbc_textFieldWidth.gridy = 4;
				PnlCenter.add(textFieldWidth, gbc_textFieldWidth);
				textFieldWidth.setColumns(10);
			}
			{
				JLabel lblFillColor = new JLabel("Boja ispune:");
				lblFillColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblFillColor = new GridBagConstraints();
				gbc_lblFillColor.anchor = GridBagConstraints.EAST;
				gbc_lblFillColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblFillColor.gridx = 1;
				gbc_lblFillColor.gridy = 5;
				PnlCenter.add(lblFillColor, gbc_lblFillColor);
			}
			{
				JPanel panelFillColor = new JPanel();
				panelFillColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Color color = JColorChooser.showDialog(panelFillColor, "Izaberite boju ivica:", panelFillColor.getBackground());
						panelFillColor.setBackground(color);
					}
				});
				panelFillColor.setBackground(Color.BLACK);
				panelFillColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				GridBagConstraints gbc_panelFillColor = new GridBagConstraints();
				gbc_panelFillColor.insets = new Insets(0, 0, 5, 5);
				gbc_panelFillColor.fill = GridBagConstraints.BOTH;
				gbc_panelFillColor.gridx = 3;
				gbc_panelFillColor.gridy = 5;
				PnlCenter.add(panelFillColor, gbc_panelFillColor);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Boja ivica:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 6;
				PnlCenter.add(lblNewLabel_1, gbc_lblNewLabel_1);
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
				panelBorderColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panelBorderColor.setBackground(Color.BLACK);
				GridBagConstraints gbc_panelBorderColor = new GridBagConstraints();
				gbc_panelBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_panelBorderColor.fill = GridBagConstraints.BOTH;
				gbc_panelBorderColor.gridx = 3;
				gbc_panelBorderColor.gridy = 6;
				PnlCenter.add(panelBorderColor, gbc_panelBorderColor);
			}
		}
		{
			JPanel panelNorth = new JPanel();
			contentPanel.add(panelNorth, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Pravougaonik");
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
						if((textFieldX.getText().isBlank() || textFieldY.getText().isBlank() || textFieldHeight.getText().isBlank() || textFieldWidth.getText().isBlank())) {
							JOptionPane.showMessageDialog(null, "Molimo popunite sva polja.");
						}
						else {
							int  x1 = Integer.parseInt(textFieldX.getText());
							int  y1 = Integer.parseInt(textFieldY.getText());
							int  height = Integer.parseInt(textFieldHeight.getText());
							int  width = Integer.parseInt(textFieldWidth.getText());
							if(x1 == 0 || y1 == 0 || height == 0 || width == 0) 
								JOptionPane.showMessageDialog(null, "Vrednosti ne smeju biti 0.");
							else {
								setTextFieldX(textFieldX.getText());
								setTextFieldY(textFieldY.getText());
								setTextFieldHeight(textFieldHeight.getText());
								setTextFieldWidth(textFieldWidth.getText());
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

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(String textFieldHeight) {
		this.textFieldHeight.setText(textFieldHeight);
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(String textFieldWidth) {
		this.textFieldWidth.setText(textFieldWidth);
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

	public boolean isOK() {
		return OK;
	}
	
	public void setOK(boolean oK) {
		OK = oK;
	}

	
}
