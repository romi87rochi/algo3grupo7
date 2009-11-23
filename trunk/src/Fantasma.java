
public abstract class Fantasma extends Personaje  {

	
	protected int estrategia;
	
	
	public Fantasma(Juego nuevoJuego, Posicion posicionOriginal, int velocidad){
	  super(nuevoJuego, posicionOriginal, velocidad, false);
	  //this.reubicar(posicionOriginal);
	}
	
	public void cambiarVelocidad(int nivel){
		
	}

	public void comer(){
		Personaje pacmanAux = this.getCasillero().getPacman(); 
		if ( pacmanAux != null && pacmanAux.puedeSerComido()){
			this.getJuego().decrementarVidaPackman();
			this.getJuego().reubicarTodosLosPersonajes();
		}else
			this.reubicar();
		
	}
	
	public void mover(Juego unJuego){
		
	}
	
	/*Traslada al fantasma a su posicion de origen*/
	public void reubicar(){
		Casillero casilleroAux   = this.getCasillero();
		Casillero casilleroOriginalAux = this.getCasilleroOriginal();
		/*
		 * mueve el fantasma al casillero original y lo borra del casillero en que
		 *  se encontraba
		 * */
		this.setCasilleroActual(casilleroOriginalAux);
		this.getCasillero().agregarFantasma(this);
		casilleroAux.removerFantasma(this);
		
	}
}
