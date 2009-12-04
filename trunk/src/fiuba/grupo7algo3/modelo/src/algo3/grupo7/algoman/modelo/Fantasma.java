package algo3.grupo7.algoman.modelo;

public abstract class Fantasma extends Personaje {

	private Pacman pacman;

	public Fantasma(Juego nuevoJuego, Personaje pacman, int velocidad) {
		super(nuevoJuego, false, velocidad);
		this.pacman = (Pacman) pacman;
	}

	protected void comer() {

		if (this.getCasilleroActual().hayPacman() && pacman.puedeSerComido()) {
			pacman.encontrado();
			this.reubicar();
		} else if (this.getCasilleroActual().hayPacman()) {
			this.reubicar();
		}
	}

	public void vivir() {

	}

	protected void mover(Casillero nuevoCasillero) {
		
		/*  Si el pacman no esta vivo es xq otro pj lo comio por lo tanto el
		 * fantasma se reubica */
		
		if (pacman.estaVivo()) {
			nuevoCasillero.agregarFantasma(this);
			getCasilleroActual().removerFantasma(this);
			this.setCasilleroActual(nuevoCasillero);
			if (pacman.puedeSerComido()) {
				this.setPuedeSerComido(false);
			} else {
				this.setPuedeSerComido(true);
			}
			this.comer();
		} else {
			this.reubicar();
		}

	}

	// metodo que sera utilizado cunaod pacman se cruse con un fantasma
	protected void encontrado() {
		this.reubicar();
	}

	/* El fantasma muere y es trasladado a su posicion de origen */
	protected void morir() {
		this.reubicar();
	}

}