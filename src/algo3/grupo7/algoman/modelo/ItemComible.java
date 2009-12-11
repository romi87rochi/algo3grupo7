package algo3.grupo7.algoman.modelo;

import algo3.grupo7.algoman.vista.Circulo;
import ar.uba.fi.algo3.titiritero.Posicionable;

abstract class ItemComible implements Posicionable{

	private int puntajePredeterminado;
	private boolean esPowa;
	Casillero casilleroActual;
	private Circulo vistaPastilla;/*para poder usar el controlador en Tablero*/
	

	

	/*se le pasa el casillero actual para que el titiritero pueda dibujarlo en los mapas*/
	public ItemComible(int nuevoPuntaje, boolean esPowa, Casillero casilleroActual) {

		this.puntajePredeterminado = nuevoPuntaje;
		this.esPowa = esPowa;
		this.casilleroActual=casilleroActual;
	}

	public int getPuntaje() {
		return this.puntajePredeterminado;
	}

	protected boolean esDePoder() {
		return esPowa;
	}
	
	/*solo para implementar posicionable*/
	public int getX(){
		return this.casilleroActual.getPosicion().getPosX();
		
	}
	
	/*solo para implementar posicionable*/
	public int getY(){
		return this.casilleroActual.getPosicion().getPosY();
	}
	
	public Circulo getVistaPastilla() {
		return vistaPastilla;
	}

	public void setVistaPastilla(Circulo vistaPastilla) {
		this.vistaPastilla = vistaPastilla;
	}
}
