
import junit.framework.TestCase;


public class FantasmaTest extends TestCase {

	public void testComer() {
		Map[] mapas=null;

		Juego juego = new Juego( mapas);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		Fantasma fantasma=new Blinky(juego, otraPosicion, velocidad);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celda.agregarPacman(pacman);
		otraCelda.agregarFantasma(fantasma);
		
		pacman.mover(otraPosicion);
		
		assertNull(otraCelda.getPacman());
		assertTrue(juego.getVidasPackman()==2);
	}

	public void testMover() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Fantasma fantasma=new Blinky(juego,posicion, velocidad);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celda.agregarFantasma(fantasma);
		
		fantasma.mover(otraPosicion);
		
		assertEquals(fantasma.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(3, 3, null);
		Fantasma fantasma=new Blinky(juego,posicion, velocidad);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		celda.agregarFantasma(fantasma);
		
		fantasma.mover(otraPosicion);
		fantasma.reubicar();
		assertEquals(fantasma.getCasilleroActual(), celda);
	}

	public void testFantasma() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(3, 3, null);
		Fantasma fantasma=new Blinky(juego,posicion, velocidad);
		assertNotNull(fantasma);
	}

	public void testCambiarVelocidad() {
		//falta implementarlo
	}

}
