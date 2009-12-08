package algo3.grupo7.algoman.modelo;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class Personaje implements ObjetoVivo,Posicionable {

	private int velocidad;
	private Juego juego;
	private ArrayList<Tablero> tablero;
	protected Casillero casilleroActual;

	private boolean puedeSerComido;

	public Personaje(Juego nuevoJuego, boolean puedeSerComido, int velocidad) {
		this.juego = nuevoJuego;
		this.tablero = nuevoJuego.getTablero();
		// El casillero Actual sera instanciado por la clase derivada
		
		this.velocidad = velocidad;
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

	protected ArrayList<Tablero> getTablero() {
		return tablero;
	}

	public Casillero getCasilleroActual() {
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
	//Implementacion getX() de la interfaz posicionable 
	public int getX() {
		
		return (this.getCasilleroActual().getPosicion().getPosX())*1;
	}
	
	//Implementacion getY() de la interfaz posicionable
	public int getY() {
		
		return (this.getCasilleroActual().getPosicion().getPosY())*1;
	}

}