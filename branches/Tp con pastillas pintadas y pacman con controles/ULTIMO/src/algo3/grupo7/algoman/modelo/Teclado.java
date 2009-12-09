package algo3.grupo7.algoman.modelo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {
	private Pacman pacman;

	public Teclado(Pacman pacman){
		this.pacman=pacman;
	   
   }



	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
			
			pacman.setProximaDireccion("arriba");
		if (key == KeyEvent.VK_DOWN)
			
			pacman.setProximaDireccion("abajo");
		if (key == KeyEvent.VK_RIGHT)
			
			pacman.setProximaDireccion("derecha");
		if (key == KeyEvent.VK_LEFT)
			
			pacman.setProximaDireccion("izquierda");
		
	}
}
