
import junit.framework.TestCase;


public class FantasmaTest extends TestCase {

	Mapa mapas;

	Juego juego;
	
	public void setUp(){
		Tablero tablero=new Tablero();
		juego = new Juego(tablero);


	}

	public void testComer() {	
	

		Pacman pacman=new Pacman(juego);
		Fantasma fantasma=new Blinky(juego, pacman);
		fantasma.mover(fantasma.getCasilleroActual().getIzquierda());
		pacman.mover(pacman.getCasilleroActual().getIzquierda());//pacman persigue al fantasma
		Casillero celda=pacman.getCasilleroActual();
		pacman.mover(fantasma.getCasilleroActual());
		
		assertNull(celda.getPacman());
		assertTrue(pacman.getVidas()==2);
	}

	public void testMover() {
	
		
		Pacman pacman=new Pacman(juego);
		Fantasma fantasma=new Blinky(juego,pacman);
		
		fantasma.mover(fantasma.getCasilleroActual().getIzquierda());
		Casillero otraCelda=fantasma.getCasilleroActual();
		assertEquals(fantasma.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
	
		Pacman pacman=new Pacman(juego);
	
		Fantasma fantasma=new Blinky(juego,pacman);
		
		fantasma.mover(pacman.getCasilleroActual());  // come a pacman, se reubica
		
		assertEquals(fantasma.getCasilleroActual(), fantasma.getTablero().getCasilleroOrigenFantasma());
	}

	public void testFantasma() {
		Pacman pacman=new Pacman(juego);
		
		Fantasma fantasma=new Blinky(juego,pacman);
		assertNotNull(fantasma);
	}

	public void testCambiarVelocidad() {
		//falta implementarlo
	}

}
