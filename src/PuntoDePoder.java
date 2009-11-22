
public class PuntoDePoder extends Item{
	
	private int tiempoDePoder;
	private static final int tiempoPoder=20;
	
	public PuntoDePoder(Juego nuevoJuego, int nuevoPuntaje, Posicion posicion){
			super( nuevoJuego,  nuevoPuntaje, posicion);		
		int nivel=unJuego.getNivel();
		this.setTiempoDePoder(tiempoPoder);
				if(tiempoDePoder>nivel)
			this.setTiempoDePoder(tiempoDePoder - nivel);
		else
			this.setTiempoDePoder(10); // ejemplo
		/*¿Hay que usar comenzarJuego de titiritero
		 *  con contador para que
		 * termine el "cambio de estado"?
	*/}

	private void setTiempoDePoder(int tiempo) {
		this.tiempoDePoder=tiempo;
		
	}
	
	public void comido(Juego unJuego){
		unJuego.setPuntaje(puntajePredeterminado);
		unJuego.cambiarEstadoDeLosFantasmas();
		unJuego.cambiarEstadoPackman();
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}


}
