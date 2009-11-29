import java.util.ArrayList;

import java.util.Iterator;

public class Pacman extends Personaje {
	private int vidas;
	private boolean vivo;
	private static final int CANTVIDAS = 3;
	private int itemsComidos;
	private int tiempoDeEfecto;

	public Pacman(Juego nuevoJuego, Casillero casilleroOriginal) {
		super(nuevoJuego, casilleroOriginal, true);
		this.vidas = CANTVIDAS;
		this.vivo = true;
		this.tiempoDeEfecto = 0;
	}

	public void mover(Casillero nuevoCasillero) {
		/*
		 * se aplica el metodo comer para revisar si no se agrego ningun
		 * fantasma antes de salir
		 */
		// this.comer();
		

		this.comprobarEstado();     
		nuevoCasillero.agregarPacman(this);
		this.getCasilleroActual().removerPacman(this);
		this.setCasilleroActual(nuevoCasillero);
		this.comer();
		
		      
	}

	/*
	 * Busca intenta comer todos los fantasmas contenidos en el casillero si
	 * come alguno que no puede ser comido pacman muere
	 */
	private void comerFantasmas() {
		ArrayList<Fantasma> listaFantasmas = this.getCasilleroActual()
				.getFantasmas();

		Iterator<Fantasma> itFantasmas = listaFantasmas.iterator();
		while (itFantasmas.hasNext()) {
			Fantasma fantasmaAux = itFantasmas.next();
			if (fantasmaAux.puedeSerComido()) {
				fantasmaAux.encontrado();

			} else {
				this.morir();
				break;
			}

		}
	}

	/*Intenta comer algun item que exista en el casillero*/
	private void comerItem() {
		if (this.getCasilleroActual().hayItem()) {
			ItemComible itemAux=this.getCasilleroActual().getItem();
			itemAux.fueComido();
			/*Pregunta si es una pastilla de poder y cambia su estado
			y el tiempo de efecto es caso de serlo*/
			if (itemAux.esDePoder()) {
				this.setPuedeSerComido(false);
				tiempoDeEfecto=((PuntoDePoder)itemAux).getTiempDeEfecto();
			}
			this.getCasilleroActual().setItem(null);
			++itemsComidos;
		}
	}

	/*
	 * Intenta comer lo que haya en el casillero, primero el item y luego los
	 * fantasmas
	 */
	private void comer() {

		this.comerItem();
		this.comerFantasmas();
	}

	protected void morir() {
		this.vivo = false;
		this.reubicar();
		this.decrementarVida();
	}

	public boolean estaVivo() {
		return vivo;
	}

	protected void encontrado() {
		this.morir();
	}

	protected void reubicar() {
		/*
		 * mueve a pacman al casillero original y lo borra del casillero en que
		 * se encontraba
		 */

		this.setCasilleroActual(this.getCasilleroOriginal());
		this.getCasilleroActual().agregarPacman(this);
		this.getCasilleroActual().removerPacman(this);

	}

	/*
	 * Decrementa una vida a packman cuando este es comido por un fantasma si el
	 * total de vidas es cero finaliza el juego
	 */
	private void decrementarVida() {
		--vidas;
		if (vidas == 0) {
			getJuego().finalizarJuego();
		}
	}


	// Comprueba si culmino el tiempo de poder, si es asi cambia su estado
	private void comprobarEstado(){
		if (!this.puedeSerComido()) {
		   
			--tiempoDeEfecto;
			
		      if(tiempoDeEfecto == 0){ 
		      this.setPuedeSerComido(true);
			}

	      }
		
	}

 
   public int getItemsComidos(){
	return itemsComidos;   
   }
   
} 