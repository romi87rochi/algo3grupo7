package algo3.grupo7.algoman.modelo;

public class Blinky extends Fantasma {

	private static final int VELOCIDADDEFECTO = 4;

	public Blinky(Juego nuevoJuego, Personaje pacman) {
		super(nuevoJuego, pacman, VELOCIDADDEFECTO);
		int tipoEstrategia = 2;
		this.setEstrategia(new Estrategia(this, pacman, tipoEstrategia));
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
	}
}