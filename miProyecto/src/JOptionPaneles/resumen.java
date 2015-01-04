package JOptionPaneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import fondos.logicaFondos;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRootPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import ventanas.ventanaGame;
import ventanas.ventanaRegistro;
import ventanas.ventanaStart;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

import logica.logicaPiloto;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class resumen implements  ActionListener {

	public JDialog frame;
	public static resumen window;
	
	private logicaFondos panelInicioFondo;
	//imagenes
	private logicaFondos piloto;
	private logicaFondos primeraPosicion;
	private logicaFondos logo;
	private JLabel LabelTituloPiloto;
	private JPanel panelLider;
	private JButton bSalir;
	private JButton bPantallaStart;
	private JLabel label_1;
	private JTable tableEnemigos;
	private JScrollPane scrollPaneEnemigosMuertos;
	private JTable tableEnemigosMuertos;
	private JLabel labelTituloMuertes;
	private JLabel lblEnemigosQuePasan;
	private JScrollPane scrollPanePasanFrontera;
	private JTable tablePasanFrontera;
	private JLabel lblRebotesEfectuados;
	private JScrollPane scrollPaneRebotes;
	private JTable tableRebotes;
	private JLabel lblEficienciaDeLos;
	private JScrollPane scrollPaneEficiencia;
	private JTable tableEficiencia;
	private JLabel labelPuntuacion;
	private JLabel labelTiempo;
	private JPanel panelTiempoyResultado;
	private JLabel puntos;
	private JLabel tiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new resumen();
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
	public resumen() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setBounds(100, 50, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(1100,650); 
		frame.setResizable(false);

		panelInicioFondo = new logicaFondos("/fondos/fondoFinal.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(null);
		
		
		
		JPanel miPanel = new JPanel();
		miPanel.setBorder(new LineBorder(new Color(0, 0, 255), 3, true));
		miPanel.setBounds(536, 0, 564, 650);
		miPanel.setOpaque(false);
		panelInicioFondo.add(miPanel);
		miPanel.setLayout(null);
		
		piloto = new logicaFondos("/fondos/personaje.png");
		piloto.setBorder(new LineBorder(Color.BLUE));
		piloto.setBounds(435, 27, 119, 87);
		miPanel.add(piloto);
		
		LabelTituloPiloto = new JLabel("Estas son tus estadisticas");
		LabelTituloPiloto.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTituloPiloto.setForeground(Color.BLUE);
		LabelTituloPiloto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		LabelTituloPiloto.setBounds(80, 11, 403, 52);
		miPanel.add(LabelTituloPiloto);
		
		bPantallaStart = new JButton("");
		bPantallaStart.setIcon(new ImageIcon(resumen.class.getResource("/fotosBotones/1419794963_quick_restart.png")));
		bPantallaStart.setBounds(29, 579, 66, 60);
		bPantallaStart.addActionListener(this);
		miPanel.add(bPantallaStart);
		
		JLabel labelNombrePiloto = new JLabel();
		labelNombrePiloto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombrePiloto.setForeground(Color.RED);
		labelNombrePiloto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNombrePiloto.setBounds(253, 74, 159, 23);
		labelNombrePiloto.setText(ventanaStart.contenedor.getNombre());
		miPanel.add(labelNombrePiloto);
		
		/*INICIO TABLA ENEMIGOS MUERTOS*/
		scrollPaneEnemigosMuertos = new JScrollPane();
		scrollPaneEnemigosMuertos.setBounds(80, 184, 459, 38);
		scrollPaneEnemigosMuertos.setOpaque(false);
		scrollPaneEnemigosMuertos.getViewport().setOpaque(false);
		miPanel.add(scrollPaneEnemigosMuertos);
		
		tableEnemigosMuertos = new JTable();
		tableEnemigosMuertos.setForeground(Color.RED);
		tableEnemigosMuertos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		tableEnemigosMuertos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Enemigos de tipo 1", "Enemigos de tipo 2", "Enemigos de tipo 3", "Enemigos Totales"
			}
		));
		tableEnemigosMuertos.getColumnModel().getColumn(0).setPreferredWidth(106);
		tableEnemigosMuertos.getColumnModel().getColumn(1).setPreferredWidth(104);
		tableEnemigosMuertos.getColumnModel().getColumn(2).setPreferredWidth(103);
		tableEnemigosMuertos.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableEnemigosMuertos.setOpaque(false);
		tableEnemigosMuertos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
            setOpaque(false);
        }});
		
		scrollPaneEnemigosMuertos.setViewportView(tableEnemigosMuertos);
		
		labelTituloMuertes = new JLabel();
		labelTituloMuertes.setText("Enemigos muertos");
		labelTituloMuertes.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloMuertes.setForeground(Color.RED);
		labelTituloMuertes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelTituloMuertes.setBounds(29, 150, 159, 23);
		miPanel.add(labelTituloMuertes);
		
		int numCols = tableEnemigosMuertos.getModel().getColumnCount();

		Object [] fila = new Object[numCols]; 
		fila[0] = Integer.toString(ventanaStart.contenedor.getEnemigosNMuertos1());
		fila[1] = Integer.toString(ventanaStart.contenedor.getEnemigosNMuertos2());
		fila[2] = Integer.toString(ventanaStart.contenedor.getEnemigosNMuertos3());
		fila[3] = Integer.toString(ventanaStart.contenedor.getEnemigosNMuertos1()+ventanaStart.contenedor.getEnemigosNMuertos2()+ventanaStart.contenedor.getEnemigosNMuertos3());
		
		((DefaultTableModel)tableEnemigosMuertos.getModel()).addRow(fila);
		/*FIN TABLA ENEMIGOS MUERTOS*/
		
		/*INICIO TABLA ENEMIGOS MUERTOS*/
		//label con titulo
		lblEnemigosQuePasan = new JLabel();
		lblEnemigosQuePasan.setText("Enemigos que pasan la frontera");
		lblEnemigosQuePasan.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemigosQuePasan.setForeground(Color.RED);
		lblEnemigosQuePasan.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEnemigosQuePasan.setBounds(29, 226, 275, 23);
		miPanel.add(lblEnemigosQuePasan);
		//Empezmos poniendo el scrollpanel
		scrollPanePasanFrontera = new JScrollPane();
		scrollPanePasanFrontera.setBounds(80, 244, 459, 38);
		//lo hacemos invisible
		scrollPanePasanFrontera.setOpaque(false);
		scrollPanePasanFrontera.getViewport().setOpaque(false);
		miPanel.add(scrollPanePasanFrontera);
		
		tablePasanFrontera = new JTable();
		tablePasanFrontera.setForeground(Color.RED);
		tablePasanFrontera.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		tablePasanFrontera.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Enemigos de tipo 1", "Enemigos de tipo 2", "Enemigos de tipo 3", "Enemigos Totales"
			}
				));
		//hacemo invisibles las filas
		tablePasanFrontera.setOpaque(false);
		tablePasanFrontera.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
			setOpaque(false);
		}});
		scrollPanePasanFrontera.setViewportView(tablePasanFrontera);

		//metemos las filas
		int numCols2 = tablePasanFrontera.getModel().getColumnCount();
		Object [] fila2 = new Object[numCols2]; 
		fila2[0] = Integer.toString(ventanaStart.contenedor.getEnemigoPasa1());
		fila2[1] = Integer.toString(ventanaStart.contenedor.getEnemigoPasa2());
		fila2[2] = Integer.toString(ventanaStart.contenedor.getEnemigoPasa3());
		fila2[3] = Integer.toString(ventanaStart.contenedor.getEnemigoPasa1()+ventanaStart.contenedor.getEnemigoPasa2()+ventanaStart.contenedor.getEnemigoPasa3());

		((DefaultTableModel)tablePasanFrontera.getModel()).addRow(fila2);
		/*FIN TABLA ENEMIGOS MUERTOS*/

		/*INICIO REBOTES*/
		//label con titulo
		lblRebotesEfectuados = new JLabel();
		lblRebotesEfectuados.setText("Rebotes efectuados");
		lblRebotesEfectuados.setHorizontalAlignment(SwingConstants.CENTER);
		lblRebotesEfectuados.setForeground(Color.RED);
		lblRebotesEfectuados.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblRebotesEfectuados.setBounds(29, 293, 159, 23);
		miPanel.add(lblRebotesEfectuados);

		//Empezmos poniendo el scrollpanel
		scrollPaneRebotes = new JScrollPane();
		scrollPaneRebotes.setBounds(80, 316, 459, 38);
		//lo hacemos invisible
		scrollPaneRebotes.setOpaque(false);
		scrollPaneRebotes.getViewport().setOpaque(false);
		miPanel.add(scrollPaneRebotes);

		tableRebotes = new JTable();
		tableRebotes.setForeground(Color.RED);
		tableRebotes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		tableRebotes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Rebote izquierdo", "Rebotes derecho", "Rebotes totales"
				}
				));
		tableRebotes.getColumnModel().getColumn(0).setPreferredWidth(95);
		tableRebotes.getColumnModel().getColumn(1).setPreferredWidth(94);
		tableRebotes.getColumnModel().getColumn(2).setPreferredWidth(87);

		//hacemo invisibles las filas
		tableRebotes.setOpaque(false);
		tableRebotes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
			setOpaque(false);
		}});
		scrollPaneRebotes.setViewportView(tableRebotes);
		//metemos las filas
		int numCols3 = tableRebotes.getModel().getColumnCount();
		Object [] fila3 = new Object[numCols3]; 
		fila3[0] = Integer.toString(ventanaStart.contenedor.getRebotesIzquierdos());
		fila3[1] = Integer.toString(ventanaStart.contenedor.getRebotesDerechos());
		fila3[2] = Integer.toString(ventanaStart.contenedor.getRebotesIzquierdos()+ventanaStart.contenedor.getRebotesDerechos());
		
		((DefaultTableModel)tableRebotes.getModel()).addRow(fila3);
	

		/*FIN TABLA REBOTES*/
		
		/*INICIO TABLA EFICIENCIA*/
		//label con titulo
		lblEficienciaDeLos = new JLabel();
		lblEficienciaDeLos.setText("Eficiencia de los disparos");
		lblEficienciaDeLos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEficienciaDeLos.setForeground(Color.RED);
		lblEficienciaDeLos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEficienciaDeLos.setBounds(29, 360, 235, 23);
		miPanel.add(lblEficienciaDeLos);
		
		//Empezmos poniendo el scrollpanel
		scrollPaneEficiencia = new JScrollPane();
		scrollPaneEficiencia.setBounds(80, 383, 212, 38);
		//lo hacemos invisible
		scrollPaneEficiencia.setOpaque(false);
		scrollPaneEficiencia.getViewport().setOpaque(false);
		miPanel.add(scrollPaneEficiencia);
		
		tableEficiencia = new JTable();
		tableEficiencia.setForeground(Color.RED);
		tableEficiencia.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tableEficiencia.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Misiles disparados", "Eficiencia"
			}
		));
		tableEficiencia.getColumnModel().getColumn(0).setPreferredWidth(99);
		
		//hacemo invisibles las filas
		tableEficiencia.setOpaque(false);
		tableEficiencia.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{
			setOpaque(false);
		}});
		scrollPaneEficiencia.setViewportView(tableEficiencia);
		//metemos las filas
		int numCols4 = tableEficiencia.getModel().getColumnCount();
		Object [] fila4 = new Object[numCols4]; 
		fila4[0] = Integer.toString(ventanaStart.contenedor.getMisilesDisparados());
		ventanaStart.contenedor.eficiencia();
		fila4[1] = ventanaStart.contenedor.eficiencia();

		((DefaultTableModel)tableEficiencia.getModel()).addRow(fila4);

		/*FIN TABLA EFICIENCIA*/


		lblEficienciaDeLos = new JLabel();
		lblEficienciaDeLos.setText("Eficiencia de los disparos");
		lblEficienciaDeLos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEficienciaDeLos.setForeground(Color.RED);
		lblEficienciaDeLos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEficienciaDeLos.setBounds(29, 360, 235, 23);
		miPanel.add(lblEficienciaDeLos);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBorder(new LineBorder(Color.BLUE, 3));
		panelInformacion.setBounds(253, 465, 284, 104);
		panelInformacion.setOpaque(false);
		miPanel.add(panelInformacion);
		panelInformacion.setLayout(null);
		
		labelPuntuacion = new JLabel("Puntuacion:");
		labelPuntuacion.setForeground(Color.WHITE);
		labelPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntuacion.setBorder(new LineBorder(Color.RED, 3));
		labelPuntuacion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		labelPuntuacion.setBounds(10, 11, 129, 41);
		panelInformacion.add(labelPuntuacion);
		
		labelTiempo = new JLabel("Tiempo:");
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setForeground(Color.WHITE);
		labelTiempo.setBorder(new LineBorder(Color.RED, 3));
		labelTiempo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		labelTiempo.setBounds(10, 50, 129, 41);
		panelInformacion.add(labelTiempo);
		
		panelTiempoyResultado = new JPanel();
		panelTiempoyResultado.setBorder(new LineBorder(Color.GREEN));
		panelTiempoyResultado.setBounds(149, 11, 125, 80);
		panelTiempoyResultado.setOpaque(false);
		panelTiempoyResultado.setLayout(null);
		panelInformacion.add(panelTiempoyResultado);
		
		
		puntos = new JLabel();
		puntos.setForeground(Color.GREEN);
		puntos.setHorizontalAlignment(SwingConstants.CENTER);
		puntos.setBounds(10, 11, 103, 26);
		puntos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		puntos.setText(Integer.toString(ventanaStart.contenedor.getPuntuacion()));
		panelTiempoyResultado.add(puntos);
		
		tiempo = new JLabel();
		tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		tiempo.setForeground(Color.GREEN);
		tiempo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tiempo.setText(Long.toString(ventanaStart.contenedor.tiempoTranscurrido())+" segundos");
		tiempo.setBounds(10, 48, 103, 26);
		panelTiempoyResultado.add(tiempo);




		panelLider = new JPanel();
		panelLider.setBorder(new LineBorder(Color.YELLOW, 3, true));
		panelLider.setBounds(0, 0, 536, 650);
		panelLider.setOpaque(false);
		panelInicioFondo.add(panelLider);
		panelLider.setLayout(null);

		primeraPosicion = new logicaFondos("/fondos/primeraPosicion.png");
		primeraPosicion.setBorder(new LineBorder(Color.BLUE));
		primeraPosicion.setBounds(20, 29, 159, 113);
		panelLider.add(primeraPosicion);

		logo = new logicaFondos("/fondos/logo.png");
		logo.setBorder(new LineBorder(Color.BLUE));
		logo.setBounds(10, 526, 146, 113);
		panelLider.add(logo);

		bSalir = new JButton("");
		bSalir.setIcon(new ImageIcon(resumen.class.getResource("/fotosBotones/1419795973_exit.png")));	
		bSalir.setBorder(new LineBorder(Color.BLACK));
		bSalir.addActionListener(this);
		bSalir.setBounds(434, 577, 63, 62);
		panelLider.add(bSalir);
		
		JLabel LabelTituloLider = new JLabel("Estadisiticas del lider");
		LabelTituloLider.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTituloLider.setForeground(Color.YELLOW);
		LabelTituloLider.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		LabelTituloLider.setBounds(158, 29, 293, 35);
		panelLider.add(LabelTituloLider);
		
		label_1 = new JLabel("New label");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(195, 75, 159, 23);
		panelLider.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==bSalir) {
			System.exit( 0 ); 
		}
		if (e.getSource()==bPantallaStart) {
			
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
			
		}
		
	}
}
