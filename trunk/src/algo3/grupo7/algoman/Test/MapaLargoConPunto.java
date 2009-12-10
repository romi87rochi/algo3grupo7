package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaLargoConPunto extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	private static final int PUNTAJEFRUTA = 100;
   
  
	public MapaLargoConPunto(){
		super(25,25);
		this.setOrigenPacman(getMatCasilleros()[10][20]) ;
		this.setOrigenFantasmas(getMatCasilleros()[10][3]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		
	}
	
	protected void cargarCaminosVerticales(){
		
		construirCaminoDesdeHasta(10, 10, 0, 20,PUNTAJEPUNTO);
	}
	
	protected void cargarPuntosDePoder(){
        
	}
	
	protected void cargarFruta(){
		
	}
	


}
