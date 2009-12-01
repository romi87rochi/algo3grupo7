
import junit.framework.TestCase;


public class PacmanTest extends TestCase {
	
	Mapa mapas;
	Juego juego;
	MatrizPosiciones matriz;
	Posicion posicion;
	Posicion otraPosicion;
	Posicion posicionPacman;
	Casillero celda;
	Casillero otraCelda;
	Casillero celdaPacman;
	Pacman pacman;
	

	
	public void setUp(){
		mapas=null;
		juego= new Juego(mapas);
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(1,1,matriz);
		otraPosicion=new Posicion(2,1,matriz);
		posicionPacman=new Posicion(3,1,matriz);
		celda =juego.getTablero().getCasillero(posicion);
		otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celdaPacman=juego.getTablero().getCasillero(posicionPacman);
		pacman=new Pacman(juego,celdaPacman);
		
	}
	
	

	public void testComer() {
		
		setUp();
		int puntaje=100;
		ItemComible punto=new Punto( puntaje);
		otraCelda.setItem(punto);
		pacman.mover(otraCelda);
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
		setUp();
		pacman.mover(otraCelda);
		
		assertEquals(pacman.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
		setUp();
		pacman.mover(otraCelda);
		pacman.reubicar();
		assertEquals(pacman.getCasilleroActual(), celdaPacman);
	}

	public void testPacman() {
		setUp();
		assertNotNull(pacman);
	}

}
