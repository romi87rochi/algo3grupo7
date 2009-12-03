
import junit.framework.TestCase;


public class PersonajeTest extends TestCase {
	Juego juego;
	Pacman pacman;
	Tablero tablero;
	Fantasma fantasma;
	
	
	public void setUp(){
		tablero=new Tablero();
		juego = new Juego( tablero);

		pacman=new Pacman(juego);
		fantasma=new Blinky(juego, pacman);
		
	}


	public void testCambiarEstado() {
		
		assertTrue(pacman.puedeSerComido());
		assertFalse(fantasma.puedeSerComido());
		pacman.setPuedeSerComido(false);
		fantasma.vivir();
		
		assertTrue(fantasma.puedeSerComido());
		assertFalse(pacman.puedeSerComido());
	}

	public void testPuedeSerComido() {
		
		assertTrue(pacman.puedeSerComido());
		assertFalse(fantasma.puedeSerComido());
	}

}
