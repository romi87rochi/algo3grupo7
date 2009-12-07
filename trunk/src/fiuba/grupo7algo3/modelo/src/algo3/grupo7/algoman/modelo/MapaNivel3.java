package algo3.grupo7.algoman.modelo;

public class MapaNivel3 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 70;
	private static final int TIEMPODEPODER = 40;
	private static final int PUNTAJEFRUTA = 300;
	private Casillero origenPacman; 
	private Casillero origenFantasmas;
	
	public MapaNivel3(){
		super(200,200);
		origenPacman = getMatCasilleros()[100][100];
		origenFantasmas = getMatCasilleros()[70][100];
	}
	
	protected void cargarContorno() {
		construirCaminoDesdeHasta(10, 10, 10, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 40, 10, 10, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 190, 10, 10, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 130, 190, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 190, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 10, 190, PUNTAJEPUNTO);
	}

	protected void cargarCaminosHorizontales() {
		construirCaminoDesdeHasta(40, 40, 10, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 10, 160, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 10, 40, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 70, 130, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 160, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 130, 40, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 10, 190, PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales() {
		construirCaminoDesdeHasta(10, 130, 40, 40, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 40, 40, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 100, 70, 70, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 160, 70, 70, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 40, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 130, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 100, 130, 130, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 160, 160, 160, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 40, 160, 160, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 190, 190, 190, PUNTAJEPUNTO);
	}

	protected void cargarFruta() {
		getMatCasilleros()[40][100].setItem(new Fruta(PUNTAJEFRUTA));
	}

	protected void cargarPuntosDePoder() {
		getMatCasilleros()[10][25].setItem(new
				PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[190][175].setItem(new
        		PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));
	}

	public Casillero getCasilleroOrigenFantasma() {
		return origenFantasmas;
	}

	public Casillero getCasilleroOrigenPacman() {
		return origenPacman;
	}
}
