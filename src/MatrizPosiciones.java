

import java.util.ArrayList;

public class MatrizPosiciones {
    private int filas;
    private int columnas;    
    private Posicion posiciones[][];
    
    
	public MatrizPosiciones(int filas, int columnas) {
		
		this.filas    = filas;
		this.columnas = columnas;
		posiciones    = new Posicion[filas][columnas];
		this.incializar();
	}

	private void incializar() {
		  int y;
			  for(int x=0;x<filas;x++){
				  y=0;
				  for(y=0;y<columnas;y++){
					  posiciones[x][y]= new Posicion(x,y,this);
				  }
			  }
	}


	public Posicion obtenerPosicion(int posX, int posY) {
		Posicion posicion = null;
		try{
			posicion = this.posiciones[posX][posY];
		}
		catch(Exception e){
			//e.printStackTrace();
			return null;
		}
		return posicion;
	}

	public Posicion obtenerPosicion(Posicion posicion) {
		Posicion pos = null;
		try{
			pos = this.posiciones[posicion.getPosX()][posicion.getPosY()];
		}
		catch(Exception e){
			//e.printStackTrace();
			return null;
		}
		return pos;
	}
	
	public ArrayList<Posicion> getAdyacente(Posicion posicion){
		Posicion arriba;
		Posicion abajo;
		Posicion izquierda;
		Posicion derecha;
		ArrayList<Posicion> posicionesAdyacenetes;
		
		posicionesAdyacenetes = new ArrayList<Posicion>(); 
		arriba    = posicion.getArriba();
		abajo     = posicion.getAbajo();
		izquierda = posicion.getIzquierda();
		derecha   = posicion.getDerecha();
	
		posicionesAdyacenetes.add(0,arriba);
		posicionesAdyacenetes.add(1,abajo);
		posicionesAdyacenetes.add(2,izquierda);
		posicionesAdyacenetes.add(3,derecha);
	
		return posicionesAdyacenetes;
	
	}

	
}
