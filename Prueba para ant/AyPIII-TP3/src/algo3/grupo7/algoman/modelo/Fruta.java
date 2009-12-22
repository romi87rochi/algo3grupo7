package algo3.grupo7.algoman.modelo;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;


public class Fruta extends ItemComible implements  ObjetoVivo{

	private long tiempoDeAparicion;
	
	public Fruta(int nuevoPuntaje, Casillero casilleroActual) {
		super(nuevoPuntaje, false, casilleroActual,false);
	    tiempoDeAparicion=600;
	   
	}

	@Override
	public void vivir() {
       if(this.tiempoDeAparicion<400 && this.tiempoDeAparicion>0){
    	   this.setPuedeserComido(true);
       }
       if(this.tiempoDeAparicion==0){
    	  this.setPuedeserComido(false);
       }
		--this.tiempoDeAparicion;
       
	}

}
