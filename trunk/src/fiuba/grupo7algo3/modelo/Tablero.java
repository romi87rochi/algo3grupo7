
public class Tablero {
	private int filas;

	private int columnas;

	private Casillero casilleros[][];

	private MatrizPosiciones posiciones;

	private Casillero origenPacman;

	private Casillero origenFantasmas;

	private int cantidadPuntos;

	private static final int FILAS = 200;

	private static final int COLUMNAS = 200;

	private static final int PUNTAJEFRUTA = 200;

	private static final int PUNTAJEPUNTO = 500;

	private static final int PUNTAJEPUNTOPODER = 750;

	/*
	 * El tablero es instancianciado con la cantidad de filas y columnas dadas,
	 * todos los casilleros no contienen personajes ni items.
	 */
	public Tablero() {
		filas = FILAS;
		columnas = COLUMNAS;
		casilleros= new Casillero[FILAS][COLUMNAS];
		posiciones = new MatrizPosiciones(FILAS, COLUMNAS);
		incializar();
		// casilleros = mapa.get();
		origenPacman = casilleros[9][11];
		origenFantasmas = casilleros[9][10];
		cantidadPuntos = 0;



		
	}
	

	private void incializar() {
		Posicion posAux = null;
		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				posAux = posiciones.obtenerPosicion(x, y);
				casilleros[x][y] = new Casillero(posAux,this);
			}
		}
	}

	private void construirCaminoDesdeHasta(int desdeX, int hastaX, int desdeY,
			int hastaY) {

		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				if (x >= desdeX && x <= hastaX && y >= desdeY && x <= hastaY) {
					casilleros[x][y].setHacerCamino();
				}
			}
		}
	}

	public Casillero getCasilleroOrigenFantasma() {
		return origenFantasmas;
	}

	public Casillero getCasilleroOrigenPacman() {
		return origenPacman; // VER
	}

	public void cargarTablero(Juego juego) {

		// Se crean las frutas
		ItemComible itemFruta1 = new Fruta(PUNTAJEFRUTA);
		ItemComible itemFruta2 = new Fruta(PUNTAJEFRUTA);
		// Se crean los puntos
		ItemComible itemPunto1 = new Punto(PUNTAJEPUNTO);
		ItemComible itemPunto2 = new Punto(PUNTAJEPUNTO);
		ItemComible itemPunto3 = new Punto(PUNTAJEPUNTO);
		ItemComible itemPunto4 = new Punto(PUNTAJEPUNTO);
		ItemComible itemPunto5 = new Punto(PUNTAJEPUNTO);
		// Se crean los puntos de poder
		ItemComible itemPuntoPoder1 = new Punto(PUNTAJEPUNTOPODER);
		ItemComible itemPuntoPoder2 = new Punto(PUNTAJEPUNTOPODER);

		// Se crea el camino por donde circularán los personajes.

		construirCaminoDesdeHasta(9, 180, 9, 9);
		construirCaminoDesdeHasta(180, 180, 9, 171);
		construirCaminoDesdeHasta(9, 180, 90, 90);
		construirCaminoDesdeHasta(9, 180, 180, 180);
		construirCaminoDesdeHasta(9, 9, 9, 171);

		casilleros[50][9].setItem(itemFruta1);
		incrementarPunto();

		casilleros[9][160].setItem(itemFruta2);
		incrementarPunto();
		
		casilleros[40][9].setItem(itemPunto1);
		incrementarPunto();
		
		casilleros[180][80].setItem(itemPunto2);
		incrementarPunto();
		
		casilleros[95][90].setItem(itemPunto3);
		incrementarPunto();
		
		casilleros[33][180].setItem(itemPunto4);
		incrementarPunto();
		
		casilleros[9][70].setItem(itemPunto5);
		incrementarPunto();
		
		casilleros[180][30].setItem(itemPuntoPoder1);
		incrementarPunto();
		
		casilleros[100][180].setItem(itemPuntoPoder2);
		incrementarPunto();


	}

	

	private void incrementarPunto() {
		this.cantidadPuntos++;
	}

	public Casillero getCasillero(Posicion posicion) {
		return casilleros[posicion.getPosX()][posicion.getPosY()];
	}
}
