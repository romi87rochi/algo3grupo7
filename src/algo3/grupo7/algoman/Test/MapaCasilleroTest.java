package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaCasilleroTest extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	public MapaCasilleroTest(){
		super(200,200,"mapaNivel1.jpg");
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
		Casillero casilleroTemp=getMatCasilleros()[9][411];
		PuntoDePoder puntoPoderTemp=new PuntoDePoder(PUNTAJEPUNTOPODER, TIEMPODEPODER,casilleroTemp);
		casilleroTemp.setItem(puntoPoderTemp);
		this.incrementarPunto();
          
	}
	
	

	protected void cargarFruta(){
		
	}
	


}
