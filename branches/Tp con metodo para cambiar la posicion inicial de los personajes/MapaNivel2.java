package algo3.grupo7.algoman.modelo;

public class MapaNivel2 extends Tablero {

	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 65;
	private static final int TIEMPODEPODER = 45;
	private static final int PUNTAJEFRUTA = 200;
    private Casillero origenPacman; 
	private Casillero origenFantasmas;
	
	public MapaNivel2(Juego juego){
		super(200,200);
		this.setOrigenPacman(getMatCasilleros()[100][160], juego) ;
		this.setOrigenFantasmas(getMatCasilleros()[100][100], juego);
		
	}
	
	protected void cargarContorno(){
		construirCaminoDesdeHasta(10, 190, 10, 10,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 160, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 160, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 190, 190,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(10, 190, 40, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 160, 70, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(40, 160, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 130, 130, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 160, 160,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosVerticales(){
		construirCaminoDesdeHasta(40, 40, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 40, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 70, 100, 160,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 10, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 70, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(100, 100, 160, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 130, 40, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(130, 130, 100, 160,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 160, 10, 190,PUNTAJEPUNTO);
	}
	
	protected void cargarPuntosDePoder(){
		getMatCasilleros()[10][175].setItem(new
				PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[190][25].setItem(new
        		PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[100][40].setItem(new Fruta(PUNTAJEFRUTA));
	}
		
	public Casillero getCasilleroOrigenFantasma() {
		return origenFantasmas;
	}

	public Casillero getCasilleroOrigenPacman() {
		return origenPacman;
	}
}
