package modelo;


import junit.framework.TestCase;


public class PuntoDePoderTest extends TestCase {
	
	Mapa mapas;
	Juego unJuego;
	int puntaje;
	int tiempoDePoder;
	ItemComible punto;
	
	public void setUp(){
		mapas=new Mapa();
		unJuego=new Juego(mapas);
		puntaje=100;
		tiempoDePoder=4;
		punto=new PuntoDePoder(puntaje,tiempoDePoder);
	}

	
	public void testPuntoCreado(){
		
		assertNotNull(punto);

		}


	public void testComido(){
		
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Pacman pacman=new Pacman(unJuego, celda);
		int tiempoDePoder=4;
		ItemComible punto=new PuntoDePoder(puntaje,tiempoDePoder);
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		
		assertTrue(unJuego.getPuntaje()>0);		
			
}

	public void testGetPuntaje(){
		
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Pacman pacman=new Pacman(unJuego, celda);
		int tiempoDePoder=4;
		ItemComible punto=new PuntoDePoder( puntaje,tiempoDePoder);
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		
		assertEquals(100, punto.getPuntaje());
}

	public void testCambiaEstadoPacman(){

		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2, 1, null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Pacman pacman=new Pacman(unJuego, celda);
		int tiempoDePoder=4;
		ItemComible punto=new PuntoDePoder(puntaje,tiempoDePoder);
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		assertFalse(pacman.puedeSerComido()); //si comio punto de poder no puede ser comido
 
}


// probar que los fantasmas tambien cambian de estado

	public void testCambiaEstadoFantasmas(){

		
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2,1,null);
		Posicion posicionFantasmas=new Posicion(2,2,null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Casillero celdaFantasmas =unJuego.getTablero().getCasillero(posicionFantasmas);
		Pacman pacman=new Pacman(unJuego, celda);
		Blinky fan1=new Blinky(unJuego, celdaFantasmas, pacman);
		Blinky fan2=new Blinky(unJuego, celdaFantasmas, pacman);
		Blinky fan3=new Blinky(unJuego, celdaFantasmas, pacman);
		
		celda.agregarPacman(pacman);
		celdaFantasmas.agregarFantasma(fan1);
		celdaFantasmas.agregarFantasma(fan2);
		celdaFantasmas.agregarFantasma(fan3);
		
		mapas.insertarPastillaDePoder(otraCelda, punto);  //setItem de casillero deberia ser privado??
		pacman.mover(otraCelda);
		int i=0;
		
		while(i<3){
		Blinky fantasmaEnCuestion=(Blinky)celdaFantasmas.getFantasmas().get(0);
		fantasmaEnCuestion.vivir();
		assertTrue(fantasmaEnCuestion.puedeSerComido());
		i++;}
		/*ArrayList<Fantasma> fantasmas=new ArrayList<Fantasma>();
		fantasmas=celdaFantasmas.getFantasmas();
		Iterator<Fantasma> it= fantasmas.iterator();
		
	  while(it.hasNext()){
		Blinky fantasma=(Blinky)it.next();
		fantasma.vivir();
		assertTrue(fantasma.puedeSerComido()); //si comio punto de poder pueden ser comidos los fantasmas
 } */
}



// probar que los fantasmas no comen los puntos de poder
	public void testFantasmasNoComenPuntoDePoder(){

		
		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2,1,null);
		Posicion posicionPacman=new Posicion(3,3,null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Casillero celdaPacman =unJuego.getTablero().getCasillero(posicionPacman);
		Pacman pacman=new Pacman(unJuego, celdaPacman);
		Blinky fan1=new Blinky(unJuego, celda, pacman);
		
		celda.agregarFantasma(fan1);
		celdaPacman.agregarPacman(pacman);
		

		mapas.insertarPastillaDePoder(otraCelda, punto);
		fan1.mover(otraCelda);
		
		assertTrue(otraCelda.getItem()!=null);  // no desaparece item
		assertFalse(otraCelda.getFantasmas().get(0).puedeSerComido()); // no cambio estado de fantasma
		
	
		
	}
	
	
 //probar que despues de un tiempo todos vuelven a su estado natural 
 
	public void testTiempoDePoderSeAcaba(){


		Posicion posicion=new Posicion(1, 1, null);
		Posicion otraPosicion=new Posicion(2,1,null);
		Posicion posicionPacman=new Posicion(3,3,null);
		Casillero celda =unJuego.getTablero().getCasillero(posicion);
		Casillero otraCelda =unJuego.getTablero().getCasillero(otraPosicion);
		Casillero celdaFantasma =unJuego.getTablero().getCasillero(posicionPacman);
		Pacman pacman=new Pacman(unJuego, celda);// fantasmas se va a mover de una celda a la otra todo el tiempo
		Blinky fan1=new Blinky(unJuego, celdaFantasma, pacman);  // el fantasma se va a quedar quieto en esta prueba
		
		celda.agregarPacman(pacman);
		celdaFantasma.agregarFantasma(fan1);
		
		int tiempoDePoder=2;
		ItemComible punto=new PuntoDePoder(puntaje, tiempoDePoder);
		mapas.insertarPastillaDePoder(otraCelda, punto);
		pacman.mover(otraCelda); //cambia estado, tiempo=2
		fan1.vivir(); //cambia estado
		
		assertFalse(pacman.puedeSerComido());
		assertTrue(fan1.puedeSerComido());
		
		pacman.mover(celda); //tiempo=1
		assertFalse(pacman.puedeSerComido());
		assertTrue(fan1.puedeSerComido());
	
		
		pacman.mover(celda); //tiempo=0
		fan1.vivir();
		assertTrue(pacman.puedeSerComido());
		assertFalse(fan1.puedeSerComido());
		
		
	}


}
