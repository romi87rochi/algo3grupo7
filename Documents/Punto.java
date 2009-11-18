
public class Punto extends Item{
	
	private int puntajePredeterminado;
	
	public Punto(int puntaje){
		this.puntajePredeterminado=puntaje;
	}
	
	public void comido(Juego unJuego){
		unJuego.sumaPuntajes(this);
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}

	
}
