package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class PuntoTest extends TestCase {
		
	
	Juego juego;
	Pacman pacman;
	Clyde clyde;
	
	public void setUp(){
		
		juego = new Juego();
		MapaCaminoHorizontalSinPoder mapa= new MapaCaminoHorizontalSinPoder();
		juego.cargarMapa(mapa, 0);
		pacman=juego.getPacman();
		clyde=juego.getClyde();


	}
	


		public void testComido(){
			
			
			pacman.vivir();
			pacman.vivir();
		
			assertTrue(juego.getPuntaje()>0);
			assertTrue(pacman.getItemsComidos()==1);
	}



	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
		//VER!	
			clyde.vivir();
			clyde.vivir(); 
			
			
			Casillero casilleroFruta=clyde.getCasilleroActual();
		
			assertFalse(casilleroFruta.getItem()==null); //la fruta sigue estando, el fantasma no la come
			assertEquals(0, juego.getPuntaje());

					
			

	}

	

}

