public class PuntoTest extends TestCase{

	Punto punto;

	
	public void setUp() throws Exception {
		super.setUp();

		punto = new punto(100); 
	}

	
	public void testPuntoCreado(){
		assertNotNull(punto);

		}


	public void testComido(){

		punto.comido(Juego unJuego);
		assertTrue(unJuego.getPuntaje()>0);		
}

	public void testGetPuntaje(){
		assertEquals(100, punto.getPuntaje());
}


// probar que no son comidos por fantasmas y si por pacman
// probar que cuando es comido deja de existir
}