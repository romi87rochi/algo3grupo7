
import junit.framework.TestCase;


public class PersonajeTest extends TestCase {


	public void testCambiarEstado() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(3, 3, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		Fantasma fantasma=new Blinky(juego, otraPosicion, velocidad);
		
		assertTrue(pacman.puedeSerComido());
		assertFalse(fantasma.puedeSerComido());
		pacman.cambiarEstado();
		fantasma.cambiarEstado();
		
		assertTrue(fantasma.puedeSerComido());
		assertFalse(pacman.puedeSerComido());
	}

	public void testPuedeSerComido() {
		Juego juego = new Juego( null);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(3, 3, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		Fantasma fantasma=new Blinky(juego, otraPosicion, velocidad);
		
		assertTrue(pacman.puedeSerComido());
		assertFalse(fantasma.puedeSerComido());
	}

}
