public abstract class Fantasma extends Personaje {

	protected int estrategia;

	public Fantasma(Juego nuevoJuego, Posicion posicionOriginal, int velocidad) {
		super(nuevoJuego, posicionOriginal, velocidad, false);
		getJuego().conocerFantasma(this);
		// this.reubicar(posicionOriginal);
	}

	public void cambiarVelocidad(int nivel) {

	}

	public void comer() {
		Personaje pacmanAux = this.getCasilleroActual().getPacman();
		if (pacmanAux != null && pacmanAux.puedeSerComido()) {
			this.getJuego().decrementarVidaPackman();
			this.getJuego().reubicarTodosLosPersonajes();
		} else
			this.reubicar();

	}

	public void mover(Posicion posicion) {
		Casillero nuevoCasillero = this.getJuego().getTablero().getCasillero(
				posicion);
		Casillero casilleroActual = this.getCasilleroActual();

		nuevoCasillero.agregarFantasma(this);
		casilleroActual.removerFantasma(this);
		//this.comer();

	}

	/* Traslada al fantasma a su posicion de origen */
	public void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();
		Casillero casilleroOriginalAux = this.getCasilleroOriginal();
		/*
		 * mueve el fantasma al casillero original y lo borra del casillero en
		 * que se encontraba
		 */
		this.setCasilleroActual(casilleroOriginalAux);
		this.getCasilleroActual().agregarFantasma(this);
		casilleroAux.removerFantasma(this);

	}
}
