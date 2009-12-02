
public class Tablero {
	
	private Casillero casilleros[][];
	private MatrizPosiciones posiciones;
    private Casillero origenPacman;
    private Casillero OrigenBlynki;
    private Casillero OrigenPinky;

	private Casillero OrigenInky;
    private Casillero OrigenClyde;
/*El tablero es instancianciado con la cantidad de filas
 * y columnas dadas, todos los casilleros no contienen personajes
 * ni items.
 */
public Tablero(int filas, int columnas){
	casilleros=new Casillero[filas][columnas];
	posiciones = new MatrizPosiciones(filas,columnas);
	this.incializar(filas,columnas);
	
}


private void incializar(int filas, int columnas) {
  int y;
	  for(int x=0;x<filas;x++){
		  y=0;
		  for(y=0;y<columnas;y++){
			  casilleros[x][y]=new Casillero(new Posicion(x,y,posiciones),this);
		  }
	  }
}
public void cargarTablero(Mapa mapa){
    casilleros=mapa.get();
}

public Casillero getCasillero(Posicion posicion){
	return casilleros[posicion.getPosX()][posicion.getPosY()];
}

public Casillero getOrigenPacman(){
	return origenPacman;
}
public Casillero getOrigenBlynki(){
   return OrigenBlynki;
}

public Casillero getOrigenPinky() {
	return OrigenPinky;
}

public Casillero getOrigenInky() {
	return OrigenInky;
}

public Casillero getOrigenClyde() {
	return OrigenClyde;
}
}