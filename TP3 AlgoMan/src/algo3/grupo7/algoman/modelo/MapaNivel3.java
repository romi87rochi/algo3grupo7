//-Xmx512m -Xms512m, para heap
package algo3.grupo7.algoman.modelo;

public class MapaNivel3 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 70;
	private static final int TIEMPODEPODER = 400;
	private static final int PUNTAJEFRUTA = 500;

	public MapaNivel3() {
		super(500, 500, "nivel3.jpg");
		this.setOrigenPacman(getMatCasilleros()[250][250]);
		this.setOrigenFantasmas(getMatCasilleros()[175][250]);

	}

	protected void cargarContorno() {
		construirCaminoDesdeHasta(25, 25, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(175, 475, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(475, 475, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 325, 475, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 475, 475, PUNTAJEPUNTO);
	}

	protected void cargarCaminosHorizontales() {
		construirCaminoDesdeHasta(100, 100, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(175, 175, 25, 400, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 250, 25, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 250, 175, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 250, 400, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 325, 100, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 400, 25, 475, PUNTAJEPUNTO);
	}

	protected void cargarCaminosVerticales() {
		construirCaminoDesdeHasta(25, 325, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 250, 175, 175, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 400, 175, 175, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 325, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 250, 325, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 400, 325, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 400, 400, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(175, 475, 400, 400, PUNTAJEPUNTO);
	}

	protected void cargarFruta() {
		getMatCasilleros()[100][250].setItem(new Fruta(PUNTAJEFRUTA, this
				.getMatCasilleros()[100][250]));
		posicionarFruta(getMatCasilleros()[100][250],PUNTAJEFRUTA);
	}

	protected void cargarPuntosDePoder() {
		posicionarPuntosDePoder(getMatCasilleros()[25][55],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[25][445],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[475][55],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[475][445],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
	}
}
