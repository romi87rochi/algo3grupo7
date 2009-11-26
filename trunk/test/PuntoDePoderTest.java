import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;


public class PuntoDePoderTest extends TestCase {

	
	public void testPuntoCreado(){
		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);
		int puntaje=100;
		ItemComible punto=new PuntoDePoder(unJuego, puntaje);
		assertNotNull(punto);

		}


	public void testComido(){
		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);
		
		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Pacman pacman=new Pacman(unJuego, posicion, velocidad);
		unJuego.conocerPacman(pacman);
		ItemComible punto=new PuntoDePoder(unJuego, puntaje);
		punto.fueComido();
		
		assertTrue(unJuego.getPuntaje()>0);		
			
}

	public void testGetPuntaje(){
		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);
		
		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Pacman pacman=new Pacman(unJuego, posicion, velocidad);
		unJuego.conocerPacman(pacman);
		ItemComible punto=new PuntoDePoder(unJuego, puntaje);
		punto.fueComido();
		assertEquals(100, punto.getPuntaje());
}

	public void testCambiaEstadoPacman(){


		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);
		
		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Pacman pacman=new Pacman(unJuego, posicion, velocidad);
		unJuego.conocerPacman(pacman);
		ItemComible punto=new PuntoDePoder(unJuego, puntaje);
		punto.fueComido();
		assertFalse(pacman.puedeSerComido()); //si comio punto de poder no puede ser comido
 
}


// probar que los fantasmas tambien cambian de estado

	public void testCambiaEstadoFantasmas(){

		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);

		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Pacman pacman=new Pacman(unJuego, posicion, velocidad);
		Fantasma fan1=new Blinky(unJuego, posicion, velocidad);
		Fantasma fan2=new Blinky(unJuego, posicion, velocidad);
		Fantasma fan3=new Blinky(unJuego, posicion, velocidad);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		celda.agregarFantasma(fan1);
		celda.agregarFantasma(fan2);
		celda.agregarFantasma(fan3);
		unJuego.conocerPacman(pacman);
		ItemComible punto=new PuntoDePoder(unJuego, puntaje);
		punto.fueComido();
		ArrayList<Fantasma> fantasmas=new ArrayList<Fantasma>();
		fantasmas=celda.getFantasmas();
		Iterator<Fantasma> it= fantasmas.iterator();
		
	while(it.hasNext()){
		assertTrue(it.next().puedeSerComido()); //si comio punto de poder pueden ser comidos los fantasmas
 } 
}



// probar que los fantasmas no comen los puntos de poder
	public void testFantasmasNoComenPuntoDePoder(){

		Map[] mapas=null;
		Juego unJuego=new Juego(mapas);

		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2,1,null);
		Fantasma fan1=new Blinky(unJuego, posicion, velocidad);
		
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		celda.agregarFantasma(fan1);
		
		ItemComible punto=new PuntoDePoder(unJuego, puntaje);
		otraCelda.setItem(punto);
		fan1.mover(otraPosicion);
		
		assertTrue(otraCelda.getItem()!=null);  // no desaparece item
		assertFalse(otraCelda.getFantasmas().get(0).puedeSerComido()); // no cambio estado de fantasma
		
	
		
	}
	
	
// probar que despues de un tiempo todos vuelven a su estado natural   <---- ver eso!!


}
