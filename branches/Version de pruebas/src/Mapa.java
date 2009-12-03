
public class Mapa {
	private Casillero casilleros[][];
    int cantItems;
    
	public Casillero[][] get(){
		return casilleros;
	}
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
	
	
}