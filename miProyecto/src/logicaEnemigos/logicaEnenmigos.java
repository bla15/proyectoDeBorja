package logicaEnemigos;

public class logicaEnenmigos {

	//creamos valorres numericos para cada una de las variables que tendra el laser
	private double suVelocidad;
	private double suDireccionActual;
	private double posX;
	private double posY;

	public logicaEnenmigos(){
		//le damos una velocidad inicial al laser
		suVelocidad = 50;
		suDireccionActual = 0.0;
		posX = 500 ;
		posY = 500;
		}
	
	
	public double getSuVelocidad() {
		return suVelocidad;
		}
		public void setSuVelocidad(double suVelocidad) {
		this.suVelocidad = suVelocidad;
		}
		public double getSuDireccionActual() {
		return suDireccionActual;
		}
		public void setSuDireccionActual(double dir) {
		if (dir < 0) dir = 360 + dir;
		if (dir > 360) dir = dir - 360;
		suDireccionActual = dir;
		}
		public double getPosX() {
		return posX;
		}
		public void setPosX(double posX) {
		this.posX = posX;
		}
		public double getPosY() {
		return posY;
		}
		public void setPosY(double posY) {
		this.posY = posY;
		}

		public void setPosicion(double posX,double posY){
		setPosY(posX);
		setPosX(posY);
		}

		//generamos el metodo para la aceleracion de los enemigos
		public void acelera(double aceleracion){
			suVelocidad += aceleracion;
		}
		//generamos el metodo para que el enemigo gire
		public void gira( double giro ) {
		setSuDireccionActual( suDireccionActual + giro );
		}

		//tiempo por segundo de el movimeiento
		public void mueve( double tiempoDeMovimiento) {
		setPosX( posX + suVelocidad * Math.sin(suDireccionActual/180.0*Math.PI) * tiempoDeMovimiento );
		// el negativo es porque en pantalla la Y crece hacia abajo y no hacia arriba
		setPosY( posY + suVelocidad * -Math.cos(suDireccionActual/180.0*Math.PI) * tiempoDeMovimiento );

		}
}
