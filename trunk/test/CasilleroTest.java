

import junit.framework.TestCase;


public class CasilleroTest extends TestCase {
	
	Tablero tablero;
	Juego juego;
	

	
	public void setUp(){
		tablero=new Tablero();
		juego= new Juego(tablero);
		
		
	}
	
	
	public void testCeldaConDosFantasmas(){	
		
		
		Pacman pacman=new Pacman(juego);//en el 9-11
		 
		Blinky fan1 = new Blinky(juego, pacman);
		Blinky fan2 = new Blinky(juego, pacman);// en el 9-10
		Casillero celda=fan1.getTablero().getCasilleroOrigenFantasma();
		
		assertTrue((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		// ambos fantasmas estan en el mismo casillero
		fan1.mover(fan1.getCasilleroActual().getIzquierda()); // tendria que moverse a la otraCelda
		assertFalse((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		// ambos fantasmas ya NO estan en el mismo casillero
		fan2.mover(fan2.getCasilleroActual().getIzquierda());
		assertTrue(celda.getFantasmas().isEmpty());
		assertTrue(celda.getPacman()==null); // la celda queda vacia, sin pacman y sin fantasmas
							
		
		
		
	
		
		
	
	}
	
	public void testCeldaConPacmanYFantasma(){
		
		Pacman pacman = new Pacman(juego);
		
		Blinky fan1 = new Blinky(juego,pacman);
		
		fan1.mover(fan1.getCasilleroActual().getDerecha());
	
		
		assertTrue(pacman.getCasilleroActual()==tablero.getCasilleroOrigenPacman());
		assertTrue(fan1.getCasilleroActual()==tablero.getCasilleroOrigenFantasma()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		
	}
	
	
	public void testPacmanComeFantasma(){
		
		
		
		Pacman pacman = new Pacman(juego);
		Blinky fan1 = new Blinky(juego, pacman);
	
		
		pacman.setPuedeSerComido(false);
		fan1.vivir();
		
		pacman.mover(pacman.getCasilleroActual().getArriba()); //pacman esta en el mismo casillero que fantasma
		Casillero otracelda=pacman.getCasilleroActual();
		
		assertTrue(pacman.getVidas()==3); //pacman no pierde vidas
		assertTrue(pacman.getCasilleroActual()==otracelda); // pacman sigue en su posicion

	}
	


	public void testAgregarFantasma() {
		
		Pacman pacman=new Pacman(juego);
		Blinky fan1 = new Blinky(juego, pacman);
		
		assertTrue(fan1.getCasilleroActual().getFantasmas().get(0)== fan1);
		assertFalse(fan1.getCasilleroActual().getPacman()== fan1);
	}

	public void testAgregarPacman() {
		
	
		Pacman pacman = new Pacman(juego);
		Casillero celda = pacman.getCasilleroActual();
		
		assertTrue(celda.getPacman()== pacman);
	}

	public void testSetItem() {
		Pacman pacman = new Pacman(juego);
		int puntaje=100;
		Punto pastilla = new Punto(puntaje);		
		pacman.getCasilleroActual().getDerecha().setItem(pastilla);
		assertTrue(pacman.getCasilleroActual().getDerecha().getItem()==pastilla);
	}

	public void testRemoverItem() {
		
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
		
		int puntaje=100;
		Punto pastilla = new Punto(puntaje);		

		celda.setItem(pastilla);
		celda.removerItem();
		assertTrue(celda.getItem()==null);
	}


	public void testRemoverFantasma() {
	
		Pacman pacman=new Pacman(juego);
		
	
		Blinky fan1 = new Blinky(juego,pacman);
		Casillero celda=fan1.getCasilleroActual();
		celda.removerFantasma(fan1);
		
		assertTrue(celda.getFantasmas().isEmpty());

	}


	public void testRemoverPacman() {
	
		Pacman pacman = new Pacman(juego);
		
		Casillero celda=pacman.getCasilleroActual();
		celda.removerPacman(pacman);
		assertTrue(celda.getPacman()==null);
		
	}


}
