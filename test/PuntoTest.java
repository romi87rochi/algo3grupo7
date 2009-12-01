
import junit.framework.TestCase;


public class PuntoTest extends TestCase {
	
	Mapa mapas;
	Juego unJuego;
	int puntaje;
	Punto punto;
	
	public void setUp(){
		mapas=null;
		unJuego=new Juego(mapas);
		puntaje=100;
		punto=new Punto(puntaje);
	}
	
	
	public void testPuntoCreado(){
		
		assertNotNull(punto);

		}


	public void testComido(){
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Pacman pacman=new Pacman(unJuego, celda);
		otraCelda.setItem(punto);  //no se si esta bien poner asi, habria que poner instertarPunto de Mapa(todavia no implementado)
		pacman.mover(otraCelda);
		
		assertTrue(unJuego.getPuntaje()>0);		
		
}



	public void testGetPuntaje(){
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Pacman pacman=new Pacman(unJuego, celda);
		otraCelda.setItem(punto);  //no se si esta bien poner asi, habria que poner instertarPunto de Mapa(todavia no implementado)
		pacman.mover(otraCelda);
		
		assertEquals(100, punto.getPuntaje());
}

// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


	public void testNoComidoPorFantasma(){
		
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicion=new Posicion(1,1,matriz);
		Posicion otraPosicion=new Posicion(2,1,matriz);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otracelda =unJuego.getTablero().getCasillero(otraPosicion);
		Posicion posicionPacman=new Posicion(3, 3, null);
		Casillero celdaPacman =unJuego.getTablero().getCasillero(posicionPacman);
		Pacman pacman=new Pacman(unJuego, celdaPacman);
		
		Blinky fan1 = new Blinky(unJuego,celda,pacman);
		celda.agregarFantasma(fan1);
		otracelda.setItem(punto);
		
		fan1.mover(otracelda);
	
		assertFalse(otracelda.getItem()==null);
		assertEquals(0, unJuego.getPuntaje());

				
		

}

}
