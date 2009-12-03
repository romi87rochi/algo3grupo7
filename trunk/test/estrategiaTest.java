import junit.framework.TestCase;

public class estrategiaTest extends TestCase {

	Tablero tablero;
	Juego juego;
	Pacman pacman;
	Fantasma fan1;

	
	  public void setUp(){
		  tablero=new Tablero(); 
		  juego=new Juego(tablero);
		  pacman=new Pacman(juego);
		  fan1=new Blinky(juego,pacman); }
	 
	
	  public void testFantasmaPersigue(){
	  
	  fan1.mover(fan1.getCasilleroActual().getIzquierda());
	  fan1.mover(fan1.getCasilleroActual().getAbajo());// pacman esta en uno para arriba y 
	   													//dos para la derecha
	  
	  Casillero CasilleroDeEstrategia=fan1.getCasilleroActual().getArriba();
	  fan1.vivir(); 
	  assertEquals(CasilleroDeEstrategia,fan1.getCasilleroActual());
	  CasilleroDeEstrategia=fan1.getCasilleroActual().getDerecha();
	  fan1.vivir(); assertEquals(CasilleroDeEstrategia,
	  fan1.getCasilleroActual());
	  
	  fan1.vivir();//come a pacman
	  assertEquals(tablero.getCasilleroOrigenFantasma(),fan1.getCasilleroActual()); }
	 

	public void testFantasmaEscapa() {

		pacman.setPuedeSerComido(false);
		
		Casillero CasilleroDeEstrategia = fan1.getCasilleroActual()
				.getIzquierda();
		fan1.mover(fan1.getCasilleroActual().getIzquierda());// pacman esta a
																// dos
																// casilleros a
																// la derecha,
																// fan1 solo
																// puede ir
																// hacia la
																// derecha o
																// hacia abajo
		CasilleroDeEstrategia = fan1.getCasilleroActual().getAbajo();
		fan1.vivir();
		assertEquals(CasilleroDeEstrategia, fan1.getCasilleroActual());

	}

}
