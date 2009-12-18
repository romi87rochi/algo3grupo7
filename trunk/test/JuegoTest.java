package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;


public class JuegoTest extends TestCase {

	Juego juego;
	Pacman pacman;
	Clyde clyde;
	
	public void setUp(){
		MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 0);
		  pacman=juego.getPacman();
		  clyde=juego.getClyde();
		  
		  
		  clyde.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
	


	}

	public void testConstructor(){
		assertNotNull(juego);
}

	public void testPrimerNivel(){
		setUp();
		assertEquals(0, juego.getNivel());
}
	

	public void testTerminaJuegoFalso(){
		setUp();
		assertFalse(juego.esFinJuego());
		
}


	public void testComeItems(){
		
		pacman.vivir();
		assertTrue(pacman.getItemsComidos()==1); //come fruta
}



	public void testIsFinJuego() {
			
		int pasos=0;
		while(pasos<4){
			clyde.vivir();
			clyde.vivir();
			clyde.vivir();
			 while (!pacman.estaVivo()) //baja el tiempo de resurreccion
			       pacman.vivir();//para que vuelva a vivir, sino queda como muerto y fantasma no lo come
			pasos++;
		}//llega hasta donde esta pacman 3 veces y lo come las 3 veces
		
		assertTrue(juego.esFinJuego());
	}



	public void testFinalizarJuego() {
		setUp();
		juego.finalizarJuego();
		assertTrue(juego.esFinJuego());
	}



}
