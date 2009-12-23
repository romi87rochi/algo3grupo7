package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.MatrizPosiciones;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import junit.framework.TestCase;


public class FantasmaTest extends TestCase {


	Juego juego;
	Pacman pacman;
	Clyde clyde;
	
	public void setUp(){
		 MapaCaminoHorizontalSinPoder mapa=new MapaCaminoHorizontalSinPoder();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  clyde=juego.getClyde();
		  
		  
		  clyde.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		   
		
	}

	public void testComer() {	
	
		Casillero casilleroEnComun=pacman.getCasilleroActual();
		
		clyde.vivir();
		clyde.vivir(); //ambos estan en el mismo casillero, fantasma intenta comer pacman
		
		
		assertTrue(casilleroEnComun.getFantasmas().isEmpty()); //clyde se reubica
		assertTrue(pacman.getVidas()==6);//fantasma comio a pacman
	}

	public void testMover() {
		MatrizPosiciones matriz=new MatrizPosiciones(20,20);
		Posicion posicionDondeSeMovera=new Posicion(12,9,matriz);
		Casillero casilleroDondeSeMovera=juego.getMapa().getCasillero(posicionDondeSeMovera);
		
		
		clyde.vivir();//pacman esta a su derecha y tiene 3 de velocidad
		assertEquals(clyde.getCasilleroActual(), casilleroDondeSeMovera);
	}

	public void testReubicar() {
	
		clyde.vivir();
		clyde.vivir();
		clyde.vivir();
		clyde.vivir();
		clyde.vivir(); // come a pacman, se reubica
		
		assertEquals(clyde.getCasilleroActual(), juego.getMapa().getOrigenFantasmas());
	}

	public void testFantasma() {

		assertNotNull(clyde);
	}


}
