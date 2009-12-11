package algo3.grupo7.algoman.vista;
import algo3.grupo7.algoman.modelo.Juego;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
public class VistaMapa extends Imagen implements Posicionable{
	private Juego juego;
	
    public VistaMapa(Juego juego) {
    	this.juego=juego;
		this.setNombreArchivoImagen("mapaNivel4.jpg");
		this.setPosicionable(this);
		
	}
    
	public void dibujar(SuperficieDeDibujo sup){
		
		if(juego.getNivel()==1){
			this.setNombreArchivoImagen("nivel2.jpg");
		}else
			if(juego.getNivel()==2){
				this.setNombreArchivoImagen("nivel3.jpg");}
		super.dibujar(sup);
		
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