package algo3.grupo7.algoman.modelo;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class Personaje implements ObjetoVivo, Posicionable {
	private static final int FACTORCORRECTIVO = 10; // Utilizado para centrar
													// las imagenes en los
													// casilleros
	private int velocidad;
	private int velocidadOriginal;
	private Juego juego;
	protected Casillero casilleroActual;

	private boolean puedeSerComido;

	public Personaje(Juego nuevoJuego, boolean puedeSerComido, int velocidad) {
		this.juego = nuevoJuego;
		// El casillero Actual sera instanciado por la clase derivada

		this.velocidad = velocidad;
		this.velocidadOriginal = velocidad;
		this.puedeSerComido = puedeSerComido;

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

	public Casillero getCasilleroActual() {
		return casilleroActual;
	}

	protected int getVelocidad() {
		return velocidad;
	}

	protected int getVelocidadOriginal() {
		return this.velocidadOriginal;
	}

	public boolean puedeSerComido() {
		return this.puedeSerComido;
	}

	protected void cambiarVelocidad(int nuevaVelocidad) {
		velocidad = nuevaVelocidad;
	}

	// Implementacion getX() de la interfaz posicionable
	public int getX() {

		return (this.getCasilleroActual().getPosicion().getPosX())
				- FACTORCORRECTIVO;
	}

	// Implementacion getY() de la interfaz posicionable
	public int getY() {

		return (this.getCasilleroActual().getPosicion().getPosY() - FACTORCORRECTIVO);
	}

}