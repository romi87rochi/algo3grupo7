package algo3.grupo7.algoman.modelo;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import algo3.grupo7.algoman.vista.VistaCasilleroCamino;

public abstract class Tablero {
	private int filas;
	private int columnas;
	private Casillero casilleros[][];
	private MatrizPosiciones posiciones;
	private int cantidadPuntos;
	private Casillero origenPacman;
	private Casillero origenFantasmas;

	public Casillero getOrigenPacman() {
		return origenPacman;
	}

	public void setOrigenPacman(Casillero origenPacman) {
		this.origenPacman = origenPacman;
	}

	public Casillero getOrigenFantasmas() {
		return origenFantasmas;
	}

	public void setOrigenFantasmas(Casillero origenFantasmas) {
		this.origenFantasmas = origenFantasmas;
	}

	/*
	 * El tablero es instancianciado con la cantidad de filas y columnas dadas,
	 * todos los casilleros no contienen personajes ni items.
	 */
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		casilleros = new Casillero[filas][columnas];
		posiciones = new MatrizPosiciones(filas, columnas);
		incializar();
		cantidadPuntos = 0;
	}

	private void incializar() {
		Posicion posAux = null;
		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				posAux = posiciones.obtenerPosicion(x, y);
				casilleros[x][y] = new Casillero(posAux, this);
			}
		}
	}

	protected void construirCaminoDesdeHasta(int desdeX, int hastaX,
			int desdeY, int hastaY, int puntajePunto) {

		int espacios = 0;
		for (int x = desdeX; x < hastaX + 1; x++) {
			for (int y = desdeY; y < hastaY + 1; y++) {
				casilleros[x][y].setHacerCamino();
				++espacios;
				// cada 10 casilleros camino inserta un punto
				if (espacios == 10) {
					casilleros[x][y].setItem(new Punto(puntajePunto));
					this.incrementarPunto();
					espacios = 0;
				}
			}
		}
	}

	private void incrementarPunto() {
		this.cantidadPuntos++;
	}

	protected int getCantidadPuntos() {
		return cantidadPuntos;
	}

	protected abstract void cargarContorno();

	protected abstract void cargarCaminosHorizontales();

	protected abstract void cargarCaminosVerticales();

	protected abstract void cargarPuntosDePoder();

	protected abstract void cargarFruta();

	public void cargarTablero() {
		this.cargarContorno();
		this.cargarCaminosHorizontales();
		this.cargarCaminosVerticales();
		this.cargarPuntosDePoder();
		this.cargarFruta();

	}

	protected Casillero[][] getMatCasilleros() {
		return casilleros;
	}

	public Casillero getCasillero(Posicion posicion) {
		return casilleros[posicion.getPosX()][posicion.getPosY()];
	}

	public void agregarDibujables(ControladorJuego control) {
		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				if (casilleros[x][y].puedeSerVisitado()) {
					System.out.print('l');
					VistaCasilleroCamino vistaCamino = new VistaCasilleroCamino();
					vistaCamino.setPosicionable(casilleros[x][y]);
					control.agregarDibujable(vistaCamino);

				} else {
					// control.agregarDibujable(vistaPared);
				}
				System.out.println();
			}
		}
	}
}
