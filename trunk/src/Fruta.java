
public class Fruta extends Item{
	
	
	public Fruta(Juego nuevoJuego, int nuevoPuntaje){
		super( nuevoJuego, nuevoPuntaje);
	}
	
		
		/*Controlador controla= new controlador(rango);
		this.comenzarJuego(rango); // metodo de titiritero, para que viva solo por un tiempo
		// no se si esta bien usarlo  */
	
	

	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());
      
	}
	
	


}
      