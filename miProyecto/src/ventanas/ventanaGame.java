package ventanas;


import hilosEnemigos.corazonNivel1y2;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;

import logica.logicaCambio;
import logica.logicaCoheteDerecho;
import logica.logicaCoheteIzquierdo;
import logica.logicaCojuntaMiNave;
import logica.logicaEsfera;
import logica.logicaFotoMiNave;
import logicaLaser.laserConjunto;
import logicaLaser.logicaFotoLaser;
import logicaTitulos.logicaMapa;
import fondos.logicaFondos;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;



public class ventanaGame implements KeyListener, ActionListener {

	public static JFrame frame;
	public static ventanaGame window;
	
	public static logicaFondos paneljuego;
	public static int anchoPanelJuego=1362;
	public static int altoPanelJuego=588;
	String ruta ="/fondos/luna.jpg";
	
	public static logicaFondos fondoControles;
	public static int anchoPanelcontrol=1362;
	public static int altoPanelControl=119;
	
	public static corazonNivel1y2 corazon;
	public static int vida=8;


	private JButton bSalir;
	private JButton bPause;
	
	//mis cosas de la nave
	static logicaCojuntaMiNave naveConjunta;
	static laserConjunto unLaser;
	boolean teclasMovimientoNave [] = new boolean[3];
	//cohetes
	logicaCoheteDerecho coheteDerecho;
	logicaCoheteIzquierdo coheteIzquierdo;
	//esfera
	logicaEsfera esfera;
	
	//mis cosas de lo laser
	//arrayList de los lasers que voy disparando
	public static ArrayList<laserConjunto> misLasers = new ArrayList<laserConjunto>();
	
	//clase de cambi de entorno
	static logicaCambio change;

	//elemento hilos
	//boolean para que funcionen los hilos
	public static boolean funcionar= true;
	protected int i;
	
