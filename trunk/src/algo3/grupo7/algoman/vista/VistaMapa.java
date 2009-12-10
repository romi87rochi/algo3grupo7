package algo3.grupo7.algoman.vista;
import ar.uba.fi.algo3.titiritero.Posicionable;
public class VistaMapa extends Imagen implements Posicionable{
    public VistaMapa() {
		this.setNombreArchivoImagen("mapaNivel4.jpg");
		this.setPosicionable(this);
		
	}

	@Override
	public int getX() {
		
		return -15;
	}

	@Override
	public int getY() {
		
		return -15;
	}
}