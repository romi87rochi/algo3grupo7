package algo3.grupo7.algoman.modelo;

public class Clyde extends Fantasma {

	private static final int VELOCIDADDEFECTO = 3;

	public Clyde(Juego nuevoJuego, Personaje pacman) {
		super(nuevoJuego, pacman, VELOCIDADDEFECTO);
		int tipoEstrategia = 1;
		this.setEstrategia(new Estrategia(this, pacman, tipoEstrategia));
		//this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
	}
}