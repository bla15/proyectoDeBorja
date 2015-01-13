package hilosEnemigos;


import java.awt.EventQueue;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JOptionPaneles.gameOver;
import logica.logicaPiloto;
import logicaEnemigos.logicaEnemigosConjunta;
import ventanas.ventanaGame;
import ventanas.ventanaRegistro;
import ventanas.ventanaStart;


public class enemigoUno {

	//limites
	int limiteDerecho=ventanaGame.paneljuego.WIDTH;
	int limiteIzquierdo=ventanaGame.anchoPanelJuego-50;

	//logicas
	public  logicaEnemigosConjunta unEnemigo;
	ArrayList<logicaEnemigosConjunta> misEnemigos = new ArrayList<logicaEnemigosConjunta>();	
	int tipoEnemigo=1;
	int velocidadEstandar=-50;
	int tiempoCreacion=2000;

	//bandera de los hilos
	public static boolean funcionar=true;
	public static boolean pasoMapa=true;



	public enemigoUno(){
		//lave de los hilos
		funcionar=true;
		pasoMapa=true;
		
		velocidadEstandar=-50;
		tiempoCreacion=2000;

		//lanzams hilo de creacion de enemigos
		hiloCreacionEnemigos creacion = new hiloCreacionEnemigos(); 
		creacion.start();

		//lanzamos el hilo de movimiento de los enemigos
		hiloMovimiento mover = new hiloMovimiento(); 
		mover.start();

		//lanzamos el hilo de choques
		hiloChoques choqueConLaser = new hiloChoques(); 
		choqueConLaser.start();

		//creamos los corazones

	}
	public int getTamañoArray(){
		return misEnemigos.size();
	}

	public class hiloCreacionEnemigos extends Thread{

		public void run() {

			while(funcionar&&ventanaGame.vida>0&&pasoMapa){
				
				//usamos el boton pausar
				if(ventanaGame.pausar==true){
					unEnemigo= new logicaEnemigosConjunta(tipoEnemigo);
					//posicon aleatoria en el eje de las x (sin que toque los bordes para que se vea bien la imagen
					unEnemigo.setPosX((int)(Math.random()*((limiteIzquierdo)-limiteDerecho+1)+limiteDerecho));
					//la posicion de las y es el alto del panel
					unEnemigo.setPosY(ventanaGame.paneljuego.HEIGHT);
					//lo metemos en el array de enmigos
					misEnemigos.add(unEnemigo);

					//lo sacmos en el panel de juego
					if(unEnemigo!=null){
						ventanaGame.paneljuego.add(unEnemigo.getFotoEnemigo());
						ventanaGame.paneljuego.repaint();
						
						//cada nuevo enemigo sale mas rapido
						velocidadEstandar-=5;
						
					}else{
						System.out.println("no hay aun enemigo");
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
	}

	/*
	 * hilo que gestiona el movimiento de los enemigos
	 * y la retira de vidas si pasan la frontera
	 */
	public class hiloMovimiento extends Thread{
		int i;
		public void run(){
			while(ventanaGame.vida>0&&(funcionar)){
				//usamos el boton pausar
				//System.out.println(ventanaGame.pausar);
				if(ventanaGame.pausar==true){
					
					//les damos movimiento
					for(i=0;i<misEnemigos.size();i++){
						//	misEnemigos.get(i).gira(10);
						misEnemigos.get(i).setSuVelocidad(velocidadEstandar);
						misEnemigos.get(i).mueve(0.040, misEnemigos.get(i).getGiro());
						ventanaGame.paneljuego.repaint();
					}
					//miramos si sobrepasan las frontera
					for(i=0;i<misEnemigos.size();i++){
						if(misEnemigos.get(i).getPosY()>ventanaGame.altoPanelJuego-50){
							ventanaGame.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
							misEnemigos.remove(i);
							ventanaGame.vida-=1;
							ventanaStart.contenedor.setEnemigoPasa1(ventanaStart.contenedor.getEnemigoPasa1()+1);
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

					try {
						hiloMovimiento.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				//usamos el boton pausar
				if(ventanaGame.pausar==true){
					for(z=0;z<ventanaGame.misLasers.size();z++){
						for(i=0;i<misEnemigos.size();i++){

							Area areaEnemigo = new Area(misEnemigos.get(i).getFoto().miArea);
							Area areaLaser = new Area(ventanaGame.misLasers.get(z).getFotoLaser().miArea );
							if(areaEnemigo.intersects(areaLaser.getBounds2D())){
								ventanaGame.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
								misEnemigos.remove(i);
								//contamos enemigos muertos
								ventanaStart.contenedor.setEnemigosNMuertos1(ventanaStart.contenedor.getEnemigosNMuertos1()+1);

								//aumentamos la puntuacion
								ventanaStart.contenedor.setPuntuacion(ventanaStart.contenedor.getPuntuacion()+1);
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

}
