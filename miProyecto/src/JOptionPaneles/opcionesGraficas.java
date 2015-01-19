package JOptionPaneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import fondos.logicaFondos;
import ventanas.ventanaGame;
import ventanas.ventanaStart;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class opcionesGraficas implements  ActionListener{

	public JDialog frame;
	public static opcionesGraficas window ;
	
	private JRadioButton jrNave1 ;
	private JRadioButton jrNave2 ;
	private JRadioButton jrLaser1 ;
	private JRadioButton jrLaser2 ;
	private JRadioButton jrLaser3 ;
	JButton btnSalir;
	private ButtonGroup grupoBotones;
	private ButtonGroup grupoBotones2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window= new opcionesGraficas();
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
	public opcionesGraficas() {
		grupoBotones  = new ButtonGroup();
		grupoBotones2  = new ButtonGroup();
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
		
		JLabel labelTitulo = new JLabel("Graficos");
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Impact", Font.PLAIN, 50));
		labelTitulo.setBorder(new LineBorder(Color.GREEN, 4));
		labelTitulo.setBounds(142, 11, 281, 51);
		panelInicioFondo.add(labelTitulo);
		
		JPanel panelNaves = new JPanel();
		panelNaves.setBounds(10, 73, 200, 104);
		panelNaves.setBorder(new LineBorder(Color.BLUE, 4));
		panelNaves.setOpaque(false);
		panelInicioFondo.add(panelNaves);
		panelNaves.setLayout(null);
		
		JLabel tituloNaves = new JLabel("Naves");
		tituloNaves.setBounds(51, 11, 98, 32);
		panelNaves.add(tituloNaves);
		tituloNaves.setHorizontalAlignment(SwingConstants.CENTER);
		tituloNaves.setForeground(Color.GREEN);
		tituloNaves.setFont(new Font("Impact", Font.PLAIN, 25));
		
		jrNave1= new JRadioButton("Nave estelar");
		jrNave1.setBounds(40, 43, 109, 23);
		jrNave1.addActionListener(this);
		grupoBotones.add(jrNave1);
		panelNaves.add(jrNave1);
		
		jrNave2= new JRadioButton("Nave cohete");
		jrNave2.setBounds(40, 74, 109, 23);
		jrNave2.addActionListener(this);
		grupoBotones.add(jrNave2);
		panelNaves.add(jrNave2);
		
		btnSalir= new JButton("");
		btnSalir.setIcon(new ImageIcon(opcionesMusica.class.getResource("/fotosBotones/exit.png")));
		btnSalir.setBounds(259, 113, 62, 51);
		btnSalir.addActionListener(this);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(0, 0, 6, 20);
		panelInicioFondo.add(formattedTextField);
		panelInicioFondo.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(new LineBorder(Color.BLUE, 4));
		panel.setBounds(375, 73, 200, 127);
		panelInicioFondo.add(panel);
		
		JLabel lblLaser = new JLabel("Laser");
		lblLaser.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaser.setForeground(Color.GREEN);
		lblLaser.setFont(new Font("Impact", Font.PLAIN, 25));
		lblLaser.setBounds(51, 0, 98, 32);
		panel.add(lblLaser);
		
		jrLaser1= new JRadioButton("Laser Blanco");
		jrLaser1.setBounds(51, 35, 109, 23);
		jrLaser1.addActionListener(this);
		grupoBotones2.add(jrLaser1);
		panel.add(jrLaser1);
		
		jrLaser2= new JRadioButton("Laser Rojo");
		jrLaser2.setBounds(51, 61, 109, 23);
		jrLaser2.addActionListener(this);
		grupoBotones2.add(jrLaser2);
		panel.add(jrLaser2);
		
		jrLaser3= new JRadioButton("Laser Azul");
		jrLaser3.setBounds(51, 87, 109, 23);
		jrLaser3.addActionListener(this);
		grupoBotones2.add(jrLaser3);
		panel.add(jrLaser3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnSalir) {
			if(jrNave1.isSelected()){
				ventanaStart.rutaNave="bin\\logica\\nave1.png";
			}else if(jrNave2.isSelected()){
				ventanaStart.rutaNave="bin\\logica\\cohete.png";
			
			}
			if(jrLaser1.isSelected()){
				ventanaStart.rutaLaser="bin\\logicaLaser\\laser.png";
			}
			else if(jrLaser2.isSelected()){
				ventanaStart.rutaLaser="bin\\logicaLaser\\laser2.png";
			}else if(jrLaser3.isSelected()){
				ventanaStart.rutaLaser="bin\\logicaLaser\\laser3.png";

			}
			
			this.window.frame.dispose();
		}
		
	}
}
