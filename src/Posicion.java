
import java.util.ArrayList;

public class Posicion {
	private int posX;
	private int posY;
	private int posXRango;
	private int posYRango;
	private ArrayList posicionesAdyacenetes;
	

	public Posicion(int posicionX, int posicionY, int posXRango, int posYRango){
		this.posX = posicionX;
		this.posY = posicionY;
		this.posXRango = posXRango;
		this.posYRango = posYRango;
		this.posicionesAdyacenetes = new ArrayList();
	}
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public Posicion[] getAdyacente(Posicion posicion){
				
		return posicionesAdyacenetes;
	}
}
