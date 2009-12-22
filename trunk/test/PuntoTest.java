package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Punto;
import junit.framework.TestCase;


public class PuntoTest extends TestCase {
		
	
	Juego juego;
	Pacman pacman;
	
	
	public void setUp(){
		
		juego = new Juego();
		MapaCaminoHorizontalSinPoder mapa= new MapaCaminoHorizontalSinPoder();
		juego.cargarMapa(mapa);
		pacman=juego.getPacman();
		 //  while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		   //    pacman.vivir();

	}
	


		public void testComido(){
			
			int puntajePunto=100;
			 while (!pacman.estaVivo()) //baja el tiempo de resurreccion
			       pacman.vivir();
			pacman.vivir();
			Casillero casilleroPunto=pacman.getCasilleroActual().getIzquierda();
			Punto punto=new Punto(puntajePunto,casilleroPunto);
			casilleroPunto.setItem(punto);
			pacman.vivir();
		
			assertTrue(juego.getPuntaje()>0);
			assertTrue(pacman.getItemsComidos()==1);
	}



	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
		//VER!	
			int puntajePunto=100;
			Clyde clyde=juego.getClyde();
			clyde.vivir();//hace q se reubique el fantasma y este listo listo para salir
			Casillero casilleroPunto=clyde.getCasilleroActual().getDerecha();
			Punto punto=new Punto(puntajePunto,casilleroPunto);
			casilleroPunto.setItem(punto);
			clyde.vivir(); // se mueve y pasa por encima de la pastilla

			
		
			assertFalse(casilleroPunto.getItem()==null); //el punto sigue estando, el fantasma no la come
			assertEquals(0, juego.getPuntaje());

					
			

	}

	

}

