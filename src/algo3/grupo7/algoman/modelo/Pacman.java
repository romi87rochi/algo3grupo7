package algo3.grupo7.algoman.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Pacman extends Personaje {

	private int vidas;
	private boolean vivo;
	private static final int CANTVIDAS = 3;
	private static final int VELOCIDAD = 5;
	private int itemsComidos;
	private int tiempoDeEfecto;
	private int idEfectoGroso;
	private int tiempoDeResurreccion;
	private String proximaDireccion;
	private String direccionActual;

	public Pacman(Juego nuevoJuego) {
		super(nuevoJuego, true, VELOCIDAD);
		this.vidas = CANTVIDAS;
		this.tiempoDeEfecto = 0;
		this.tiempoDeResurreccion = 2;
		this.vivo = false;
		this.itemsComidos=0;
		this.idEfectoGroso=0;
		this.setCasilleroActual(nuevoJuego.getMapa().getOrigenPacman());
		//this.inicializar();
	}

	protected void mover(Casillero nuevoCasillero) {
		this.comprobarEstado();
		if (nuevoCasillero.puedeSerVisitado()) {
			nuevoCasillero.agregarPacman(this);
			this.getCasilleroActual().removerPacman(this);
			this.setCasilleroActual(nuevoCasillero);
			this.comer();
		}
	}

	public void setProximaDireccion(String proximaDireccion) {
		this.proximaDireccion = proximaDireccion;
	}

	public void vivir() {
		
			int pasos = 0;
			this.comprobarIntegridadYresurreccion();
			while (pasos < this.getVelocidad() && this.estaVivo()) {
				// se guarda un casillero auxiliar adyacente al actual segun la
				// direccion actual
				Casillero casilleroAux = getCasilleroProximaDireccion(this.direccionActual);
				/*
				 * pregunta si en la direccion q indica el usuario hay un
				 * casillero camino, si lo es lo visita y esta direccion se
				 * convertira en la actual
				 */
				if (this.getCasilleroProximaDireccion(proximaDireccion)
						.puedeSerVisitado()) {
					casilleroAux = this
							.getCasilleroProximaDireccion(proximaDireccion);
					this.direccionActual = proximaDireccion;
				}
				pasos++;
				this.mover(casilleroAux);
			}
		}
	
 /*Verifica si pacman esta muerto y en este caso por cuestiones de implementacion de titiritero
  * el personaje continuara muerto hasta q se hagote su tiempo de resurrecion para asegurar que todos los fantasmas
  *supieron que pacman estubo sin vida. De esta manera ellos se reubicaran y pacman volvera a la vida reubicandose tambien.
  */
	private void comprobarIntegridadYresurreccion(){
		if (!this.estaVivo()) {
			if (this.tiempoDeResurreccion > 0) {
				--this.tiempoDeResurreccion;
			} else {
				this.inicializar();
			}
		}
         
	}
	
	private void inicializar() {
		this.vivo = true;
		this.reubicar();
		direccionActual = "izquierda";
		this.proximaDireccion = "izquierda";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/*
	 * Intenta comer todos los fantasmas contenidos en el casillero si come
	 * alguno que no puede ser comido pacman muere
	 */
	private void comerFantasmas() {
		ArrayList<Fantasma> listaFantasmas = this.getCasilleroActual()
				.getFantasmas();

		while (!listaFantasmas.isEmpty()) {
			Iterator<Fantasma> itFantasmas = listaFantasmas.iterator();
			Fantasma fantasmaAux = itFantasmas.next();
			if (fantasmaAux.puedeSerComido()) {
				itFantasmas = null;// cierra el uso del iterador para q pueda
				// perdir uno el fantasma
				fantasmaAux.encontrado();

			} else {
				this.morir();
				break;
			}
		}
	}

	/* Intenta comer algun item que exista en el casillero */
	private void comerItem() {
		if (this.getCasilleroActual().hayItem()) {
			
			ItemComible itemAux = this.getCasilleroActual().getItem();
			// Si no fue comido se le pasa el item para que el juego determine
			// su puntaje
			this.getJuego().adicionarPuntajeItem(itemAux);

			/*
			 * Pregunta si es una pastilla de poder y cambia su estado y el
			 * tiempo de efecto es caso de serlo
			 */

			if (itemAux.esDePoder()) {
				this.setPuedeSerComido(false);
				tiempoDeEfecto = ((PuntoDePoder) itemAux).getTiempDeEfecto();
				++this.idEfectoGroso; //Es un nuevo efecto 
			}
			this.getCasilleroActual().setItem(null);
			++itemsComidos;
			this.comprobarSiDebeSerFinNivel();
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

	private void comprobarSiDebeSerFinNivel(){
		if (this.getJuego().getCantPastillasDelNivel() == this
				.getItemsComidos()) {
			this.itemsComidos = 0;
			this.vivo=false;
			this.tiempoDeResurreccion=2;
			this.setPuedeSerComido(true);
			this.getJuego().finalizarNivel();
		}
	}

	protected void morir() {
		this.vivo = false;
		this.reubicar();
		this.decrementarVida();
		this.tiempoDeResurreccion = 2;
		this.direccionActual = "izquierda";
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public boolean estaVivo() {
		return vivo;
	}

	protected void encontrado() {
		this.morir();
	}

	/*
	 * mueve a pacman al casillero original y lo borra del casillero en que se
	 * encontraba
	 */
	protected void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenPacman());
		this.getCasilleroActual().agregarPacman(this);
		this.idEfectoGroso=0; 
		if (casilleroAux != this.getJuego().getMapa().getOrigenPacman())
			casilleroAux.removerPacman(this);
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
	private void comprobarEstado() {
		if (!this.puedeSerComido()) {

			--tiempoDeEfecto;

			if (tiempoDeEfecto == 0) {
				this.setPuedeSerComido(true);
			}

		}

	}

	public int getItemsComidos() {
		return itemsComidos;
	}

	public int getVidas() {
		return vidas;
	}

	/* Devuelve el casillero adyacente segun la direccion indicada */
	private Casillero getCasilleroProximaDireccion(String direccion) {
		Casillero casilleroAux = null;
		if (direccion == "arriba") {
			return getCasilleroActual().getArriba();
		}
		if (direccion == "abajo") {
			return getCasilleroActual().getAbajo();
		}
		if (direccion == "derecha") {
			casilleroAux = getCasilleroActual().getDerecha();
		}
		if (direccion == "izquierda") {
			casilleroAux = getCasilleroActual().getIzquierda();
		}
		return casilleroAux;
	}

	public String getDireccionActual() {
		return direccionActual;
	}
	public int getTiempoDeEfecto(){
		return this.tiempoDeEfecto;
	}
	public int getIdEfectoGroso(){
	   return this.idEfectoGroso;
	}
}