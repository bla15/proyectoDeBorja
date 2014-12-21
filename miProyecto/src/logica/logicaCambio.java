package logica;

import hilosEnemigos.enemigoCuatro;
import hilosEnemigos.enemigoDos;
import hilosEnemigos.enemigoUno;
import ventanas.ventanaGame;



public class logicaCambio {
	//varaible que usaremos para determinar el tiempo pasado desde que iniciamos el juego
	int tiempoAlEmpezar;
	boolean funcionar= true;
	
	boolean paso1=true;
	boolean paso2=true;
	boolean paso3=true;
	
	enemigoUno enemigosFirst;
	enemigoDos enemigoTwo;
	enemigoCuatro enemigosFourth;
	
	public logicaCambio(){
		//le metemos el tiempo
		tiempoAlEmpezar=(int) System.currentTimeMillis();
		System.out.println(tiempoAlEmpezar);
		hiloCambios miHiloCambios = new hiloCambios(); 
		miHiloCambios.start();
		
		//creamos los primeros enemigos
		enemigosFirst= new enemigoUno();

		

	}

	public class hiloCambios extends Thread{
		public void run(){
			while(true){
				try {
					//si pasa 30 segundos hace el primer cambio de mapa
					if((int)System.currentTimeMillis()-tiempoAlEmpezar>3000){
						//acabamos con los enemigos uno
						enemigoUno.funcionar=false;
						if((enemigosFirst.getTamañoArray()==0)&&(paso1==true)){
							//EMPEZAMOS CON LOS DOS
							paso1=false;
							ventanaGame.paneljuego.setCambio("/fondos/puertaSalto.jpg");
							ventanaGame.paneljuego.repaint();
							//paramos la creacion de enenmigos de otro tipo
							enemigoTwo=new enemigoDos();
							
							tiempoAlEmpezar=(int)System.currentTimeMillis();
							
						}
						//ACABAMOS CON LOS ENEMIGOS DOS
						if(((int)System.currentTimeMillis()-tiempoAlEmpezar>3000)&&(enemigosFirst.getTamañoArray()==0)){
							enemigoDos.funcionar=false;
							
							if((enemigoTwo.getTamañoArray()==0)&&(paso2==true)){
								//EMPEZAMOS CON LOS TRES
								paso2=false;
								ventanaGame.paneljuego.setCambio("/fondos/saturno.jpg");
								ventanaGame.paneljuego.repaint();
								enemigosFourth=new enemigoCuatro();
								//ACABAMOS CON LOS ENEMIGOS TRES....
								//ultima entrada
								funcionar= false;
							}
						}

					}
					

					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
