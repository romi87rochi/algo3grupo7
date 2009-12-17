package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.MatrizPosiciones;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class PosicionesCasillerosTest extends TestCase {
	

	Juego juego;
	Posicion posicion;
	Casillero celda;
	Pacman pacman;
	MatrizPosiciones matriz;
	MapaFormaCruz mapa;
	
	public void setUp(){
		
		MapaFormaCruz mapa=new MapaFormaCruz();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  
		  
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(12,12,matriz);
		celda =juego.getMapa().getCasillero(posicion);
		
	}

	
	public void testGetArriba(){
		Posicion posicionArriba=new Posicion(12,11,matriz);
		Casillero celdaArribaDePrueba=juego.getMapa().getCasillero(posicionArriba);
		
		assertEquals(celdaArribaDePrueba, celda.getArriba());
		
	}
	public void testgetAbajo(){
		Posicion posicionAbajo=new Posicion(12,13,matriz);
		Casillero celdaArribaDePrueba=juego.getMapa().getCasillero(posicionAbajo);
		
		assertEquals(celdaArribaDePrueba, celda.getAbajo());
		
	}
	
	public void testgetIzquierda(){
		Posicion posicionIzquierda=new Posicion(11,12,matriz);
		Casillero celdaArribaDePrueba=juego.getMapa().getCasillero(posicionIzquierda);
		
		assertEquals(celdaArribaDePrueba, celda.getIzquierda());
			}
	
	public void testgetDerecha(){
		Posicion posicionDerecha=new Posicion(13,12,matriz);
		Casillero celdaArribaDePrueba=juego.getMapa().getCasillero(posicionDerecha);
		
		assertEquals(celdaArribaDePrueba, celda.getDerecha());
		
	}
	


}
