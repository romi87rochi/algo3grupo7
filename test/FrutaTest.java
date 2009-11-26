import junit.framework.TestCase;


public class FrutaTest extends TestCase {
		
		public void testFrutaCreada(){
			Map[] mapas=null;
			Juego unJuego=new Juego(mapas);
			int puntaje=100;
			Fruta fruta=new Fruta(unJuego, puntaje);
			assertNotNull(fruta);

			}


		public void testComido(){
			
			Map[] mapas=null;
			Juego juego= new Juego(mapas);
			MatrizPosiciones matriz=new MatrizPosiciones(4,4);
			Posicion posicion=new Posicion(1,1,matriz);
			Posicion otraPosicion=new Posicion(2,1,matriz);
			Casillero celda =juego.getTablero().getCasillero(posicion);
			Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
			int puntaje=100;
			Fruta fruta=new Fruta(juego, puntaje);
			otracelda.setItem(fruta);
			
			int velocidad=1;
			Pacman pacman=new Pacman(juego, posicion, velocidad);
			pacman.mover(posicion.getDerecha());
			
			
			assertTrue(juego.getPuntaje()>0);
			assertTrue(otracelda.getItem()==null);
	}

		public void testGetPuntaje(){
			Map[] mapas=null;
			Juego juego= new Juego(mapas);

			int puntaje=100;
			Fruta fruta=new Fruta(juego, puntaje);
			fruta.fueComido();
			assertEquals(100, fruta.getPuntaje());
	}

	// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


		public void testNoComidoPorFantasma(){
			
			Map[] mapas=null;
			Juego juego= new Juego(mapas);
			MatrizPosiciones matriz=new MatrizPosiciones(4,4);
			Posicion posicion=new Posicion(1,1,matriz);
			Posicion otraPosicion=new Posicion(2,1,matriz);
			Casillero celda =juego.getTablero().getCasillero(posicion);
			Casillero otracelda =juego.getTablero().getCasillero(otraPosicion);
			int puntaje=100;
			Fruta fruta=new Fruta(juego, puntaje);
			
			int velocidad=1;
			Blinky fan1 = new Blinky(juego,posicion, velocidad);
			celda.agregarFantasma(fan1);
			celda.setItem(fruta);
			otracelda.setItem(fruta);
			
			fan1.mover(posicion.getDerecha());
		
			assertFalse(otracelda.getItem()==null);
			assertEquals(0, juego.getPuntaje());

					
			

	}

	public void testFueComido() {
		Map[] mapas=null;
		Juego juego= new Juego(mapas);
		int puntaje=100;
		
		Fruta fruta=new Fruta(juego, puntaje);
		fruta.fueComido();
		assertEquals(juego.getPuntaje(),100);
	}


}
