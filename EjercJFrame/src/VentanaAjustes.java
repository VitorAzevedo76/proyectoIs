import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class VentanaAjustes extends JDialog {
	private JPanel panel;
	private JButton btnAceptar;
	private JPanel panel_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAjustes dialog = new VentanaAjustes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAjustes() {

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
		setTitle("Selecciona el tamaño de la ventana");
		setBounds(100, 100, 346, 115);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		ButtonGroup g = new ButtonGroup();
		g.add(rdbtnNewRadioButton);
		g.add(rdbtnNewRadioButton_1);
		g.add(rdbtnx);
		btnAceptar.addActionListener(new Controlador());
		
		
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnAceptar());
		}
		return panel;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
		}
		return btnAceptar;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getRdbtnNewRadioButton());
			panel_1.add(getRdbtnNewRadioButton_1());
			panel_1.add(getRdbtnx());
		}
		return panel_1;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("3x3");
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("5x5");
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnx() {
		if (rdbtnx == null) {
			rdbtnx = new JRadioButton("10x10");
		}
		return rdbtnx;
	}
	
	private class Controlador implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rdbtnNewRadioButton.isSelected()) {
				VentanaAjustes.this.dispose();
				ventanaFinal vf= new ventanaFinal(3,3);
				
			}
			else if(rdbtnNewRadioButton_1.isSelected()) {
				VentanaAjustes.this.dispose();
				ventanaFinal vf= new ventanaFinal(5,5);
			}
			else {
				VentanaAjustes.this.dispose();
				ventanaFinal vf= new ventanaFinal(10,10);
			}
			
		}
		
	}
}
