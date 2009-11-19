public class PuntoTest extends TestCase{

	Fruta fruta;

	
	public void setUp() throws Exception {
		super.setUp();

		fantasmas= new ArrayList;
		pacman=new Pacman;
		// mapas??

		unJuego = new Juego(fantasmas,pacman, mapas); 
		fruta = new Fruta(200); 
	}

	
	public void testPuntoCreado(){
		assertNotNull(fruta);

		}


	public void testComido(){

		fruta.comido(unJuego);
		assertTrue(unJuego.getPuntaje()>0);		
}

	public void testGetPuntaje(){
		assertEquals(200, fruta.getPuntaje());
}

// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma

}