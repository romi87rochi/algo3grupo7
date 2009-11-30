

import junit.framework.TestCase;


public class CasilleroTest extends TestCase {
	
	Mapa mapas;
	Juego juego;
	MatrizPosiciones matriz;
	Posicion posicion;
	Posicion otraPosicion;
	Posicion posicionPacman;
	Casillero celda;
	Casillero otracelda;
	Casillero celdaPacman;
	

	
	public void setUp(){
		mapas=null;
		juego= new Juego(mapas);
		matriz=new MatrizPosiciones(4,4);
		posicion=new Posicion(1,1,matriz);
		otraPosicion=new Posicion(2,1,matriz);
		posicionPacman=new Posicion(3,1,matriz);
		celda =juego.getTablero().getCasillero(posicion);
		otracelda =juego.getTablero().getCasillero(otraPosicion);
		celdaPacman=juego.getTablero().getCasillero(posicionPacman);
		
	}

	
	
	public void testCeldaConDosFantasmas(){
		setUp();	
		
		Pacman pacman=new Pacman(juego, celdaPacman);
		 
		Blinky fan1 = new Blinky(juego,celda, pacman);
		Blinky fan2 = new Blinky(juego, otracelda,pacman);
	
		
		celda.agregarFantasma(fan1);	
		
		otracelda.agregarFantasma(fan2);
		
		fan1.vivir(); // tendria que moverse a la otraCelda
		assertTrue(celda.getFantasmas().isEmpty());
		assertTrue(celda.getPacman()==null); // la celda queda vacia, sin pacman y sin fantasmas
							
		assertTrue((fan1.getCasilleroActual().getPosicion()).equals(fan2.getCasilleroActual().getPosicion())) ;
	// ambos fantasmas estan en el mismo casillero
		
		
	
		
		
	
	}
	
	public void testCeldaConPacman(){
		setUp();
		Pacman pacman = new Pacman(juego, otracelda);
		
		Blinky fan1 = new Blinky(juego,celda,pacman);
		
	
		
		celda.agregarFantasma(fan1);
		otracelda.agregarPacman(pacman);
		
		
			fan1.vivir(); // tendria que moverse a la otraCelda
		
	
		
		assertTrue(otracelda.getPacman()==null);
		assertTrue(pacman.getCasilleroActual()==pacman.getCasilleroOriginal());
		assertTrue(fan1.getCasilleroActual()==fan1.getCasilleroOriginal()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		
	}
	
	
	public void testPacmanComeFantasma(){
		
		
		
		Pacman pacman = new Pacman(juego, otracelda);
		Blinky fan1 = new Blinky(juego,celda, pacman);
		
		

		celda.agregarFantasma(fan1);
		otracelda.agregarPacman(pacman);
		
		pacman.setPuedeSerComido(false);
		
		fan1.vivir();   //VER.... TENDRIA QUE HUIR!!!!
		
		assertTrue(pacman.getVidas()==3); //pacman no pierde vidas
		assertTrue(pacman.getCasilleroActual()==otracelda); // pacman sigue en su posicion

	}
	


	public void testAgregarFantasma() {
		
		Pacman pacman=new Pacman(juego,otracelda);
		Blinky fan1 = new Blinky(juego,celda, pacman);
		celda.agregarFantasma(fan1);
		
		assertTrue(celda.getFantasmas().get(0)== fan1);
	}

	public void testAgregarPacman() {
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
	
		Pacman pacman = new Pacman(juego,celda);
		celda.agregarPacman(pacman);
		
		assertTrue(celda.getPacman()== pacman);
	}

	public void testSetItem() {
		
		int puntaje=100;
		Punto pastilla = new Punto(puntaje);		

		celda.setItem(pastilla);
		assertTrue(celda.getItem()==pastilla);
	}

	public void testRemoverItem() {
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
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
	
		Pacman pacman=new Pacman(juego,celdaPacman);
		
	
		Blinky fan1 = new Blinky(juego,celda, pacman);
		celda.agregarFantasma(fan1);
		celda.removerFantasma(fan1);
		
		assertTrue(celda.getFantasmas().isEmpty());

	}


	public void testRemoverPacman() {
	
		Pacman pacman = new Pacman(juego, celda);
		
		celda.agregarPacman(pacman);
		celda.removerPacman(pacman);
		assertTrue(celda.getPacman()==null);
		
	}


}
