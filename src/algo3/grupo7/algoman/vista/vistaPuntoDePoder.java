package algo3.grupo7.algoman.vista;

import java.awt.Color;

import algo3.grupo7.algoman.modelo.PuntoDePoder;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class vistaPuntoDePoder extends Circulo{
	PuntoDePoder puntoPoder;
	
	public vistaPuntoDePoder(PuntoDePoder puntoPoder){
		super(12);
		this.puntoPoder=puntoPoder;
		this.setColor(Color.green);
		this.setPosicionable(puntoPoder);
		}

	public void dibujar(SuperficieDeDibujo sup){
		if(this.puntoPoder.getCasilleroActual().getItem()==null){
			this.setColor(Color.black);
		}else
			this.setColor(Color.green);
		super.dibujar(sup);
		
	}
}