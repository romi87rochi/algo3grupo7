package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Inky;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaInky extends Imagen {
	private Inky inky;
	private static final int IMGINKY = 0;
	private static final int IMGPUEDESERCOMIDO = 1;

	public VistaInky(Inky inky) {
		this.inky = inky;
		this.setPosicionable(inky);
		this.agregarImagenes(IMGINKY, "Inky.jpg");
		this.agregarImagenes(IMGPUEDESERCOMIDO, "FanPuedeSerComido.jpg");
		this.setImagenAgregada(IMGINKY);
	}

	private void determinarImagen() {
		if (inky.puedeSerComido()) {
			if (inky.getTiempoDebilidad() < 320
					&& inky.getTiempoDebilidad() > 0) {
				this.cambiarImagen();
			} else if (inky.puedeSerComido())
				if (this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
					this.setImagenAgregada(IMGPUEDESERCOMIDO);
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
				this.setImagenAgregada(IMGINKY);
		}
	}

	private void cambiarImagen() {
		if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg") {
			this.setImagenAgregada(IMGINKY);
		} else {
			this.setImagenAgregada(IMGPUEDESERCOMIDO);
		}
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}