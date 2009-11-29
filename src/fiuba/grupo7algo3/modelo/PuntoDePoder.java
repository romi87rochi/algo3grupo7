
public class PuntoDePoder extends ItemComible{
	
	int tiempoDeEfecto;
	
	public PuntoDePoder(Juego nuevoJuego, int nuevoPuntaje,int tiempoDeEfecto){
			super( nuevoJuego, nuevoPuntaje,true);		
           this.tiempoDePoder=tiempoDeEfecto;      
	}


	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());

	}
	
   public int getTiempDeEfecto(){
	   return tiempoDeEfecto;
   }

}
