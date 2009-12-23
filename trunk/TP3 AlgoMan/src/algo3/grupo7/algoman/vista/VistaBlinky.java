package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Blinky;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaBlinky extends Imagen {
    private	Blinky blinky;
    private static final int IMGBLINKY = 0;
    private static final int IMGPUEDESERCOMIDO=1;

	public VistaBlinky(Blinky blinky) {
		this.blinky=blinky;
		this.setPosicionable(blinky);
		this.agregarImagenes(IMGBLINKY,"Blinky.jpg");
		this.agregarImagenes(IMGPUEDESERCOMIDO,"FanPuedeSerComido.jpg");      
		this.setImagenAgregada(IMGBLINKY);
	}

	private void determinarImagen() {
		if (blinky.puedeSerComido()) {
			if (blinky.getTiempoDebilidad() < 320
					&& blinky.getTiempoDebilidad() > 0) {
				this.cambiarImagen();
			} else if (blinky.puedeSerComido())
				if (this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
					this.setImagenAgregada(IMGPUEDESERCOMIDO);
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
				this.setImagenAgregada(IMGBLINKY);
		}
	}

	private void cambiarImagen() {
		if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg") {
			this.setImagenAgregada(IMGBLINKY);
		} else {
			this.setImagenAgregada(IMGPUEDESERCOMIDO);
		}
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}
