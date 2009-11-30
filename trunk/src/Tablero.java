
public class Tablero {

	private Casillero casilleros[][];

	private MatrizPosiciones posiciones;
		
	/*
	 * El tablero es instancianciado con la cantidad de filas y columnas dadas,
	 * todos los casilleros no contienen personajes ni items.
	 */
	public Tablero() {
		
		int filas    = posiciones.getMapa().getFilas();
		int columnas = posiciones.getMapa().getColumnas();
		posiciones = new MatrizPosiciones();
		
		
//		casilleros = new Casillero[filas][columnas];
		this.incializar(filas, columnas);
		
	}

	private void incializar(int filas, int columnas) {
		int y;
		for (int x = 0; x < filas; x++) {
			y = 0;
			for (y = 0; y < columnas; y++) {
				casilleros[x][y] = new Casillero(posiciones.obtenerPosicion(x,y), this);
			}
		}
	}


	public Casillero getCasillero(Posicion posicion) {
		return casilleros[posicion.getPosX()][posicion.getPosY()];
	}
}
