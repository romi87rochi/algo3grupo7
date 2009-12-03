
import junit.framework.TestCase;


public class PacmanTest extends TestCase {
	
	Mapa mapas;
	Juego juego;
	Tablero tablero;
	Pacman pacman;
	

	
	public void setUp(){
		tablero=new Tablero();
		juego= new Juego(tablero);
		
		pacman=new Pacman(juego);
		
	}
	
	

	public void testComer() {
		int puntaje=100;
		ItemComible punto=new Punto( puntaje);
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		otraCelda.setItem(punto);
		pacman.mover(otraCelda);
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		pacman.mover(otraCelda);
		
		assertEquals(pacman.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
		
		pacman.mover(pacman.getCasilleroActual().getDerecha());
		pacman.reubicar();
		assertEquals(pacman.getCasilleroActual(), tablero.getCasilleroOrigenPacman());
	}

	public void testPacman() {
		setUp();
		assertNotNull(pacman);
	}

}
