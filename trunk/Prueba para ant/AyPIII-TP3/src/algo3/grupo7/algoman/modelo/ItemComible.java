package algo3.grupo7.algoman.modelo;


import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class ItemComible implements  Posicionable {

	private int puntajePredeterminado;
	private boolean esPuntoDePoder;
	private boolean puedeSerComido;
	private Casillero casilleroActual;

	/* se le pasa el casillero actual para que el titiritero pueda dibujarlo en
	 * los mapas
	 */
	public ItemComible(int nuevoPuntaje, boolean esPuntoDePoder,
			Casillero casilleroActual,boolean puedeSerComido) {

		this.puntajePredeterminado = nuevoPuntaje;
		this.esPuntoDePoder = esPuntoDePoder;
		this.puedeSerComido=puedeSerComido;
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
	
	public void encontrado(){
		if (this.puedeSerComido)
			this.getCasilleroActual().setItem(null);
		}
		
	public boolean puedeSerComido(){
		return this.puedeSerComido;
	}
	protected void setPuedeserComido(boolean puedeSerComido){
		this.puedeSerComido=puedeSerComido;
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
