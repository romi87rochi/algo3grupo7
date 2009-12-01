package modelo;

import junit.framework.TestCase;


public class PacmanTest extends TestCase {
	
	Mapa mapas;
	Juego juego;
	Posicion posicion;
	Posicion otraPosicion;
	Pacman pacman;
	Casillero celda ;
	Casillero otraCelda;
	
	public void setUp(){
		mapas=null;
		juego = new Juego( mapas);
		posicion=new Posicion(1, 1, null);
		otraPosicion=new Posicion(2, 1, null);
		celda =juego.getTablero().getCasillero(posicion);
		otraCelda =juego.getTablero().getCasillero(otraPosicion);
		pacman=new Pacman(juego,celda);
		celda.agregarPacman(pacman);
	}

	public void testComer() {
		
		setUp();
		int puntaje=100;
		ItemComible punto=new Punto( puntaje);
		otraCelda.setItem(punto);
		pacman.mover(otraCelda);
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
		setUp();
		pacman.mover(otraCelda);
		
		assertEquals(pacman.getCasilleroActual(), otraCelda);
	}

	public void testReubicar() {
		setUp();
		pacman.mover(otraCelda);
		pacman.reubicar();
		assertEquals(pacman.getCasilleroActual(), celda);
	}

	public void testPacman() {
		setUp();
		assertNotNull(pacman);
	}

}
