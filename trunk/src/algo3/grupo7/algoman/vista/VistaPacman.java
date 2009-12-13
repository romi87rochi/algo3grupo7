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
	private static final int BOCAABIERTAIZQ = 0;
	private static final int BOCAABIERTADER = 1;
	private static final int BOCAABIERTAARRIBA = 2;
	private static final int BOCAABIERTAABAJO = 3;
	private static final int BOCACERRADAIZQ = 4;
	private static final int BOCACERRADADER = 5;
	private static final int BOCACERRADAARRIBA = 6;
	private static final int BOCACERRADAABAJO = 7;
	private Pacman pacman;
	private ArrayList<BufferedImage> listaImagenes;
	private ArrayList<String> listaNombreArchivos;
	private int tiempoBocaAbierta;
	boolean bocaAbierta;

	public VistaPacman(Pacman unPacman) {
		super();
		this.pacman = unPacman;
		this.setPosicionable(pacman);
		this.listaImagenes = new ArrayList<BufferedImage>();
		this.listaNombreArchivos = new ArrayList<String>();
		this.tiempoBocaAbierta = 0;
		this.bocaAbierta = true;
		this.cargarNombresArchivos();
		try {
			this.cargarImagenes();

		} catch (IOException e) {
		}

	}

	/*
	 * Guarda en una lista la ruta y nombre de las imagenes que seran utilizadas
	 * para mostrar los diferentes estados del modelo
	 */
	private void cargarNombresArchivos() {
		//carga de imagenes con boca abierta
		this.listaNombreArchivos.add(BOCAABIERTAIZQ, "PacBocaAbiertaIzq.jpg");
		this.listaNombreArchivos.add(BOCAABIERTADER, "PacBocaAbiertaDer.jpg");
		this.listaNombreArchivos.add(BOCAABIERTAARRIBA, "PacBocaAbiertaArriba.jpg");
		this.listaNombreArchivos.add(BOCAABIERTAABAJO, "PacBocaAbiertaAbajo.jpg");
        //carga de imagenes con boca cerrada
		this.listaNombreArchivos.add(BOCACERRADAIZQ, "PacBocaCerradaIzq.jpg");
		this.listaNombreArchivos.add(BOCACERRADADER,  "PacBocaCerradaDer.jpg");
		this.listaNombreArchivos.add(BOCACERRADAARRIBA,"PacBocaCerradaArriba.jpg");
		this.listaNombreArchivos.add(BOCACERRADAABAJO, "PacBocaCerradaAbajo.jpg");
		
	}
	
	/*
	 * Determina segun la direccion del pacman y si la boca debe estar abierta o no
	 * la imagen q debe utilizarse para ser pintada, esta es obtenida de la listaDeImagenes
	 */

	private BufferedImage determinarImagen() {
      BufferedImage imagenAmostrar=this.listaImagenes.get(BOCAABIERTAIZQ);
		if (pacman.getDireccionActual() == "izquierda")
			if (this.bocaAbierta()) {
				imagenAmostrar= this.listaImagenes.get(BOCAABIERTAIZQ);
			} else
				imagenAmostrar =this.listaImagenes.get(BOCACERRADAIZQ);

		if (pacman.getDireccionActual() == "derecha")
			if (this.bocaAbierta()) {
				imagenAmostrar= this.listaImagenes.get(BOCAABIERTADER);
			} else {
				imagenAmostrar= this.listaImagenes.get(BOCACERRADADER);
			}

		if (pacman.getDireccionActual() == "arriba")
			if (this.bocaAbierta()) {
				imagenAmostrar= this.listaImagenes.get(BOCAABIERTAARRIBA);
			} else {
				imagenAmostrar= this.listaImagenes.get(BOCACERRADAARRIBA);
			}

		if (pacman.getDireccionActual() == "abajo")
			if(this.bocaAbierta()){
				imagenAmostrar= this.listaImagenes.get(BOCAABIERTAABAJO);
			}else{
				imagenAmostrar= this.listaImagenes.get(BOCACERRADAABAJO);
			}

		return imagenAmostrar;
	}

	/*Devuelve verdadero o falso dependiendo de si la boca debe estar abierta o cerrada*/
	private boolean bocaAbierta() {

		if (this.tiempoBocaAbierta > 0) {
			--this.tiempoBocaAbierta;
		} else {
			bocaAbierta = cerrarOabrirBoca();
			this.tiempoBocaAbierta = 2;
		}
		return bocaAbierta;
	}
 
	/*Cambia de boca abierta a cerrada y viceversa*/
	private boolean cerrarOabrirBoca() {

		if (this.bocaAbierta) {
			return bocaAbierta=false;
		} else {
			return bocaAbierta=true;
		}
	}

	/*
	 * Guarda las imagenes en una lista de imagenes. Los nombres y ruta de estos
	 * archivos son obtenidos de listaNombreArchivo
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

	/*
	 * Dibuja la imagen correspondiente al estado del pacman mediante la llamada
	 * a determinarImagen() la cual sera pintada en la superficie de dibujo.
	 */
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {

		Graphics grafico = ((Ventana) superficeDeDibujo).getGrafico();
		grafico.drawImage(this.determinarImagen(), this.getPosicionable()
				.getX(), this.getPosicionable().getY(), null);
	}

}
