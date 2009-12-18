package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.PuntoDePoder;
import algo3.grupo7.algoman.modelo.Tablero;


public class MapaLargoConPuntoDePoder extends Tablero{
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	private static final int PUNTAJEFRUTA = 100;
	public MapaLargoConPuntoDePoder(){
		super(40,240,"mapaNivel1.jpg");
		this.setOrigenPacman(getMatCasilleros()[20][10]) ;
		this.setOrigenFantasmas(getMatCasilleros()[3][10]);
	}

	protected void cargarContorno(){
	
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(0, 39, 10, 10,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		
		
	}
	
	protected void cargarPuntosDePoder(){
		 getMatCasilleros()[13][10].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER,this.getMatCasilleros()[13][10]));
		 this.incrementarCantidadDePuntos();
			
		 getMatCasilleros()[6][10].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER,this.getMatCasilleros()[6][10]));
		 this.incrementarCantidadDePuntos();
			
		 
        
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[18][10].setItem(new Fruta(PUNTAJEFRUTA,this.getMatCasilleros()[18][10]));
		this.incrementarCantidadDePuntos();
		
	}
	


}