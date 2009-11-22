
public class Fruta extends Item{
	
	private int rangoDeTiempoDeVida;

	
	public Fruta(Juego nuevoJuego, int nuevoPuntaje, Posicion posicion){
		super(Juego nuevoJuego, int nuevoPuntaje, Posicion posicion);
	}
	
		/*int rango= this.setRangoDeVida(20); //ejemplo
		Controlador controla= new controlador(rango);
		this.comenzarJuego(rango); // metodo de titiritero, para que viva solo por un tiempo
		// no se si esta bien usarlo  */
	}
	
	public int getRangoDeVida() {
	   return rangoDeTiempoDeVida;
	}

	public void fueComido(Juego unJuego){
		getJuego().setPuntaje(this.getPuntaje());
		/* Me revuelve el estomago*/
		getJuego().getTablero().getCasillero(this.getPosicion()).setItem()=null;
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}


}
      