
import junit.framework.TestCase;

public class BlinkyTest extends TestCase {

	Blinky blinky;
	int velocidad;
	//int? estrategia;
	int posX;
	int posY;
	
	protected void setUp() throws Exception {
		super.setUp();
		velocidad = 1;
		//estrategia = ?;
		posX = 10;
		posY = 10;
		blinky = new Blinky(posX,posY,velocidad);
	}
	
	public void testComerErroneo() {
		try {
			blinky.comer();
			fail("Deberia lanzar excepcion por no poder comer a un fantasma");
		}
		catch(NoDeberiaSerComidoException e) {
			assertTrue(true);
		}
	}
	
	public void testComerOk() {
		try {
			blinky.cambiarEstado();
			blinky.comer();
			assertEquals(posX,blinky.getX());
			assertEquals(posY,blinky.getY());
		}
		catch(NoDeberiaSerComidoException e) {
			fail("Falla al intentar comer a un fantasma que puede ser comido");
		}
	}

}
