package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaCaminoHorizontal extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 100;
	private static final int PUNTAJEFRUTA = 100;
   
  
	public MapaCaminoHorizontal(){
		super(20,20);
		this.setOrigenPacman(getMatCasilleros()[17][9]) ;
		this.setOrigenFantasmas(getMatCasilleros()[9][9]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(9, 17, 9, 9,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		
	
	}
	
	protected void cargarPuntosDePoder(){
        getMatCasilleros()[12][9].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER,this.getMatCasilleros()[12][9]));  
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[13][9].setItem(new Fruta(PUNTAJEFRUTA,this.getMatCasilleros()[13][9]));
	}
	


}
