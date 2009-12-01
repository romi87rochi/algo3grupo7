

import junit.framework.TestCase;


public class JuegoTest extends TestCase {

	
	Mapa mapas;
	Juego juego; 
	
	public void setUp(){
		mapas=null;
		juego = new Juego( mapas); 
	}


	public void testConstructor(){
		setUp();
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
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicionPacman=new Posicion(3, 3, matriz);
		Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);
		Pacman pacman=new Pacman(juego,celdaPacman);

		Posicion posicion=new Posicion(3, 3, matriz);
		Casillero celda =juego.getTablero().getCasillero(posicion);
		Punto punto=new Punto(puntaje);
		celda.setItem(punto);
		//int itemsIniciales=juego.getCantPastillasDelNivel();
		pacman.mover(celda);
		
		
		//assertTrue(itemsIniciales>juego.getCantPastillasDelNivel());  //VER COMO HACERLO!!!!
}



	public void testIsFinJuego() {
		setUp();
		MatrizPosiciones matriz=new MatrizPosiciones(4,4);
		Posicion posicionPacman=new Posicion(3, 3, matriz);
		Casillero celdaPacman =juego.getTablero().getCasillero(posicionPacman);		
		Pacman pacman=new Pacman(juego,celdaPacman);
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
