import junit.framework.TestCase;


public class estrategiaTest extends TestCase {
/*	
	Mapa mapa;
	Juego juego;
	Pacman pacman;
	Fantasma fan1;
	
	public void setUp(){
		mapa=new Mapa();
		juego=new Juego(mapa);
		pacman=new Pacman(juego);
		fan1=new Blinky(juego,pacman);
	}
	*/
	public void testFantasma(){
		
		Tablero tablero=new Tablero();
		Juego juego=new Juego(tablero);
		Pacman pacman=new Pacman(juego);
		Fantasma fan1=new Blinky(juego,pacman);
	
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		assertTrue(true);
	}

}
