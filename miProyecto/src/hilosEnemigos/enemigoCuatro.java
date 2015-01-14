package hilosEnemigos;





import java.awt.EventQueue;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JOptionPaneles.gameOver;
import logica.logicaPiloto;
import logicaEnemigos.logicaEnemigosConjunta;
import ventanas.ventanaGame;
import ventanas.ventanaStart;


public class enemigoCuatro {
	//limites
	int limiteDerecho=ventanaGame.paneljuego.WIDTH;
	int limiteIzquierdo=ventanaGame.anchoPanelJuego-50;

	//logicas
	public  logicaEnemigosConjunta unEnemigo;
	ArrayList<logicaEnemigosConjunta> misEnemigos = new ArrayList<logicaEnemigosConjunta>();
	ArrayList<Long> tiempo = new ArrayList<Long>();
	Long tiempoAccion;
	int tipoEnemigo=4;
	
	int velocidadEstandar=-80;
	int tiempoCreacion=2000;
	
	long tiempoInicio;

	//bandera de los hilos
	public static boolean funcionar=true;
	public static boolean pasoMapa=true;

	//puntuacion
	int puntuacion = 0;

	public enemigoCuatro(){
		//lave de los hilos
		funcionar=true;
		pasoMapa=true;
		
		velocidadEstandar=-80;
		tiempoCreacion=2000;
		tiempoInicio=System.currentTimeMillis();
		
		//lanzams hilo de creacion de enemigos
		hiloCreacionEnemigos creacion = new hiloCreacionEnemigos(); 
		creacion.start();

		//lanzamos el hilo de movimiento de los enemigos
		hiloMovimiento mover = new hiloMovimiento();
		mover.start();
		
		//lanzamos el hilo de choques
		hiloChoques choqueConLaser = new hiloChoques(); 
		choqueConLaser.start();
	}
	
	public int getTamañoArray(){
		return misEnemigos.size();
	}
public class hiloCreacionEnemigos extends Thread{
		
