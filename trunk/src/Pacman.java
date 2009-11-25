import java.util.ArrayList;

import java.util.Iterator;

public class Pacman extends Personaje {

	public Pacman(Juego nuevoJuego, Posicion posicionOriginal, int velocidad) {
		super(nuevoJuego, posicionOriginal, velocidad, true);
		// this.reubicar(posicionOriginal);
	}

	public void mover() {

	}

	public void comer() {
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
       this.getCasilleroActual().setItem(null);
		}

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
