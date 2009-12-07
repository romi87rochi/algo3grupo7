package algo3.grupo7.algoman.modelo;

public class MapaNivel1 extends Tablero {
	
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	private static final int PUNTAJEFRUTA = 100;
	private Casillero origenPacman; 
	private Casillero origenFantasmas;
  
	public MapaNivel1(){
		super(200,200);
		origenPacman = getMatCasilleros()[160][100];
		origenFantasmas = getMatCasilleros()[100][100];
	}

	protected void cargarContorno(){
		construirCaminoDesdeHasta(10, 190, 10, 10,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 190, 190,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(40, 40, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 70, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 160, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 130, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 10, 190,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		construirCaminoDesdeHasta(10, 190, 40, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 100, 70, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 160, 70, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 40, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 130, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 100, 130, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 160, 130, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 160, 160,PUNTAJEPUNTO);
	}
	
	protected void cargarPuntosDePoder(){
		getMatCasilleros()[10][100].setItem(new
				PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[130][100].setItem(new
        		PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[70][100].setItem(new Fruta(PUNTAJEFRUTA));
	}
	
	public  Casillero getCasilleroOrigenFantasma(){
		return origenFantasmas;
	}
	
	public Casillero getCasilleroOrigenPacman(){
		return origenPacman;		
	}
}
