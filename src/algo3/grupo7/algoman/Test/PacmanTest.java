package algo3.grupo7.algoman.Test;


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
		MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  clyde=juego.getClyde();
		  
		  
		  clyde.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		
	


	}
	
	

	public void testComer() {
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa, 0);
		Casillero otraCelda=pacman.getCasilleroActual();
		pacman.vivir();
		
		assertNull(otraCelda.getItem());
	}

	public void testMover() {
	
		pacman.vivir();
		
		assertFalse(pacman.getCasilleroActual() == juego.getMapa().getOrigenPacman());
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
