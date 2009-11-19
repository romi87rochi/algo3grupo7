
public class PuntoDePoder extends Item{
	
	private int tiempoDePoder;
	private int puntajePredeterminado;
	
	public PuntoDePoder(Juego unJuego, int puntaje){
		int nivel=unJuego.getNivel();
		this.setTiempoPoder(20);
		this.puntajePredeterminado=puntaje;
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
