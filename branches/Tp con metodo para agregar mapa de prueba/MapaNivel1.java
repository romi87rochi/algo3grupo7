package algo3.grupo7.algoman.modelo;

public class MapaNivel1 extends Tablero {
	
	private static final int PUNTAJEPUNTO = 20;
	private static final int PUNTAJEPUNTOPODER = 60;
	private static final int TIEMPODEPODER = 50;
	private static final int PUNTAJEFRUTA = 100;

  
	public MapaNivel1(){
		super(200,200);
		this.setOrigenPacman(getMatCasilleros()[100][40]) ;
		this.setOrigenFantasmas(getMatCasilleros()[100][100]);
	}

	protected void cargarContorno(){
		construirCaminoDesdeHasta(10, 190, 10, 10,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 10, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(190, 190, 10, 190,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 190, 190,PUNTAJEPUNTO);
	}
	
	protected void cargarCaminosHorizontales(){
		construirCaminoDesdeHasta(10, 190, 40, 40,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 70, 70,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 190, 100, 100,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(10, 40, 130, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(70, 130, 130, 130,PUNTAJEPUNTO);
		construirCaminoDesdeHasta(160, 190, 130, 130,PUNTAJEPUNTO);
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
		getMatCasilleros()[10][25].setItem(new
				PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));  
        getMatCasilleros()[190][175].setItem(new
        		PuntoDePoder(PUNTAJEPUNTOPODER,TIEMPODEPODER));
	}
	
	protected void cargarFruta(){
		getMatCasilleros()[100][130].setItem(new Fruta(PUNTAJEFRUTA));
	}
	

}
