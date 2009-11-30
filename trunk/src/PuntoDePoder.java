
public class PuntoDePoder extends ItemComible {

	private int tiempoDeEfecto;
	private int puntaje;
	private boolean esPowa;
	private boolean fueComido;
	private final static int PUNTAJE = 300;

	public PuntoDePoder(int tiempoDeEfecto) {
		this.tiempoDeEfecto = tiempoDeEfecto;
		fueComido = false;
		esPowa    = true;
		puntaje   = PUNTAJE;
	}

/*	public void fueComido() {

		this.getJuego().setPuntaje(this.getPuntaje());

	}
*/
	public boolean esDePoder(){
		return this.esPowa;
	}
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public boolean fueComido(){
		return this.fueComido;
	}
	
	public int getTiempDeEfecto() {
		return tiempoDeEfecto;
	}

}
