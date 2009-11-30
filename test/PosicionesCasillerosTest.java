import junit.framework.TestCase;


public class PosicionesCasillerosTest extends TestCase {
	

	Mapa mapas;
	Juego juego;
	MatrizPosiciones matriz;
	Posicion posicion;
	Casillero celda;
	
	public void setUp(){
		mapas=null;
		juego= new Juego(mapas);
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(2,2,matriz);
		
		celda =juego.getTablero().getCasillero(posicion);
		
	}

	
	public void testGetArriba(){
		setUp();
		Posicion posicionArribaDePrueba=new Posicion(2,1,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionArribaDePrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getArriba());
		
	}
	public void testgetAbajo(){
		setUp();
		Posicion posicionArribaDePrueba=new Posicion(2,3,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionArribaDePrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getAbajo());
	}
	
	public void testgetIzquierda(){
		setUp();
		Posicion posicionArribaDePrueba=new Posicion(1,2,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionArribaDePrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getIzquierda());

	}
	
	public void testgetDerecha(){
		setUp();
		Posicion posicionArribaDePrueba=new Posicion(3,2,matriz);
		Casillero celdaArribaDePrueba=juego.getTablero().getCasillero(posicionArribaDePrueba);
		
		assertEquals(celdaArribaDePrueba, celda.getDerecha());
	}
	


}
