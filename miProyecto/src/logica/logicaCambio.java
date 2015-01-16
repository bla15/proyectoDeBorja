package logica;

import hilosEnemigos.enemigoCuatro;
import hilosEnemigos.enemigoDos;
import hilosEnemigos.enemigoUno;
import ventanas.ventanaGame;



public class logicaCambio {
	//varaible que usaremos para determinar el tiempo pasado desde que iniciamos el juego
	long tiempoAlEmpezar;
	long tiempoMapa2;
	public static boolean funcionar= true;
	
	boolean paso1=true;
	boolean paso2=true;
	boolean paso3=true;
	
	enemigoUno enemigosFirst;
	enemigoDos enemigoTwo;
	enemigoCuatro enemigosFourth;
	
	public logicaCambio(){
		//llaves de los hilos 
		funcionar=true;
		paso1=true;
		paso2=false;
		paso3=false;
		//le metemos el tiempo
		tiempoAlEmpezar=(int) System.currentTimeMillis();
		tiempoMapa2=0;
		
		hiloCambios miHiloCambios = new hiloCambios(); 
		miHiloCambios.start();
		
		//creamos los primeros enemigos
		enemigosFirst= new enemigoUno();

		

	}

	public class hiloCambios extends Thread{
		public void run(){
			while(funcionar){
				if(ventanaGame.pausar==true){
					try {
						if(paso1==true){
							//System.out.println(((int)System.currentTimeMillis()-tiempoAlEmpezar)/1000+" seg:   mapa 1");
							//si pasa 30 segundos hace el primer cambio de mapa
							if(((int)System.currentTimeMillis()-tiempoAlEmpezar>3000)&&(ventanaGame.vida>0)){
								//acabamos con los enemigos uno
								enemigoUno.pasoMapa=false;
								if((enemigosFirst.getTamañoArray()==0)&&(paso1==true)){
									//EMPEZAMOS CON LOS DOS
									paso1=false;
									ventanaGame.paneljuego.setCambio("/fondos/puertaSalto.jpg");
									ventanaGame.paneljuego.repaint();
									//paramos la creacion de enenmigos de otro tipo
									enemigoTwo=new enemigoDos();

									tiempoMapa2=(int)System.currentTimeMillis();
									paso2=true;
									//System.out.println("CHANGEEEE");
								}
							}
						}
						
							//ACABAMOS CON LOS ENEMIGOS DOS
							
							if(paso2==true){
								//System.out.println(((int)System.currentTimeMillis()-tiempoMapa2)/1000+"  seg:   mapa 2");
								if(((int)System.currentTimeMillis()-tiempoMapa2>3000)&&(enemigosFirst.getTamañoArray()==0)&&(ventanaGame.vida>0)){
									enemigoDos.pasoMapa=false;

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

}
