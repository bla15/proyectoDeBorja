package JOptionPaneles;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;

import java.awt.Color;

import javax.swing.JLabel;

import ventanas.ventanaInicio;
import fondos.logicaFondos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameOver implements KeyListener, ActionListener{
	//el objeto de esta clase
	public static gameOver window;
	
	//frame de la ventana
	public JFrame frame;
	
	
	//los botones
	JButton botonNext;
	JButton botonAdelante;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new gameOver();
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
	public gameOver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(600,350); 
		frame.setResizable(false); 
		
		
		
		logicaFondos panelInicioFondo = new logicaFondos("/JOptionPaneles/gameOver.png");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(null);	
		
		JLabel panelRepetir = new JLabel("<html><body>Quieres mas o ya tienes bastante<br> eres muy malo y lo sabes, <br>bueno si quieres mas de lo buenno dale al boton molon </body></html>");
		panelRepetir.setForeground(new Color(255, 255, 255));
		panelRepetir.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 11));
		panelRepetir.setBounds(81, 182, 220, 129);
		panelRepetir.setOpaque( false );
		panelInicioFondo.add(panelRepetir);
		
		botonNext= new JButton("");
		botonNext.setIcon(new ImageIcon(gameOver.class.getResource("/fotosBotones/1417460652_Shift.png")));
		botonNext.setBounds(505, 288, 89, 23);
		botonNext.addActionListener(this);
		panelInicioFondo.add(botonNext);
		
		botonAdelante= new JButton("");
		botonAdelante.setForeground(new Color(255, 255, 255));
		botonAdelante.setIcon(new ImageIcon(gameOver.class.getResource("/fotosBotones/1417470019_repeat-64.png")));
		//btnNewButton.setOpaque(false);
		//btnNewButton.setContentAreaFilled(false);
		botonAdelante.setBounds(359, 231, 58, 59);
		botonAdelante.addActionListener(this);
		panelInicioFondo.add(botonAdelante);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent botonPulsado) {
		// TODO Auto-generated method stub
		if (botonPulsado.getSource()==botonNext) {
			this.window.frame.dispose();
			
		}else if(botonPulsado.getSource()==botonAdelante){
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
