package algo3.grupo7.algoman.modelo;

public class MapaNivel4 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 70;
	private static final int TIEMPODEPODER = 1200;
	private static final int PUNTAJEFRUTA = 500;
	
	public MapaNivel4(){
		super(475, 515, "mapaNivel4.jpg");
		this.setOrigenPacman(getMatCasilleros()[228][395]) ;
		this.setOrigenFantasmas(getMatCasilleros()[235][190]);
	}
	
	@Override
	protected void cargarContorno() { // TODO Auto-generated method stub
		construirCaminoDesdeHasta(25, 210, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(210, 210, 25, 90, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(210, 260, 90, 90, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 260, 25, 90, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 450, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 25, 25, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 115, 140, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(115, 115, 140, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 115, 350, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 25, 350, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 60, 395, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(60, 60, 395, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 60, 450, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 25, 450, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 450, 500, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(450, 450, 450, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(425, 450, 450, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(425, 425, 395, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(425, 450, 395, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(450, 450, 350, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(370, 450, 350, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(370, 370, 140, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(370, 450, 140, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(450, 450, 25, 140, PUNTAJEPUNTO);
	}
	
	@Override
	protected void cargarCaminosHorizontales() { // TODO Auto-generated method stub
		construirCaminoDesdeHasta(60, 115, 450, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 210, 450, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 310, 450, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(370, 425, 450, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(115, 370, 395, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(115, 210, 350, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 370, 350, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 310, 295, 295, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(115, 160, 240, 240, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(310, 370, 240, 240, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 310, 190, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 210, 140, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 310, 140, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 210, 90, 90, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 450, 90, 90, PUNTAJEPUNTO);
	}

	@Override
	protected void cargarCaminosVerticales() { // TODO Auto-generated method stub
		construirCaminoDesdeHasta(115, 115, 25, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(115, 115, 350, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 90, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 190, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 395, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(210, 210, 140, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(210, 210, 350, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(210, 210, 450, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 260, 140, 190, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 260, 350, 395, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(260, 260, 450, 500, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(310, 310, 90, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(310, 310, 190, 350, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(310, 310, 395, 450, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(370, 370, 25, 140, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(370, 370, 350, 450, PUNTAJEPUNTO);
	}

	@Override
	protected void cargarFruta() { // TODO Auto-generated method stub
		getMatCasilleros()[228][295].setItem(new Fruta(PUNTAJEFRUTA, this.
				getMatCasilleros()[228][295]));
		posicionarFruta(getMatCasilleros()[228][295],PUNTAJEFRUTA);
	}

	@Override
	protected void cargarPuntosDePoder() { // TODO Auto-generated method stub
		posicionarPuntosDePoder(getMatCasilleros()[25][55],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[25][385],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[450][55],//x++
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
		posicionarPuntosDePoder(getMatCasilleros()[450][385],
				PUNTAJEPUNTOPODER, TIEMPODEPODER);
	}

}
