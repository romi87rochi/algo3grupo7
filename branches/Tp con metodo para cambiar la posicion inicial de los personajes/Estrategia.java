package algo3.grupo7.algoman.modelo;
public class Estrategia {

	private int tipoDeEstrategia;
	private Personaje pacman;
	private Personaje fantasma;
	private Casillero casilleroAmoverse;
	private Casillero casilleroActual;
	private Casillero ultimoCasilleroFan;
	private Tablero tablero;
	private boolean continuar;

	/*
	 * pre: el numero de estrategia sera utilizado para realizar una combinacion
	 * para evaluar las coordenadas este numero debe estar comprendido de 1 a 4
	 */
	public Estrategia(Personaje fantasma, Personaje pacman, int tipoDeEstrategia) {
		this.tipoDeEstrategia = tipoDeEstrategia;
		this.pacman = pacman;
		this.fantasma = fantasma;
		this.casilleroActual = fantasma.getCasilleroActual();
		this.casilleroAmoverse = null;
		this.ultimoCasilleroFan = fantasma.getCasilleroActual();
		this.tablero = fantasma.getJuego().getMapa();
		this.continuar = true;
	}

	/*
	 * Devuelve un casillero al que de debera moverse el fantasma dependiendo de
	 * si puede ser comido o no
	 */
	public Casillero proximoCasillero() {
		continuar = true;
		casilleroActual = fantasma.getCasilleroActual();
		if (!fantasma.puedeSerComido()) {
			switch (tipoDeEstrategia) {
			case 1:
				combinacion1();
				break;
			case 2:
				combinacion2();
				break;
			case 3:
				combinacion3();
				break;
			case 4:
				combinacion4();
				break;
			}
		} else {
			combinacionEvasiva();
		}

		return casilleroAmoverse;
	}

	/*
	 * CombinacionX() dependiendo el numero(x) llama en diferente orden el tipo
	 * de coordenadas para evaluar
	 */
	private void combinacion1() {

		this.acercarsePorX();
		this.acercarsePorY();
		this.alejarsePorX();
		this.alejarsePorY();
	}

	private void combinacion2() {
		this.acercarsePorY();
		this.acercarsePorX();
		this.alejarsePorX();
		this.alejarsePorY();
	}

	private void combinacion3() {
		this.acercarsePorX();
		this.acercarsePorY();
		this.alejarsePorY();
		this.alejarsePorX();
		

	}

	private void combinacion4() {
		this.acercarsePorY();
		this.acercarsePorX();
		this.alejarsePorX();
		this.alejarsePorY();
	}

	/*
	 * Intenta huir de pacman hasta mientras que este no puede ser comido.
	 */
	private void combinacionEvasiva() {
		this.alejarsePorX();
		this.alejarsePorY();
		this.acercarsePorX();
		this.acercarsePorY();
	}

	/* Devuelve la posicion actual del pacman */
	private Posicion rastrearPacman() {
		return pacman.getCasilleroActual().getPosicion();

	}

	/*
	 * Comprueba que el casillero candidato no sea el mismo que el ultimo que
	 * estuvo el fantasma
	 */
	private boolean fueVisitado(Casillero casillero) {
		return ultimoCasilleroFan != casillero;
	}

	/*
	 * Comprueba si el casillero q sera visitado es pared o si la posicion ya
	 * fue visitada en el ultimo moviento
	 */
	private boolean puedeSerVisitado(Casillero casillero) {
		if ((casillero.puedeSerVisitado()) && (fueVisitado(casillero))) {
			return true;
		} else {
			return false;
		}
	}

	
	 /* Intenta acercarse un casillero al pacman por la coordenada X */
	 	private void acercarsePorX() {
		if (continuar && distintoX()) {
			Casillero casilleroAfavorX = getCasilleroIgualSentidoX();
			if (puedeSerVisitado(casilleroAfavorX)) {
				ultimoCasilleroFan = casilleroActual;
				casilleroAmoverse = casilleroAfavorX;
				continuar = false;
			}
		}
	}

	 	/* Intenta acercarse un casillero al pacman por la coordenada Y  */
	private void acercarsePorY() {
		if (continuar && distintoY()) {
			Casillero casilleroAfavorY = getCasilleroIgualSentidoY();
			if (puedeSerVisitado(casilleroAfavorY)) {
				ultimoCasilleroFan = casilleroActual;
				casilleroAmoverse = casilleroAfavorY;
				continuar = false;
			}
		}
	}

