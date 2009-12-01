
import junit.framework.TestCase;


public class FrutaTest extends TestCase {
		
	
	Mapa mapas;
	Juego juego;
	Casillero celda;
	Casillero otracelda;
	int puntaje;
	Fruta fruta;
	Posicion posicion;
	Posicion otraPosicion;
	MatrizPosiciones matriz;
	
	public void setUp(){
		mapas=null;
		juego= new Juego(mapas);
		posicion=new Posicion(1, 1, matriz);
		otraPosicion=new Posicion(2, 1, matriz);
		celda =juego.getTablero().getCasillero(posicion);
		otracelda =juego.getTablero().getCasillero(otraPosicion);
		puntaje=100;
		fruta=new Fruta(puntaje);
		
	}
	
		public void testFrutaCreada(){
			setUp();
			assertNotNull(fruta);

			}


		public void testComido(){
			setUp();
			otracelda.setItem(fruta);
			
			Pacman pacman=new Pacman(juego, celda);
			
			pacman.mover(celda.getDerecha());
			
			
			assertTrue(juego.getPuntaje()>0);
			assertTrue(otracelda.getItem()==null);
	}

		public void testGetPuntaje(){
			setUp();
			otracelda.setItem(fruta);
			
			Pacman pacman=new Pacman(juego, celda);
			pacman.mover(celda.getDerecha());
			
			assertEquals(100, fruta.getPuntaje());
	}

	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){

			setUp();
			Posicion posicionPacman=new Posicion(3, 3, matriz);
			Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);
			
			Pacman pacman=new Pacman(juego,celdaPacman);
			
			
			Blinky fan1 = new Blinky(juego,celda,pacman);
			celda.setItem(fruta);
			otracelda.setItem(fruta);
			
			fan1.mover(celda.getDerecha());
		
			assertFalse(otracelda.getItem()==null);
			assertEquals(0, juego.getPuntaje());

					
			

	}

	

}
