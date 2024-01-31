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

public class DlgPoint extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JPanel panelPointColor = new JPanel();
	public boolean OK = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setResizable(false);
		setTitle("Tačka");
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
			gbl_PnlCenter.rowHeights = new int[]{10, 0, 0, 0, 10, 0};
			gbl_PnlCenter.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_PnlCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			PnlCenter.setLayout(gbl_PnlCenter);
			{
				JLabel lblX = new JLabel("X koordinata tačke:");
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
				JLabel lblY = new JLabel("Y koordinata tačke:");
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
				JLabel lblColor = new JLabel("Boja tačke:");
				lblColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
				GridBagConstraints gbc_lblColor = new GridBagConstraints();
				gbc_lblColor.anchor = GridBagConstraints.EAST;
				gbc_lblColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblColor.gridx = 1;
				gbc_lblColor.gridy = 3;
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
				gbc_panelColor.gridy = 3;
				PnlCenter.add(panelColor, gbc_panelColor);
			}
		}
		{
			JPanel panelNorth = new JPanel();
			contentPanel.add(panelNorth, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Tačka");
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
						if((textFieldX.getText().isBlank() || textFieldY.getText().isBlank())) {
							JOptionPane.showMessageDialog(null, "Molimo popunite sva polja.");
						}
						else {
							int  x = Integer.parseInt(textFieldX.getText());
							int  y = Integer.parseInt(textFieldY.getText());
							if(x == 0 || y == 0) 
								JOptionPane.showMessageDialog(null, "Vrednosti ne smeju biti 0.");
							else {
								setTextFieldX(textFieldX.getText());
								setTextFieldY(textFieldY.getText());
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

	public JPanel getPanelPointColor() {
		return panelPointColor;
	}

	public void setPanelPointColor(JPanel panelPointColor) {
		this.panelPointColor = panelPointColor;
	}

	public boolean isOK() {
		return OK;
	}

	public void setOK(boolean oK) {
		OK = oK;
	}

	
}
