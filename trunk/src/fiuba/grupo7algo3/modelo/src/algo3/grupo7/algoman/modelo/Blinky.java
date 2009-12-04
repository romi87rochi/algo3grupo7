package algo3.grupo7.algoman.modelo;

public class Blinky extends Fantasma {
	private Estrategia estrategia;
	private static final int VELOCIDADDEFECTO = 9;

	public Blinky(Juego nuevoJuego, Personaje pacman) {
		super(nuevoJuego, pacman, VELOCIDADDEFECTO);
		int tipoEstrategia = 1;
		this.estrategia = new Estrategia(this, pacman, tipoEstrategia);
		this.setCasilleroActual(this.getTablero().getCasilleroOrigenFantasma());

	}
	/*
	 * mueve el fantasma al casillero original y lo borra del casillero en
	 * que se encontraba
	 */
	protected void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();
		this.setCasilleroActual(this.getTablero().getCasilleroOrigenFantasma());
		this.getCasilleroActual().agregarFantasma(this);
		if (this.getCasilleroActual() != this.getTablero()
				.getCasilleroOrigenFantasma())
			casilleroAux.removerFantasma(this);
	}

	public void vivir() {
		int pasos = 0;

		while (pasos < this.getVelocidad()) { // ver cuando cambia de nivel

			this.mover(estrategia.proximoCasillero());
			pasos++;
		}
	}

}