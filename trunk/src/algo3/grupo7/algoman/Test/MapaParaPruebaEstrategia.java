package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;

public class MapaParaPruebaEstrategia extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	public MapaParaPruebaEstrategia(){
		super(100,100);
		this.setOrigenPacman(getMatCasilleros()[10][9]) ;
		this.setOrigenFantasmas(getMatCasilleros()[66][9]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(1, 96, 9, 9,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		
	
	}
	
	protected void cargarPuntosDePoder(){
        getMatCasilleros()[7][9].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER, this.getMatCasilleros()[7][9]));  
	}
	
	protected void cargarFruta(){
		
	}

}
