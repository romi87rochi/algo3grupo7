package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.MatrizPosiciones;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class FrutaTest extends TestCase {
		
	
	Juego juego;
	Pacman pacman;
	Clyde clyde;
	Fruta fruta;
	
	public void setUp(){
		
		MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  clyde=juego.getClyde();
		  MatrizPosiciones matriz=new MatrizPosiciones(30,30);
		  Posicion posicionFruta=new Posicion(13,9,matriz);
		  Casillero casilleroFruta=juego.getMapa().getCasillero(posicionFruta);
		  
		  clyde.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		   
		   fruta=(Fruta)casilleroFruta.getItem();
		   while(!fruta.puedeSerComido()){
			  
		   fruta.vivir();
		   }
		

	}
	


		public void testComido(){
			
			
			pacman.vivir();
			Posicion posicionFruta=pacman.getCasilleroActual().getPosicion().getDerecha();
			Casillero casilleroFruta=juego.getMapa().getCasillero(posicionFruta);
			
			
			assertTrue(juego.getPuntaje()>0);
			assertTrue(casilleroFruta.getItem()==null);
	}

		public void testGetPuntaje(){
			
			int puntajeFruta=100;
			
			pacman.vivir();
			
			assertTrue(juego.getPuntaje()==puntajeFruta );//come fruta y punto de poder
	}

	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
			
			clyde.vivir(); //clyde esta al lado de la fruta
			Casillero casilleroFruta=clyde.getCasilleroActual().getDerecha();
		
			assertFalse(casilleroFruta.getItem()==null); //la fruta sigue estando, el fantasma no la come
			assertEquals(0, juego.getPuntaje());

					
			

	}

	

}
