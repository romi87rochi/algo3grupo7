package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;

public class ItemComibleTest extends TestCase {
	
	Juego juego;
	Pacman pacman;
	Blinky blinky;
	

	
	 public void setUp(){
		 MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  blinky=juego.getBlinky();
		  
		  
		  blinky.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		  }
	

	public void testItemComible() {
		
		pacman.vivir(); // blinky pasa sobre un item
		assertNull(pacman.getCasilleroActual().getItem());
	}

	public void testGetPuntaje() {
		int puntajePoder=100;
		blinky.vivir();
		assertTrue(blinky.getCasilleroActual().getDerecha().getItem().getPuntaje()==puntajePoder);
	}


}
