package FumanPac;

public class Posicion {
	private int posX;
	private int posY;
 	private MatrizPosiciones matriz;
	private int tipo;
	enum tipoPosicion{PARED, CAMINO, VACIO, PASTILLA, FRUTA, POWER};
    
	public Posicion(int posicionX, int posicionY, MatrizPosiciones matriz, int tipo){
		
		this.matriz = matriz;
		this.posX   = posicionX;
		this.posY   = posicionY;
		this.tipo   = tipo;
	}
	public int getTipo(){
		return this.tipo;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public Posicion getArriba(){
		Posicion arriba = null;
		int posX = this.posX;
		int posY = this.posY;
		posY++;
		
		arriba = this.matriz.obtenerPosicion(posX,posY);
		return arriba;
	}
	
	public Posicion getAbajo(){
		Posicion abajo = null;
		int posX = this.posX;
		int posY = this.posY;
		posY--;
		abajo = this.matriz.obtenerPosicion(posX,posY);
		return abajo;
	}	
	
	public Posicion getIzquierda(){
		Posicion izquierda = null;
		int posX = this.posX;
		int posY = this.posY;
		posX--;
		izquierda = this.matriz.obtenerPosicion(posX,posY);
		return izquierda;
	}	

	public Posicion getDerecha(){
		Posicion derecha = null;
		int posX = this.posX;
		int posY = this.posY;
		posX++;
		derecha = this.matriz.obtenerPosicion(posX,posY);
		return derecha;
	}	
	
	
}