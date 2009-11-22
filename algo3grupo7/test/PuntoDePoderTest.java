public class PuntoTest extends TestCase{

	PuntoDePoder punto;
	Juego juego;
	
	public void setUp() throws Exception {
		super.setUp();
		
		fantasmas= new ArrayList;
		pacman=new Pacman;
		// mapas??

		juego = new Juego(fantasmas,pacman, mapas); 
		puntoDePoder = new PuntoDePoder(juego,200); 
	}

	
	public void testPuntoCreado(){
		assertNotNull(punto);

		}


	public void testComido(){

		punto.comido(juego);
		assertTrue(Juego.getPuntaje()>0);		
}

	public void testGetPuntaje(){
		assertEquals(200, punto.getPuntaje());
}

	public void testCambiaEstado(){

		int x=pacman.getx();
		int y=pacman.gety();
		punto.comido(juego);
		Pacman pacmanActual= juego.getTablero().getCasillero(x,y).getPacman();
		assertTrue(pacmanActual.getEstado(),false); //si comio punto de poder no puede ser comido
 
}


// probar que los fantasmas tambien cambian de estado
// probar que los fantasmas no comen los puntos de poder
// probar que despues de un tiempo todos vuelven a su estado natural   <---- ver eso!!
}