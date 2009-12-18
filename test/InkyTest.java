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

	
	
	
	 
	public void testInky() {
		MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  fan1=juego.getInky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		
		assertNotNull(fan1);
	}

	public void testMover() {
		MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  fan1=juego.getInky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		
		Casillero casilleroFantasma=fan1.getCasilleroActual();
		fan1.vivir();
		
		int pasos=0;
		while(pasos < 5){
			casilleroFantasma=casilleroFantasma.getDerecha();
		pasos++;
		}
		assertEquals(fan1.getCasilleroActual(), casilleroFantasma);
	}
	
	public void testCeldaFantasmaComePacman(){
		//pacman en 12-9
		//fantasmas en 9-9
		  juego= new Juego();
		MapaCaminoHorizontalSinPoder mapa= new MapaCaminoHorizontalSinPoder();
		
		juego.cargarMapa(mapa, 0);
		fan1=juego.getInky();
		pacman=juego.getPacman();
		
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();

		fan1.vivir(); 
		fan1.vivir(); 

		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		assertTrue(pacman.getCasilleroActual()==juego.getMapa().getOrigenPacman());
		 
		
		juego=null;
		
	}


	public void testPacmanComeFantasma(){  //suponiendo que pacman se mueve hacia la izquierda al principio del juego
		//pacman con velocidad 5
		MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  fan1=juego.getInky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();

		Casillero otracelda=pacman.getCasilleroActual();
		 //pacman come punto de poder
		fan1.vivir(); // pacman se encuentra con fan1
		assertTrue(pacman.getVidas()==3); //pacman no pierde vidas
		assertTrue(pacman.getCasilleroActual()==otracelda); // pacman sigue en su posicion
		juego=null;

	}

}