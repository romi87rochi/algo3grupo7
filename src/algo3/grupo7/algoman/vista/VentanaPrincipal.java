package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.vista.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		super(800,800, unControladorJuego);
		this.setTitle("Ejemplo");
	}

	private static final long serialVersionUID = 1L;

}
