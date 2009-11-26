import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;


public class JuegoTest extends TestCase {


	public void testConstructor(){
		Map[] mapas=null;

		Juego juego = new Juego( mapas); 
		assertNotNull(juego);
}

	public void testPrimerNivel(){
		Map[] mapas=null;

		Juego juego = new Juego( mapas); 

		assertEquals(0, juego.getNivel());
}
	
	public void testcambiaEstadoDeLosFantasmas(){
		Map[] mapas=null;

		Juego juego = new Juego( mapas); 
		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);

		Fantasma fan1=new Blinky(juego, posicion, velocidad);
		Fantasma fan2=new Blinky(juego, posicion, velocidad);
		Fantasma fan3=new Blinky(juego, posicion, velocidad);
		Casillero celda =juego.getTablero().getCasillero(posicion);
	
		celda.agregarFantasma(fan1);
		celda.agregarFantasma(fan2);
		celda.agregarFantasma(fan3);
		ArrayList<Fantasma> fantasmas=new ArrayList<Fantasma>();
		fantasmas=celda.getFantasmas();
		Iterator<Fantasma> it= fantasmas.iterator();
		juego.cambiarEstadoDeLosFantasmas();
		
		while(it.hasNext()){
			assertTrue(it.next().puedeSerComido()); //si comio punto de poder pueden ser comidos los fantasmas
}}

	public void testTerminaJuegoFalso(){
		Map[] mapas=null;

		Juego juego = new Juego( mapas); 
		assertFalse(juego.isFinJuego());
		
}


	public void testComeItems(){

		Map[] mapas=null;

		Juego juego = new Juego( mapas); 
		int puntaje=100;
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Punto punto=new Punto(juego, puntaje);
		celda.setItem(punto);
		int itemsIniciales=juego.getCantPastillasDelNivel();
		celda.getItem().fueComido();
		
		
		assertTrue(itemsIniciales>juego.getCantPastillasDelNivel());
}


	public void testBajaVidaPacman(){
		Map[] mapas=null;

		Juego juego = new Juego( mapas); 

		int vidasIniciales= juego.getVidasPackman();
		juego.decrementarVidaPackman();
		assertTrue(vidasIniciales > juego.getVidasPackman());

}



	public void testIsFinJuego() {
		Map[] mapas=null;

		Juego juego = new Juego( mapas);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		juego.conocerPacman(pacman);
		juego.decrementarVidaPackman();
		juego.decrementarVidaPackman();
		juego.decrementarVidaPackman();
		assertTrue(juego.isFinJuego());
	}

	public void testDecrementarVidaPackman() {
		Map[] mapas=null;

		Juego juego = new Juego( mapas);
		int velocidad=1;
		Posicion posicion=new Posicion(1, 1, null);
		Pacman pacman=new Pacman(juego,posicion, velocidad);
		juego.conocerPacman(pacman);
		juego.decrementarVidaPackman();
		
		assertTrue(juego.getVidasPackman()<3);
	}


	public void testFinalizarJuego() {
		Map[] mapas=null;

		Juego juego = new Juego( mapas);
		juego.finalizarJuego();
		assertTrue(juego.isFinJuego());
	}



}
