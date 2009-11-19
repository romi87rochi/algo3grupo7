

import java.util.ArrayList;

import java.util.Iterator;


public class Juego {
	private static final int FILAS = 200;
	private static final int COLUMNAS = 200;
	private Tablero tablero;
	private ArrayList fantasmas;
	private Personaje packman;
	private  Maps[] mapas;
	private boolean finJuego;
	private int puntaje;
	private int cantItemsDelNivel;
	private int vidasPackman;
	private int nivel;

	/*
	 * El juego recibe una lista de fantasmas y otra de packman para que este
	 * conozca a sus personajes. Mapas es un array de mapas predefinidos
	 */
	public Juego(ArrayList fantasmas, Personaje packman,Maps[] mapas) {

		tablero = new Tablero(FILAS, COLUMNAS);
		this.mapas = mapas;
		this.fantasmas = fantasmas;
		this.packman = packman;
		int cantPasilltas;
		puntaje = 0;
		cantItemsDelNivel=0;
		finJuego = false;
		vidasPackman = 3;
		nivel = 0;

	}

	public void iniciarJuego() {

		this.nuevoNivel();
	}

	/*Carga el mapa segun el nivel y obliga a los fantasmas y a packman regresar a sus posiciones predefinidas*/
	public void nuevoNivel() {
		tablero.cargarTablero(mapas[nivel]);
		Iterator itFantasmas = fantasmas.iterator();
		while (itFantasmas.hasNext()) {
			((Personaje)itFantasmas.next()).reubicar();
		}
		packman.reubicar();
	}

	/*
	 * pude ser comido indica el estado que debe tomar el personajeTodos los
	 * fantasmas del juego cambian su estado.
	 */
	public void cambiarEstadoDeLosFantasmas() {
		Iterator itFantasmas = fantasmas.iterator();
		while (itFantasmas.hasNext()) {
			((Personaje)itFantasmas.next()).cambiarEstado();
		}
	}

	/* Cambia el estado de packman dependiendo de puedeSerComido */
	public void cambiarEstadoPackman(boolean puedeSerComido) {
		packman.cambiarEstado();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void setFinJuego(boolean finJuego) {
		this.finJuego = finJuego;
	}

	public int getPuntaje() {
		return puntaje;
	}

	
	
	/* puntaje es sumado a la cantidad de puntos totales */
	public void setPuntaje(int puntaje) {
		this.puntaje = this.getPuntaje() + puntaje;
	}

	public int getCantidadItemsDelNivel() {
		return cantItemsDelNivel;
	}
  
	/*Decrementa en una unidad la cantidad de items restantes del nivel actual cuando 
	 * alguno de estos es comido
	 */
	public void itemComido(){
		--cantItemsDelNivel;
	}
	public int getVidasPackman() {
		return vidasPackman;
	}

	/*Decrementa una vida a packman cuando este es comido por 
	 * un fantasma si el total de vidas es cero finaliza el juego
	 */
	public void decrementarVidaPackman() {
		--vidasPackman;
		if (vidasPackman==0){
			 this.finalizarJuego();
		}		
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
    
	public void finalizarJuego(){
		this.finJuego=true;
	}	
	}
