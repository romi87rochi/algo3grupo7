
public abstract class Personaje {
	
  private int velocidad;
  private Juego juego;
  private Posicion posicion;
  private Posicion posicionOriginal;
  private boolean puedeSerComido;
	

	public Personaje(Juego nuevoJuego, Posicion posicionOriginal, int velocidad, boolean puedeSerComido) {
		this.juego=nuevoJuego;
		this.posicion=nuevaPosicionOriginal; //inicialmente la posicion actual sera la original
		this.posicionOriginal=nuevaPosicioOriginal;
		this.puedeSerComido=puedeSerComido;
	}


	public abstract void  comer() {
		
	}

	public abstract void mover(){
		
	}
	
   /*cuando pacman pueda ser comido los fantasmas no y viseversa
    * por eso este algoritmo debe funcionar
    */
	public void cambiarEstado(){
		 if (this.getPuedeSerComido()){
			 this.setPuedeSerComidio=true;
		 }else{
			 this.setPuedeSerComido=false;
		 }
	}
	
	

	public  void reubicar(Posicion posicionOriginal){
		/*escribir codigo*/
	}
	
	public Juego getJuego(){
		return juego;
	}

	public Posicion getPosicion(){
		return posicion;
	}
	 
	public Posicion getPosicionOriginal(){
		return posicionOriginal;
	}

	public int getVelocidad(){
    	return velocidad;
    }

	
	public boolean getPuedeSerComido(){
		return this.puedeSerComido;
	}
	
	
}
