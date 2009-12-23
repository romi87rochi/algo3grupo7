package algo3.grupo7.algoman.Test;

import algo3.grupo7.algoman.modelo.Casillero;
import algo3.grupo7.algoman.modelo.Clyde;
import algo3.grupo7.algoman.modelo.Fantasma;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Pacman;
import junit.framework.TestCase;

public class EstrategiaTest extends TestCase {

	Juego juego;
	Pacman pacman;
	Fantasma fan1;

	
	 public void setUp(){
		  MapaParaPruebaEstrategia mapa=new MapaParaPruebaEstrategia();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir(); }
	

	  public void testFantasmaPersigue(){
		  
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
		MapaParaPruebaEstrategiaEvasiva mapa=new MapaParaPruebaEstrategiaEvasiva();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky();
		  
		  
		  fan1.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
		 //come pastilla de poder
		 
	      Casillero casilleroPacman=pacman.getCasilleroActual();
	      int distanciaInicial=(fan1.getCasilleroActual().getPosicion().getPosY() - casilleroPacman.getPosicion().getPosY());
	      fan1.vivir(); 
	      fan1.vivir(); 
		  int distanciaDespuesDeMoverse=(casilleroPacman.getPosicion().getPosY() - fan1.getCasilleroActual().getPosicion().getPosY());
		  assertTrue(distanciaInicial<distanciaDespuesDeMoverse); //fan1 esta mas cerca de Pacman
		  fan1.vivir();
		  int distanciaDespuesDeMoverse2Veces=(fan1.getCasilleroActual().getPosicion().getPosX() - casilleroPacman.getPosicion().getPosX());
		  assertTrue(distanciaDespuesDeMoverse<distanciaDespuesDeMoverse2Veces); //fan1 esta mas cerca de Pacman aun
		
	}
	
	public void testFantasmasEncierran(){
		
		 
		MapaCuadrado mapa=new MapaCuadrado();
		  juego= new Juego();
		  juego.cargarMapa(mapa);
		  pacman=juego.getPacman();
		  fan1=juego.getBlinky();
	     Clyde fan2=juego.getClyde();

		  fan1.vivir();
		  fan2.vivir();
		   while (!pacman.estaVivo()) //baja el tiempo de resurreccion
		       pacman.vivir();
	     
	     int distanciaPorXInicial=(pacman.getCasilleroActual().getPosicion().getPosX() - fan2.getCasilleroActual().getPosicion().getPosX());
	     int distanciaPorYInicial=(pacman.getCasilleroActual().getPosicion().getPosY() - fan1.getCasilleroActual().getPosicion().getPosY());
	     fan2.vivir();
	     fan1.vivir();
	     int distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - fan2.getCasilleroActual().getPosicion().getPosX());
	     int distanciaPorY=(pacman.getCasilleroActual().getPosicion().getPosY() - fan1.getCasilleroActual().getPosicion().getPosY());
		  
	     assertTrue(distanciaPorXInicial > distanciaPorX); //inky se acerca por x
	     assertTrue(distanciaPorYInicial>distanciaPorY);// fanq se acerca por y
	     
	     distanciaPorXInicial=distanciaPorX;
	     distanciaPorYInicial=distanciaPorY;
	     
	     fan2.vivir();
	     fan1.vivir();
	     distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - fan2.getCasilleroActual().getPosicion().getPosX());
	     assertTrue(distanciaPorXInicial > distanciaPorX); //inky se acerca por x
	     //fan1  quedo con misma coordenada y que pacman
	    
	     

	     distanciaPorYInicial=(pacman.getCasilleroActual().getPosicion().getPosY() - fan2.getCasilleroActual().getPosicion().getPosY());
	     distanciaPorXInicial=(pacman.getCasilleroActual().getPosicion().getPosX() - fan1.getCasilleroActual().getPosicion().getPosX());
	     fan2.vivir();
	     fan1.vivir();
	     distanciaPorY=(pacman.getCasilleroActual().getPosicion().getPosY() - fan2.getCasilleroActual().getPosicion().getPosY());
	     distanciaPorX=(pacman.getCasilleroActual().getPosicion().getPosX() - fan1.getCasilleroActual().getPosicion().getPosX());
		  
	     assertTrue(distanciaPorXInicial >= distanciaPorX); //inky se acerca por y ahora
	     assertTrue(distanciaPorYInicial>=distanciaPorY);// fanq se acerca por x ahora
	     
	     
	     
	}

}
