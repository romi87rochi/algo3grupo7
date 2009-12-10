package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Fantasma;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;

public class ClydeTest extends TestCase {
	Juego juego;
	Pacman pacman;
	Fantasma fan1;

	
	 public void setUp(){
		  MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 1);
		  pacman=juego.getPacman();
		  fan1=juego.getClyde(); }
	
	 
	public void testClyde() {
		assertNotNull(fan1);
	}

	public void testMover() {
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