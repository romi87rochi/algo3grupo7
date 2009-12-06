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
		MatrizPosiciones matriz=juego.getPacman().getCasilleroActual().getPosicion().getMatriz();
		Posicion posicionFantasmas=new Posicion(10,24,matriz);
		Casillero origenFantasmas=juego.getMapa().getCasillero(posicionFantasmas);
		juego.getMapa().setOrigenFantasmas(origenFantasmas, juego);
		Posicion posicionPacman=new Posicion(10,26,matriz); //hacia la izquierda tiene un punto de poder
		Casillero origenPacman=juego.getMapa().getCasillero(posicionPacman);
		juego.getMapa().setOrigenPacman(origenPacman, juego);
		
		
	}
	
	
	public void testCeldaConDosFantasmas(){	
		
		
		Pacman pacman=juego.getPacman();//en el 9-12
		 
		Blinky fan1 = juego.getBlinky();
		Blinky fan2 = new Blinky(juego, pacman);// en el 9-9
		Casillero casilleroOrigenFantasma=juego.getMapa().getOrigenFantasmas();
		
		assertTrue((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		// ambos fantasmas estan en el mismo casillero
		fan1.vivir(); 
		assertFalse((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		// ambos fantasmas ya NO estan en el mismo casillero
		fan2.vivir();
		assertTrue(casilleroOrigenFantasma.getFantasmas().isEmpty());
		assertTrue(casilleroOrigenFantasma.getPacman()==null); // la celda queda vacia, sin pacman y sin fantasmas
		assertTrue(pacman.getCasilleroActual().getPacman()==pacman);
		assertTrue(fan1.getCasilleroActual().getFantasmas().get(0)==fan1);
		assertTrue(fan2.getCasilleroActual().getFantasmas().get(1)==fan2);					

		juego=null;
	
		
		
	
	}
	
	public void testCeldaFantasmaComePacman(){

		
		
		Pacman pacman = juego.getPacman();
		
		Blinky fan1 = juego.getBlinky(); 
		
		
		
			fan1.vivir();  //fantasma se acerca a pacman, que esta quieto
		
			fan1.vivir(); //fantasma esta en el mismo casillero que pacman
	
		
		assertTrue(pacman.getCasilleroActual()==juego.getMapa().getOrigenPacman());
		assertTrue(fan1.getCasilleroActual()==juego.getMapa().getOrigenFantasmas()); // todos los personajes vuelven a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		juego=null;
	}
	

	public void testPacmanComeFantasma(){  //suponiendo que pacman se mueve hacia arriba ni bien empieza el juego
	
		
		
		Pacman pacman =juego.getPacman(); //10-26
		Blinky fan1 = juego.getBlinky(); //10-24
	
		Casillero otracelda=pacman.getCasilleroActual();
		pacman.vivir(); //pacman come punto de poder
		fan1.vivir(); // pacman se encuentra con fan1
		
		
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
		
		
		
		Casillero celda =juego.getBlinky().getCasilleroActual();
		
		int puntaje=100;
		Punto pastilla = new Punto(puntaje);		

		celda.setItem(pastilla);
		celda.removerItem();
		assertTrue(celda.getItem()==null);
	}


	public void testRemoverFantasma() {
	
	
		
	
		Blinky fan1 = juego.getBlinky();
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