		public void run() {
			
			while(funcionar&&ventanaGame.vida>0&&pasoMapa){
				unEnemigo= new logicaEnemigosConjunta(tipoEnemigo);
				//posicon aleatoria en el eje de las x (sin que toque los bordes para que se vea bien la imagen
				unEnemigo.setPosX((int)(Math.random()*((limiteIzquierdo)-limiteDerecho+1)+limiteDerecho));
				//la posicion de las y es el alto del panel
				unEnemigo.setPosY(ventanaGame.paneljuego.HEIGHT);
				//lo metemos en los arrays los datos
				misEnemigos.add(unEnemigo);
				tiempo.add(System.currentTimeMillis());
				
				if(unEnemigo!=null){
					//lo sacamos en el panel de juego
					ventanaGame.paneljuego.add(unEnemigo.getFotoEnemigo());
					ventanaGame.paneljuego.repaint();
				}
				
				if(tiempoCreacion>=1500){
					//reducimos tiempo de creacion
					tiempoCreacion-=25;
				}
				
				try {
					//cada cuanto tiempo los va creando
					Thread.sleep(tiempoCreacion);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * hilo que gestiona el movimiento de los enemigos
	 * y la retira de vidas si pasan la frontera
	 */
public class hiloMovimiento extends Thread{

	int i;
	public void run(){
		while(ventanaGame.vida>0&&(funcionar)){
			
			
			for(i=0;i<tiempo.size();i++){
				if ((System.currentTimeMillis()-tiempo.get(i) >=250) && (System.currentTimeMillis()-tiempo.get(i) <=300)){
					//System.out.println(i+"  posicon change ");
					misEnemigos.get(i).randomDestino();
					tiempo.set(i, System.currentTimeMillis());
				}
			}


			
			
			//les damos movimiento
			for(i=0;i<misEnemigos.size();i++){
			//	misEnemigos.get(i).gira(10);
				misEnemigos.get(i).setSuVelocidad(velocidadEstandar);
				//Aqui le pasamos los parametros que necesita para mover el enemigo
				misEnemigos.get(i).mueve(0.040, misEnemigos.get(i).getGiro());
				ventanaGame.paneljuego.repaint();
			}
			
			for(i=0;i<misEnemigos.size();i++){
				if(misEnemigos.get(i).getPosX() < limiteDerecho){
					misEnemigos.get(i).setGiro(270);
					
				} else if (misEnemigos.get(i).getPosX() > limiteIzquierdo){
					misEnemigos.get(i).setGiro(90);
					
				}
				
				if(misEnemigos.get(i).getPosY()>ventanaGame.altoPanelJuego-50){
					ventanaGame.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
					misEnemigos.remove(i);
					tiempo.remove(i);
					ventanaGame.paneljuego.repaint();
					ventanaGame.vida-=1;
					ventanaStart.contenedor.setEnemigoPasa3(ventanaStart.contenedor.getEnemigoPasa3()+1);
					//vemos que hacer con los corazones
					if(ventanaGame.vida<=0){
						ventanaGame.corazon.setVidas(ventanaGame.vida);
						ventanaGame.corazon.pares();
						//sacamos el JDialog de fin de partida
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									  	
									gameOver.window = new gameOver();
									gameOver.window.frame.setVisible(true);
									for(logicaPiloto opc : ventanaStart.mejoresPilotos){
										//si tiene el mismo nombre que algun elemento ya guardado en la lista
										if(ventanaStart.contenedor.getNombre().equals(opc.getNombre())){
											for(logicaPiloto zp : ventanaStart.mejoresPilotos){
												//y si ademas tiene la misma puntuacion que un elemento de las lista
												if(ventanaStart.contenedor.getPuntuacion()==zp.getPuntuacion()){
													ventanaStart.guardar=false;
												}else{
													//se puede guardar
													ventanaStart.guardar=true;
												}
											}										

										}else{
											ventanaStart.guardar=true;
										}
									}
									if(ventanaStart.guardar==true){
										ventanaStart.mejoresPilotos.add(ventanaStart.contenedor);	
									}
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
						//paramos los hilos
						ventanaGame.funcionar=false;

					}
					if ((ventanaGame.vida % 2) != 0) {
						ventanaGame.corazon.setVidas(ventanaGame.vida);
						ventanaGame.corazon.impares();
					}else if ((ventanaGame.vida % 2) == 0) {
						ventanaGame.corazon.setVidas(ventanaGame.vida);
						ventanaGame.corazon.pares();
					}
				}
				
			}
			
			if(System.currentTimeMillis()-tiempoInicio>5000){
				tiempoInicio=System.currentTimeMillis();
				velocidadEstandar-=5;
			}
				try {
					hiloMovimiento.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

/*
 * hilo que gestiona el movimiento de los enemigos
 */
public class hiloChoques extends Thread{
	int i;
	int z;
	public void run(){
		while(ventanaGame.vida>0&&(funcionar)){
			for(z=0;z<ventanaGame.misLasers.size();z++){
				for(i=0;i<misEnemigos.size();i++){

					Area areaEnemigo = new Area(misEnemigos.get(i).getFoto().miArea);
					Area areaLaser = new Area(ventanaGame.misLasers.get(z).getFotoLaser().miArea );
					if(areaEnemigo.intersects(areaLaser.getBounds2D())){
						ventanaGame.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
						misEnemigos.remove(i);
						tiempo.remove(i);
						//contamos enemigos muertos
						ventanaStart.contenedor.setEnemigosNMuertos3(ventanaStart.contenedor.getEnemigosNMuertos3()+1);
						
						//aumentamos la puntuacion
						ventanaStart.contenedor.setPuntuacion(ventanaStart.contenedor.getPuntuacion()+2);
						ventanaGame.puntuacionVisible.setText(Integer.toString(ventanaStart.contenedor.getPuntuacion()));
						ventanaGame.fondoControles.repaint();

					}
					
					
				}
			}
			try {
				hiloChoques.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
}

