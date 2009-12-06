package algo3.grupo7.algoman.modelo;

public class Blinky extends Fantasma {
	private Estrategia estrategia;
	private static final int VELOCIDADDEFECTO = 1;

	public Blinky(Juego nuevoJuego, Personaje pacman) {
		super(nuevoJuego, pacman, VELOCIDADDEFECTO);
		int tipoEstrategia = 1;
		this.estrategia = new Estrategia(this, pacman, tipoEstrategia);
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
	

	}
	/*
	 * mueve el fantasma al casillero original y lo borra del casillero en
	 * que se encontraba
	 */
	protected void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
		this.getCasilleroActual().agregarFantasma(this);
		if (casilleroAux!= this.getJuego().getMapa().getOrigenFantasmas())
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