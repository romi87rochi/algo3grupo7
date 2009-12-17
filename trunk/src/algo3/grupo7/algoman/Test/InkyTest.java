package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Fantasma;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;

public class InkyTest extends TestCase {
	Juego juego;
	Pacman pacman;
	Fantasma fan1;

	
	 public void setUp(){
		 
		 MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  fan1=juego.getInky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		
 }
	
	 
	public void testInky() {
		assertNotNull(fan1);
	}

	public void testMover() {
		Casillero casilleroFantasma=fan1.getCasilleroActual();
		fan1.vivir();
		
		int pasos=0;
		while(pasos < 5){
			casilleroFantasma=casilleroFantasma.getDerecha();
		pasos++;
		}
		assertEquals(fan1.getCasilleroActual(), casilleroFantasma);
	}

}