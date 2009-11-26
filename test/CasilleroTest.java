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
	


	public void testAgregarFantasma() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
	
		
		int velocidad=1;
		Blinky fan1 = new Blinky(juego,posicion, velocidad);
		celda.agregarFantasma(fan1);
		
		assertTrue(celda.getFantasmas().get(0)== fan1);
	}

	public void testAgregarPacman() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
	
		
		int velocidad=1;
		Pacman pacman = new Pacman(juego,posicion, velocidad);
		celda.agregarPacman(pacman);
		
		assertTrue(celda.getPacman()== pacman);
	}

	public void testSetItem() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
		
		int puntaje=100;
		Punto pastilla = new Punto(juego,puntaje);		

		celda.setItem(pastilla);
		assertTrue(celda.getItem()==pastilla);
	}

	public void testRemoverItem() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
		
		int puntaje=100;
		Punto pastilla = new Punto(juego,puntaje);		

		celda.setItem(pastilla);
		celda.removerItem();
		assertTrue(celda.getItem()==null);
	}


	public void testRemoverFantasma() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);		
		
		int velocidad=1;
		Blinky fan1 = new Blinky(juego,posicion, velocidad);
		celda.agregarFantasma(fan1);
		celda.removerFantasma(fan1);
		
		assertTrue(celda.getFantasmas().isEmpty());

	}


	public void testRemoverPacman() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);		
		
		int velocidad=1;
		Pacman pacman = new Pacman(juego, posicion, velocidad);
		
		celda.agregarPacman(pacman);
		celda.removerPacman(pacman);
		assertTrue(celda.getPacman()==null);
		
	}


}
