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

	
	
	 
	public void testBlinky() {
		MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		assertNotNull(fan1);
	}

	public void testVivir() {
		MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		
		Casillero casilleroFantasma=fan1.getCasilleroActual();
		fan1.vivir();
		int pasos=0;
		while(pasos < 2){
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
	
	juego.cargarMapa(mapa);
	fan1=juego.getBlinky();
	pacman=juego.getPacman();
	
	  
	  fan1.vivir();
	   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
	       pacman.vivir();


	
	fan1.vivir();
	fan1.vivir(); //fantasma esta en el mismo casillero que pacman

	
	assertTrue(pacman.getCasilleroActual()==juego.getMapa().getOrigenPacman());
	assertTrue(fan1.getCasilleroActual()==juego.getMapa().getOrigenFantasmas()); // el fantasma vuelve a su posicion original
	
	assertTrue(pacman.getVidas()==6); // baja vidas de pacman
	juego=null;
	
}


public void testPacmanComeFantasma(){  //suponiendo que pacman se mueve hacia la izquierda al principio del juego
	//pacman con velocidad 5
	MapaCaminoHorizontal mapa=new MapaCaminoHorizontal();
	  juego= new Juego();
	  juego.cargarMapa(mapa);
	  pacman=juego.getPacman();
	  fan1=juego.getBlinky();
	  
	  
	  fan1.vivir();
	   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
	       pacman.vivir();

	Casillero otracelda=pacman.getCasilleroActual();
	 //pacman come punto de poder
	fan1.vivir(); // pacman se encuentra con fan1
	assertTrue(pacman.getVidas()==7); //pacman no pierde vidas
	assertTrue(pacman.getCasilleroActual()==otracelda); // pacman sigue en su posicion
	
	juego=null;

}



}
