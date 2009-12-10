package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class PuntoDePoderTest extends TestCase {
		
	
	Juego juego;
	Pacman pacman;
	Clyde clyde;
	
	public void setUp(){
		
		juego = new Juego();
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa, 0);
		pacman=juego.getPacman();
		clyde=juego.getClyde();


	}
	


		public void testComido(){
			
			
			pacman.vivir();
			Posicion posicionFruta=pacman.getCasilleroActual().getPosicion();
			Casillero casilleroFruta=juego.getMapa().getCasillero(posicionFruta);
			
			
			assertTrue(juego.getPuntaje()>0);
			assertTrue(casilleroFruta.getItem()==null);
	}

		public void testGetPuntaje(){
			
			int puntajeFruta=100;
			
			pacman.vivir();
			assertTrue(juego.getPuntaje()>puntajeFruta );//come fruta y punto de poder
	}

	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
			Blinky blinky=juego.getBlinky();
			blinky.vivir(); //blinky esta en el misma casillero que la fruta
			Casillero casilleroPoder=blinky.getCasilleroActual();
		
			assertFalse(casilleroPoder.getItem()==null); //la fruta sigue estando, el fantasma no la come
			assertEquals(0, juego.getPuntaje());

					
			

	}

	

}

