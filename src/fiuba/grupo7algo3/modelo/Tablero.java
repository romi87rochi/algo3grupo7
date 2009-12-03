
public abstract class Tablero {
	private int filas;
	private int columnas;
	private Casillero casilleros[][];
	private MatrizPosiciones posiciones;
	private int cantidadPuntos;
    
	/*
	 * El tablero es instancianciado con la cantidad de filas y columnas dadas,
	 * todos los casilleros no contienen personajes ni items.
	 */
	public Tablero(int filas,int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		casilleros= new Casillero[filas][columnas];
		posiciones = new MatrizPosiciones(filas, columnas);
		incializar();
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

	protected void construirCaminoDesdeHasta(int desdeX, int hastaX, int desdeY,
			int hastaY, int puntajePunto) {
 
		int espacios=0;
		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				if (x >= desdeX && x <= hastaX && y >= desdeY && x <= hastaY) {
					casilleros[x][y].setHacerCamino();
					++espacios;
				}
				//cada 10 casilleros camino inserta un PUNTO (pastilla)
				if (espacios==10){
					casilleros[x][y].setItem(new Punto(puntajePunto));
		            espacios=0;
				}
			}
		}
	}

	public abstract Casillero getCasilleroOrigenFantasma();
	
	public abstract Casillero getCasilleroOrigenPacman();
		
	public abstract void cargarTablero();

	protected void incrementarPunto() {
		this.cantidadPuntos++;
	}

	protected Casillero[][] getMatCasilleros(){
		return casilleros;
	}
	public Casillero getCasillero(Posicion posicion) {
		return casilleros[posicion.getPosX()][posicion.getPosY()];
	}
}
