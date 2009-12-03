
import junit.framework.TestCase;


public class PacmanTest extends TestCase {
	
	Juego juego;
	Pacman pacman;
	

	
	public void setUp(){
	MapaNivel1 mapa=new MapaNivel1();
		
		juego = new Juego(mapa); 
		
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
		assertEquals(pacman.getCasilleroActual(), juego.getTablero().getCasilleroOrigenPacman());
	}

	public void testPacman() {
		setUp();
		assertNotNull(pacman);
	}

}
