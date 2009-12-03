
import junit.framework.TestCase;


public class PuntoTest extends TestCase {
	
	Juego juego;
	int puntaje;
	Punto punto;
	Pacman pacman;
	Fantasma fantasma;
	
	
	public void setUp(){
	MapaNivel1 mapa=new MapaNivel1();
		
		juego = new Juego(mapa); 
		puntaje=100;
		punto=new Punto(puntaje);
		pacman=new Pacman(juego);
		
		fantasma=new Blinky(juego,pacman);
		
	}
	
	public void testPuntoCreado(){
		
		assertNotNull(punto);

		}


	public void testComido(){
		Casillero celda=pacman.getCasilleroActual().getDerecha();
		celda.setItem(punto);
		
		pacman.mover(celda);
		
		
		assertTrue(juego.getPuntaje()>0);
		assertTrue(pacman.getCasilleroActual().getItem()==null);
			
}



	public void testGetPuntaje(){
		
		Casillero celda=pacman.getCasilleroActual().getDerecha();
		celda.setItem(punto);
		
		pacman.mover(celda);
		assertEquals(100, punto.getPuntaje());
}

// probar que desaparece cuando es comido por pacman y no desaparece cuando pasa un fantasma


	public void testNoComidoPorFantasma(){
		Mapa mapas=new Mapa();
		ItemComible punto=new Punto(puntaje);
		
		  //setItem de casillero deberia ser privado??
		pacman.mover(pacman.getCasilleroActual().getDerecha());
		
	
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		mapas.insertarPastillaDePoder(otraCelda, punto);
		
		mapas.insertarPastillaDePoder(otraCelda, punto);
		fantasma.mover(otraCelda);
	
		
		assertTrue(otraCelda.getItem()!=null);  // no desaparece item
		assertFalse(otraCelda.getFantasmas().get(0).puedeSerComido()); // no cambio estado de fantasma
		
	
		
	}
	

}
