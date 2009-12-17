package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;

public class BlinkyTest extends TestCase {
	Juego juego;
	Pacman pacman;
	Blinky fan1;

	
	 public void setUp(){
		  MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();

	 }
	
	 
	public void testBlinky() {
		assertNotNull(fan1);
	}

	public void testVivir() {
		
		Casillero casilleroFantasma=fan1.getCasilleroActual();
		fan1.vivir();
		int pasos=0;
		while(pasos < 2){
			casilleroFantasma=casilleroFantasma.getDerecha();
		pasos++;
		}
		assertEquals(fan1.getCasilleroActual(), casilleroFantasma);
	}

}