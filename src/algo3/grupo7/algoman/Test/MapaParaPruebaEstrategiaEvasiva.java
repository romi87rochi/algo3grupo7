package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;

public class MapaParaPruebaEstrategiaEvasiva extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	public MapaParaPruebaEstrategiaEvasiva(){
		super(100,100,"mapaNivel1.jpg");
		this.setOrigenPacman(getMatCasilleros()[7][9]) ;
		this.setOrigenFantasmas(getMatCasilleros()[14][9]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(1, 96, 9, 9,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		construirCaminoDesdeHasta(12, 12, 6, 12,PUNTAJEPUNTO);	
	
	}
	
	protected void cargarPuntosDePoder(){
        getMatCasilleros()[3][9].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER, this.getMatCasilleros()[7][9]));  
	}
	
	protected void cargarFruta(){
		
	}

}