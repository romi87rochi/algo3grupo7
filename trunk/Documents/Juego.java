package game;

import java.util.ArrayList;

import java.util.Iterator;


public class Juego {
	Tablero tablero;
	ArrayList fantasmas;
	Personaje packman;
	ArrayList mapas;
	boolean finJuego;
	int puntaje;
	int cantItemsDelNivel;
	int vidasPackman;
	int nivel;

	/*
	 * El juego recibe una lista de fantasmas y otra de packman para que este
	 * conozca a sus personajes. Mapas es un array de mapas predefinidos
	 */
	public Juego(ArrayList fantasmas, Personaje packman,Maps[] Mapas) {

		tablero = new Tablero(filas, columnas);
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
		tablero.cargarTablero(mapa[nivel]);
		Iterator itFantasmas = fantasmas.iterator();
		while (itFantasmas.hasNext()) {
			((Personaje)itFantasmas.next()).reset();
		}
		packman.reset();
	}

	/*
	 * pude ser comido indica el estado que debe tomar el personajeTodos los
	 * fantasmas del juego cambian su estado.
	 */
	public void cambiarEstadoDeLosFantasmas(boolean puedeSerComido) {
		Iterator itFantasmas = fantasmas.iterator();
		while (itFantasmas.hasNext()) {
			((Personaje)itFantasmas.next()).cambiarEstado(puedeSerComido);
		}
	}

	/* Cambia el estado de packman dependiendo de puedeSerComido */
	public void cambiarEstadoPackman(boolean puedeSerComido) {
		packman.cambiarEstado(puedeSerComido);
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

	public void decrementarVidaPackman() {
		--vidasPackman;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}