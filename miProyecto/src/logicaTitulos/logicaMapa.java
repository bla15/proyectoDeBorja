package logicaTitulos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class logicaMapa extends JLabel{
	//tamaño del mapa
	public static int tamañoX = 200;
	public static int tamañoY = 100;

	//constructor
	public logicaMapa(){
		//le damos el tamaño antes definido
		setSize(tamañoX, tamañoY);

		//CReamos una BufferedImage de nombre "imgagenPrimitiva" , que lee el archivo donde esta la imagen
		BufferedImage imgagenPrimitiva = null;//CReamos una BufferedImage de nombre "img" , con la cual se lee el archivo donde esta la imagen
		//Hacemos el try cathc por si no en cuentra el fichero
		try {
			imgagenPrimitiva = ImageIO.read(new File("bin\\logicaTitulos\\mapaMundial.png"));
		} catch (IOException e) {
			System.err.print("No se ha podido cargar bien la imagen");
			e.printStackTrace();
		}
		/*Utilizo el metodo getScaledInstance el cual pertenenece a la clase BufferedImage y nos da una Image
		 *redimensionada 
		 */
		setIcon(new ImageIcon(imgagenPrimitiva.getScaledInstance(tamañoX, tamañoY, Image.SCALE_SMOOTH)));

	}
	protected void paintComponent(Graphics g) {
		Image imagenRedimensionada= ((ImageIcon)getIcon()).getImage();
		//El Graphics realmente es Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		// Prepara rotación (siguientes operaciones se rotarán)
		//g2.rotate( miGiro, 50, 50 );
		// Prepara rotación (siguientes operaciones se rotarán)
		g2.drawImage( imagenRedimensionada, 0, 0, tamañoX, tamañoY, null );
	}

}
