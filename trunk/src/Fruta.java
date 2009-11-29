
public class Fruta extends ItemComible{
	
	
	public Fruta(Juego nuevoJuego, int nuevoPuntaje){
		super( nuevoJuego, nuevoPuntaje,false);
	}
	
	
	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());
      
	}

}
      