
import junit.framework.TestCase;


public class PersonajeTest extends TestCase {
	Juego juego;
	Pacman pacman;
	MatrizPosiciones matriz;
	Fantasma fantasma;
	Posicion posicion;
	Posicion otraPosicion;
	Casillero celda;
	Casillero otraCelda;
	
	public void setUp(){
		juego = new Juego( null);
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(1,1,matriz);
		otraPosicion=new Posicion(3,3,matriz);
		celda=juego.getTablero().getCasillero(posicion);
		otraCelda=juego.getTablero().getCasillero(otraPosicion);
		pacman=new Pacman(juego,celda);
		fantasma=new Blinky(juego, otraCelda,pacman);
		
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
