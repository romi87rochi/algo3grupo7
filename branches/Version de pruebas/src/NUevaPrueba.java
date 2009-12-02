import junit.framework.TestCase;


public class NUevaPrueba extends TestCase {
     private Mapa mapa;
     private Juego juego;
     private Pacman pacman;
     private Blinky fan1;
	
	public void setUp(){
		this.mapa=new Mapa();
		this.juego=new Juego(mapa);
		this.pacman=new Pacman(juego);
		this.fan1=new Blinky(juego,pacman);
	}
	
	public void testMover(){
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		fan1.mover(fan1.getEstrategia().proximoCasillero());
	}
}
