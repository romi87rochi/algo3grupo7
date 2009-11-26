
public class PuntoDePoder extends ItemComible{
	
	private int tiempoDePoder;
	private static final int tiempoPoder=20;
	private int[] vTiempo;
	
	public PuntoDePoder(Juego nuevoJuego, int nuevoPuntaje){
			super( nuevoJuego, nuevoPuntaje);		
			vTiempo=new int[3];
		vTiempo[0]=20;
	    vTiempo[1]=15;
		vTiempo[2]=10;
			
		this.setTiempoDePoder(vTiempo[this.getJuego().getNivel()]);

	}

	private void setTiempoDePoder(int tiempo) {
		this.tiempoDePoder=tiempo;
		
	}
	
	public void fueComido(){
		
		this.getJuego().setPuntaje(this.getPuntaje());
         this.getJuego().cambiarEstadoPackman();
         this.getJuego().cambiarEstadoDeLosFantasmas();
	}
	


}
