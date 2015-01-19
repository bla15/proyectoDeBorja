package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import fondos.logicaFondos;

import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.SwingConstants;

import logica.logicaPiloto;
import presentaciones.presentacion0;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class ventanaRegistro implements KeyListener, ActionListener {

	public JFrame frame;
	public static ventanaRegistro window;
	private logicaFondos panelInicioFondo;
	private JTextField txtPonAquiTu;
	
	JTextPane txtExplicativo;
	JLabel titulo ;
	JLabel tituloPuntucaciones;
	JButton bContinuar; 
	
	
	//tamaño del frame por defecto
	int anchoFrame=450;
	int altoFrame=300;

	//valores del texto explicativo
	int xTxt=10;
	int yTxt=89;
	int anchuraTxt=203;
	int alturaTxt=61;
	int tamañoTextoTxt=12;
	
	//valores del titulo
		int xTitulo=43;
		int yTitulo=29;
		int anchuraTitulo=343;
		int alturaTitulo=36;
		int tamañoTextoTitulo=28;
		
		//valores del titulo puntuaciones
		int xTituloPuntuaciones=22;
		int yTituloPuntuaciones=166;
		int anchuraTituloPuntuaciones=140;
		int alturaTituloPuntuaciones=14;
		int tamañoTextoTituloPuntuaciones=15;

		//valores campo a completar
		int xTxtCompletar=246;
		int yTxtCompletar=120;
		int anchuraTxtCompletar=180;
		int alturaTxtCompletar=15;
		int tamañoTxtCompletar=11;

		//valores boton continuar
		int xBotonContinuar=276;
		int yBotonContinuar=215;
		int anchuraBotonContinuar=89;
		int alturaBotonContinuar=23;
		int tamañoBotonContinuar=11;
		
		//valores del scrollPanel
		int xScroll=10;
		int yScroll=188;
		int anchuraScroll=200;
		int alturaScroll=50;
		
		//valores de la lista
		int tamañoLetraList = 11;
		
		//lista
		private DefaultListModel lmName;

		//nombre por defecto del piloto
		String nombrePiloto="Identificacion requerida, introduce tu nombre y procede a montar en tu nave. Gracias por tu colaboracion.";
		private JScrollPane scrollPanedeList;
		private JList list;
		
		String rutaNave;

		//ponemos el properties
		private java.util.Properties miConfiguracion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ventanaRegistro();
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
	public ventanaRegistro() {
		this.rutaNave=rutaNave;
		
		lmName = new DefaultListModel();
		
		initialize();
		
		//Descargamos la informacion del properties
		miConfiguracion = new Properties();
		try {
			miConfiguracion.loadFromXML( new FileInputStream( new java.io.File("nombrePiloto.ini") ) );
			nombrePiloto = miConfiguracion.getProperty( "NOMBRE" );;
			txtPonAquiTu.setText(nombrePiloto);
			
		}catch (Exception e) { 
			System.out.println("No se ha podido cargar bien el fichero");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				//Regla de tres para remasterizar el txt
				txtExplicativo.setBounds(frame.getWidth()*xTxt/anchoFrame,frame.getHeight()*yTxt/altoFrame,frame.getWidth()*anchuraTxt/anchoFrame,frame.getHeight()*alturaTxt/altoFrame);
				txtExplicativo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoTextoTxt/(anchoFrame+altoFrame)));
				
				//Regla de tres para remasterizar el titulo
				titulo.setBounds(frame.getWidth()*xTitulo/anchoFrame,frame.getHeight()*yTitulo/altoFrame,frame.getWidth()*anchuraTitulo/anchoFrame,frame.getHeight()*alturaTitulo/altoFrame);
				titulo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoTextoTitulo/(anchoFrame+altoFrame)));
				
				//Regla de tres para remasterizar el titulo puntuaciones
				tituloPuntucaciones.setBounds(frame.getWidth()*xTituloPuntuaciones/anchoFrame,frame.getHeight()*yTituloPuntuaciones/altoFrame,frame.getWidth()*anchuraTituloPuntuaciones/anchoFrame,frame.getHeight()*alturaTituloPuntuaciones/altoFrame);
				tituloPuntucaciones.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoTextoTituloPuntuaciones/(anchoFrame+altoFrame)));
				
				//Regla de tres para remasterizar el campo a completar
				txtPonAquiTu.setBounds(frame.getWidth()*xTxtCompletar/anchoFrame,frame.getHeight()*yTxtCompletar/altoFrame,frame.getWidth()*anchuraTxtCompletar/anchoFrame,frame.getHeight()*alturaTxtCompletar/altoFrame);
				txtPonAquiTu.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoTxtCompletar/(anchoFrame+altoFrame)));
				
				//Regla de tres para remasterizar el boton de continuar
				bContinuar.setBounds(frame.getWidth()*xBotonContinuar/anchoFrame,frame.getHeight()*yBotonContinuar/altoFrame,frame.getWidth()*anchuraBotonContinuar/anchoFrame,frame.getHeight()*alturaBotonContinuar/altoFrame);
				
				//Regla de tres para remasterizar el srollPannel
				scrollPanedeList.setBounds(frame.getWidth()*xScroll/anchoFrame,frame.getHeight()*yScroll/altoFrame,frame.getWidth()*anchuraScroll/anchoFrame,frame.getHeight()*alturaScroll/altoFrame);
				
				//Regla de tres para remasterizar el srollPannel
				list.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoLetraList/(anchoFrame+altoFrame)));
			}
		});
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelInicioFondo = new logicaFondos("/fondos/despege.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(null);
		
		txtExplicativo = new JTextPane();
		txtExplicativo.setFont(new Font("Tahoma", Font.PLAIN, tamañoTextoTxt));
		txtExplicativo.setText(nombrePiloto);
		txtExplicativo.setBounds(xTxt, yTxt, anchuraTxt, alturaTxt);
		txtExplicativo.setEditable(false);
		panelInicioFondo.add(txtExplicativo);
		
		titulo = new JLabel("Zona de Identificaion");
		titulo.setForeground(Color.GREEN);
		titulo.setFont(new Font("Stencil", Font.PLAIN, tamañoTextoTitulo));
		titulo.setBounds(xTitulo, yTitulo, anchuraTitulo, alturaTitulo);
		panelInicioFondo.add(titulo);
		
		txtPonAquiTu = new JTextField();
		txtPonAquiTu.setHorizontalAlignment(SwingConstants.CENTER);
		txtPonAquiTu.setFont(new Font("Tahoma", Font.PLAIN, tamañoTxtCompletar));
		txtPonAquiTu.setText("Pon tu nombre, Recluta:");
		txtPonAquiTu.setBounds(xTxtCompletar, yTxtCompletar, anchuraTxtCompletar, alturaTxtCompletar);
		panelInicioFondo.add(txtPonAquiTu);
		txtPonAquiTu.setColumns(10);
		
		tituloPuntucaciones = new JLabel("Mejores Pilotos");
		tituloPuntucaciones.setForeground(Color.RED);
		tituloPuntucaciones.setFont(new Font("Stencil", Font.PLAIN, 15));
		tituloPuntucaciones.setBounds(22, 166, 140, 14);
		panelInicioFondo.add(tituloPuntucaciones);
		
		bContinuar = new JButton("");
		bContinuar.setIcon(new ImageIcon(ventanaRegistro.class.getResource("/fotosBotones/1417460652_Shift.png")));
		bContinuar.setBounds(xBotonContinuar, yBotonContinuar, anchuraBotonContinuar, alturaBotonContinuar);
		bContinuar.addActionListener(this);
		panelInicioFondo.add(bContinuar);
		
		scrollPanedeList = new JScrollPane();
		scrollPanedeList.setBounds(xScroll, yScroll, anchuraScroll, alturaScroll);
		panelInicioFondo.add(scrollPanedeList);
		
		list = new JList(lmName);
		scrollPanedeList.setViewportView(list);
		
		lmName.removeAllElements();
		for(logicaPiloto opc  : ventanaStart.mejoresPilotos){
			
			lmName.addElement("Nombre:  "+opc.getNombre()+"    puntuacion:   "+opc.getPuntuacion());
		
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bContinuar){
			if(txtPonAquiTu.getText().equals("")||txtPonAquiTu.getText().equals("Pon tu nombre, Recluta:")){
				JOptionPane.showMessageDialog(null,"Pon tu nombre, recluta patoso!!!","ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
				
				//empezamos a guardar el properties
				miConfiguracion = new Properties();
				try {
					miConfiguracion.setProperty("NOMBRE",txtPonAquiTu.getText());
					miConfiguracion.setProperty("NAVE",ventanaStart.rutaNave);
					miConfiguracion.setProperty("LASER",ventanaStart.rutaLaser);
					miConfiguracion.storeToXML( new FileOutputStream( new java.io.File("nombrePiloto.ini") ), "Nombre del piloto" );
				}catch (Exception ex) { 
					System.out.println("Fallo en el guardado del properties");
				} 

				
				//metemos el valor dentro del contendor del personaje
				ventanaStart.contenedor.setNombre(txtPonAquiTu.getText());
				//this.window.frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							presentacion0.window = new presentacion0();
							presentacion0.window.frame.setVisible(true);



						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			});
				
			}
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