package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Blinky;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaBlinky extends Imagen {
	Blinky blinky;

	public VistaBlinky(Blinky blinky) {
		this.blinky=blinky;
		this.setNombreArchivoImagen("Blinky.jpg");
        this.setPosicionable(blinky);
	}

	private void determinarImagen() {
		if (blinky.puedeSerComido()) {
			if(this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("FanPuedeSerComido.jpg");
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("Blinky.jpg");
		}
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}