package hilosEnemigos;





import java.awt.geom.Area;
import java.util.ArrayList;
import logicaEnemigos.logicaEnemigosConjunta;
import ventanas.ventanaGame;





public class enemigoCuatro {
	int limiteDerecho=ventanaGame.paneljuego.WIDTH;
	int limiteIzquierdo=ventanaGame.anchoPanelJuego-50;

	public  logicaEnemigosConjunta unEnemigo;
	ArrayList<logicaEnemigosConjunta> misEnemigos = new ArrayList<logicaEnemigosConjunta>();
	ArrayList<Long> tiempo = new ArrayList<Long>();
	Long tiempoAccion;
	
	//los corazones
		//corazonNivel3y4 corazon;
	
	int vida=4;
	int tipoEnemigo=4;
	

	public static boolean funcionar=true;
	
	public enemigoCuatro(){
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
			System.out.println( funcionar);
			
			while(funcionar&&vida>0){
				unEnemigo= new logicaEnemigosConjunta(tipoEnemigo);
				//posicon aleatoria en el eje de las x (sin que toque los bordes para que se vea bien la imagen
				unEnemigo.setPosX((int)(Math.random()*((limiteIzquierdo)-limiteDerecho+1)+limiteDerecho));
				//la posicion de las y es el alto del panel
				unEnemigo.setPosY(ventanaGame.paneljuego.HEIGHT);
				//lo metemos en los arrays los datos
				misEnemigos.add(unEnemigo);
				tiempo.add(System.currentTimeMillis());
				

				//lo sacamos en el panel de juego
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
	
	/*
	 * hilo que gestiona el movimiento de los enemigos
	 * y la retira de vidas si pasan la frontera
	 */
public class hiloMovimiento extends Thread{

	int i;
	public void run(){
		while(vida>0){
			
			
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
				misEnemigos.get(i).setSuVelocidad(-100);
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
					vida-=1;
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
						tiempo.remove(i);

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

