package algo3.grupo7.algoman.vista;

import java.awt.Color;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VistaPacman extends Circulo {
	
	public VistaPacman(){
		super(8);
		this.setColor(Color.yellow);
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		// hablas con el modelo y ves el estado
		this.setColor(Color.yellow);
		super.dibujar(superfice);
	}
}
