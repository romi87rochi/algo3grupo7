//-Xmx512m -Xms512m, para heap
package algo3.grupo7.algoman.modelo;

public class MapaNivel1 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 1000;
	private static final int PUNTAJEFRUTA = 100;

	public MapaNivel1() {
		super(500, 500, "mapaNivel1.jpg");
		this.setOrigenPacman(getMatCasilleros()[250][400]);
		this.setOrigenFantasmas(getMatCasilleros()[250][250]);
	}
	
	protected void cargarContorno() {
		construirCaminoDesdeHasta(25, 25, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(475, 475, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 475, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 475, 475, 475, PUNTAJEPUNTO);
	}

	protected void cargarCaminosHorizontales() {
		construirCaminoDesdeHasta(100, 100, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(175, 175, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 250, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 325, 25, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 325, 175, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 325, 400, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 400, 25, 475, PUNTAJEPUNTO);
	}

	protected void cargarCaminosVerticales() {
		construirCaminoDesdeHasta(25, 475, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 175, 175, 175, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 400, 175, 175, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(175, 250, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 175, 325, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 400, 325, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 475, 400, 400, PUNTAJEPUNTO);
	}

	protected void cargarFruta() {
		getMatCasilleros()[250][175].setItem(new Fruta(PUNTAJEFRUTA, this
				.getMatCasilleros()[250][175]));
		posicionarFruta(getMatCasilleros()[250][175],PUNTAJEFRUTA);
	}

	protected void cargarPuntosDePoder() {
		posicionarPuntosDePoder(getMatCasilleros()[100][400],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[400][400],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[400][100],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[100][100],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
	}
}
