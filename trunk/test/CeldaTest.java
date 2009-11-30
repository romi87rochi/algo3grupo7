
import junit.framework.TestCase;


public class CeldaTest extends TestCase {

	public void testCeldaConDosFantasmas(){
		Celda celda = new Celda(1,1);
		Celda otracelda = new Celda(1,2);
		Juego juego = new Juego():
		juego.addCelda(celda);
		juego.addCelda(otracelda);
		
		Fantasma fan1 = new Fantasma(celda, juego);
		Fantasma fan2 = new Fantasma(otracelda, juego);
		
		fan1.vivir() // tendria que moverse a la otraCelda
		
		assert.isTrue(celda.estaVacia);
		assert.isTrue(fan1.getPsocions((), fan2.getposiocion()));
		
	}
	
	
	public void testCeldaConPacman(){
		Celda celda = new Celda(1,1);
		Celda otracelda = new Celda(1,2);
		Juego juego = new Juego():
		juego.addCelda(celda);
		juego.addCelda(otracelda);
		
		Fantasma fan1 = new Fantasma(celda, juego);
		Pacman pacman = new Pacman(otracelda, juego);
		
		fan1.vivir() // tendria que moverse a la otraCelda
		
		assert.isTrue(celda.estaVacia);
		assert.isTrue(fan1.getPsocions((), fan2.getposiocion()));
	}

	
	public void testPacmanComeFantasma(){
		Celda celda = new Celda(1,1);
		Celda otracelda = new Celda(1,2);

		Juego juego = new Juego():
		juego.addCelda(celda);
		juego.addCelda(otracelda);
		
		Fantasma fan1 = new Fantasma(celda, juego);
		Pacman pacman = new Pacman(otracelda, juego);
		pacman.setGroso();
		
		
		pacman.vivir() // tendria que moverse a la otraCelda
		
		
		posicion.esAdyacente(posicion)
		assert.isFalse(fan1.estavivio);

	}
}
