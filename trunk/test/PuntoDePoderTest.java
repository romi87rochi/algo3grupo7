

import junit.framework.TestCase;


public class PuntoDePoderTest extends TestCase {
	
	Juego juego;
	int puntaje;
	PuntoDePoder punto;
	Pacman pacman;
	int tiempo;
	Fantasma fantasma;
	
	
	public void setUp(){
	MapaNivel1 mapa=new MapaNivel1();
		
		juego = new Juego(mapa); 
		puntaje=100;
		tiempo=30;
		punto=new PuntoDePoder(puntaje,tiempo);
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

	public void testCambiaEstadoPacman(){

		Mapa mapas=new Mapa();
		int tiempoDePoder=4;
		ItemComible punto=new PuntoDePoder(puntaje,tiempoDePoder);
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		assertFalse(pacman.puedeSerComido()); //si comio punto de poder no puede ser comido
 
}


// probar que los fantasmas tambien cambian de estado

	public void testCambiaEstadoFantasmas(){
		
		Mapa mapas=new Mapa();
		int tiempoDePoder=4;
		ItemComible punto=new PuntoDePoder(puntaje,tiempoDePoder);
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		int i=0;
		
		while(i<3){
		Fantasma fantasmaEnCuestion=fantasma.getCasilleroActual().getFantasmas().get(0);
		fantasmaEnCuestion.vivir();
		assertTrue(fantasmaEnCuestion.puedeSerComido());
		i++;}
		
}



// probar que los fantasmas no comen los puntos de poder
	public void testFantasmasNoComenPuntoDePoder(){
		Mapa mapas=new Mapa();
		int tiempoDePoder=4;
		ItemComible punto=new PuntoDePoder(puntaje,tiempoDePoder);
		
		  //setItem de casillero deberia ser privado??
		pacman.mover(pacman.getCasilleroActual().getDerecha());
		
	
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		mapas.insertarPastillaDePoder(otraCelda, punto);
		
		mapas.insertarPastillaDePoder(otraCelda, punto);
		fantasma.mover(otraCelda);
	
		
		assertTrue(otraCelda.getItem()!=null);  // no desaparece item
		assertFalse(otraCelda.getFantasmas().get(0).puedeSerComido()); // no cambio estado de fantasma
		
	
		
	}
	
	
 //probar que despues de un tiempo todos vuelven a su estado natural 
 
	public void testTiempoDePoderSeAcaba(){
		
		Mapa mapas=new Mapa();
		int tiempoDePoder=2;
		ItemComible punto=new PuntoDePoder(puntaje,tiempoDePoder);
		Casillero otraCelda=pacman.getCasilleroActual().getDerecha();
		mapas.insertarPastillaDePoder(otraCelda, punto); 
		pacman.mover(otraCelda);
		
		mapas.insertarPastillaDePoder(otraCelda, punto); 
		pacman.mover(otraCelda);
	
		mapas.insertarPastillaDePoder(otraCelda, punto);
		pacman.mover(otraCelda); 
		fantasma.vivir(); //cambia estado
		
		assertFalse(pacman.puedeSerComido());//cambia estado, tiempo=2
		assertTrue(fantasma.puedeSerComido());
		
		pacman.mover(pacman.getCasilleroActual().getDerecha()); //tiempo=1
		assertFalse(pacman.puedeSerComido());
		assertTrue(fantasma.puedeSerComido());
	
		
		pacman.mover(otraCelda); //tiempo=0
		fantasma.vivir();
		assertTrue(pacman.puedeSerComido());
		assertFalse(fantasma.puedeSerComido());
		
		
	}


}
