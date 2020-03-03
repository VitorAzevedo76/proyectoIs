import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaACESs extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaACESs dialog = new VentanaACESs();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaACESs() {
		initialize();
		vizualizar();
	}
	
	private void vizualizar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
		frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
		setVisible(true);
	}
	private void initialize() {
		setTitle("Ventana de Aceso");
		setBounds(100, 100, 249, 134);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblNewLabel = new JLabel("Usuario");
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contraseña");
			contentPanel.add(lblNewLabel_1);
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						if(passwordField.getText().equals("iso")) {
							VentanaACESs.this.dispose();
							VentanaAjustes ve=new VentanaAjustes(); 
							
							
						}
						else {	
							JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
							passwordField.setText(null);
						}
						 }
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Borrar");
				
				cancelButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						textField.setText(null);
						passwordField.setText(null);
						 }
				});
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
			
		}
	}

}
