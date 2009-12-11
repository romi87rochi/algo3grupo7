package algo3.grupo7.algoman.vista;

import java.awt.Color;

import algo3.grupo7.algoman.modelo.Casillero;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class vistaPuntoDePoder extends Circulo{
	Casillero casilleros;
	
	public vistaPuntoDePoder(Casillero casilleros){
		super(12);
		this.casilleros=casilleros;
		this.setColor(Color.green);
		}

	public void dibujar(SuperficieDeDibujo sup){
		if(casilleros.getItem()==null){
			this.setColor(Color.black);
		}else
			this.setColor(Color.green);
		super.dibujar(sup);
		
	}
}