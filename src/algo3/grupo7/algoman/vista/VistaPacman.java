package algo3.grupo7.algoman.vista;

import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import algo3.grupo7.algoman.modelo.Pacman;
import java.awt.image.BufferedImage;
/*El objetivo de los metodos cargarImagen determinarImagen y cargarNombreArchivos
 * es optimizar la velocidad de busqueda de las imagenes q seran utilizadas constantmente
 * La idea es evitar la constante busqueda de imagenes desde el disco rigido, en cambio ahora los 
 * archivos seran alamacenados en memoria optimizando el rendimiento final del juego
 */


public class VistaPacman extends Imagen {
	private static final int IZQUIERDA=0;
	private static final int DERECHA=1;
	private static final int ARRIBA=2;
	private static final int ABAJO=3;
	private Pacman pacman;
	private ArrayList<BufferedImage> listaImagenes;
	private ArrayList<String> listaNombreArchivos;

	public VistaPacman(Pacman unPacman) {
		super();
		this.pacman = unPacman;
		this.setPosicionable(pacman);
		this.listaImagenes = new ArrayList<BufferedImage>();
		this.listaNombreArchivos = new ArrayList<String>();
		this.cargarNombresArchivos();
		try {
			this.cargarImagenes();

		} catch (IOException e) {
		}

	}

	/*Guarda en una lista la ruta y nombre de las imagenes que seran
	 * utilizadas para mostrar los diferentes estados del modelo
	 */
	private void cargarNombresArchivos() {
		this.listaNombreArchivos.add(IZQUIERDA,"PacmanIzquierda.jpg");
		this.listaNombreArchivos.add(DERECHA,"PacmanDerecha.jpg");
		this.listaNombreArchivos.add(ARRIBA,"PacmanArriba.jpg");
		this.listaNombreArchivos.add(ABAJO,"PacmanAbajo.jpg");
	}

	
	/*Determina segun la direccion del pacman la imagen q debe
	 * utilizarse para ser pintada, esta es obtenida de la listaDeImagenes
	 */
	private BufferedImage determinarImagen() {
		if (pacman.getDireccionActual() == "izquierda")
			return this.listaImagenes.get(IZQUIERDA);
		if (pacman.getDireccionActual() == "derecha")
			return this.listaImagenes.get(DERECHA);
		if (pacman.getDireccionActual() == "arriba")
			return this.listaImagenes.get(ARRIBA);
		if (pacman.getDireccionActual() == "abajo")
			return this.listaImagenes.get(ABAJO);

		return this.listaImagenes.get(0);
	}

	/*Guarda las imagenes en una lista de imagenes. Los nombres de estos archivos
	 * son obtenidos de la listaNombreArchivo
	 */
	private void cargarImagenes() throws ImageFormatException, IOException {
		String nombreArchivo;
		Iterator<String> itListaNombresArchivos = this.listaNombreArchivos
				.iterator();
		while (itListaNombresArchivos.hasNext()) {
			nombreArchivo = itListaNombresArchivos.next();
			InputStream in = getClass().getResourceAsStream(nombreArchivo);
			JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
			listaImagenes.add(decoder.decodeAsBufferedImage());
		}
	}

	/*Dibuja la imagen correspondiente al estado del pacman mediante la llamada a determinarImagen()
	 * la cual sera pintada en la superficie de dibujo.
	 */
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {

		Graphics grafico = ((Ventana) superficeDeDibujo).getGrafico();
		grafico.drawImage(this.determinarImagen(), this.getPosicionable()
				.getX(), this.getPosicionable().getY(), null);
	}

}
