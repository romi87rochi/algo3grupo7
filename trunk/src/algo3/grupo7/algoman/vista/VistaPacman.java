package algo3.grupo7.algoman.vista;


import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import algo3.grupo7.algoman.modelo.Pacman;


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
	private int tiempoBocaAbierta;
	boolean bocaAbierta;

	public VistaPacman(Pacman unPacman) {
		super();
		this.pacman = unPacman;
		this.setPosicionable(pacman);
		this.tiempoBocaAbierta = 0;
		this.bocaAbierta = true;
		this.cargarNombresArchivos();
	}

	/*
	 * Guarda en una lista la ruta y nombre de las imagenes que seran utilizadas
	 * para mostrar los diferentes estados del modelo
	 */
	private void cargarNombresArchivos() {
		// carga de imagenes con boca abierta
		this.agregarImagenes(BOCAABIERTAIZQ, "PacBocaAbiertaIzq.jpg");
		this.agregarImagenes(BOCAABIERTADER, "PacBocaAbiertaDer.jpg");
		this.agregarImagenes(BOCAABIERTAARRIBA, "PacBocaAbiertaArriba.jpg");
		this.agregarImagenes(BOCAABIERTAABAJO, "PacBocaAbiertaAbajo.jpg");
		// carga de imagenes con boca cerrada
		this.agregarImagenes(BOCACERRADAIZQ, "PacBocaCerradaIzq.jpg");
		this.agregarImagenes(BOCACERRADADER, "PacBocaCerradaDer.jpg");
		this.agregarImagenes(BOCACERRADAARRIBA, "PacBocaCerradaArriba.jpg");
		this.agregarImagenes(BOCACERRADAABAJO, "PacBocaCerradaAbajo.jpg");
	}

	/*
	 * Determina segun la direccion del pacman y si la boca debe estar abierta o
	 * no la imagen q debe utilizarse para ser pintada, esta es obtenida de la
	 * listaDeImagenes
	 */

	private void determinarImagen() {
		this.setImagenAgregada(BOCAABIERTAIZQ);
		if (pacman.getDireccionActual() == "izquierda")
			if (this.bocaAbierta()) {
				this.setImagenAgregada(BOCAABIERTAIZQ);
			} else
				this.setImagenAgregada(BOCACERRADAIZQ);

		if (pacman.getDireccionActual() == "derecha")
			if (this.bocaAbierta()) {
				this.setImagenAgregada(BOCAABIERTADER);
			} else {
				this.setImagenAgregada(BOCACERRADADER);
			}

		if (pacman.getDireccionActual() == "arriba")
			if (this.bocaAbierta()) {
				this.setImagenAgregada(BOCAABIERTAARRIBA);
			} else {
				this.setImagenAgregada(BOCACERRADAARRIBA);
			}

		if (pacman.getDireccionActual() == "abajo")
			if (this.bocaAbierta()) {
				this.setImagenAgregada(BOCAABIERTAABAJO);
			} else {
				this.setImagenAgregada(BOCACERRADAABAJO);
			}
	}

	/*
	 * Devuelve verdadero o falso dependiendo de si la boca debe estar abierta o
	 * cerrada
	 */
	private boolean bocaAbierta() {

		if (this.tiempoBocaAbierta > 0) {
			--this.tiempoBocaAbierta;
		} else {
			bocaAbierta = cerrarOabrirBoca();
			this.tiempoBocaAbierta = 2;
		}
		return bocaAbierta;
	}

	/* Cambia de boca abierta a cerrada y viceversa */
	private boolean cerrarOabrirBoca() {

		if (this.bocaAbierta) {
			return bocaAbierta = false;
		} else {
			return bocaAbierta = true;
		}
	}

	/*
	 * Dibuja la imagen correspondiente al estado del pacman mediante la llamada
	 * a determinarImagen() la cual sera pintada en la superficie de dibujo.
	 */
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		this.determinarImagen();
		super.dibujar(superficeDeDibujo);
	}

}
