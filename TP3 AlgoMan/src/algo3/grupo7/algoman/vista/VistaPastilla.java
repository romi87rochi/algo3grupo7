package algo3.grupo7.algoman.vista;

import java.awt.Color;

import algo3.grupo7.algoman.modelo.Punto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaPastilla extends Circulo {
	Punto punto;

	public VistaPastilla(Punto unPunto) {
		super(5);
		this.punto=unPunto;
		this.setColor(Color.yellow);
		this.setPosicionable(punto);
	}

	public void dibujar(SuperficieDeDibujo sup) {
		if (this.punto.getCasilleroActual().getItem()== null) {
			this.setColor(Color.black);
		} else
			this.setColor(Color.yellow);
		super.dibujar(sup);

	}

}