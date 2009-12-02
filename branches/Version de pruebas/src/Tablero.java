
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
public Tablero(Mapa mapa){
	
   casilleros=mapa.get();
   origenPacman=casilleros[1][1];
   OrigenBlynki=casilleros[4][3];
   OrigenPinky=casilleros[1][1];
   OrigenInky=casilleros[0][1];
   OrigenClyde=casilleros[5][1];
   
	
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