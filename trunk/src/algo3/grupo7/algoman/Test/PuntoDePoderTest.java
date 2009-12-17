package algo3.grupo7.algoman.Test;


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
		
		MapaLargoConPuntoDePoder mapa=new MapaLargoConPuntoDePoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  clyde=juego.getClyde();
		  
		  
		  clyde.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();

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
			assertTrue(juego.getPuntaje()>=puntajeFruta );//come fruta y punto de poder
	}

	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
		
			clyde.vivir(); //clyde esta al lado de la fruta
			Casillero casilleroPoder=clyde.getCasilleroActual();
		
			assertFalse(casilleroPoder.getItem()==null); //la fruta sigue estando, el fantasma no la come

					
			

	}

	

}

