package algo3.grupo7.algoman.modelo;

import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class ItemComible implements Posicionable {

	private int puntajePredeterminado;
	private boolean esPuntoDePoder;
	private Casillero casilleroActual;

	/* se le pasa el casillero actual para que el titiritero pueda dibujarlo en
	 * los mapas
	 */
	public ItemComible(int nuevoPuntaje, boolean esPuntoDePoder,
			Casillero casilleroActual) {

		this.puntajePredeterminado = nuevoPuntaje;
		this.esPuntoDePoder = esPuntoDePoder;
		this.casilleroActual = casilleroActual;
	}
	
	public Casillero getCasilleroActual() {
		return casilleroActual;
	}
	
	public int getPuntaje() {
		return this.puntajePredeterminado;
	}

	protected boolean esDePoder() {
		return esPuntoDePoder;
	}

	/* solo para implementar posicionable */
	public int getX() {
		return this.casilleroActual.getPosicion().getPosX();
	}

	/* solo para implementar posicionable */
	public int getY() {
		return this.casilleroActual.getPosicion().getPosY();
	}
}