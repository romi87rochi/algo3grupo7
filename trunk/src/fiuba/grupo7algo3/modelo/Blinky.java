
public class Blinky extends Fantasma{
	
	private int velocidad;

	public Blinky(Juego nuevoJuego, Casillero casilleroOriginal,Personaje pacman ){
		super( nuevoJuego,casilleroOriginal,pacman);
		casilleroOriginal.agregarFantasma(this);
		this.velocidad=1;
		int tipoEstrategia=1;
		this.estrategia= new Estrategia(pacman, tipoEstrategia,this);
	}
	
	public void vivir(){
		int pasos=0;
		while(pasos<this.velocidad){  //ver cuando cambia de nivel
			
			this.mover(this.getJuego().getTablero().getCasillero(this.estrategia.proximoCasillero()));   //VER!!!!
			pasos++;
		}
		}
		

}
