
import junit.framework.TestCase;


public class FantasmaTest extends TestCase {

	Mapa mapas;

	Juego juego;
	Posicion posicion;
	Posicion otraPosicion;
	Casillero celda;
	Casillero otraCelda;
	MatrizPosiciones matriz;
	
	public void setUp(){
		mapas=null;
		juego = new Juego( mapas);
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(1, 1, matriz);
		otraPosicion=new Posicion(2, 1, matriz);
		celda =juego.getTablero().getCasillero(posicion);
		otraCelda =juego.getTablero().getCasillero(otraPosicion);

	}

	public void testComer() {
		setUp();				
		Pacman pacman=new Pacman(juego,celda);
		Fantasma fantasma=new Blinky(juego, otraCelda,pacman);
		
		fantasma.mover(celda);
		
		assertNull(celda.getPacman());
		assertTrue(pacman.getVidas()==2);
	}

	public void testMover() {
		
		setUp();
		Posicion posicionPacman=new Posicion(3, 3, matriz);
		Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);
		
		Pacman pacman=new Pacman(juego,celdaPacman);
		Fantasma fantasma=new Blinky(juego,celda,pacman);
		
		fantasma.mover(otraCelda);
		
		assertEquals(fantasma.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
		Posicion posicionPacman=new Posicion(3, 3, matriz);
		Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);
		
		Pacman pacman=new Pacman(juego,celdaPacman);
	
		Fantasma fantasma=new Blinky(juego,celda, pacman);
		
		fantasma.mover(otraCelda);
		fantasma.reubicar();
		assertEquals(fantasma.getCasilleroActual(), celda);
	}

	public void testFantasma() {
		Posicion posicionPacman=new Posicion(3, 3, matriz);
		Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);
		
		Pacman pacman=new Pacman(juego,celdaPacman);
	
		Fantasma fantasma=new Blinky(juego,celda, pacman);
		assertNotNull(fantasma);
	}

	public void testCambiarVelocidad() {
		//falta implementarlo
	}

}
