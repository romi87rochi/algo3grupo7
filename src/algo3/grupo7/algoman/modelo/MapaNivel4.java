package algo3.grupo7.algoman.modelo;

public class MapaNivel4 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;

	private static final int PUNTAJEPUNTOPODER = 70;

	private static final int TIEMPODEPODER = 40;

	private static final int PUNTAJEFRUTA = 300;

	private Casillero origenPacman;

	private Casillero origenFantasmas;

	public MapaNivel4() {
		super(1000, 1000);
		origenPacman = getMatCasilleros()[800][500];
		origenFantasmas = getMatCasilleros()[500][500];
	}

	protected void cargarCaminosHorizontales() {
		construirCaminoDesdeHasta(50, 50, 50, 950, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(200, 200, 50, 950, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(350, 350, 50, 950, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(500, 500, 50, 950, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(650, 650, 50, 200, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(650, 650, 350, 650, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(650, 650, 800, 950, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(800, 800, 50, 950, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(950, 950, 50, 950, PUNTAJEPUNTO);
	}

	protected void cargarCaminosVerticales() {
		construirCaminoDesdeHasta(50, 950, 50, 50, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(50, 950, 200, 200, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(200, 350, 350, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(500, 800, 350, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(50, 200, 500, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(350, 500, 500, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(800, 950, 500, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(200, 350, 650, 650, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(500, 800, 650, 650, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(50, 950, 800, 800, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(50, 950, 950, 950, PUNTAJEPUNTO);
	}

	protected void cargarContorno() {
/*		construirCaminoDesdeHasta(10, 190, 10, 10, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 10, 130, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 160, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 10, 40, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 70, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 190, 190, PUNTAJEPUNTO);*/
	}

	protected void cargarFruta() {
		getMatCasilleros()[200][260].setItem(new Fruta(PUNTAJEFRUTA));
	}

	protected void cargarPuntosDePoder() {
		getMatCasilleros()[200][800].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,
				TIEMPODEPODER));
		getMatCasilleros()[800][800].setItem(new PuntoDePoder(PUNTAJEPUNTOPODER,
				TIEMPODEPODER));
	}

	public Casillero getCasilleroOrigenFantasma() {
		return origenFantasmas;
	}

	public Casillero getCasilleroOrigenPacman() {
		return origenPacman;
	}
}
