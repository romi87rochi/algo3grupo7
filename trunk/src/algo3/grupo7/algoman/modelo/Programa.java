package algo3.grupo7.algoman.modelo;
import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.vista.Ventana;
import algo3.grupo7.algoman.vista.VentanaPrincipal;

public class Programa {
	public static void main(String[] args) {

		 
	Juego juego=new Juego();
	Pacman pac=juego.getPacman();
    Ventana ventana=new VentanaPrincipal(juego.getControlador(), pac);
    


    ventana.setVisible(true);
    juego.getControlador().setSuperficieDeDibujo(ventana);
    juego.iniciar();
    
    }
}
