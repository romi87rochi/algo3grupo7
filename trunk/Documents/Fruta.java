
public class Fruta extends Item{
	
	private int rangoDeTiempoDeVida;
	private int puntajePredeterminado;
	
	public Fruta(int puntaje){
		this.puntajePredeterminado=puntaje;
		int rango= this.setRangoDeVida(20); //ejemplo
		Controlador controla= new controlador(rango);
		this.comenzarJuego(rango); // metodo de titiritero, para que viva solo por un tiempo
		// no se si esta bien usarlo
	}
	
	private int setRangoDeVida(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void comido(Juego unJuego){
		unJuego.setPuntaje(puntajePredeterminado);
	}
	
	public int getPuntaje(){
		return this.puntajePredeterminado;
	}


}
      