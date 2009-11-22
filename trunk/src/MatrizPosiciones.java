package PaquetePruebasMatrizPosiciones;
import java.util.ArrayList;

public class MatrizPosiciones {
    private int filas;
    private int columnas;    
    private Posicion posiciones[][];
    
    
	public MatrizPosiciones(int filas, int columnas) {
		super();
		// TODO Auto-generated constructor stub
		
		this.filas    = filas;
		this.columnas = columnas;
		posiciones    = new Posicion[filas +1][columnas+1];
		this.incializar();
	}

	private void incializar() {
		  int y;
			  for(int x=1;x<=filas;x++){
				  y=0;
				  posiciones[x][y]= new Posicion(x,y,this);
				  for(y=0;y<=columnas;y++){
					  posiciones[x][y]= new Posicion(x,y,this);
				  }
			  }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	public ArrayList getAdyacente(Posicion posicion){
		Posicion arriba;
		Posicion abajo;
		Posicion izquierda;
		Posicion derecha;
		ArrayList posicionesAdyacenetes;
		
		posicionesAdyacenetes = new ArrayList(4); 
		arriba = posicion.getArriba();
		abajo  = posicion.getAbajo();
		izquierda = posicion.getIzquierda();
		derecha   = posicion.getDerecha();
	
		posicionesAdyacenetes.add(1,arriba);
		posicionesAdyacenetes.add(1,abajo);
		posicionesAdyacenetes.add(1,izquierda);
		posicionesAdyacenetes.add(1,derecha);
	
		return posicionesAdyacenetes;
	
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
}
