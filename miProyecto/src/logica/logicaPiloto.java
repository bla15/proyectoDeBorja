package logica;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Comparator;

public class logicaPiloto implements Serializable{
	
	//iniciamos las variables
	int puntuacion=0;
	String Nombre;
	//enemigos
	int enemigosNMuertos1=0;
	int enemigosNMuertos2=0;
	int enemigosNMuertos3=0;
	//enemigos que me han quitado vida
	int enemigoPasa1=0;
	int enemigoPasa2=0;
	int enemigoPasa3=0;
	//tiempo de la partida
	long tiempoPartida=0;
	//misiles lanzados
	int misilesDisparados=0;
	double eficiencia=0;
	//rebotes
	int rebotesIzquierdos=0;
	int rebotesDerechos=0;
	
	public logicaPiloto(){
		
	}
	
	public String eficiencia(){
	
		eficiencia=(double)(enemigosNMuertos1+enemigosNMuertos2+enemigosNMuertos3)/misilesDisparados;
	
		DecimalFormat formateador = new DecimalFormat("###.##%");
	
		return formateador.format(eficiencia);
	}
	public long tiempoTranscurrido(){
		long tiempo;
		tiempo=(System.currentTimeMillis()-tiempoPartida)/1000;
		return tiempo;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEnemigosNMuertos1() {
		return enemigosNMuertos1;
	}

	public void setEnemigosNMuertos1(int enemigosNMuertos1) {
		this.enemigosNMuertos1 = enemigosNMuertos1;
	}

	public int getEnemigosNMuertos2() {
		return enemigosNMuertos2;
	}

	public void setEnemigosNMuertos2(int enemigosNMuertos2) {
		this.enemigosNMuertos2 = enemigosNMuertos2;
	}

	public int getEnemigosNMuertos3() {
		return enemigosNMuertos3;
	}

	public void setEnemigosNMuertos3(int enemigosNMuertos3) {
		this.enemigosNMuertos3 = enemigosNMuertos3;
	}

	public int getEnemigoPasa1() {
		return enemigoPasa1;
	}

	public void setEnemigoPasa1(int enemigoPasa1) {
		this.enemigoPasa1 = enemigoPasa1;
	}

	public int getEnemigoPasa2() {
		return enemigoPasa2;
	}

	public void setEnemigoPasa2(int enemigoPasa2) {
		this.enemigoPasa2 = enemigoPasa2;
	}

	public int getEnemigoPasa3() {
		return enemigoPasa3;
	}

	public void setEnemigoPasa3(int enemigoPasa3) {
		this.enemigoPasa3 = enemigoPasa3;
	}

	public long getTiempoPartida() {
		return tiempoPartida;
	}

	public void setTiempoPartida(long tiempoPartida) {
		this.tiempoPartida = tiempoPartida;
	}

	public int getMisilesDisparados() {
		return misilesDisparados;
	}

	public void setMisilesDisparados(int misilesDisparados) {
		this.misilesDisparados = misilesDisparados;
	}

	public double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(int eficiencia) {
		this.eficiencia = eficiencia;
	}

	public int getRebotesIzquierdos() {
		return rebotesIzquierdos;
	}

	public void setRebotesIzquierdos(int rebotesIzquierdos) {
		this.rebotesIzquierdos = rebotesIzquierdos;
	}

	public int getRebotesDerechos() {
		return rebotesDerechos;
	}

	public void setRebotesDerechos(int rebotesDerechos) {
		this.rebotesDerechos = rebotesDerechos;
	}
	@Override
	public boolean equals(Object obj) {  
		//Dos pilotos son iguales si tienen la misma putuacion
		if (!(obj instanceof logicaPiloto)) return false;
		logicaPiloto est2 = (logicaPiloto) obj;
		return (getPuntuacion()==(est2.getPuntuacion()));
	}
	
	public static Comparator<logicaPiloto> puntuacionComparador = new Comparator<logicaPiloto>() {

		public int compare(logicaPiloto p1, logicaPiloto p2) {
			  int puntuacion1 = p1.getPuntuacion();
			  int puntuacion2 = p2.getPuntuacion();
			return puntuacion2-puntuacion1;
			
		}};

}
