package algo3.grupo7.algoman.modelo;

import java.util.ArrayList;

import algo3.grupo7.algoman.vista.VistaFruta;
import algo3.grupo7.algoman.vista.VistaPastilla;
import algo3.grupo7.algoman.vista.vistaPuntoDePoder;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public abstract class Tablero {
	private int filas;
	private int columnas;
	private Casillero casilleros[][];
	private MatrizPosiciones posiciones;
	private int cantidadPuntos;
	private Casillero origenPacman;
	private Casillero origenFantasmas;
	private String directorioMapa;
	private ArrayList<Dibujable> vistasItemsComibles; 
	private ArrayList<ObjetoVivo> listaFrutas;

	/*
	 * El tablero es instancianciado con la cantidad de filas y columnas dadas,
	 * todos los casilleros no contienen personajes ni items.
	 */
	public Tablero(int filas, int columnas, String directorioMapa) {
		this.filas = filas;
		this.columnas = columnas;
		this.directorioMapa=directorioMapa;
		casilleros = new Casillero[filas][columnas];
		posiciones = new MatrizPosiciones(filas, columnas);
		incializar();
		vistasItemsComibles=new ArrayList<Dibujable>();
		listaFrutas=new ArrayList<ObjetoVivo>();
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
				if (espacios == 20) {
					Punto puntoTemp=new Punto(puntajePunto,this.getMatCasilleros()[x][y]);
					casilleros[x][y].setItem(new Punto(puntajePunto, this.getMatCasilleros()[x][y]));
					this.vistasItemsComibles.add(new VistaPastilla(puntoTemp));
					this.incrementarCantidadDePuntos();
					espacios = 0;
				}
			}
		}
	}

	protected void incrementarCantidadDePuntos() {
		this.cantidadPuntos++;
	}

	protected int getCantidadPuntos() {
		return cantidadPuntos;
	}

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

	public void cargarTablero() {
		this.cargarContorno();
		this.cargarCaminosHorizontales();
		this.cargarCaminosVerticales();
		this.cargarPuntosDePoder();
		this.cargarFruta();

	}
	
	protected abstract void cargarContorno();

	protected abstract void cargarCaminosHorizontales();

	protected abstract void cargarCaminosVerticales();

	protected abstract void cargarPuntosDePoder();

	protected abstract void cargarFruta();

	protected void posicionarPuntosDePoder(Casillero unCasillero,
			int puntaje, int tiempo) {
		PuntoDePoder unPuntoPoder = new PuntoDePoder(puntaje,tiempo, unCasillero);
		unCasillero.setItem(unPuntoPoder);
		this.getVistasItems().add(new vistaPuntoDePoder(unPuntoPoder));
		this.incrementarCantidadDePuntos(); 
	}
	

	protected void posicionarFruta(Casillero unCasillero,
			int puntaje) {
		Fruta fruta = new Fruta(puntaje, unCasillero);
		this.listaFrutas.add(fruta); 
		unCasillero.setItem(fruta);
		this.getVistasItems().add(new VistaFruta(fruta));
		this.incrementarCantidadDePuntos();
	}
	
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	protected Casillero[][] getMatCasilleros() {
		return casilleros;
	}

	public Casillero getCasillero(Posicion posicion) {
		return casilleros[posicion.getPosX()][posicion.getPosY()];
	}

	public Casillero[][] getCasilleros() {
		return casilleros;
	}
	
	public String getDirectorioMapa(){
		return this.directorioMapa;
	}
	

	public ArrayList<Dibujable> getVistasItems(){
		return this.vistasItemsComibles;
	}
	
	public ArrayList<ObjetoVivo> getFrutas(){
		return this.listaFrutas;
	}
	public void desvincular(){
		this.posiciones=null;
		this.casilleros=null;
	}
	// cuando no se quiera mostrar camino quitar agregar dibujables

}
