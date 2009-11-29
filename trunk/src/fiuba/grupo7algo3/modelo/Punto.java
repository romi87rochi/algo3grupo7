
public class Punto extends ItemComible{
	

	
	public Punto(Juego nuevoJuego, int nuevoPuntaje){
		super(nuevoJuego, nuevoPuntaje,false);
	}

	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());
		this.getJuego().pastillaComida();

	}
	

}
