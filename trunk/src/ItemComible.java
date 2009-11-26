
abstract class ItemComible {
	private Juego juego;
	private int puntajePredeterminado;
	//private Casillero casillero;
	
	public ItemComible (Juego nuevoJuego, int nuevoPuntaje){
		this.juego=nuevoJuego;
		this.puntajePredeterminado=nuevoPuntaje;
		
		
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}

	
	public Juego getJuego(){
		return juego;
	}
	public abstract void fueComido();
	

		
	


}
