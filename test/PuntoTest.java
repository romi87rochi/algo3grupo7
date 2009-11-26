import junit.framework.TestCase;


public class PuntoTest extends TestCase {
	
	
	public void testPuntoCreado(){
		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);
		int puntaje=100;
		Punto punto=new Punto(unJuego, puntaje);
		assertNotNull(punto);

		}


	public void testComido(){
		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);
		int puntaje=100;
		Punto punto=new Punto(unJuego, puntaje);
		punto.fueComido();
		assertTrue(unJuego.getPuntaje()>0);		
		
}



	public void testGetPuntaje(){
		Map[] mapas=null;
		Juego juego= new Juego(mapas);

		int puntaje=100;
		Punto punto=new Punto(juego, puntaje);
		punto.fueComido();
		assertEquals(100, punto.getPuntaje());
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
		Punto punto=new Punto(juego, puntaje);
		
		int velocidad=1;
		Blinky fan1 = new Blinky(juego,posicion, velocidad);
		celda.agregarFantasma(fan1);
		celda.setItem(punto);
		otracelda.setItem(punto);
		
		fan1.mover(posicion.getDerecha());
	
		assertFalse(otracelda.getItem()==null);
		assertEquals(0, juego.getPuntaje());

				
		

}

public void testFueComido() {
	Map[] mapas=null;
	Juego juego= new Juego(mapas);
	int puntaje=100;
	
	Punto punto=new Punto(juego, puntaje);
	punto.fueComido();
	assertEquals(juego.getPuntaje(),100);
}



}
