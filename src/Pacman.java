import java.util.ArrayList;

import java.util.Iterator;

public class Pacman extends Personaje {

	public Pacman(Juego nuevoJuego, Posicion posicionOriginal, int velocidad) {
		super(nuevoJuego, posicionOriginal, velocidad, true);
		// this.reubicar(posicionOriginal);
	}

	public void mover() {

	}

	private void comerFantasmas(){
		ArrayList<Fantasma> listaFantasmas = this.getCasilleroActual().getFantasmas();
        
		boolean pacmanVivo=true;
		Iterator<Fantasma> itFantasmas = listaFantasmas.iterator();
		while (itFantasmas.hasNext()&& pacmanVivo) {
			Personaje fantasmaAux = itFantasmas.next();
			if (fantasmaAux.puedeSerComido()) {
				fantasmaAux.reubicar();
				fantasmaAux.cambiarEstado();
			} else {
				this.getJuego().decrementarVidaPackman();
				this.getJuego().reubicarTodosLosPersonajes();
                pacmanVivo=false;	
			}
		
	}
}		
	private void comerItem(){
		if (this.getCasilleroActual().getItem()!=null){
			   this.getCasilleroActual().getItem().fueComido();		
		       this.getCasilleroActual().setItem(null);
		}
	}
	/*Intenta comer lo que haya en el casillero, primero
	 * el item y luego los fantasmas
	 */
	public void comer() {
        this.comerItem();
        this.comerFantasmas();

		}

	

	public void reubicar() {
		/*
		 * mueve a pacman al casillero original y lo borra del casillero en que
		 * se encontraba
		 */
		Casillero casilleroAux = this.getCasilleroActual();
		Casillero casilleroOriginal = this.getCasilleroOriginal();

		this.setCasilleroActual(casilleroOriginal);
		this.getCasilleroActual().agregarPacman(this);
		casilleroAux.removerPacman(this);

	}
}
