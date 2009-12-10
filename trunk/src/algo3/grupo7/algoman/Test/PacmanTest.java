package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;


public class PacmanTest extends TestCase {
	
	Juego juego;
	Pacman pacman;
	Clyde clyde;
	
	public void setUp(){
		
		juego = new Juego();
		
		pacman=juego.getPacman();
		clyde=juego.getClyde();


	}
	
	

	public void testComer() {
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa, 0);
		Casillero otraCelda=pacman.getCasilleroActual();
		pacman.vivir();
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa, 0);
		pacman.vivir();
		
		assertFalse(pacman.getCasilleroActual() == juego.getMapa().getOrigenPacman());
	}

	public void testReubicar() {
		MapaCaminoHorizontalSinPoder mapa= new MapaCaminoHorizontalSinPoder();
		juego.cargarMapa(mapa, 0);
		Blinky blinky=juego.getBlinky();
		pacman.vivir();// come pastilla de poder
		blinky.vivir(); //fantasma come a pacman

		assertEquals(pacman.getCasilleroActual(), juego.getMapa().getOrigenPacman());
		assertEquals(blinky.getCasilleroActual(), juego.getMapa().getOrigenFantasmas());
	}

	public void testPacman() {
		
		assertNotNull(pacman);
	}

}
