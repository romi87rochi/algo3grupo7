package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Fruta;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaFruta extends Imagen {
	Fruta fruta;
	private static final int IMGMANZANA = 0;
	private static final int IMGNADA = 1;
	public VistaFruta(Fruta fruta) {

				this.fruta=fruta;
				this.setPosicionable(fruta);
				this.agregarImagenes(IMGMANZANA,"manzana.jpg");
				this.agregarImagenes(IMGNADA, "nada.jpg");
				this.setImagenAgregada(IMGMANZANA);
		        
			}

			
				
			
			public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
				if (this.fruta!= null && this.fruta.getCasilleroActual().hayItem() && this.fruta.puedeSerComido()) {
					this.setImagenAgregada(IMGMANZANA);
				} else {
					this.setImagenAgregada(IMGNADA);
				}
			 
				
				super.dibujar(superficeDeDibujo);
			}
		


	
	}

