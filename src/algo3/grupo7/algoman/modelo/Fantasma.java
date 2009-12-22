package algo3.grupo7.algoman.modelo;

public abstract class Fantasma extends Personaje {

	private Estrategia estrategia;
	private Pacman pacman;
	private int tiempoDeEspera;
	private int tiempoDebilidad;
	private int idDebilidad; 

	public Fantasma(Juego nuevoJuego, Personaje pacman, int velocidad) {
		super(nuevoJuego, false, velocidad);
		this.pacman = (Pacman) pacman;
		this.estrategia = null; // es seteada al finalizar el constructor de las
		this.tiempoDeEspera = 0; // derivadas
		this.tiempoDebilidad=0;
		this.idDebilidad = 0;
	}

	protected void comer() {

		if (this.getCasilleroActual().hayPacman() && pacman.puedeSerComido()) {
			pacman.encontrado();
			this.reubicar();
		}
		if (this.getCasilleroActual().hayPacman() && !pacman.puedeSerComido()
				&& !this.puedeSerComido()) {
			pacman.encontrado();
			this.reubicar();
		} else if (this.getCasilleroActual().hayPacman()) {
			this.reubicar();
			tiempoDeEspera = 70 - (this.getJuego().getNivel() * 30);
			this.idDebilidad=pacman.getIdEfectoGroso();	
		}
	}

	public void vivir() {
		/*
		 * Si el pacman no esta vivo es xq otro pj lo comio por lo tanto el
		 * fantasma se reubica
		 */
		int pasos = 0;
		if (tiempoDeEspera > 0) {
			pasos = this.getVelocidad();
			--tiempoDeEspera;
			
		}
		if (pacman.estaVivo()) {
			while (pasos < this.getVelocidad()) { // ver cuando cambia de nivel

				this.mover(getEstrategia().proximoCasillero());
				pasos++;
			}
		} else {
			this.reubicar();
		}
	}


	/*
	 * mueve el fantasma al casillero original y lo borra del casillero en que
	 * se encontraba
	 */
	protected void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();
		this.setPuedeSerComido(false);
		this.idDebilidad=pacman.getIdEfectoGroso();	
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
		this.getCasilleroActual().agregarFantasma(this);
		try {casilleroAux.removerFantasma(this);
		} catch (Exception e) {}
	}

	protected void mover(Casillero nuevoCasillero) {
		/*
		 * En cada movimiento se pregunta el estado del pacman para modificar su
		 * estado. Cuando el fantasmas puede ser comido se mantiene su velocidad
		 * disminuida
		 */

		nuevoCasillero.agregarFantasma(this);
		getCasilleroActual().removerFantasma(this);
		this.setCasilleroActual(nuevoCasillero);
		if (pacman.puedeSerComido()) {
			this.cambiarVelocidad(getVelocidadOriginal());
			this.setPuedeSerComido(false);
		}
		if (!pacman.puedeSerComido()
				&& this.idDebilidad == pacman.getIdEfectoGroso()) {
			this.cambiarVelocidad(getVelocidadOriginal());
			this.setPuedeSerComido(false);
			this.tiempoDebilidad=pacman.getTiempoDeEfecto();
		}
		if (!pacman.puedeSerComido()&& this.idDebilidad != pacman.getIdEfectoGroso()) {// pacman no
															// estado
			    this.setPuedeSerComido(true);
				if ((this.getVelocidad() - 2) > 0)
				this.cambiarVelocidad(getVelocidad() - 1);
				this.tiempoDebilidad=pacman.getTiempoDeEfecto();
		}
		// Sea cual sea la situacion el fantasma intentara comer
		this.comer();

	}

	// metodo que sera utilizado cuando pacman se cruse con un fantasma
	protected void encontrado() {
        morir();
	}

	/* El fantasma muere y es trasladado a su posicion de origen */
	protected void morir() {
		this.reubicar();
		this.tiempoDeEspera = 70 - (this.getJuego().getNivel() * 30);
		this.idDebilidad=pacman.getIdEfectoGroso();
	}

	protected void setEstrategia(Estrategia unaEstrategia) {
		this.estrategia = unaEstrategia;
	}

	protected Estrategia getEstrategia() {
		return this.estrategia;
	}
	public int getTiempoDebilidad(){
		return this.tiempoDebilidad;
	}
}