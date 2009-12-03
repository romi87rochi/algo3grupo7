import junit.framework.TestCase;

public class estrategiaTest extends TestCase {

	Juego juego;
	Pacman pacman;
	Fantasma fan1;

	
	 public void setUp(){
		  MapaNivel1 mapa=new MapaNivel1();
		  juego= new Juego(mapa);
		  pacman=new Pacman(juego);
		  fan1=new Blinky(juego,pacman); }
	

	  public void testFantasmaPersigue(){
		  MapaNivel1 mapa=new MapaNivel1();
			juego= new Juego(mapa);
		  pacman=new Pacman(juego);
		  fan1=new Blinky(juego,pacman);
		  
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
	  assertEquals(juego.getTablero().getCasilleroOrigenFantasma(),fan1.getCasilleroActual()); }
	 

	public void testFantasmaEscapa() {
		  MapaNivel1 mapa=new MapaNivel1();
			juego= new Juego(mapa);
		  pacman=new Pacman(juego);
		  fan1=new Blinky(juego,pacman);
		
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
