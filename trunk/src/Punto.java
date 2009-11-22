
public class Punto extends Item{
	
	
	
	public Punto(Juego nuevoJuego, int nuevoPuntaje, Posicion posicion){
		super(nuevoJuego, nuevoPuntaje, posicion);
	}
	
	public void comido(Juego unJuego){
		unJuego.setPuntaje(puntajePredeterminado);
	}
	


	
}
