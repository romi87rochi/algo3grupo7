

import junit.framework.TestCase;
import java.util.ArrayList;

public class MatrizPosicionesTest extends TestCase {

	
	public static void main(String[] args) {
	
	}

	protected void setUp() throws Exception {
		super.setUp();
			
	}

	public void testObtenerPosicionArriba(){
		MatrizPosiciones matriz;
		matriz = new MatrizPosiciones(5,5);
		Posicion  posicion;
		Posicion  arriba1;
		Posicion  arriba2;
		ArrayList<Posicion> adyacentes;
		
		
		posicion   = matriz.obtenerPosicion(2,2);
		adyacentes = matriz.getAdyacente(posicion);
		arriba1    = (Posicion)adyacentes.get(0);
		arriba2    = posicion.getArriba();
		
		if (arriba1 == arriba2){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		System.out.println("Adyacente1 " + arriba1);
		System.out.println("Adyacente2 " + arriba2);
		
	}
	
	public void testObtenerPosicionAbajo(){
		MatrizPosiciones matriz;
		matriz = new MatrizPosiciones(5,5);
		Posicion  posicion;
		Posicion  abajo1;
		Posicion  abajo2;
		ArrayList<Posicion> adyacentes;
		
		
		posicion   = matriz.obtenerPosicion(2,2);
		adyacentes = matriz.getAdyacente(posicion);
		abajo1     = (Posicion)adyacentes.get(1);
		abajo2     = posicion.getAbajo();
		
		if (abajo1 == abajo2){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		System.out.println("Adyacente1 " + abajo1);
		System.out.println("Adyacente2 " + abajo2);
		
	}
	
	public void testObtenerPosicionIzquierda(){
		MatrizPosiciones matriz;
		matriz = new MatrizPosiciones(5,5);
		Posicion  posicion;
		Posicion  izquierda1;
		Posicion  izquierda2;
		ArrayList<Posicion> adyacentes;
		
		
		posicion   = matriz.obtenerPosicion(2,2);
		adyacentes = matriz.getAdyacente(posicion);
		izquierda1     = (Posicion)adyacentes.get(2);
		izquierda2     = posicion.getIzquierda();
		
		if (izquierda1 == izquierda2){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		System.out.println("Adyacente1 " + izquierda1);
		System.out.println("Adyacente2 " + izquierda2);
		
	}
	
	public void testObtenerPosicionDerecha(){
		MatrizPosiciones matriz;
		matriz = new MatrizPosiciones(5,5);
		Posicion  posicion;
		Posicion  derecha1;
		Posicion  derecha2;
		ArrayList<Posicion> adyacentes;
		
		
		posicion   = matriz.obtenerPosicion(2,2);
		adyacentes = matriz.getAdyacente(posicion);
		derecha1     = (Posicion)adyacentes.get(3);
		derecha2     = posicion.getDerecha();
		
		if (derecha1 == derecha2){
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
		System.out.println("Adyacente1 " + derecha1);
		System.out.println("Adyacente2 " + derecha2);
		
	}
	
}