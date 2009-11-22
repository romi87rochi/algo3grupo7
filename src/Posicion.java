package PaquetePruebasMatrizPosiciones;


//import java.util.ArrayList;


public class Posicion {
	private int posX;
	private int posY;
	private MatrizPosiciones matriz;
	

	public Posicion(int posicionX, int posicionY, MatrizPosiciones matriz){
		
		this.matriz = matriz;
		this.posX   = posicionX;
		this.posY   = posicionY;
		
	}
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public Posicion getArriba(){
		Posicion arriba = null;
		arriba = this.matriz.obtenerPosicion(this.posX,this.posY++);
		return arriba;
	}
	
	public Posicion getAbajo(){
		Posicion abajo = null;
		abajo = this.matriz.obtenerPosicion(this.posX,this.posY--);
		return abajo;
	}	
	
	public Posicion getIzquierda(){
		Posicion izquierda = null;
		izquierda = this.matriz.obtenerPosicion(this.posX--,this.posY);
		return izquierda;
	}	

	public Posicion getDerecha(){
		Posicion derecha = null;
		derecha = this.matriz.obtenerPosicion(this.posX--,this.posY);
		return derecha;
	}	
	
	
}