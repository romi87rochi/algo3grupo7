package algo3.grupo7.algoman.modelo;

public class Juego{

	private controlador; 
	public void inicializar(Panel superficioDeDibujo, panel panelDEePuntaje ) {

		/* creo un mapa y todas los personajes y todas las yerbas
		 * 
		 * crear un ControladorJuego (titiritero)
		 * 
		 * agrego los objetos vivos al controlador
		 * 
		 * creo las vistas -> new vistaBlinky(unBlinly);
		 * 
		 * 
		 * agregar las vistas al controlador 
		 * 
		 * 
		 */
		
		
		 controlador.agregarObjetoVivo(unaPelota);
		 controlador.agregarDibujable(vistaMesa);

	}

	public void comenzar() {
		controlador.comenzarJuego();
		
	}
	
	public void pausar(){
		controlador.pausar();
	}
}
