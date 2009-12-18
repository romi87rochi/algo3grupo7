package algo3.grupo7.algoman.Test;


import algo3.grupo7.algoman.modelo.Blinky;
import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Inky;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import algo3.grupo7.algoman.modelo.Pinky;
import algo3.grupo7.algoman.modelo.Punto;
import junit.framework.TestCase;



public class CasilleroTest extends TestCase {
	
	private Juego juego;
	private Blinky fan1;
	private Clyde fan2;
	private Pacman pacman;
	

	
	public void setUp(){
		
		juego= new Juego();
		MapaCaminoHorizontalSinPoder mapa= new MapaCaminoHorizontalSinPoder();
		juego.cargarMapa(mapa, 0);
		fan1=juego.getBlinky();
		fan2=juego.getClyde();
		pacman=juego.getPacman();
		
		  
		  fan1.vivir();
		  fan2.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
	
	}
	
	
	public void testCeldaConDosFantasmas(){	
		
		
		Casillero casilleroOrigenFantasma=juego.getMapa().getOrigenFantasmas();
		
		assertTrue((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		// ambos fantasmas estan en el mismo casillero
		
	
		fan2.vivir(); 
		// ambos fantasmas ya NO estan en el mismo casillero
		assertFalse((fan1.getCasilleroActual()).equals(fan2.getCasilleroActual())) ;
		
		fan1.vivir();
		assertTrue(casilleroOrigenFantasma.getFantasmas().isEmpty()); 
		assertTrue(pacman.getCasilleroActual().getPacman()==pacman);
		assertTrue(fan2.getCasilleroActual().getFantasmas().get(0)==fan2);					
		
		fan1.vivir(); 
		fan2.vivir();
		fan2.vivir(); //los dos fantasmas estan en el mismo casillero
	
		
		assertTrue(fan1.getCasilleroActual()==fan2.getCasilleroActual());
		
		
		
	
		juego=null;
		
	
	}
	
	public void testCeldaFantasmaComePacman(){
		//pacman en 12-9
		//fantasmas en 9-9
		
		fan2.vivir();
		fan2.vivir(); //fantasma esta en el mismo casillero que pacman
	
		
		assertTrue(pacman.getCasilleroActual()==juego.getMapa().getOrigenPacman());
		assertTrue(fan1.getCasilleroActual()==juego.getMapa().getOrigenFantasmas()); // el fantasma vuelve a su posicion original
		
		assertTrue(pacman.getVidas()==2); // baja vidas de pacman
		juego=null;
		
	}
	

	public void testPacmanComeFantasma(){  //suponiendo que pacman se mueve hacia la izquierda al principio del juego
		//pacman con velocidad 5
		MapaCaminoHorizontal mapa= new MapaCaminoHorizontal();
		juego.cargarMapa(mapa, 0);
		fan1=juego.getBlinky();
		fan2=juego.getClyde();
		pacman=juego.getPacman();
		
		  
		  fan1.vivir();
		  fan2.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
	
		Casillero otracelda=pacman.getCasilleroActual();
		pacman.vivir(); //pacman come punto de poder
		fan1.vivir(); // pacman se encuentra con fan1
		assertTrue(pacman.getVidas()==3); //pacman no pierde vidas
		assertFalse(pacman.getCasilleroActual()==otracelda); // pacman NO sigue en su posicion
		juego=null;

	}
	


	public void testAgregarFantasma() {
     
		
		assertTrue(fan1.getCasilleroActual().getFantasmas().get(0)== fan1);
		fan1.vivir();
		assertTrue(fan1.getCasilleroActual().getFantasmas().get(0)== fan1); //cuando se mueve se agrega al nuevo casillero
		
		juego=null;
	}

	public void testAgregarPacman() {
    
		Casillero celda = pacman.getCasilleroActual();
		assertTrue(celda.getPacman()== pacman);
		assertTrue(celda.hayPacman());
		pacman.vivir();
		assertTrue(pacman.getCasilleroActual().getPacman()== pacman); //cuando se mueve se agrega al nuevo casillero
		juego=null;
	}

	public void testSetItem() {

		int puntaje=100;
		Casillero casilleroPastilla=fan1.getCasilleroActual();
		Punto pastilla = new Punto(puntaje,casilleroPastilla);
		casilleroPastilla.setItem(pastilla);
		
		assertTrue(fan1.getCasilleroActual().getItem()==pastilla);
		assertTrue(casilleroPastilla.hayItem());
		juego=null;
	}

	public void testRemoverItem() {
		
		
		int puntaje=100;
		Casillero casilleroPastilla=fan1.getCasilleroActual();
		Punto pastilla = new Punto(puntaje,casilleroPastilla);
		casilleroPastilla.setItem(pastilla);
		casilleroPastilla.removerItem();
		assertTrue(casilleroPastilla.getItem()==null);
		assertFalse(casilleroPastilla.hayItem());
		juego=null;
	}


	public void testRemoverFantasma() {
		Blinky fan1 = juego.getBlinky();
		Clyde fan2=juego.getClyde();
		Inky fan3=juego.getInky();
		Pinky fan4=juego.getPinky();
		Casillero casilleroFantasma=fan1.getCasilleroActual();
		casilleroFantasma.removerFantasma(fan1);
		casilleroFantasma.removerFantasma(fan2);
		casilleroFantasma.removerFantasma(fan3);
		casilleroFantasma.removerFantasma(fan4);
		assertTrue(casilleroFantasma.getFantasmas().isEmpty());//el casillero queda vacio
		juego=null;
	}


	public void testRemoverPacman() {
		
		Casillero celda=pacman.getCasilleroActual();
		celda.removerPacman(pacman);
		assertTrue(celda.getPacman()==null);
		assertFalse(celda.hayPacman());
		juego=null;
		
	}


}
