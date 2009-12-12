package algo3.grupo7.algoman.modelo;

public class Pinky extends Fantasma {

	private static final int VELOCIDADDEFECTO = 4;

	public Pinky(Juego nuevoJuego, Personaje pacman) {
		super(nuevoJuego, pacman, VELOCIDADDEFECTO);
		int tipoEstrategia = 1;
		this.setEstrategia(new Estrategia(this, pacman, tipoEstrategia));
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
	}
}