
import junit.framework.TestCase;


public class CasilleroTest extends TestCase {

	
	
	public void testCeldaConDosFantasmas(){
		
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Posicion posicionPacman=new Posicion(3,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
		Casillero celdaPacman=juego.getTablero().getCasillero(posicionPacman);
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
		
		
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(otraPosicion);
		Pacman pacman = new Pacman(juego, otraCelda);
		
		Blinky fan1 = new Blinky(juego,celda,pacman);
		
	
		
		celda.agregarFantasma(fan1);
		otraCelda.agregarPacman(pacman);
		
		fan1.vivir(); // tendria que moverse a la otraCelda
		
	
		
		assertTrue(otraCelda.getPacman()==null);
		assertTrue(pacman.getCasilleroActual()==pacman.getCasilleroOriginal());
		assertTrue(fan1.getCasilleroActual()==fan1.getCasilleroOriginal()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		
	}
	
	
	public void testPacmanComeFantasma(){
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
		
		
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
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion posicionPacman=new Posicion(2,2,matriz);
		
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero otraCelda =juego.getTablero().getCasillero(posicionPacman);
		Pacman pacman=new Pacman(juego,otraCelda);
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
		Mapa mapas=null;
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
		Mapa mapas=null;
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
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion posicionPacman=new Posicion(2,2,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);
		
		Pacman pacman=new Pacman(juego,celdaPacman);
		
	
		Blinky fan1 = new Blinky(juego,celda, pacman);
		celda.agregarFantasma(fan1);
		celda.removerFantasma(fan1);
		
		assertTrue(celda.getFantasmas().isEmpty());

	}


	public void testRemoverPacman() {
		Mapa mapas=null;
		Juego juego= new Juego(mapas);
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);		
		
		Pacman pacman = new Pacman(juego, celda);
		
		celda.agregarPacman(pacman);
		celda.removerPacman(pacman);
		assertTrue(celda.getPacman()==null);
		
	}


}
