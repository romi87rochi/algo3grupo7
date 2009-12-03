
import junit.framework.TestCase;


public class PersonajeTest extends TestCase {
	Juego juego;
	Pacman pacman;
	Fantasma fantasma;
	
	
	public void setUp(){
	MapaNivel1 mapa=new MapaNivel1();
		
		juego = new Juego(mapa); 
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
