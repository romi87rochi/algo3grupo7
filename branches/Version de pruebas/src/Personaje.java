public abstract class Personaje {

	private int velocidad;
	private Juego juego;
	private Tablero tablero;
    private Casillero casilleroActual;
	
	private boolean puedeSerComido;

	public Personaje(Juego nuevoJuego, boolean puedeSerComido) {
		this.juego = nuevoJuego;
		this.tablero=nuevoJuego.getTablero();
				 // inicialmente la posicion actual sera la
		// original
		this.casilleroActual =null;

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
    
	protected Tablero getTablero(){
		return tablero;
	}
	protected Casillero getCasilleroActual() {
		return casilleroActual;
	}


	protected int getVelocidad() {
		return velocidad;
	}

	public boolean puedeSerComido() {
		return this.puedeSerComido;
	}
    
	
}
