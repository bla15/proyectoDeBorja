package hilosEnemigos;

public class eleccionHilo {
	hiloEnemigoUno enemigoUno;
	public eleccionHilo(int tipoEnemigo){
		if(tipoEnemigo==1){
			enemigoUno= new hiloEnemigoUno(tipoEnemigo);
		}
		if(tipoEnemigo==2){
			enemigoUno= new hiloEnemigoUno(tipoEnemigo);
		}
		if(tipoEnemigo==3){
			enemigoUno= new hiloEnemigoUno(tipoEnemigo);
		}
		if(tipoEnemigo==4){
			enemigoUno= new hiloEnemigoUno(tipoEnemigo);
		}
	}
		

}
