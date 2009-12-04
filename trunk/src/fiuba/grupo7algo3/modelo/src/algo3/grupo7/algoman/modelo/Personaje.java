package algo3.grupo7.algoman.modelo;

public abstract class Personaje {

	private int velocidad;
	private Juego juego;
	private Tablero tablero;
	private Casillero casilleroActual;

	private boolean puedeSerComido;

	public Personaje(Juego nuevoJuego, boolean puedeSerComido, int velocidad) {
		this.juego = nuevoJuego;
		this.tablero = nuevoJuego.getTablero();
		// El casillero Actual sera instanciado por la clase derivada
		this.casilleroActual = null;
		this.velocidad = velocidad;
		this.puedeSerComido = puedeSerComido;
		this.reubicar();
	}

	protected void setCasilleroActual(Casillero casilleroActual) {
		this.casilleroActual = casilleroActual;
	}

	protected abstract void mover(Casillero nuevoCasillero);

	protected void setPuedeSerComido(boolean valor) {
		puedeSerComido = valor;
	}

	protected abstract void encontrado();

	protected abstract void reubicar();

	protected abstract void morir();

	protected Juego getJuego() {
		return juego;
	}

	protected Tablero getTablero() {
		return tablero;
	}

	protected Casillero getCasilleroActual() {
		return casilleroActual;
	}

	protected int getVelocidad() {
		return velocidad;
	}

	public boolean puedeSerComido() {
		return this.puedeSerComido;
	}

	protected void cambiarVelocidad(int nuevaVelocidad) {
		velocidad = nuevaVelocidad;
	}

}