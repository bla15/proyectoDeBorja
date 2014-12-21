package presentaciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import logicaTitulos.logicaMapa;
import fondos.logicaFondos;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import ventanas.ventanaGame;
import ventanas.ventanaRegistro;


public class presentacion0 implements KeyListener, ActionListener{

	public JFrame frame;
	public static presentacion0 window;
	
	static logicaMapa cartel;
	private JScrollPane scrollPane;
	private JTextPane txtpnEstasAPunto;
	private JLabel lblNewLabel;
	private JButton bContinuar;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new presentacion0();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public presentacion0() {
		cartel = new logicaMapa();
		cartel.setLocation(450, 10);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 200, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(700,450); 
		frame.setResizable(false); 
		
		logicaFondos panelInicioFondo = new logicaFondos("/fondos/tierra.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(null);	
		
		panelInicioFondo.add(cartel);
		
		lblNewLabel = new JLabel("INFORME DE BASE");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(196, 134, 306, 56);
		panelInicioFondo.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(181, 207, 269, 90);
		panelInicioFondo.add(scrollPane);
		
		txtpnEstasAPunto = new JTextPane();
		txtpnEstasAPunto.setForeground(new Color(0, 0, 0));
		txtpnEstasAPunto.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 13));
		txtpnEstasAPunto.setText("Estas a punto de enbarcarte en una mision de defensa, preparate en breves entraras en combate. Los enemigos estan rodeando la tierra, hay que expulsarlos antes de que sus naves aterricen. El consejo te ha asignado defender la zona ALPHA, en esta zona se espera una fuerte incursi\u00F3n enemiga de gran escala. Por si no t acuerdas la zona designada es la luna. Suerte y que no hagas prisioneros");
		txtpnEstasAPunto.setToolTipText(" ");
		txtpnEstasAPunto.setEditable(false);
		scrollPane.setViewportView(txtpnEstasAPunto);
		
		bContinuar = new JButton("");
		bContinuar.setIcon(new ImageIcon(presentacion0.class.getResource("/fotosBotones/1417460652_Shift.png")));
		bContinuar.setBounds(494, 367, 155, 35);
		bContinuar.addActionListener(this);
		panelInicioFondo.add(bContinuar);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bContinuar){
			
		
			ventanaRegistro.window.frame.dispose();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
							
						ventanaGame.window = new ventanaGame();
						ventanaGame.window.frame.setVisible(true);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			this.window.frame.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
