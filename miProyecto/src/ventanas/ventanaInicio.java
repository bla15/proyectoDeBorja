package ventanas;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fondos.logicaFondos;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JTextPane;
import javax.swing.JLabel;

import logica.logicaPiloto;

public class ventanaInicio implements KeyListener, ActionListener{

	private JFrame frame;
	private JButton botonStart;
	
	static ventanaInicio window;
	
	static LinkedList<logicaPiloto>registro=new LinkedList<logicaPiloto>();
	static logicaPiloto contenedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ventanaInicio();
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
	public ventanaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logicaFondos panelInicioFondo = new logicaFondos("/fondos/inicio.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setOpaque( false );
		panelInicioFondo.add(panelTitulo, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(200);
		panelTitulo.add(verticalStrut_3);
		
		JLabel lblNewLabelTitulo = new JLabel("Space attack");
		lblNewLabelTitulo.setFont(new Font("Snap ITC", Font.ITALIC, 72));
		lblNewLabelTitulo.setForeground(Color.YELLOW);
		lblNewLabelTitulo.setOpaque( false );
		lblNewLabelTitulo.setBorder(null);
		panelTitulo.add(lblNewLabelTitulo);
		
		
		JPanel panelBoton = new JPanel();
		panelBoton.setForeground(Color.WHITE);
		panelInicioFondo.add(panelBoton, BorderLayout.CENTER);
		panelBoton.setOpaque( false );
		panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
		
		Component verticalGlueBotonArriba = Box.createVerticalGlue();
		panelBoton.add(verticalGlueBotonArriba);
		
		JPanel panelBoton2 = new JPanel();
		panelBoton2.setOpaque( false );
		panelBoton.add(panelBoton2);
		panelBoton2.setLayout(new BoxLayout(panelBoton2, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelBoton2.add(horizontalGlue);
		
		botonStart = new JButton("START");
		botonStart.setForeground(Color.YELLOW);
		botonStart.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 55));
		//botonStart.setOpaque(false);
		//botonStart.setContentAreaFilled(false);
		botonStart.setBorder(new LineBorder(Color.WHITE, 9));
		//botonStart.setBorderPainted(false);
		botonStart.addActionListener(this);
		panelBoton2.add(botonStart);
		
		Component verticalGlueBotonAbajo = Box.createVerticalGlue();
		panelBoton.add(verticalGlueBotonAbajo);
		
		JPanel panel = new JPanel();
		panel.setOpaque( false );
		panelInicioFondo.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabelCreadores = new JLabel("Por: Bastien L\u00F3pez y Borja L\u00F3pez");
		lblNewLabelCreadores.setForeground(Color.WHITE);
		lblNewLabelCreadores.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 30));
		lblNewLabelCreadores.setOpaque( false );
		lblNewLabelCreadores.setBorder(null);
		panel.add(lblNewLabelCreadores);
		
		JPanel panelRecords = new JPanel();
		panelRecords.setOpaque( false );
		panelInicioFondo.add(panelRecords, BorderLayout.EAST);
	
		panelRecords.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRecords2 = new JPanel();
		panelRecords2.setOpaque( false );
		panelRecords.add(panelRecords2, BorderLayout.SOUTH);
		panelRecords2.setLayout(new BoxLayout(panelRecords2, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabelTituloGanadores = new JLabel("Mejores pilotos");
		lblNewLabelTituloGanadores.setForeground(Color.GREEN);
		lblNewLabelTituloGanadores.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 40));
		lblNewLabelTituloGanadores.setOpaque( false );
		lblNewLabelTituloGanadores.setBorder(null);
		panelRecords2.add(lblNewLabelTituloGanadores);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelRecords2.add(verticalStrut);
		
		JLabel lblNewLabelPrimero = new JLabel("New label");
		lblNewLabelPrimero.setOpaque( false );
		lblNewLabelPrimero.setBorder(null);
		panelRecords2.add(lblNewLabelPrimero);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelRecords2.add(verticalStrut_1);
		
		JLabel lblNewLabelSegundo = new JLabel("New label");
		lblNewLabelSegundo.setOpaque( false );
		lblNewLabelSegundo.setBorder(null);
		panelRecords2.add(lblNewLabelSegundo);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panelRecords2.add(verticalStrut_2);
		
		JLabel lblNewLabelTercero = new JLabel("New label");
		lblNewLabelTercero.setOpaque( false );
		lblNewLabelTercero.setBorder(null);
		panelRecords2.add(lblNewLabelTercero);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==botonStart) {
			this.window.frame.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						ventanaEleccion.window = new ventanaEleccion();
						ventanaEleccion.window.frame.setVisible(true);
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
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
