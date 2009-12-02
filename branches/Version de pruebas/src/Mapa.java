public class Mapa {
	private Casillero casilleros[][];
	private MatrizPosiciones matPos;
	int cantItems;
   
    
	
	public Mapa() {
		casilleros = new Casillero[10][10];
		matPos = new MatrizPosiciones(10, 10);
		this.incializar(10, 10);
	}

	public Casillero[][] get() {
		return casilleros;
	}
	
	

	public MatrizPosiciones getMatPos() {
		return matPos;
	}

	private void incializar(int filas, int columnas) {
		int y;
		for (int x = 0; x < filas; x++) {
			y = 0;
			for (y = 0; y < columnas; y++) {
				casilleros[x][y] = new Casillero(new Posicion(x, y, matPos));
			}
		}
		
		this.cargarMapaPrueba();
		


	}
	
	

	private void cargarMapaPrueba() {
		Casillero cas1 = casilleros[0][0];
		Casillero cas2 = casilleros[0][1];
		Casillero cas3 = casilleros[0][2];
		Casillero cas4 = casilleros[0][3];
		Casillero cas5 = casilleros[0][4];
		Casillero cas6 = casilleros[0][5];
		Casillero cas7 = casilleros[1][0];
		Casillero cas8 = casilleros[2][0];
		Casillero cas9 = casilleros[3][0];
		Casillero cas10 = casilleros[4][0];
		Casillero cas11 = casilleros[5][0];
		Casillero cas12 = casilleros[6][0];
		Casillero cas13 = casilleros[6][1];
		Casillero cas14 = casilleros[6][2];
		Casillero cas15 = casilleros[6][3];
		Casillero cas16 = casilleros[6][4];
		Casillero cas17 = casilleros[6][5];
		Casillero cas18 = casilleros[5][5];
		Casillero cas19 = casilleros[4][5];
		Casillero cas20 = casilleros[3][5];
		Casillero cas21 = casilleros[2][5];
		Casillero cas22 = casilleros[1][4];
		Casillero cas23 = casilleros[5][4];
		Casillero cas24 = casilleros[1][5];
		Casillero cas25 = casilleros[2][5];
		Casillero cas26 = casilleros[0][1];
		Casillero cas27 = casilleros[2][2];
		Casillero cas28 = casilleros[3][2];
		Casillero cas29 = casilleros[4][2];
		Casillero cas30 = casilleros[3][3];
		cas1.setHacerPared();
		cas2.setHacerPared();
		cas3.setHacerPared();
		cas4.setHacerPared();
		cas5.setHacerPared();
		cas6.setHacerPared();
		cas7.setHacerPared();
		cas8.setHacerPared();
		cas9.setHacerPared();
		cas10.setHacerPared();
		cas11.setHacerPared();
		cas12.setHacerPared();
		cas13.setHacerPared();
		cas14.setHacerPared();
		cas15.setHacerPared();
		cas16.setHacerPared();
		cas17.setHacerPared();
		cas18.setHacerPared();
		cas19.setHacerPared();
		cas20.setHacerPared();
		cas21.setHacerPared();
		cas22.setHacerPared();
		cas23.setHacerPared();
		cas24.setHacerPared();
		cas25.setHacerPared();
		cas26.setHacerPared();
		cas27.setHacerPared();
	    cas28.setHacerPared();
		cas29.setHacerPared();
		cas30.setHacerPared();
		
		
	}

	/*
	 * public int getCantidadItems(){ return cantItems; } public void
	 * construirParedDesdeHasta(int DesdeX, int aX, int Desdey, int aY, int
	 * hastaX, int hastY){ ++cantItems; } public void insertarPastilla(int
	 * cantidad){ ++cantItems; } public void insertarPastillaDePoder(Casillero
	 * casillero, ItemComible punto){ casillero.setItem(punto); ++cantItems; }
	 * public void insertarFruta(int posX, int posY){ } public int
	 * getCantItems(){ return cantItems; }
	 */

	public int getCantItems() {
		return this.cantItems;
	}

}