package algo3.grupo7.algoman.vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Rectangle;

import algo3.grupo7.algoman.modelo.Teclado;

import algo3.grupo7.algoman.vista.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class VentanaPrincipal extends Ventana {
	private Label label = null;
	public VentanaPrincipal(ControladorJuego unControladorJuego, Teclado controladorPacman) {
		super(700, 700, unControladorJuego);
		this.setTitle("Ejemplo");
		this.setFocusable(true);
		this.addKeyListener(controladorPacman);
	}

	private static final long serialVersionUID = 1L;
	

}
