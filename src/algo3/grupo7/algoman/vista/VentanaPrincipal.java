package algo3.grupo7.algoman.vista;
import algo3.grupo7.algoman.modelo.Pacman;
import  algo3.grupo7.algoman.modelo.Teclado;

import algo3.grupo7.algoman.vista.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego unControladorJuego, Pacman pacman) {
		super(700,700, unControladorJuego,"mapaNivel4.jpg");
		this.setTitle("Ejemplo");
	    this.setFocusable(true);
	    this.addKeyListener(new Teclado(pacman));
	}

	
	private static final long serialVersionUID = 1L;

}
