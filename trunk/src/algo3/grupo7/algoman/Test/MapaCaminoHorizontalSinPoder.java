package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaCaminoHorizontalSinPoder extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEFRUTA = 100;
   
  
	public MapaCaminoHorizontalSinPoder(){
		super(30,30,"mapaNivel1.jpg");
		this.setOrigenPacman(getMatCasilleros()[20][9]) ;
		this.setOrigenFantasmas(getMatCasilleros()[9][9]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(9, 20, 9, 9,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		
	
	}
	
	protected void cargarPuntosDePoder(){
         
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[13][9].setItem(new Fruta(PUNTAJEFRUTA,this.getMatCasilleros()[13][9]));
	}
	


}