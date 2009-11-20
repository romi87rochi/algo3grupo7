
public class Pacman {

	private int     cantidadDeVidas;
	private boolean puedeSerComido;
	private int     posX;
	private int     posY;	
	
	
	public int getCantidadDeVidas(){
		return this.cantidadDeVidas;
	}
	
	public boolean getPuedeSerComido(){
		return this.puedeSerComido;
	}
	
	public void setCantidadDeVidas(int cantidadDeVidas){
		this.cantidadDeVidas = cantidadDeVidas;
	}
	
	public void setPuedeSerComido(boolean valor){
		this.puedeSerComido = valor;
	}
	
	public Pacman() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void cambiarEstado(){
		
	}
	
	public void revivir(){
		
	}

	public void mover(){
		
	}
	
	public void comer(){
		
	}
	
	public void setPosiciones(int posX, int posY){
		
	}
	
	public int getX(){
		return this.posX;
	}
	
	public int getY(){
		return this.posY;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
