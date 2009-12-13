package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Inky;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaInky extends Imagen {
	Inky inky;

	public VistaInky(Inky inky) {
		this.inky=inky;
		this.setNombreArchivoImagen("Inky.jpg");
        this.setPosicionable(inky);
	}

	private void determinarImagen() {
		if (inky.puedeSerComido()) {
			if(this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("FanPuedeSerComido.jpg");
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("Inky.jpg");
		}
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}