
public class Punto extends ItemComible{
	
	private int     puntaje;
	private boolean esPowa;
	private boolean fueComido ;
	private final static int PUNTAJE = 200;
	
	public Punto(){
		super();
		fueComido = false;	
		esPowa    = false; 
		puntaje   = PUNTAJE;
	}
/*
	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());
		this.getJuego().pastillaComida();

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
}
