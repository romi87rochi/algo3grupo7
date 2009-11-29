public class Estrategia {

	private int tipoDeEstrategia;
	private Personaje pacman;
	private Posicion posActualFan;
	private Posicion ultimaPosFan;

	public Estrategia(Personaje pacman, int tipoDeEstrategia, Fantasma fantasma) {
		this.tipoDeEstrategia = tipoDeEstrategia;
		this.pacman = pacman;
		this.ultimaPosFan = fantasma.getCasilleroActual().getPosicion();  // si esta en null no puede fijarse si ya fue visitado, da nullpointexception
		this.posActualFan = fantasma.getCasilleroActual().getPosicion();
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
			return false;
		} else {
			return true;
		}
	}

	private Posicion irHaciaX() {
		if ((posActualFan.getPosX() > rastrearPacman().getPosX())
				&& (puedeSerVisitado(posActualFan.getIzquierda()))) {
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getIzquierda();
			return posActualFan;
		} else 
			return null;
	}

	private Posicion irHaciaY() {
		if ((posActualFan.getPosY() < rastrearPacman().getPosY())
				&& (puedeSerVisitado(posActualFan.getAbajo()))) {
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getAbajo();
			return posActualFan;
		}else
			return null;
	}

	private Posicion irContraX(){
		if ((posActualFan.getPosX()< rastrearPacman().getPosX()) && (puedeSerVisitado(posActualFan.getDerecha()))){
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getDerecha();
			return posActualFan;
		}else
			return null;
	}
	
	private Posicion irContray(){
		if ((posActualFan.getPosY()> rastrearPacman().getPosY()) && (puedeSerVisitado(posActualFan.getArriba()))){
			ultimaPosFan = posActualFan;
			posActualFan = posActualFan.getArriba();
			return posActualFan;
		}else
			return null;
	}
	
	
	//solo para probar!!!!!
	
	public Posicion proximoCasillero(){
		Posicion posiblePosicion=null;
		
		switch(this.tipoDeEstrategia){
			case 1: posiblePosicion=this.irContraX();
					if(posiblePosicion!=null)
						return  posiblePosicion;
			
					posiblePosicion=this.irContray();
					if(posiblePosicion!=null)
						return  posiblePosicion;
					
					posiblePosicion=this.irHaciaX();
					if(posiblePosicion!=null)
						return  posiblePosicion;
					
					posiblePosicion=this.irHaciaY();
					if(posiblePosicion!=null)
						return  posiblePosicion; 
					break;
					
				
		}
		return null;
		
		}
		
}
   