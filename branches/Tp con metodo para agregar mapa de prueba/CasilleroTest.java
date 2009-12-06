package algo3.grupo7.algoman.modelo;


import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.MatrizPosiciones;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Posicion;
import algo3.grupo7.algoman.modelo.Punto;
import junit.framework.TestCase;



public class CasilleroTest extends TestCase {
	
	Juego juego;
	

	
	public void setUp(){
		
		juego= new Juego();
		MapaCasilleroTest mapa= new MapaCasilleroTest();
		juego.cargarMapa(mapa, 0);
		
		
	}
	
	
	public void testCeldaConDosFantasmasComenPacman(){	
		
		Blinky fan1=juego.getBlinky();
		Blinky fan2=new Blinky(juego, juego.getPacman());
		Pacman pacman=juego.getPacman();
		Casillero casilleroOrigenFantasma=fan1.getJuego().getMapa().getOrigenFantasmas();
		
		assertTrue((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		// ambos fantasmas estan en el mismo casillero
		Casillero abajo=fan1.getCasilleroActual().getDerecha();
	
		fan1.vivir(); 
		assertFalse((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		
		
		// ambos fantasmas ya NO estan en el mismo casillero
		fan2.vivir();
		assertTrue(casilleroOrigenFantasma.getFantasmas().isEmpty());
		assertTrue(casilleroOrigenFantasma.getPacman()==null); // la celda queda vacia, sin pacman y sin fantasmas
		assertTrue(pacman.getCasilleroActual().getPacman()==pacman);
		assertTrue(fan1.getCasilleroActual().getFantasmas().get(0)==fan1);
		assertTrue(fan2.getCasilleroActual().getFantasmas().get(1)==fan2);					
		fan1.vivir(); 
		fan1.vivir(); //fantasma esta en el mismo casillero que pacman
	
		
		assertTrue(pacman.getCasilleroActual()==juego.getMapa().getOrigenPacman());
		assertTrue(fan1.getCasilleroActual()==juego.getMapa().getOrigenFantasmas()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		
		
	
		juego=null;
		
	
	}
	
	public void testCeldaFantasmaComePacman(){
		
		Blinky fan1=juego.getBlinky();
		
		Pacman pacman=juego.getPacman();
		
		
		fan1.vivir();  //fantasma se acerca a pacman, que esta quieto
		fan1.vivir(); 
		fan1.vivir(); //fantasma esta en el mismo casillero que pacman
	
		
		assertTrue(pacman.getCasilleroActual()==juego.getMapa().getOrigenPacman());
		assertTrue(fan1.getCasilleroActual()==juego.getMapa().getOrigenFantasmas()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		juego=null;
		
	}
	

	public void testPacmanComeFantasma(){  //suponiendo que pacman se mueve hacia arriba ni bien empieza el juego
		
		
		
		Pacman pacman = juego.getPacman(); //9-12
		Blinky fan1 = juego.getBlinky(); //9-9
	
		Casillero otracelda=pacman.getCasilleroActual();
		pacman.vivir(); //pacman come punto de poder
		pacman.vivir(); // pacman se encuentra con fan1
		
		
		assertTrue(pacman.getVidas()==3); //pacman no pierde vidas
		assertFalse(pacman.getCasilleroActual()==otracelda); // pacman NO sigue en su posicion
		juego=null;

	}
	


	public void testAgregarFantasma() {
		
		Pacman pacman=juego.getPacman();
		Blinky fan1 = juego.getBlinky();
		
		assertTrue(fan1.getCasilleroActual().getFantasmas().get(0)== fan1);
		assertFalse(fan1.getCasilleroActual().getPacman()== fan1);
		juego=null;
	}

	public void testAgregarPacman() {
		
	
		Pacman pacman = juego.getPacman();
		Casillero celda = pacman.getCasilleroActual();
		
		assertTrue(celda.getPacman()== pacman);
		juego=null;
	}

	public void testSetItem() {
		Pacman pacman = juego.getPacman();
		int puntaje=100;
		Punto pastilla = new Punto(puntaje);		
		pacman.getCasilleroActual().getDerecha().setItem(pastilla);
		assertTrue(pacman.getCasilleroActual().getDerecha().getItem()==pastilla);
		juego=null;
	}

	public void testRemoverItem() {
		
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		
		Casillero celda =juego.getMapa().getCasillero(posicion);
		
		int puntaje=100;
		Punto pastilla = new Punto(puntaje);		

		celda.setItem(pastilla);
		celda.removerItem();
		assertTrue(celda.getItem()==null);
		juego=null;
	}


	public void testRemoverFantasma() {
	
		Pacman pacman=juego.getPacman();
		
	
		Blinky fan1 = juego.getBlinky();
		Casillero celda=fan1.getCasilleroActual();
		celda.removerFantasma(fan1);
		
		assertTrue(celda.getFantasmas().isEmpty());
		juego=null;

	}


	public void testRemoverPacman() {
	
		Pacman pacman = juego.getPacman();
		
		Casillero celda=pacman.getCasilleroActual();
		celda.removerPacman(pacman);
		assertTrue(celda.getPacman()==null);
		juego=null;
		
	}


}
