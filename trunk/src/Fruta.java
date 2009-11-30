public class Fruta extends ItemComible{
	private int     puntaje;
	private boolean esPowa;
	private boolean fueComido ;
	private final static int PUNTAJE = 400;
	
	public Fruta(){
		super();
		fueComido = false;	
		esPowa    = false; 
		puntaje   = PUNTAJE;
	}

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
