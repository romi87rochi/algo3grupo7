package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Clyde;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaClyde extends Imagen {
	Clyde clyde;

	public VistaClyde(Clyde clyde) {
		this.clyde=clyde;
		this.setNombreArchivoImagen("Clyde.jpg");
        this.setPosicionable(clyde);
	}

	private void determinarImagen() {
		if (clyde.puedeSerComido()) {
			if(this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("FanPuedeSerComido.jpg");
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("Clyde.jpg");
		}
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}