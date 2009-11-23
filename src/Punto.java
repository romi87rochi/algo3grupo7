
public class Punto extends Item{
	
	
	
	public Punto(Juego nuevoJuego, int nuevoPuntaje){
		super(nuevoJuego, nuevoPuntaje);
	}

	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());

	}
	
	
}
