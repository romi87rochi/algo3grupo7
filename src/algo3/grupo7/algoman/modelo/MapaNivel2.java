
public class MapaNivel2 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 65;
	private static final int TIEMPODEPODER = 45;
	private static final int PUNTAJEFRUTA = 200;
	private Casillero origenPacman; 
	private Casillero origenFantasmas;
	
	public MapaNivel2(){
		super(500,500);
		origenPacman = getMatCasilleros()[100][2500];
		origenFantasmas = getMatCasilleros()[250][250];
	}
	
	protected void cargarContorno(){
		construirCaminoDesdeHasta(25, 25, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 25, 25, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(475, 475, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 475, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 475, 475, PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(100, 100, 25, 475, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(175, 175, 175, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 250, 100, 400, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 325, 100, 400, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 400, 25, 475, PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		construirCaminoDesdeHasta(25, 475, 100, 100, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 250, 175, 175, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 400, 175, 175, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 100, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(250, 325, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(400, 475, 250, 250, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 250, 325, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(325, 400, 325, 325, PUNTAJEPUNTO);
		construirCaminoDesdeHasta(25, 475, 400, 400, PUNTAJEPUNTO);
	}
	
	protected void cargarPuntosDePoder(){
		getMatCasilleros()[100][55].setItem(new
				PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[400][445].setItem(new
        		PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[400][250].setItem(new Fruta(PUNTAJEFRUTA));
	}
		
	public Casillero getCasilleroOrigenFantasma() {
		return origenFantasmas;
	}

	public Casillero getCasilleroOrigenPacman() {
		return origenPacman;
	}
}
