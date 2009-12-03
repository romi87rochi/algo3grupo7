
import junit.framework.TestCase;


public class FrutaTest extends TestCase {
		
	
	Mapa mapas;
	Juego juego;
	int puntaje;
	Fruta fruta;
	Pacman pacman;
	
	Fantasma fantasma;
	
	
	public void setUp(){
		Tablero tablero=new Tablero();
		juego= new Juego(tablero);
		puntaje=100;
		fruta=new Fruta(puntaje);
		pacman=new Pacman(juego);
		
		fantasma=new Blinky(juego,pacman);
		
	}
	
		public void testFrutaCreada(){
			
			assertNotNull(fruta);

			}


		public void testComido(){
			Casillero celda=pacman.getCasilleroActual().getDerecha();
			celda.setItem(fruta);
			
			pacman.mover(celda);
			
			
			assertTrue(juego.getPuntaje()>0);
			assertTrue(pacman.getCasilleroActual().getItem()==null);
	}

		public void testGetPuntaje(){
			Casillero celda=pacman.getCasilleroActual().getDerecha();
			celda.setItem(fruta);
			
			pacman.mover(celda);
			assertEquals(100, fruta.getPuntaje());
	}

	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
			
			Pacman pacman=new Pacman(juego);
			
			
			Blinky fan1 = new Blinky(juego,pacman);
			Casillero celda=fan1.getCasilleroActual().getDerecha();
			celda.setItem(fruta);
			
			fan1.mover(celda);
		
			assertFalse(celda.getItem()==null);
			assertEquals(0, juego.getPuntaje());

					
			

	}

	

}
