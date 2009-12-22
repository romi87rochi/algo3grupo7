package algo3.grupo7.algoman.vista;

import algo3.grupo7.algoman.modelo.Clyde;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaClyde extends Imagen {
	private Clyde clyde;
    private static final int IMGCLYDE = 0;
    private static final int IMGPUEDESERCOMIDO=1;

	public VistaClyde(Clyde clyde) {
		this.clyde=clyde;
		 this.setPosicionable(clyde);
		this.agregarImagenes(IMGCLYDE,"Clyde.jpg");
		this.agregarImagenes(IMGPUEDESERCOMIDO,"FanPuedeSerComido.jpg");      
		this.setImagenAgregada(IMGCLYDE);
	}

	private void determinarImagen() {
		if (clyde.puedeSerComido()) {
			if (clyde.getTiempoDebilidad() < 320
					&& clyde.getTiempoDebilidad() > 0) {
				this.cambiarImagen();
			} else if (clyde.puedeSerComido())
				if (this.getNombreArchivoImagen() != "FanPuedeSerComido.jpg")
					this.setImagenAgregada(IMGPUEDESERCOMIDO);
		} else {
			if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg")
				this.setImagenAgregada(IMGCLYDE);
		}
	}

	private void cambiarImagen() {
		if (this.getNombreArchivoImagen() == "FanPuedeSerComido.jpg") {
			this.setImagenAgregada(IMGCLYDE);
		} else {
			this.setImagenAgregada(IMGPUEDESERCOMIDO);
		}
	}
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		determinarImagen();
		super.dibujar(superficeDeDibujo);
	}
}