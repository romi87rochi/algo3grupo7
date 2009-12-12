package algo3.grupo7.algoman.vista;

import java.awt.Color;

import algo3.grupo7.algoman.modelo.Casillero;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaPastilla extends Circulo {
	Casillero casilleros;

	public VistaPastilla(Casillero casillero) {
		super(5);
		this.casilleros = casillero;
		this.setColor(Color.yellow);
	}

	public void dibujar(SuperficieDeDibujo sup) {
		if (casilleros.getItem() == null) {
			this.setColor(Color.black);
		} else
			this.setColor(Color.yellow);
		super.dibujar(sup);

	}

}