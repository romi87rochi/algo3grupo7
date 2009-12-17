package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Fruta;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaFruta extends Imagen {
	Fruta fruta;

	public VistaFruta(Fruta fruta) {

				this.fruta=fruta;
				this.setNombreArchivoImagen("manzana.jpg");
		        this.setPosicionable(fruta);
			}

			
				
			
			public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
				if (this.fruta.getCasilleroActual().hayItem()) {
					this.setNombreArchivoImagen("manzana.jpg");
				} else {
					this.setNombreArchivoImagen("nada.jpg");
				}
			
				super.dibujar(superficeDeDibujo);
			}
		


	
	}

