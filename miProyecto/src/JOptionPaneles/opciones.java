package JOptionPaneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRootPane;

import fondos.logicaFondos;
import ventanas.ventanaGame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class opciones implements  ActionListener{

	public JDialog frame;
	public static opciones window;
	
	//botones
	JButton btnMusica;
	JButton btnGraficos;
	JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new opciones();
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
	public opciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog(ventanaGame.frame);
		frame.setBounds(500, 100, 200, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(300, 300); 
		frame.setResizable(false); 
		
		logicaFondos panelInicioFondo = new logicaFondos("/JOptionPaneles/malla.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setBorder(new LineBorder(Color.WHITE, 4));

		panelInicioFondo.setLayout(null);
		
		JLabel tituloOpciones = new JLabel("OPCIONES");
		tituloOpciones.setForeground(Color.GREEN);
		tituloOpciones.setFont(new Font("Impact", Font.BOLD, 40));
		tituloOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		tituloOpciones.setBorder(new LineBorder(Color.GREEN, 4));
		tituloOpciones.setBounds(10, 11, 280, 42);
		panelInicioFondo.add(tituloOpciones);
		
		btnMusica= new JButton("Musica");
		btnMusica.setForeground(Color.GREEN);
		btnMusica.setFont(new Font("Impact", Font.PLAIN, 20));
		btnMusica.setBounds(83, 85, 122, 42);
		btnMusica.setBorder(new LineBorder(Color.GREEN, 4));
		btnMusica.addActionListener(this);
		panelInicioFondo.add(btnMusica);
		
		btnGraficos = new JButton("Graficos");
		btnGraficos.setForeground(Color.GREEN);
		btnGraficos.setFont(new Font("Impact", Font.PLAIN, 20));
		btnGraficos.setBounds(83, 165, 122, 42);
		btnGraficos.setBorder(new LineBorder(Color.GREEN, 4));
		btnGraficos.addActionListener(this);
		panelInicioFondo.add(btnGraficos);
		
		btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Impact", Font.PLAIN, 20));
		btnExit.setBounds(83, 239, 122, 42);
		btnExit.setBorder(new LineBorder(Color.RED, 4));
		btnExit.addActionListener(this);
		panelInicioFondo.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnExit) {
			this.window.frame.dispose();
		}
		if (e.getSource()==btnMusica) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try { 	
						opcionesMusica.window = new opcionesMusica();
						opcionesMusica.window.frame.setVisible(true);
											
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if (e.getSource()==btnGraficos) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try { 	
						opcionesGraficas.window = new opcionesGraficas();
						opcionesGraficas.window.frame.setVisible(true);
											
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
}
