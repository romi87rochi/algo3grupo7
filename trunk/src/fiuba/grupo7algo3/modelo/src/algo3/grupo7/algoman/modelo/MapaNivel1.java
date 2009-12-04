package algo3.grupo7.algoman.modelo;
public class MapaNivel1 extends Tablero {

	
	private static final int PUNTAJEPUNTO = 500;
	private static final int PUNTAJEPUNTOPODER = 750;
	private static final int TIEMPODEPODER=50;
    private Casillero origenPacman; 
	private Casillero origenFantasmas;
	
  
	public MapaNivel1(){
		super(200,200);
		origenPacman=getMatCasilleros()[9][11];
		origenFantasmas=getMatCasilleros()[9][10];
	}
	public void cargarTablero() {

		// Se crea el camino por donde circularán los personajes.

		construirCaminoDesdeHasta(9, 180, 9, 9,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(180, 180, 9, 171,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(9, 10, 9, 10,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(9, 180, 90, 90,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(9, 180, 180, 180,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(9, 9, 9, 171,PUNTAJEPUNTO);
        getMatCasilleros()[100][180].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[100][180].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER)); 
	}
	
public  Casillero getCasilleroOrigenFantasma(){
	return origenFantasmas;
}
	
	public Casillero getCasilleroOrigenPacman(){
		return origenPacman;		
	}

}
