import java.util.ArrayList;
import java.util.Iterator;

public class Casillero {

	private ArrayList<Fantasma> fantasmas;
	private Personaje pacman;
	private Item item;
	private boolean puedeSerVisitado;
	
	public boolean getPuedeSerVisitado() {
		return puedeSerVisitado;
	}

	private Posicion posicion;

	/* El Casillero queda instanciado sin item ni personajes */
	public Casillero(Posicion posicion) {
		fantasmas = new ArrayList<Fantasma>();
		item = null;
		pacman = null;
		puedeSerVisitado = true;
		this.posicion = posicion;

	}

	/* Agrega un nuevo fantasma al final de la lista */
	public void agregarFantasma(Personaje nuevoFantasma) {
		this.fantasmas.add((Fantasma) nuevoFantasma);
	}

	/* Agrega un pacman al casillero */
	public void agregarPacman(Personaje nuevoPacman) {
		this.pacman = nuevoPacman;
	}

	public void setItem(Item nuevoItem) {
		item = nuevoItem;

	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	/* quita el item del casillero cuando este es comido por pacman */
	public void removerItem() {
		item = null;
	}

	public Item getItem() {
		return item;
	}

	/*
	 * Quita un personaje de la lista, este metodo sera utilizado para que un
	 * personaje pueda eliminar su posicion del casillero al desplazarse
	 */
	public void removerFantasma(Personaje estePersonaje) {
		Iterator<Fantasma> itFantasmas = fantasmas.iterator();
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

}
