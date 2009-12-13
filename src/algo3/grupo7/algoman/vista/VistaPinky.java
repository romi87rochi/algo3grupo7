package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Pinky;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaPinky extends Imagen {
	Pinky pinky;

	public VistaPinky(Pinky pinky) {
		this.pinky=pinky;
		this.setNombreArchivoImagen("Pinky.jpg");
        this.setPosicionable(pinky);
	}
   

	private void determinarImagen() {
		if (pinky.puedeSerComido()) {
			if(this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("FanPuedeSerComido.jpg");
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
			this.setNombreArchivoImagen("Pinky.jpg");
		}
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}