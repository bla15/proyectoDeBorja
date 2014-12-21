package hilosEnemigos;



import hilosEnemigos.enemigoUno.hiloChoques;

import java.awt.geom.Area;
import java.util.ArrayList;

import ventanas.ventanaGame;
import logicaEnemigos.logicaEnemigosConjunta;


public class enemigoDos {
	int limiteDerecho=ventanaGame.paneljuego.WIDTH;
	int limiteIzquierdo=ventanaGame.anchoPanelJuego-50;
	public  logicaEnemigosConjunta unEnemigo;
	ArrayList<logicaEnemigosConjunta> misEnemigos = new ArrayList<logicaEnemigosConjunta>();
	
	int vida=8;
	int tipoEnemigo=2;
	public static boolean funcionar=true;

	public enemigoDos() {
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
			while(funcionar&&vida>0){
				unEnemigo= new logicaEnemigosConjunta(tipoEnemigo);
				//posicon aleatoria en el eje de las x (sin que toque los bordes para que se vea bien la imagen
				unEnemigo.setPosX((int)(Math.random()*((limiteIzquierdo)-limiteDerecho+1)+limiteDerecho));
				//la posicion de las y es el alto del panel
				unEnemigo.setPosY(ventanaGame.paneljuego.HEIGHT);
				//le damos un giro hacia la derecha o izquierda
				int numero = (int) (Math.random() * 2);
				if(numero==0){
					unEnemigo.setGiro(270);
				}else{
					unEnemigo.setGiro(90);
				}
				

				//lo metemos en el array de enmigos
				misEnemigos.add(unEnemigo);

				//lo sacmos en el panel de juego
				ventanaGame.paneljuego.add(unEnemigo.getFotoEnemigo());
				ventanaGame.paneljuego.repaint();
				
				try {
					//cada cuanto tiempo los va creando
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public class hiloMovimiento extends Thread{
		int i;
		public void run(){
			while(vida>0){
				//les damos movimiento
				for(i=0;i<misEnemigos.size();i++){
					//misEnemigos.get(i).gira(10);
					//Ultimo cambiado   misEnemigos.get(i).setSuVelocidad(-50/4);
					misEnemigos.get(i).setSuVelocidad(-50/2);
					//Ultimo modificado con giro = 90 como giro base (el movimiento enemigo es ya conocido)
					misEnemigos.get(i).mueve(0.040, misEnemigos.get(i).getGiro());
					ventanaGame.paneljuego.repaint();
				}
				for(i=0;i<misEnemigos.size();i++){
					if(misEnemigos.get(i).getPosY()>ventanaGame.altoPanelJuego-50){
						ventanaGame.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
						misEnemigos.remove(i);
						vida-=1;
						
					}
					if(misEnemigos.get(i).getPosX() < limiteDerecho){
						misEnemigos.get(i).setGiro(270);
						System.out.println("izq");
					} else if (misEnemigos.get(i).getPosX() > limiteIzquierdo){
						misEnemigos.get(i).setGiro(90);
						System.out.println("der");
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
	
	/*
	 * hilo que gestiona el movimiento de los enemigos
	 */
	public class hiloChoques extends Thread{
		int i;
		int z;
		public void run(){
			while(vida>0){
				for(z=0;z<ventanaGame.misLasers.size();z++){
					for(i=0;i<misEnemigos.size();i++){

						Area areaEnemigo = new Area(misEnemigos.get(i).getFoto().miArea);
						Area areaLaser = new Area(ventanaGame.misLasers.get(z).getFotoLaser().miArea );
						if(areaEnemigo.intersects(areaLaser.getBounds2D())){
							ventanaGame.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
							misEnemigos.remove(i);
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
