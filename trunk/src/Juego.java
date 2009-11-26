

import java.util.ArrayList;

import java.util.Iterator;


public class Juego {
	private static final int FILAS = 200;
	private static final int COLUMNAS = 200;
	private Tablero tablero;
	private ArrayList<Fantasma> fantasmas;
	private Personaje pacman;
	private  Map[] mapas;
	private boolean finJuego;
	private int puntaje;
	private int cantPastillasDelNivel;
	private int vidasPacman;
	private int nivel;

	/*
	 * El juego recibe una lista de fantasmas y otra de packman para que este
	 * conozca a sus personajes. Mapas es un array de mapas predefinidos
	 */
	public Juego(Map[] mapas) {

		tablero = new Tablero(FILAS, COLUMNAS);
		//this.mapas = mapas;
		this.fantasmas = new ArrayList<Fantasma>();
		this.pacman =  null;
		puntaje = 0;
		cantPastillasDelNivel=100;
		finJuego = false;
		vidasPacman = 3;
		nivel = 0;

	}

	public void iniciarJuego() {

		this.nuevoNivel();
	}
	
	public void reubicarTodosLosPersonajes(){
		Iterator<Fantasma> itFantasmas = fantasmas.iterator();
		while (itFantasmas.hasNext()) {
			Personaje fantasmaAux=(Personaje)itFantasmas.next();
			fantasmaAux.reubicar();
		}
		pacman.reubicar();
	}
	
	
	/*Carga el mapa segun el nivel y obliga a los fantasmas y a packman regresar a sus posiciones predefinidas*/
	public void nuevoNivel() {
		//tablero.cargarTablero(mapas[nivel]);
		this.reubicarTodosLosPersonajes();
	}

	/*
	 * pude ser comido indica el estado que debe tomar el personajeTodos los
	 * fantasmas del juego cambian su estado.
	 */
	public void cambiarEstadoDeLosFantasmas() {
		Iterator<Fantasma> itFantasmas = fantasmas.iterator();
		while (itFantasmas.hasNext()) {
			((Personaje)itFantasmas.next()).cambiarEstado();
		}
	}

	/* Cambia el estado de packman dependiendo de puedeSerComido */
	public void cambiarEstadoPackman() {
		pacman.cambiarEstado();
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

	public int getCantPastillasDelNivel() {
		return cantPastillasDelNivel;
	}
  
	/*Decrementa en una unidad la cantidad de items restantes del nivel actual cuando 
	 * alguno de estos es comido
	 */
	public void pastillaComida(){
		--cantPastillasDelNivel;
	}
	public int getVidasPackman() {
		return vidasPacman;
	}

	/*Decrementa una vida a packman cuando este es comido por 
	 * un fantasma si el total de vidas es cero finaliza el juego
	 */
	public void decrementarVidaPackman() {
		--vidasPacman;
		if (vidasPacman==0){
			 this.finalizarJuego();
		}		
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
    
	/*Finaliza el juego cuando la cantidad de vidas de packman
	 * es cero.
	 */
	public void finalizarJuego(){
		this.finJuego=true;
	}	
	
	/*Agrega como atributo del juego un obejto Pacman*/
	public void conocerPacman(Personaje unPacman){
		this.pacman=unPacman;
	}
	
	/*Agrega como atributo del juego un objeto Fantasma*/
	public void conocerFantasma(Personaje unFantasma){
		fantasmas.add((Fantasma)unFantasma);
	}
	}
