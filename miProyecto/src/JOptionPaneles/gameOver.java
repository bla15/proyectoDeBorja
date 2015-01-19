package JOptionPaneles;

import hilosEnemigos.enemigoCuatro;
import hilosEnemigos.enemigoDos;
import hilosEnemigos.enemigoUno;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JRootPane;

import java.awt.Color;

import javax.swing.JLabel;












import ventanas.ventanaGame;
import ventanas.ventanaRegistro;
import ventanas.ventanaStart;
import fondos.logicaFondos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import logica.logicaCambio;

public class gameOver implements KeyListener, ActionListener{
	//el objeto de esta clase
	public static gameOver window;
	
	//frame de la ventana
	public JDialog frame;
	
	
	//los botones
	JButton botonNext;
	JButton botonAdelante;
	private JPanel panelPuntuaciones;
	private JLabel enunciadoPuntuaciones;
	private JLabel puntuaciones;
	

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
		
	//parar todos los hilos
	ventanaGame.funcionar=false;
	logicaCambio.funcionar=false;
	enemigoUno.funcionar=false;
	enemigoDos.funcionar=false;
	enemigoCuatro.funcionar=false;
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog(ventanaGame.frame);
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		panelPuntuaciones = new JPanel();
		panelPuntuaciones.setBorder(new LineBorder(Color.GREEN));
		panelPuntuaciones.setBounds(32, 58, 248, 74);
		panelPuntuaciones.setOpaque( false );
		panelInicioFondo.add(panelPuntuaciones);
		panelPuntuaciones.setLayout(null);
		
		enunciadoPuntuaciones = new JLabel("Tu puntuacion es:  ");
		enunciadoPuntuaciones.setForeground(Color.GREEN);
		enunciadoPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enunciadoPuntuaciones.setBounds(10, 22, 133, 26);
		panelPuntuaciones.add(enunciadoPuntuaciones);
		
		puntuaciones = new JLabel();
		puntuaciones.setForeground(Color.GREEN);
		puntuaciones.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
		puntuaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		puntuaciones.setBounds(142, 11, 96, 52);
		puntuaciones.setText(Integer.toString(ventanaStart.contenedor.getPuntuacion()));
		panelPuntuaciones.add(puntuaciones);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent botonPulsado) {
		// TODO Auto-generated method stub
		if (botonPulsado.getSource()==botonNext) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
  	
						resumen.window = new resumen();
						resumen.window.frame.setVisible(true);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			this.window.frame.dispose();
			ventanaGame.window.frame.dispose();
			
		}else if(botonPulsado.getSource()==botonAdelante){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
  	
						ventanaStart.window = new ventanaStart();
						ventanaStart.window.frame.setVisible(true);

						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			this.window.frame.dispose();
			ventanaGame.window.frame.dispose();
			
			
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