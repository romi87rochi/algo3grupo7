package algo3.grupo7.algoman.modelo;

public abstract class Fantasma extends Personaje {
    
	private Estrategia estrategia;
	private Pacman pacman;
	

	public Fantasma(Juego nuevoJuego, Personaje pacman, int velocidad) {
		super(nuevoJuego, false, velocidad);
		this.pacman = (Pacman) pacman;
		this.estrategia=null; //es seteada al finalizar el constructor de las derivadas
	
	}

	protected void comer() {

		if (this.getCasilleroActual().hayPacman() && pacman.puedeSerComido()) {
			pacman.encontrado();
			this.reubicar();
		} else if (this.getCasilleroActual().hayPacman()) {
			this.reubicar();
		}
	}

	public void vivir() {
		/*  Si el pacman no esta vivo es xq otro pj lo comio por lo tanto el
		 * fantasma se reubica */
		int pasos = 0;
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
	 * mueve el fantasma al casillero original y lo borra del casillero en
	 * que se encontraba
	 */
	protected void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();
		this.setCasilleroActual(this.getJuego().getMapa().getOrigenFantasmas());
		this.getCasilleroActual().agregarFantasma(this);
	//	if (casilleroAux!= this.getJuego().getMapa().getOrigenFantasmas())
			casilleroAux.removerFantasma(this); 
	}

	
	protected void mover(Casillero nuevoCasillero) {
	  /*En cada movimiento se pregunta el estado del pacman
	   * para modificar su estado. Cuando el fantasmas puede
	   * ser comido se mantiene su velocidad disminuida
	   */

			nuevoCasillero.agregarFantasma(this);
			getCasilleroActual().removerFantasma(this);
			this.setCasilleroActual(nuevoCasillero);
			if (pacman.puedeSerComido()) {
					this.cambiarVelocidad(getVelocidadOriginal());
					this.setPuedeSerComido(false);
				
			} else {
				this.setPuedeSerComido(true);
				if ((this.getVelocidad()-2)>0){
				this.cambiarVelocidad(getVelocidad()-1);
				}
			}
			this.comer();


	}

	// metodo que sera utilizado cuando pacman se cruse con un fantasma
	protected void encontrado() {
		this.reubicar();
	}

	/* El fantasma muere y es trasladado a su posicion de origen */
	protected void morir() {
		this.reubicar();
	}
    
	protected void setEstrategia(Estrategia unaEstrategia){
		this.estrategia=unaEstrategia;
	}
	
	protected Estrategia getEstrategia(){
		return this.estrategia;
	}
}