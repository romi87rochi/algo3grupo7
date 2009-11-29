public class Estrategia {

	private int tipoDeEstrategia;
	private Personaje pacman;
	private Posicion posActualFan;
	private Posicion ultimaPosFan;

	public Estrategia(Personaje pacman, int tipoDeEstrategia) {
		this.tipoDeEstrategia = tipoDeEstrategia;
		this.pacman = pacman;
		this.ultimaPosFan = null;
		this.posActualFan = null;
	}

	/* Devuelve la posicion actual del pacman */
	private Posicion rastrearPacman() {
		return pacman.getCasilleroActual().getPosicion();

	}

	private boolean fueVisitado(Posicion posAmover) {
		return ultimaPosFan.getPosX() == posAmover.getPosX()
				&& ultimaPosFan.getPosY() == posAmover.getPosY();
	}
   
	/*Comprueba si el casillero q sera visitado es pared o si 
	 * la posicion ya fue visitada en el ultimo moviento
	 */
	private boolean puedeSerVisitado(Posicion posicion) {
		if ((posicion != null) && (fueVisitado(posicion))) {
			return true;
		} else {
			return false;
		}
	}

	private void irHaciaX() {
		if ((posActualFan.getPosX() > rastrearPacman().getPosX())
				&& (puedeSerVisitado(posActualFan.getIzquierda()))) {
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getIzquierda();
		}
	}

	private void irHaciaY() {
		if ((posActualFan.getPosY() > rastrearPacman().getPosY())
				&& (puedeSerVisitado(posActualFan.getAbajo()))) {
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getAbajo();
		}
	}

	private void irContraX(){
		if ((posActualFan.getPosX()> rastrearPacman().getPosX()) && (puedeSerVisitado(posActualFan.getDerecha()))){
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getDerecha();
		}
	}
	
	private void irContray(){
		if ((posActualFan.getPosX()> rastrearPacman().getPosY()) && (puedeSerVisitado(posActualFan.getArriba()))){
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getArriba();
		}
	}
}
   