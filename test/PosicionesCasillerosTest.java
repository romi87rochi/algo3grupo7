
import junit.framework.TestCase;


public class PosicionesCasillerosTest extends TestCase {
	

	Juego juego;
	Posicion posicion;
	Casillero celda;
	Pacman pacman;
	MatrizPosiciones matriz;
	
	public void setUp(){
	MapaNivel1 mapa=new MapaNivel1();
		
		juego = new Juego(mapa); 
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(2,2,matriz);
		celda =juego.getTablero().getCasillero(posicion);
		
	}

	
	public void testGetArriba(){
		setUp();
		Posicion posicionPrueba=new Posicion(1,2,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionPrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getArriba());
		
	}
	public void testgetAbajo(){
		setUp();
		Posicion posicionPrueba=new Posicion(3,2,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionPrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getAbajo());
	}
	
	public void testgetIzquierda(){
		setUp();
		Posicion posicionPrueba=new Posicion(2,1,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionPrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getIzquierda());

	}
	
	public void testgetDerecha(){
		setUp();
		Posicion posicionPrueba=new Posicion(2,3,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionPrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getDerecha());
	}
	


}
