
import java.util.ArrayList;

public class MatrizPosiciones {
    private int filas;
    private int columnas;    
    private Posicion posiciones[][];
	private Mapa mapa;
    
	public MatrizPosiciones() {
		this.mapa     = new Mapa();
		this.filas    = mapa.getFilas();
		this.columnas = mapa.getColumnas();
		posiciones    = new Posicion[filas][columnas];
		this.incializar();
		
	}

	public Mapa getMapa(){
		return this.mapa;
	}
	
	
	private void incializar() {
		  int y;
		  int tipoPosicion = 0;
			  for(int x=0;x<filas;x++){
				  y=0;
				  for(y=0;y<columnas;y++){
					  tipoPosicion = mapa.getTipoPosicion(x,y);
					  posiciones[x][y]= new Posicion(x,y,this,tipoPosicion);
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