	/* Intenta alejarse un casillero respecto a Pacman por la coordenada X */
	private void alejarsePorX() {
		if (continuar) {
			Casillero casilleroContrarioX = this.getCasilleoSentidoOpuestoX();
			if (puedeSerVisitado(casilleroContrarioX)) {
				ultimoCasilleroFan = casilleroActual;
				casilleroAmoverse = casilleroContrarioX;
				continuar = false;
			}
		}
	}

	/* Intenta alejarse un casillero respecto a Pacman por la coordenada Y */
	private void alejarsePorY() {
		if (continuar) {
			Casillero casilleroContrarioY = this.getCasilleroSentidoOpuestoY();
			if (puedeSerVisitado(casilleroContrarioY)) {
				ultimoCasilleroFan = casilleroActual;
				casilleroAmoverse = casilleroContrarioY;
				continuar = false;
			}
		}
	}

	/*
	 * Devuelve el casillero adyacente contrario de la coordenada X respecto del
	 * Pacman
	 */
	private Casillero getCasilleoSentidoOpuestoX() {
		Posicion posActualFan = casilleroActual.getPosicion();
		int distanciaPacmanFantasma = rastrearPacman().getPosX()
				- posActualFan.getPosX();
		if ((distanciaPacmanFantasma > 0)) {
			return casilleroActual.getArriba();
		}
		if (distanciaPacmanFantasma < 0) {
			return casilleroActual.getAbajo();
		} else {
			/* en caso de que las coordenadas sean cero tiene que resolver si o
			 *si por esta razon
			 *se verifica que no se haya pisado antes el casillero y si el casillero candidato es una pared (ojo no 
			 *quitar esta comprobacion
			*/
			if (puedeSerVisitado(casilleroActual.getAbajo()) && (casilleroActual.getAbajo() != ultimoCasilleroFan)) {
				return casilleroActual.getAbajo();
			} else {
				return casilleroActual.getArriba();
			}
		}

	}

	/*
	 * Devuelve el casillero adyacente contrario de la coordenada Y respecto del
	 * Pacman
	 */
	private Casillero getCasilleroSentidoOpuestoY() {
		Posicion posActualFan = casilleroActual.getPosicion();
		int distanciaPacmanFantasma = rastrearPacman().getPosY()
				- posActualFan.getPosY();
		if ((distanciaPacmanFantasma > 0)) {
			return casilleroActual.getIzquierda();
		}
		if (distanciaPacmanFantasma < 0) {
			return casilleroActual.getDerecha();
		}
		// en caso de que las coordenadas sean cero tiene que resolver si o si
		// por esta
		// se verifica que no se haya pisado antes el casillero
		if (puedeSerVisitado(casilleroActual.getDerecha()) && (casilleroActual.getDerecha() != ultimoCasilleroFan) ) {
			return casilleroActual.getDerecha();
		} else {
			return casilleroActual.getIzquierda();
		}
	}

	/*
	 * Devuelve el casillero adyacente acercarcandose por la coordenada Y al
	 * pacman
	 */
	private Casillero getCasilleroIgualSentidoY() {
		Posicion posActualFan = casilleroActual.getPosicion();
		int distanciaPacmanFantasma = rastrearPacman().getPosY()
				- posActualFan.getPosY();
		if ((distanciaPacmanFantasma >= 0)) {
			return tablero.getCasillero(posActualFan.getDerecha());
		} else {
			return tablero.getCasillero(posActualFan.getIzquierda());
		}
	}

	/*
	 * Devuelve el casillero adyacente acercarcandose por la coordenada X al
	 * pacman
	 */
	/* Intenta acercarse por la coordenada X al pacman */
	private Casillero getCasilleroIgualSentidoX() {
		Posicion posActualFan = casilleroActual.getPosicion();
		int distanciaPacmanFantasma = rastrearPacman().getPosX()
				- posActualFan.getPosX();
		if ((distanciaPacmanFantasma >= 0)) {
			return tablero.getCasillero(posActualFan.getAbajo());
		} else {
			return tablero.getCasillero(posActualFan.getArriba());
		}
	}

	/*
	 * Comprueba que la coordenada X del fantasma tenga un valor distinto que la
	 * del pacman
	 */
	private boolean distintoX() {

		return rastrearPacman().getPosX() != casilleroActual.getPosicion()
				.getPosX();
	}

	/*
	 * Comprueba que la coordenada Y del fantasma sea igual que la del pacman
	 */
	/*
	 * Comprueba que la coordenada X del fantasma igual que la del pacman
	 */
	private boolean distintoY() {

		return rastrearPacman().getPosY() != casilleroActual.getPosicion()
				.getPosY();
	}
}
