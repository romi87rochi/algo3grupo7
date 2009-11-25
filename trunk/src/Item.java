
abstract class Item {
	private Juego juego;
	private int puntajePredeterminado;
	//private Casillero casillero;
	
	public Item (Juego nuevoJuego, int nuevoPuntaje){
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
