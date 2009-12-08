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
		origenFantasmas = getMatCasilleros()[100][130];
	}

	protected void cargarCaminosHorizontales() {
		construirCaminoDesdeHasta(10, 190, 40, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 190, 70, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 40, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 130, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 160, 130, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 160, 160,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales() {
		construirCaminoDesdeHasta(40, 40, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 40, 70, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 40, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 100, 160,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 70, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 160, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 130, 40, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 130, 100, 160,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 10, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 160, 190,PUNTAJEPUNTO);
	}

	protected void cargarContorno() {
		construirCaminoDesdeHasta(10, 190, 10, 10,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 10, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 160, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 70, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 190, 190,PUNTAJEPUNTO);
	}

	protected void cargarFruta() {
		getMatCasilleros()[100][160].setItem(new Fruta(PUNTAJEFRUTA));
	}

	protected void cargarPuntosDePoder() {
		getMatCasilleros()[25][190].setItem(new
				PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[175][10].setItem(new
        		PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));
	}

	public Casillero getCasilleroOrigenFantasma() {
		return origenFantasmas;
	}

	public Casillero getCasilleroOrigenPacman() {
		return origenPacman;
	}
}
