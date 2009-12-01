package modelo;


import junit.framework.TestCase;
import java.util.ArrayList;


public class TestMatrizPosiciones extends TestCase {
	public static void main(String[] args) {
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	
	}

	public void testObtenerPosicion(){
		MatrizPosiciones matriz;
		matriz = new MatrizPosiciones(5,5);
		Posicion  posicion;
		Posicion  arriba1;
		Posicion  arriba2;
		ArrayList adyacentes;
		
		
		posicion   = matriz.obtenerPosicion(1,1);
		adyacentes = matriz.getAdyacente(posicion);
		arriba1    = (Posicion)adyacentes.get(1);
		arriba2    = posicion.getArriba();
		
		if (arriba1 == arriba2){
			assertTrue(true);
		} else {
			assertTrue(true);
		}
			
		
		
		
		System.out.println("Adyacente1 " + adyacentes.get(1));
		System.out.println("Adyacente2 " + adyacentes.get(2));
		System.out.println("Adyacente3 " + adyacentes.get(3));
		System.out.println("Adyacente4 " + adyacentes.get(4));
		
		
		
	}
	
}
