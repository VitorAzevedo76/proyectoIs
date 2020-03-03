import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class ventanaFinal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private	JButton bMatriz[][];
	private int DimX;
	private int DimY;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaFinal frame = new ventanaFinal(5,5);
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
	public ventanaFinal(int x, int y) {
		panel= new JPanel();
		DimX=x;
		DimY=y;
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
		bMatriz = new JButton[DimX][DimY];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(DimX, DimY, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLblNewLabel(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("X: 0 Y: 0");
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
	
	    panel.setLayout(new GridLayout(DimX,DimY));

	    for(int f=0;f<DimX;f++){
	      for(int c=0;c<DimY;c++){
	    	JButton boton=new JButton(""+f+","+c);
	        bMatriz[f][c] = boton;
	        bMatriz[f][c].setBounds(5,5,0,0);

	        panel.setBounds(140,15,270,300);
	        panel.add(bMatriz[f][c]); 
	        boton.addMouseListener(new controlador(f,c));
	        boton.addActionListener(new ControladorB(f,c));

	      }
	    }
	    return panel;
		
	}
	private class controlador implements MouseListener{
		private int x;
		private int y;
		public controlador(int f, int c) {
			x=f; y=c;
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			lblNewLabel.setText("X: "+x+" Y: "+y);
			
		}


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
	private class ControladorB implements ActionListener {
		private int x;
		private int y;
		public ControladorB(int f, int c) {
			x=f; y=c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(bMatriz[x][y], "X: "+x+" Y: "+y);
			
		}

	}
}
