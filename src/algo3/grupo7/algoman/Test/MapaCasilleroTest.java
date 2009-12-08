package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Punto;
import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaCasilleroTest extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	private static final int PUNTAJEFRUTA = 100;
   
  
	public MapaCasilleroTest(){
		super(200,200);
		this.setOrigenPacman(getMatCasilleros()[9][12]) ;
		this.setOrigenFantasmas(getMatCasilleros()[9][9]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(9, 9, 9, 12,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		
	
	}
	
	protected void cargarPuntosDePoder(){
        getMatCasilleros()[9][11].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
	}
	
	protected void cargarFruta(){
		
	}
	


}
