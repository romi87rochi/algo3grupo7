package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.MatrizPosiciones;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class PacmanTest extends TestCase {
	
	Juego juego;
	Pacman pacman;
	Clyde clyde;
	
	public void setUp(){
		MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  clyde=juego.getClyde();
		  
		  
		  clyde.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		
	


	}
	
	public void testEstaVivo(){
		assertTrue(pacman.estaVivo());
	}
	

	public void testComer() {
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa);
		Casillero otraCelda=pacman.getCasilleroActual();
		pacman.vivir();
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
		MatrizPosiciones matriz=new MatrizPosiciones(30,30);
		Posicion posicionAMoverse= new Posicion(18,9,matriz);
		Casillero casilleroAMoverse=juego.getMapa().getCasillero(posicionAMoverse);
		
		assertFalse(pacman.getCasilleroActual() == casilleroAMoverse);
	}

	public void testReubicar() {
		
		pacman.vivir();
		pacman.vivir();//intenta comer fantasma
		

		assertEquals(pacman.getCasilleroActual(), juego.getMapa().getOrigenPacman());
		assertEquals(clyde.getCasilleroActual(), juego.getMapa().getOrigenFantasmas());
	}

	public void testPacman() {
		
		assertNotNull(pacman);
	}

}
