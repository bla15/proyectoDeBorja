package JOptionPaneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.border.LineBorder;

import fondos.logicaFondos;
import ventanas.ventanaGame;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class opcionesMusica implements  ActionListener{

	public JDialog frame;
	public static opcionesMusica window;
	
	//botones
	private JRadioButton jrBoton1;
	private JRadioButton jrBoton2;
	private JRadioButton jrBoton3;
	JButton btnSalir;
	
	private ButtonGroup grupoBotones;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new opcionesMusica();
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
	public opcionesMusica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog(ventanaGame.frame);
		frame.setBounds(400, 250, 200, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(600, 200); 
		frame.setResizable(false); 
		
		logicaFondos panelInicioFondo = new logicaFondos("/JOptionPaneles/malla.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setBorder(new LineBorder(Color.WHITE, 4));
		panelInicioFondo.setLayout(null);
		
		logicaFondos panelFoto1 = new logicaFondos("/fondos/claveSol.png");
		panelFoto1.setBorder(new LineBorder(Color.WHITE, 4));
		panelFoto1.setLayout(null);
		panelFoto1.setBounds(34, 49, 87, 120);
		panelInicioFondo.add(panelFoto1);
		
		logicaFondos panelFoto2 = new logicaFondos("/fondos/claveSol.png");
		panelFoto2.setBorder(new LineBorder(Color.WHITE, 4));
		panelFoto2.setLayout(null);
		panelFoto2.setBounds(457, 49, 87, 120);
		panelInicioFondo.add(panelFoto2);
		
		JLabel labelTitulo = new JLabel("Musica");
		labelTitulo.setForeground(Color.RED);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Impact", Font.PLAIN, 50));
		labelTitulo.setBorder(new LineBorder(Color.red, 4));
		labelTitulo.setBounds(142, 11, 281, 51);
		panelInicioFondo.add(labelTitulo);
		
		grupoBotones  = new ButtonGroup();
		
		
		jrBoton1 = new JRadioButton("New radio button");
		jrBoton1.setBounds(133, 87, 109, 23);
		jrBoton1.addActionListener(this);
		grupoBotones.add(jrBoton1);
		panelInicioFondo.add(jrBoton1);
		
		jrBoton2 = new JRadioButton("New radio button");
		jrBoton2.setBounds(133, 127, 109, 23);
		jrBoton2.addActionListener(this);
		grupoBotones.add(jrBoton2);
		panelInicioFondo.add(jrBoton2);
		
		jrBoton3 = new JRadioButton("New radio button");
		jrBoton3.setBounds(281, 87, 109, 23);
		jrBoton3.addActionListener(this);
		grupoBotones.add(jrBoton3);
		panelInicioFondo.add(jrBoton3);
		
		btnSalir= new JButton("");
		btnSalir.setIcon(new ImageIcon(opcionesMusica.class.getResource("/fotosBotones/exit.png")));
		btnSalir.setBounds(295, 127, 62, 51);
		btnSalir.addActionListener(this);
		panelInicioFondo.add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSalir) {
			this.window.frame.dispose();
		}
		
	}
}
