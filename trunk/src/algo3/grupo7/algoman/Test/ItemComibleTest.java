package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Fantasma;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.ItemComible;
import junit.framework.TestCase;

public class ItemComibleTest extends TestCase {
	
	Juego juego;
	Pacman pacman;
	Blinky blinky;
	

	
	 public void setUp(){
		  MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 1);
		  pacman=juego.getPacman();
		  blinky=juego.getBlinky();
		  }
	

	public void testItemComible() {
		blinky.vivir(); // blinky esta parado sobre un item
		assertNotNull(blinky.getCasilleroActual().getItem());
	}

	public void testGetPuntaje() {
		int puntajePoder=60;
		blinky.vivir();
		assertNotNull(blinky.getCasilleroActual().getItem().getPuntaje()>0);
	}


}
