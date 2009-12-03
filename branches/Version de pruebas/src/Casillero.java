import java.util.ArrayList;
import java.util.Iterator;

public class Casillero {

	private ArrayList<Fantasma> fantasmas;
	private Personaje pacman;
	private ItemComible item;
	private boolean puedeSerVisitado;
	private Posicion posicion;
	private Tablero tablero;
	
	public boolean getPuedeSerVisitado() {
		return puedeSerVisitado;
	}

	/* El Casillero queda instanciado sin item ni personajes */
	public Casillero(Posicion posicion,Tablero tablero) {
		fantasmas = new ArrayList<Fantasma>();
		item = null;
		pacman = null;
		puedeSerVisitado = true;
		this.posicion = posicion;
		this.tablero=tablero;
	}
	
	public void conocerTablero(){
		
	}

	/* Agrega un nuevo fantasma al final de la lista */
	public void agregarFantasma(Personaje nuevoFantasma) {
		this.fantasmas.add((Fantasma) nuevoFantasma);
	}

	/* Agrega un pacman al casillero */
	public void agregarPacman(Personaje nuevoPacman) {
		this.pacman = nuevoPacman;
	}

	public void setItem(ItemComible nuevoItem) {
		item = nuevoItem;

	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	/* quita el item del casillero cuando este es comido por pacman */
	public void removerItem() {
		item = null;
	}

	public ItemComible getItem() {
		return item;
	}

	/*
	 * Quita un personaje de la lista, este metodo sera utilizado para que un
	 * personaje pueda eliminar su posicion del casillero al desplazarse
	 */
	public void removerFantasma(Personaje estePersonaje) {
		Iterator<Fantasma> itFantasmas = this.fantasmas.iterator();
		boolean encontrado = false;
		while (itFantasmas.hasNext() && !encontrado) {
			if (itFantasmas.next() == estePersonaje) {
				itFantasmas.remove();
				encontrado = true;
			}
		}
	}

	/*
	 * Devuelve una lista con todos los fantasmas que se encuntren en un
	 * casillero
	 */
	public ArrayList<Fantasma> getFantasmas() {
		return this.fantasmas;
	}

	public void removerPacman(Personaje estePersonaje) {
		pacman = null;
	}

	public Personaje getPacman() {
		return pacman;
	}

	public Casillero getArriba(){
		Casillero arriba = null;
		Posicion  posArriba = null;
		posArriba = this.posicion.getArriba();
		arriba = this.tablero.getCasillero(posArriba);
		return arriba;
	}
	public Casillero getAbajo(){
		Casillero abajo = null;
		Posicion  posAbajo = null;
		posAbajo = this.posicion.getAbajo();
		abajo = this.tablero.getCasillero(posAbajo);
		return abajo;
	}
	
	public Casillero getIzquierda(){
		Casillero izquierda = null;
		Posicion  posIzquierda = null;
		posIzquierda = this.posicion.getIzquierda();
		izquierda = this.tablero.getCasillero(posIzquierda);
		return izquierda;
	}
	
	public Casillero getDerecha(){
		Casillero derecha = null;
		Posicion  posDerecha = null;
		posDerecha = this.posicion.getDerecha();
		derecha = this.tablero.getCasillero(posDerecha);
		return derecha;
	}
	
	public boolean puedeSerVisitado(){
		return puedeSerVisitado;
	}
	
	public boolean hayPacman(){
		return pacman!=null;
	}
	
	public boolean hayItem(){
		return item!=null;
	}

	public void setHacerPared() {
		this.puedeSerVisitado=false;
	}
}
