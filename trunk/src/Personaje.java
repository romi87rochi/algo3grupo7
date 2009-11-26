public abstract class Personaje {

	private int velocidad;
	private Juego juego;
	private Casillero casilleroActual;

	private Casillero casilleroOriginal;

	private boolean puedeSerComido;

	public Personaje(Juego nuevoJuego, Posicion posicionOriginal,
			int velocidad, boolean puedeSerComido) {
		this.juego = nuevoJuego;
		this.casilleroOriginal = nuevoJuego.getTablero().getCasillero(
				posicionOriginal); // inicialmente la posicion actual sera la
		// original
		this.casilleroActual = casilleroOriginal;

		this.puedeSerComido = puedeSerComido;

		/*
		 * this.juego=nuevoJuego; this.puedeSerComido = false; this.velocidad =
		 * velocidad; this.casilleroOriginal = new Casillero(cOriginal);
		 * this.casilleroActual = casilleroOriginal;
		 */
	}

	public void setCasilleroActual(Casillero casilleroActual) {
		this.casilleroActual = casilleroActual;
	}

	public void setCasilleroOriginal(Casillero casilleroOriginal) {
		this.casilleroOriginal = casilleroOriginal;
	}

	public abstract void comer();

	public abstract boolean mover(Posicion posicion);

	/*
	 * cuando pacman pueda ser comido los fantasmas no y viseversa por eso este
	 * algoritmo debe funcionar
	 */
	public void cambiarEstado() {
		if (this.puedeSerComido()) {
			this.puedeSerComido = false;
		} else {
			this.puedeSerComido = true;
		}
	}

	public void reubicar() {

	}

	public Juego getJuego() {
		return juego;
	}

	public Casillero getCasilleroActual() {
		return casilleroActual;
	}

	public Casillero getCasilleroOriginal() {
		return casilleroOriginal;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public boolean puedeSerComido() {
		return this.puedeSerComido;
	}

}
