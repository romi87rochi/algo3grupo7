package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Pinky;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaPinky extends Imagen {
	private Pinky pinky;

	private static final int IMGPINKY = 0;
	private static final int IMGPUEDESERCOMIDO = 1;

	public VistaPinky(Pinky pinky) {
		this.pinky = pinky;
		this.setPosicionable(pinky);
		this.agregarImagenes(IMGPINKY, "Pinky.jpg");
		this.agregarImagenes(IMGPUEDESERCOMIDO, "FanPuedeSerComido.jpg");
		this.setImagenAgregada(IMGPINKY);
	}

	private void determinarImagen() {

		if (pinky.puedeSerComido()) {
			if (pinky.getTiempoDebilidad() < 320&& pinky.getTiempoDebilidad() > 0) {
				this.cambiarImagen();
			} else if (this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
				this.setImagenAgregada(IMGPUEDESERCOMIDO);
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
				this.setImagenAgregada(IMGPINKY);
		}
	}

	private void cambiarImagen() {
		if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg") {
			this.setImagenAgregada(IMGPINKY);
		} else {
			this.setImagenAgregada(IMGPUEDESERCOMIDO);
		}
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}