package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaFormaCruz extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEFRUTA = 100;
   
  
	public MapaFormaCruz(){
		super(20,20,"mapaNivel1.jpg");
		this.setOrigenPacman(getMatCasilleros()[14][9]) ;
		this.setOrigenFantasmas(getMatCasilleros()[9][14]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(9, 14, 9, 9,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		construirCaminoDesdeHasta(9, 9 , 9, 14,PUNTAJEPUNTO);
	
	}
	
	protected void cargarPuntosDePoder(){
         
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[13][9].setItem(new Fruta(PUNTAJEFRUTA,this.getMatCasilleros()[13][9]));
	}
	


}