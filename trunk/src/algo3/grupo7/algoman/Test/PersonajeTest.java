package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;


public class PersonajeTest extends TestCase {
	
	private Juego juego;
	private Pacman pacman;
	private Blinky blinky;

	public void setUp(){
		
		juego= new Juego();
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa, 0);
		blinky=juego.getBlinky();
		pacman=juego.getPacman();
	
	}


	public void testCambiarEstado() {
		
		assertTrue(pacman.puedeSerComido());
		assertFalse(blinky.puedeSerComido());
		pacman.vivir();
		blinky.vivir();
		
		assertTrue(blinky.puedeSerComido());
		assertFalse(pacman.puedeSerComido());
	}

	public void testPuedeSerComido() {
		
		assertTrue(pacman.puedeSerComido());
		assertFalse(blinky.puedeSerComido());
	}

}
