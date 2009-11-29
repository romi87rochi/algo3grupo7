public abstract class Personaje {

	private int velocidad;
	private Juego juego;
	private Casillero casilleroActual;
	private Casillero casilleroOriginal;
	private boolean puedeSerComido;

	public Personaje(Juego nuevoJuego, Casillero casilleroOriginal,
			 boolean puedeSerComido) {
		this.juego = nuevoJuego;
		this.casilleroOriginal = casilleroOriginal;
				 // inicialmente la posicion actual sera la
		// original
		this.casilleroActual = casilleroOriginal;

		this.puedeSerComido = puedeSerComido;

		/*
		 * this.juego=nuevoJuego; this.puedeSerComido = false; this.velocidad =
		 * velocidad; this.casilleroOriginal = new Casillero(cOriginal);
		 * this.casilleroActual = casilleroOriginal;
		 */
	}

	protected void setCasilleroActual(Casillero casilleroActual) {
		this.casilleroActual = casilleroActual;
	}

	protected void setCasilleroOriginal(Casillero casilleroOriginal) {
		this.casilleroOriginal = casilleroOriginal;
	}



	protected abstract void mover(Casillero nuevoCasillero);

	/*
	 * cuando pacman pueda ser comido los fantasmas no y viseversa por eso este
	 * algoritmo debe funcionar
	 */
	protected void setPuedeSerComido(boolean valor){
		puedeSerComido=valor;
	}
	
	protected abstract void encontrado();

	protected abstract void reubicar();
	protected abstract void morir();
	 
	protected Juego getJuego() {
		return juego;
	}

	protected Casillero getCasilleroActual() {
		return casilleroActual;
	}

	protected Casillero getCasilleroOriginal() {
		return casilleroOriginal;
	}

	protected int getVelocidad() {
		return velocidad;
	}

	public boolean puedeSerComido() {
		return this.puedeSerComido;
	}
    
	
}
