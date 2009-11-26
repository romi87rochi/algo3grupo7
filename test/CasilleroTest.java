import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;


public class CasilleroTest extends TestCase {

	public void testCeldaConDosFantasmas(){
		
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
		
		 
		
		int velocidad=1;
		Blinky fan1 = new Blinky(juego,posicion, velocidad);
		Blinky fan2 = new Blinky(juego, otraPosicion, velocidad);
	
		
		celda.agregarFantasma(fan1);	
		
		otracelda.agregarFantasma(fan2);
		
		fan1.mover(posicion.getDerecha()); // tendria que moverse a la otraCelda
		
	
		assertTrue(celda.getFantasmas().isEmpty());
		assertTrue(celda.getPacman()==null); // la celda queda vacia, sin pacman y sin fantasmas
							
		assertTrue((fan1.getCasilleroActual().getPosicion()).equals(fan2.getCasilleroActual().getPosicion())) ;
	// ambos fantasmas estan en el mismo casillero
	}
	
	public void testCeldaConPacman(){
		
		
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
		
		
		int velocidad=1;
		Blinky fan1 = new Blinky(juego,posicion, velocidad);
		Pacman pacman = new Pacman(juego, otraPosicion, velocidad);
	
		
		celda.agregarFantasma(fan1);
		otracelda.agregarPacman(pacman);
		
		fan1.mover(posicion.getDerecha()); // tendria que moverse a la otraCelda
		
	
		Posicion posicionFantasma=new Posicion(2,1,matriz);
		assertTrue(otracelda.getPacman()==null);
		assertTrue(pacman.getCasilleroActual()==pacman.getCasilleroOriginal());
		assertTrue(fan1.getCasilleroActual()==fan1.getCasilleroOriginal()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getJuego().getVidasPackman()==2); // baja vidas de pacman
		
	}
	
	public void testPacmanComeFantasma(){
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
		
		
		int velocidad=1;
		Blinky fan1 = new Blinky(juego,posicion, velocidad);
		Pacman pacman = new Pacman(juego, otraPosicion, velocidad);
		

		celda.agregarFantasma(fan1);
		otracelda.agregarPacman(pacman);
		
		pacman.cambiarEstado();
		//fan1.mover(fan1.getCasilleroActual().getPosicion().getDerecha());  // me da null pointer exception
		fan1.mover(posicion.getDerecha());
		
		assertTrue(pacman.getJuego().getVidasPackman()==3); //pacman no pierde vidas
		assertTrue(pacman.getCasilleroActual()==otracelda);
		assertTrue(fan1.getCasilleroActual()==fan1.getCasilleroOriginal());

	}
	
	public void testGetPuedeSerVisitado() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
		
	}

	public void testCasillero() {
		fail("Not yet implemented");
	}

	public void testAgregarFantasma() {
		fail("Not yet implemented");
	}

	public void testAgregarPacman() {
		fail("Not yet implemented");
	}

	public void testSetItem() {
		fail("Not yet implemented");
	}

	public void testGetPosicion() {
		fail("Not yet implemented");
	}

	public void testRemoverItem() {
		fail("Not yet implemented");
	}

	public void testGetItem() {
		fail("Not yet implemented");
	}

	public void testRemoverFantasma() {
		fail("Not yet implemented");
	}

	public void testGetFantasmas() {
		fail("Not yet implemented");
	}

	public void testRemoverPacman() {
		fail("Not yet implemented");
	}

	public void testGetPacman() {
		fail("Not yet implemented");
	}

}
