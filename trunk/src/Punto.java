
public class Punto extends ItemComible{
	
	
	
	public Punto(Juego nuevoJuego, int nuevoPuntaje){
		super(nuevoJuego, nuevoPuntaje);
	}

	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());
		this.getJuego().pastillaComida();

	}
	
	
}
