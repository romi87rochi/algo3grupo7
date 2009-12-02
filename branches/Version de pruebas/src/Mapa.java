
public class Mapa {
	private Casillero casilleros[][];
	private MatrizPosiciones matPos;
    int cantItems;
    
	public Mapa(){
		casilleros=new Casillero[10][10];
		matPos = new MatrizPosiciones(10,10);
		this.incializar(10, 10);
	}
    public Casillero[][] get(){
		return casilleros;
	}
	public MatrizPosiciones getMatPos(){
		return matPos;
	}
	
	
	private void incializar(int filas, int columnas) {
		  int y;
			  for(int x=0;x<filas;x++){
				  y=0;
				  for(y=0;y<columnas;y++){
					  casilleros[x][y]=new Casillero(new Posicion(x,y,matPos));
				  }
			  }
		}
	
	
	
	
	
	
	/*
	public int getCantidadItems(){
    	
    	return cantItems;
    }
    
	
	public void construirParedDesdeHasta(int DesdeX, int aX, int Desdey, int aY, int hastaX, int hastY){
	   ++cantItems;
   }
	
	public void insertarPastilla(int cantidad){
		++cantItems;
	}
	
	public void insertarPastillaDePoder(Casillero casillero, ItemComible punto){
		casillero.setItem(punto);
		++cantItems;
	}
	
	public void insertarFruta(int posX, int posY){
		
	}
	
	public int getCantItems(){
		return cantItems;
	}
	
	*/
}
