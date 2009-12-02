
public abstract class Fantasma extends Personaje {

	protected Estrategia estrategia;
	Pacman pacman;

	public Fantasma(Juego nuevoJuego, Casillero casilleroOriginal,
			Personaje pacman) {
		super(nuevoJuego, casilleroOriginal, false);
		this.pacman = (Pacman)pacman;
	}

	public void cambiarVelocidad(int nivel) {

	}

	public void comer() {

		if (this.getCasilleroActual().hayPacman() && pacman.puedeSerComido()) {
			pacman.encontrado();
			this.reubicar();
		} else if(this.getCasilleroActual().hayPacman()){
			this.reubicar();
		}
	}
    
	public void vivir(){
		
	}
	
	protected void mover(Casillero nuevoCasillero) {
      /*Si el pacman no esta vivo es xq otro pj lo comio por 
       * lo tanto el fantasma se reubica
       */
		if (pacman.estaVivo()) {
			nuevoCasillero.agregarFantasma(this);
			getCasilleroActual().removerFantasma(this);
			this.setCasilleroActual(nuevoCasillero);
			if (pacman.puedeSerComido()) {
				this.setPuedeSerComido(false);				
			} else {
				this.setPuedeSerComido(true);
			}
			this.comer();
		} else {
			this.reubicar();
		}

	}

	/* Traslada al fantasma a su posicion de origen */
	protected void reubicar() {
		Casillero casilleroAux = this.getCasilleroActual();

		/*
		 * mueve el fantasma al casillero original y lo borra del casillero en
		 * que se encontraba
		 */
		this.setCasilleroActual(this.getCasilleroOriginal());
		this.getCasilleroActual().agregarFantasma(this);
		casilleroAux.removerFantasma(this);

	}

	/*
	 * metodo que sera utilizado cunaod pacman se cruse con un fantasma
	 */
	protected void encontrado() {
		this.reubicar();
	}

 
   protected void morir(){
	  /*en el caso de fanstasma el morir solo reubica al pj
	   * pero semanticamente no es lo mismo encontrado que morir.
	   */
	   this.reubicar();
   }
   
}