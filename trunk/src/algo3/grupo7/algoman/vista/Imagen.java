package algo3.grupo7.algoman.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable{
	
	public Imagen(){
		listaImagenes=new ArrayList<BufferedImage>();
		listaNombresImagenes=new ArrayList<String>();
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
	}
	    
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		InputStream in = getClass().getResourceAsStream(this.nombreArchivoImagen);
		JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagen = decoder.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){

		}			
	}
	

	
	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}
	
	protected BufferedImage getImagen(){
		return imagen;
	}
	
	////////////////////////
	
	protected void agregarImagenes(int posImg, String rutaImg){
	try {
		
			InputStream in = getClass().getResourceAsStream(rutaImg);
			JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
			this.listaImagenes.add(posImg,decoder.decodeAsBufferedImage());
			this.listaNombresImagenes.add(posImg, rutaImg);
			
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	}
	
	public void setImagenAgregada(int posImg) {
		this.imagen = this.listaImagenes.get(posImg);
		this.nombreArchivoImagen = this.listaNombresImagenes.get(posImg);
}
	
	private ArrayList<BufferedImage> listaImagenes;
	private ArrayList<String> listaNombresImagenes;

///////////////////////////////////////////////////	
	private String nombreArchivoImagen;
    private BufferedImage imagen;
    private Posicionable posicionable;

}
