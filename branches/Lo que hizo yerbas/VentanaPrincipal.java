package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Juego;


public class VentanaPrincipal {

	private Juego juego;
	
	public void inicialNuevoJuego(){
		this.juego = new Juego();
		juego.inicializar();
		juego.comenzar();
	}
}
