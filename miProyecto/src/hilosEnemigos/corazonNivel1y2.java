package hilosEnemigos;

import ventanas.ventanaGame;
import fondos.logicaFondos;

public class corazonNivel1y2 {
	// vidas que me quedan
	int vidas;
	//los corazones
	logicaFondos corazon1;
	logicaFondos corazon2;
	logicaFondos corazon3;
	logicaFondos corazon4;
	
	public corazonNivel1y2(int vida){
		//igualamos vidas
		vidas=vida;
		//creamos los corazones
		corazon1 = new logicaFondos("/fondos/corazonVivo.png");
		corazon1.setBounds(27, 10, 39, 45);
		ventanaGame.fondoControles.add(corazon1);
		
		corazon2 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon2.setBounds(75, 10, 39, 45);
		ventanaGame.fondoControles.add(corazon2);
		
		corazon3 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon3.setBounds(124, 10, 39, 45);
		ventanaGame.fondoControles.add(corazon3);
		
		corazon4 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon4.setBounds(165, 10, 39, 45);
		ventanaGame.fondoControles.add(corazon4);
		ventanaGame.fondoControles.repaint();
	}
	public void pares(){
		if(vidas==6){
			ventanaGame.fondoControles.remove(corazon4);
			corazon4 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon4.setBounds(165, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon4);
			ventanaGame.fondoControles.repaint();
		}
		if(vidas==4){
			ventanaGame.fondoControles.remove(corazon3);
			corazon3 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon3.setBounds(124, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon3);
			ventanaGame.fondoControles.repaint();
		}
		if(vidas==2){
			ventanaGame.fondoControles.remove(corazon2);
			corazon2 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon2.setBounds(75, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon2);
			ventanaGame.fondoControles.repaint();
		}
		if(vidas==0){
			ventanaGame.fondoControles.remove(corazon1);
			corazon1 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon1.setBounds(27, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon1);
			ventanaGame.fondoControles.repaint();
		}
	}
	public void impares(){
		if(vidas==7){
			ventanaGame.fondoControles.remove(corazon4);
			corazon4 = new logicaFondos("/fondos/medioCorazon.png");
			corazon4.setBounds(165, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon4);
			ventanaGame.fondoControles.repaint();
		}
		if(vidas==5){
			ventanaGame.fondoControles.remove(corazon3);
			corazon3 = new logicaFondos("/fondos/medioCorazon.png");
			corazon3.setBounds(124, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon3);
			ventanaGame.fondoControles.repaint();
		}
		if(vidas==3){
			ventanaGame.fondoControles.remove(corazon2);
			corazon2 = new logicaFondos("/fondos/medioCorazon.png");
			corazon2.setBounds(75, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon2);
			ventanaGame.fondoControles.repaint();
		}
		if(vidas==1){
			ventanaGame.fondoControles.remove(corazon1);
			corazon1 = new logicaFondos("/fondos/medioCorazon.png");
			corazon1.setBounds(27, 10, 39, 45);
			ventanaGame.fondoControles.add(corazon1);
			ventanaGame.fondoControles.repaint();
		}
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

}