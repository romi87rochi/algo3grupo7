package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Fruta;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.MatrizPosiciones;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class JuegoTest extends TestCase {

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

	public void testConstructor(){
		assertNotNull(juego);
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
		while(pasos<9){
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
