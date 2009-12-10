package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Fantasma;
import algo3.grupo7.algoman.modelo.Inky;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;

public class estrategiaTest extends TestCase {

	Juego juego;
	Pacman pacman;
	Fantasma fan1;

	
	 public void setUp(){
		  MapaParaPruebaEstrategia mapa=new MapaParaPruebaEstrategia();
		  juego= new Juego();
		  juego.cargarMapa(mapa, 1);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky(); }
	

	  public void testFantasmaPersigue(){
		  MapaParaPruebaEstrategia mapa=new MapaParaPruebaEstrategia();
		  juego.cargarMapa(mapa, 1);
      Casillero casilleroPacman=pacman.getCasilleroActual();
      int distanciaInicial=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
      fan1.vivir(); 
	  int distanciaDespuesDeMoverse=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
	  assertTrue(distanciaInicial>distanciaDespuesDeMoverse); //fan1 esta mas cerca de Pacman
	  fan1.vivir();
	  int distanciaDespuesDeMoverse2Veces=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
	  assertTrue(distanciaDespuesDeMoverse>distanciaDespuesDeMoverse2Veces); //fan1 esta mas cerca de Pacman aun
	  fan1.vivir();
	  int distanciaDespuesDeMoverse3Veces=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
	  assertTrue(distanciaDespuesDeMoverse2Veces>distanciaDespuesDeMoverse3Veces); //fan1 esta mas cerca de Pacman aun
	  fan1.vivir();
	
	  
	  
}
	 

	public void testFantasmaEscapa() {
		  //pacman tiene la pastilla de poder a su izquierda
		  pacman.vivir(); //come pastilla de poder
		  MapaParaPruebaEstrategiaEvasiva mapa=new MapaParaPruebaEstrategiaEvasiva();
		  juego.cargarMapa(mapa, 1);
	      Casillero casilleroPacman=pacman.getCasilleroActual();
	      int distanciaInicial=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
	      fan1.vivir(); 
	      fan1.vivir(); 
		  int distanciaDespuesDeMoverse=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
		  assertTrue(distanciaInicial<distanciaDespuesDeMoverse); //fan1 esta mas cerca de Pacman
		  fan1.vivir();
		  int distanciaDespuesDeMoverse2Veces=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
		  assertTrue(distanciaDespuesDeMoverse<distanciaDespuesDeMoverse2Veces); //fan1 esta mas cerca de Pacman aun
		 fan1.vivir();
		  int distanciaDespuesDeMoverse3Veces=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
		  assertTrue(distanciaDespuesDeMoverse2Veces<distanciaDespuesDeMoverse3Veces); //fan1 esta mas cerca de Pacman aun
	}
	
	public void testFantasmasEncierran(){
		 MapaCuadrado mapa=new MapaCuadrado();
	     juego.cargarMapa(mapa, 1);
	     Inky inky=juego.getInky();
	     int distanciaPorXInicial=(pacman.getCasilleroActual().getPosicion().getPosX() - inky.getCasilleroActual().getPosicion().getPosX());
	     int distanciaPorYInicial=(pacman.getCasilleroActual().getPosicion().getPosY() - fan1.getCasilleroActual().getPosicion().getPosY());
	     inky.vivir();
	     fan1.vivir();
	     int distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - inky.getCasilleroActual().getPosicion().getPosX());
	     int distanciaPorY=(pacman.getCasilleroActual().getPosicion().getPosY() - fan1.getCasilleroActual().getPosicion().getPosY());
		  
	     assertTrue(distanciaPorXInicial > distanciaPorX); //inky se acerca por x
	     assertTrue(distanciaPorYInicial>distanciaPorY);// fanq se acerca por y
	     
	     distanciaPorXInicial=distanciaPorX;
	     distanciaPorYInicial=distanciaPorY;
	     
	     inky.vivir();
	     fan1.vivir();
	     distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - inky.getCasilleroActual().getPosicion().getPosX());
	     assertTrue(distanciaPorXInicial > distanciaPorX); //inky se acerca por x
	     //fan1  quedo con misma coordenada y que pacman
	    
	     

	     distanciaPorYInicial=(pacman.getCasilleroActual().getPosicion().getPosY() - inky.getCasilleroActual().getPosicion().getPosY());
	     distanciaPorXInicial=(pacman.getCasilleroActual().getPosicion().getPosX() - fan1.getCasilleroActual().getPosicion().getPosX());
	     inky.vivir();
	     fan1.vivir();
	     distanciaPorY=(pacman.getCasilleroActual().getPosicion().getPosY() - inky.getCasilleroActual().getPosicion().getPosY());
	     distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - fan1.getCasilleroActual().getPosicion().getPosX());
		  
	     assertTrue(distanciaPorXInicial > distanciaPorX); //inky se acerca por y ahora
	     //assertTrue(distanciaPorYInicial>distanciaPorY);// fanq se acerca por x ahora
	     
	     distanciaPorXInicial=distanciaPorX;
	     distanciaPorYInicial=distanciaPorY;
	     
	     inky.vivir();
	     fan1.vivir();
	     distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - inky.getCasilleroActual().getPosicion().getPosX());
	     assertTrue(distanciaPorXInicial > distanciaPorX); //inky se acerca por x
	     //fan1  quedo con misma coordenada y que pacman

	     
	     
	}

}
