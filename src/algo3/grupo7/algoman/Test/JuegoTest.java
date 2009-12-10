package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;


public class JuegoTest extends TestCase {

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
	
		assertTrue(pacman.getItemsComidos()==2); //come pastilla de poder y fruta
}



	public void testIsFinJuego() {
			
		Blinky blinky=juego.getBlinky();
		int pasos=0;
		while(pasos<4){
			blinky.vivir();
			blinky.vivir();
			blinky.vivir();
			blinky.vivir();
			blinky.vivir();
			pacman.vivir();//para que vuelva a vivir, sino queda como muerto y fantasma no lo come
			pasos++;
		}//llega hasta donde esta pacman 3 veces y lo come las 3 veces
		
		assertTrue(juego.esFinNivel());
	}



	public void testFinalizarJuego() {
		setUp();
		juego.finalizarJuego();
		assertTrue(juego.esFinJuego());
	}



}
