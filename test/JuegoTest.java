

import junit.framework.TestCase;


public class JuegoTest extends TestCase {

	
	Mapa mapas;
	Juego juego; 
	Tablero tablero;
	
	public void setUp(){
		mapas=null;
		tablero= new Tablero();
		
		juego = new Juego(tablero); 
	}


	public void testConstructor(){
		assertNotNull(juego);
}

	public void testPrimerNivel(){
		setUp();
		assertEquals(0, juego.getNivel());
}
	

	public void testTerminaJuegoFalso(){
		setUp();
		assertFalse(juego.esFinJuego());
		
}


	public void testComeItems(){
		setUp();
		int puntaje=100;
		
		Pacman pacman=new Pacman(juego);

		Punto punto=new Punto(puntaje);
		Casillero celda=pacman.getCasilleroActual().getDerecha();
		celda.setItem(punto);
		//int itemsIniciales=juego.getCantPastillasDelNivel();
		pacman.mover(celda);
		
		
		assertTrue(pacman.getItemsComidos()==1);
}



	public void testIsFinJuego() {
			
		Pacman pacman=new Pacman(juego);
		pacman.morir();
		pacman.morir();
		pacman.morir();
		assertTrue(juego.esFinJuego());
	}



	public void testFinalizarJuego() {
		setUp();
		juego.finalizarJuego();
		assertTrue(juego.esFinJuego());
	}



}
