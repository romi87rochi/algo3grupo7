
import junit.framework.TestCase;


public class PacmanTest extends TestCase {

	public void testComer() {
		Map[] mapas=null;

		Juego juego = new Juego( mapas);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celda.agregarPacman(pacman);
		int puntaje=100;
		ItemComible punto=new Punto(juego, puntaje);
		otraCelda.setItem(punto);
		pacman.mover(otraPosicion);
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celda.agregarPacman(pacman);
		
		pacman.mover(otraPosicion);
		
		assertEquals(pacman.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(3, 3, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celda.agregarPacman(pacman);
		
		pacman.mover(otraPosicion);
		pacman.reubicar();
		assertEquals(pacman.getCasilleroActual(), celda);
	}

	public void testPacman() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(3, 3, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		assertNotNull(pacman);
	}

}
