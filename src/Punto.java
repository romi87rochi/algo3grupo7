
public class Punto extends Item{
	
	private int puntajePredeterminado;
	
	public Punto(int puntaje){
		this.puntajePredeterminado=puntaje;
	}
	
	public void comido(Juego unJuego){
		unJuego.setPuntaje(puntajePredeterminado);
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}

	
}
