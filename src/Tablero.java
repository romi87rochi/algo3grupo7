
public class Tablero {
	
	private Casillero casilleros[][];

/*El tablero es instancianciado con la cantidad de filas
 * y columnas dadas, todos los casilleros no contienen personajes
 * ni items.
 */
public Tablero(int filas, int columnas){
	casilleros=new Casillero[filas][columnas];
	this.incializar(filas,columnas);
}


private void incializar(int filas, int columnas) {
  int y;
	  for(int x=0;x<=filas;x++){
		  y=0;
		  casilleros[x][y]=new Casillero();
		  for(y=0;y<=columnas;y++){
			  casilleros[x][y]=new Casillero();
		  }
	  }
}
public void cargarTablero(Map mapas){
	
}

}