	//puntuacion
	public static JLabel puntuacionVisible;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ventanaGame();
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
	public ventanaGame() {

		//posicion de la nave
		naveConjunta = new logicaCojuntaMiNave();
		naveConjunta.setPosX(623);
		naveConjunta.setPosY(500);
		//cohetes
		coheteDerecho = new logicaCoheteDerecho();
		coheteDerecho.setLocation(680, 560);
		
		coheteIzquierdo= new logicaCoheteIzquierdo();
		coheteIzquierdo.setLocation(570, 560);
		
		//esfera
		esfera= new logicaEsfera();
		esfera.setVisible(false);
		esfera.setLocation(600, 480);
		
		//instanciamos el cambio
		change = new logicaCambio();
		
		//creamos los componentes de la ventana
		initialize();
		//metemos los corazones
		corazon= new corazonNivel1y2(vida);
		
		//hilos
		hiloMiNave miHiloNave = new hiloMiNave(); 
		miHiloNave.start();
		
		hiloLaser hiloLaser = new hiloLaser(); 
		hiloLaser.start();

		//metodos para recuperar el foco y que las teclas funcionan
		paneljuego.setFocusable(true);
		paneljuego.requestFocus();
		paneljuego.addKeyListener(this);
		paneljuego.addFocusListener( new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				paneljuego.requestFocus();
			}
		});

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(0, 0, 1362, 706);
		frame.getContentPane().add(panelCentral);
		
		paneljuego = new logicaFondos(ruta);
		paneljuego.setBackground(Color.BLACK);
		paneljuego.setBounds(0, 0, anchoPanelJuego, altoPanelJuego);
		paneljuego.setLayout(null);
		paneljuego.requestFocus();
		panelCentral.setLayout(null);
		panelCentral.add(paneljuego);
		
		paneljuego.add(naveConjunta.getFotoNave());
		
		paneljuego.add(coheteDerecho);
		coheteDerecho.setVisible(false);
		paneljuego.add(coheteIzquierdo);
		
		paneljuego.add(esfera);
		
		fondoControles  = new logicaFondos("/fondos/panel.jpg");
		fondoControles.setBounds(0, 587, anchoPanelcontrol, altoPanelControl);
		panelCentral.add(fondoControles);
		fondoControles.setLayout(null);
		
		//los corazones se gestionan ahora en una clase aparte
		/*
		logicaFondos corazon1 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon1.setBounds(27, 10, 39, 45);
		fondoControles.add(corazon1);
		
		logicaFondos corazon2 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon2.setBounds(75, 10, 39, 45);
		fondoControles.add(corazon2);
		
		logicaFondos corazon3 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon3.setBounds(124, 10, 39, 45);
		fondoControles.add(corazon3);
		
		logicaFondos corazon4 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon4.setBounds(165, 10, 39, 45);
		fondoControles.add(corazon4);
		
		*/
		
		JPanel panelCorazones = new JPanel();
		panelCorazones.setBorder(new LineBorder(Color.BLUE, 2));
		panelCorazones.setBounds(20, 2, 190, 60);
		panelCorazones.setOpaque( false );
		fondoControles.add(panelCorazones);
		
		bSalir = new JButton("");
		bSalir.setBounds(1191, 57, 62, 51);
		fondoControles.add(bSalir);
		bSalir.setIcon(new ImageIcon(ventanaGame.class.getResource("/fotosBotones/exit.png")));
		
		bPause = new JButton("");
		bPause.setBounds(1274, 54, 62, 65);
		fondoControles.add(bPause);
		bPause.setIcon(new ImageIcon(ventanaGame.class.getResource("/fotosBotones/pause.png")));
		
		JPanel panelPuntuacion = new JPanel();
		panelPuntuacion.setBorder(new LineBorder(Color.GREEN));
		panelPuntuacion.setOpaque( false );
		panelPuntuacion.setBounds(235, 2, 106, 60);
		fondoControles.add(panelPuntuacion);
		panelPuntuacion.setLayout(null);
		
		puntuacionVisible = new JLabel();
		puntuacionVisible.setForeground(Color.GREEN);
		puntuacionVisible.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacionVisible.setBounds(251, 2, 90, 48);
		fondoControles.add(puntuacionVisible);
		puntuacionVisible.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		puntuacionVisible.setText(Integer.toString(ventanaStart.contenedor.getPuntuacion()));
		bPause.addActionListener(this);
		bSalir.addActionListener(this);
		

	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//si le damos a play ponemos el foco y el juego vuelve a funcionr
		
		if(e.getSource()==bSalir){
			this.window.frame.dispose();
		}
		if(e.getSource()==bPause){

			
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			teclasMovimientoNave[0]=true;
			
		}
			
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			teclasMovimientoNave[1]=true;
		}
			
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			teclasMovimientoNave[2]=true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					teclasMovimientoNave[0]=false;
					
				}

				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					teclasMovimientoNave[1]=false;
					
				}

				if(e.getKeyCode()==KeyEvent.VK_SPACE)
					teclasMovimientoNave[2]=false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//hilo que gestiona mi nave
	public class hiloMiNave extends Thread{
		long tiempoEsfera;

		
		public void run(){

			while(funcionar){
				
				naveConjunta.mueve(0.040);
				//movimiento de la nave
				if(teclasMovimientoNave[0]==true){
					if(naveConjunta.getMiVelocidad()==0){
						naveConjunta.acelera(-100);
						
						
					}
					else if(naveConjunta.getMiVelocidad()<-400){
						naveConjunta.acelera(0);
					}
					else if(naveConjunta.getMiVelocidad()>0){
						naveConjunta.acelera(-50);
					}
					else
						naveConjunta.acelera(-35);

					//ponemos los cohetes en posicion
					coheteDerecho.setVisible(true);
					
						
				}else{
					coheteDerecho.setVisible(false);
				}
				
	
				if(teclasMovimientoNave[1]==true){
					if(naveConjunta.getMiVelocidad()==0){
						naveConjunta.acelera(100);
					}
					else if(naveConjunta.getMiVelocidad()>400){
						naveConjunta.acelera(0);
					}
					else if(naveConjunta.getMiVelocidad()<0){
						naveConjunta.acelera(100);
					}
					else
						naveConjunta.acelera(35);
					
					//ponemos los cohetes en posicion
					coheteIzquierdo.setVisible(true);
					
					
				}else{
					coheteIzquierdo.setVisible(false);
				}
				
				
				
				if(teclasMovimientoNave[2]==true){
					
				}
				//para cuando la tecla no esta pulsada
				if(teclasMovimientoNave[1]==false){
					//tiempo=0;;
				}
				
				if (naveConjunta.getPosX() < paneljuego.WIDTH -logicaFotoMiNave.TAMAÑO/2 ) {
					naveConjunta.setPosX(naveConjunta.getPosX()+10);
					naveConjunta.setMiVelocidad(-naveConjunta.getMiVelocidad());
					tiempoEsfera=System.currentTimeMillis();
					tiempoEsfera=System.currentTimeMillis();
					esfera.setVisible(true);		
				}
				
				if (naveConjunta.getPosX()>paneljuego.getWidth()-logicaFotoMiNave.TAMAÑO/2  ) {
					naveConjunta.setPosX(naveConjunta.getPosX()-10);
					naveConjunta.setMiVelocidad(-naveConjunta.getMiVelocidad());
					tiempoEsfera=System.currentTimeMillis();
					esfera.setVisible(true);
				}
				//hacemos invisible a esfera
				if(System.currentTimeMillis()-tiempoEsfera>700){
					esfera.setVisible(false);
				}
				
				//las posiciones de los componentes sigen la nave
				coheteIzquierdo.setLocation((int)naveConjunta.getPosX()-53, (int)naveConjunta.getPosY()+60);
				coheteDerecho.setLocation((int)naveConjunta.getPosX()+57, (int)naveConjunta.getPosY()+60);
				esfera.setLocation((int)naveConjunta.getPosX()-23,480);
				

				try {
					
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	//el hilo de los lasers
			public class hiloLaser extends Thread{
				public void run(){
					while(funcionar==true){
						if(teclasMovimientoNave[2]==true){
							unLaser= new laserConjunto();
							unLaser.setPosX(naveConjunta.getPosX()+13);
							unLaser.setPosY(naveConjunta.getPosY());
							unLaser.setMiVelocidad(300);
							paneljuego.add(unLaser.getFotoLaser());
							
							

							//el giro del laser
							if(naveConjunta.getMiVelocidad()>100){
								unLaser.gira(20);	
							}

							else if(naveConjunta.getMiVelocidad()<-100){
								unLaser.gira(-20);

							}

							//lo añadimos al arrayList de lasers
							misLasers.add(unLaser);
							
							paneljuego.repaint();

						}
						for(i=0;i<misLasers.size();i++){
							misLasers.get(i).mueve(0.040);
							if (misLasers.get(i).getPosY() < -logicaFotoMiNave.TAMAÑO/2 || misLasers.get(i).getPosY()>paneljuego.getHeight()-logicaFotoLaser.TAMAÑO/2 ) {
								paneljuego.remove(misLasers.get(i).getFotoLaser());
								misLasers.remove(i);
								
							}


						}
						try {
							hiloLaser.sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				
			}
}
