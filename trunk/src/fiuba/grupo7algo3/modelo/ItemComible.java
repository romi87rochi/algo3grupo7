
abstract class ItemComible {
	private Juego juego;
	private int puntajePredeterminado;
	private boolean esPowa;
	
	public ItemComible (Juego nuevoJuego, int nuevoPuntaje, boolean esPowa){
		this.juego=nuevoJuego;
		this.puntajePredeterminado=nuevoPuntaje;
		this.esPowa=esPowa;
		
		
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}

	
	public Juego getJuego(){
		return juego;
	}
	public abstract void fueComido();
	
	protected boolean esDePoder(){
		return esPowa;
	}
	
		
	


}
