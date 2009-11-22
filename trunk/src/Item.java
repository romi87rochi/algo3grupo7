
abstract class Item {
	private Juego juego;
	private int puntajePredeterminado;
	private Posicion posicion
	
	public Item (Juego nuevoJuego, int nuevoPuntaje, Posicion posicion){
		this.juego=nuevoJuego;
		this.puntajePredeterminado=nuevoPuntaje;
		this.posicion=posicion;
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}
	public Posicion getPosicion(){
		return posicion;
	}
	
	public void getJuego(){
		return juego;
	}
	public abstract void fueComido();
		
	
	
	

}
