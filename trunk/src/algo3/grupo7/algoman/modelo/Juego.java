package algo3.grupo7.algoman.modelo;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;

import algo3.grupo7.algoman.vista.VistaMapa;
import algo3.grupo7.algoman.vista.VistaPacman;
import algo3.grupo7.algoman.vista.VistaBlinky;
import algo3.grupo7.algoman.vista.VistaPinky;
import algo3.grupo7.algoman.vista.VistaInky;
import algo3.grupo7.algoman.vista.VistaClyde;
import java.util.Iterator;

import java.util.ArrayList;

public class Juego {

	private ArrayList<Tablero> tablero;
	
	private Tablero mapa;
	private boolean finJuego;
	private int puntaje;
	private int cantPastillasDelNivel;
	private int nivel;
	private boolean finNivel;
	private Pacman pacman;
	private Teclado controladorPacman;
	private Blinky blinky;
	private Pinky pinky;
	private Inky inky;
	private Clyde clyde; 
	private ControladorJuego controlador;

	/*
	 * El juego recibe una lista de fantasmas y otra de packman para que este
	 * conozca a sus personajes. Mapas es un array de mapas predefinidos
	 */

	public Juego() {

		this.tablero = new ArrayList<Tablero>();
		this.cargarMapas();
		puntaje = 0;

		finJuego = false;
		finNivel = true;
		nivel = 0;
		this.controlador = new ControladorJuego();
		this.mapa = tablero.get(0);
		this.pacman= new Pacman(this);
		this.blinky = new Blinky(this, pacman);
		this.pinky = new Pinky(this, pacman);
		this.inky = new Inky(this, pacman);
		this.clyde = new Clyde(this, pacman);
        this.controladorPacman=new Teclado(pacman);
   		this.nuevoNivel(this.nivel);

	}

	

	private void cargarMapas() {
		/* si tira error de heap, ingresar como parametros: -Xmx512m -Xms512m en
		 * Run Configurations
		 */
		this.tablero.add(new MapaNive4());
		this.tablero.add(new MapaNivel1());
		this.tablero.add(new MapaNivel2());
		this.tablero.add(new MapaNivel3());
		//this.tablero.add(new MapaNivel4());
	}

	public void cargarMapa(Tablero mapa, int nivel) {
		this.tablero.add(nivel, mapa);
		this.nuevoNivel(nivel);
	}

	public void iniciar() {
		finNivel = false;
		controlador.comenzar();
	}

	public void pausar() {
		this.controlador.detener();
	}
  

	private void cargarControlador() {
		

		VistaBlinky vistaBlinky = new VistaBlinky(blinky);
		VistaPinky vistaPinky = new VistaPinky(pinky);
		VistaInky vistaInky = new VistaInky(inky);
		VistaClyde vistaClyde = new VistaClyde(clyde);
		VistaPacman vistaPacman = new VistaPacman(pacman);

		this.controlador.agregarObjetoVivo(blinky);
		this.controlador.agregarObjetoVivo(pinky);
		this.controlador.agregarObjetoVivo(inky);
		this.controlador.agregarObjetoVivo(clyde);
		this.controlador.agregarObjetoVivo(pacman);

		this.controlador.agregarDibujable(vistaBlinky);
		this.controlador.agregarDibujable(vistaPinky);
		this.controlador.agregarDibujable(vistaInky);
		this.controlador.agregarDibujable(vistaClyde);
		this.controlador.agregarDibujable(vistaPacman);
		this.controlador.setIntervaloSimulacion(20);

	}

	public void nuevoNivel(int nivel) {
		if (this.nivel < tablero.size()) {
			controlador.removerTodosLosDibujables();
			controlador.removerTodosLosObjetosVivos();
			this.mapa = tablero.get(nivel);
			this.agregarDibujablesMapa();
			tablero.get(nivel).cargarTablero();
			/*
			 * se agregan pastillas en otro metodo porque sino se pinta el
			 * camino sobre ellas
			 */
			this.agregarDibujablesPastillas();
			this.cargarControlador();
			this.cantPastillasDelNivel =this.getMapa().getCantidadPuntos();
   			this.finNivel = false;
			if (this.nivel != 0)
			this.controlador.comenzar();
		}

	}

	public Tablero getMapa() {
		return mapa;
	}

	public ArrayList<Tablero> getTablero() {
		return this.tablero;
	}

	public boolean esFinJuego() {
		return finJuego;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public int getCantPastillasDelNivel() {
		return cantPastillasDelNivel;
	}

	/*
	 * Decrementa en una unidad la cantidad de items restantes del nivel actual
	 * cuando alguno de estos es comido
	 */

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public boolean esFinNivel() {
		return finNivel;
	}

	public void finalizarNivel() {
		finNivel = true;
		controlador.detener();
		this.setNivel(this.getNivel() + 1);
	    this.nuevoNivel(this.getNivel());
	}

	/*
	 * Finaliza el juego cuando la cantidad de vidas de pacman es cero.
	 */
	public void finalizarJuego() {
		controlador.detener();
		controlador.removerTodosLosDibujables();
		this.finJuego = true;
	}

	public void adicionarPuntajeItem(ItemComible item) {
		this.puntaje += item.getPuntaje();
	}

	public ControladorJuego getControlador() {
		return controlador;
	}

	private void agregarDibujablesMapa() {
		VistaMapa vistaMapa = new VistaMapa(this.getMapa().getDirectorioMapa());
		controlador.agregarDibujable(vistaMapa);
	}

	private void agregarDibujablesPastillas() {
          Iterator<Dibujable> itVistasPastillas= mapa.getVistasItems().iterator();
              while (itVistasPastillas.hasNext()){
                 controlador.agregarDibujable(itVistasPastillas.next());
              }   
	}
	
	public Teclado getControladorPacman(){
		return controladorPacman;
	}
   
	public Pacman getPacman(){
		return pacman;
	}
	
	public Blinky getBlinky() {
		return blinky;
	}

	public Pinky getPinky() {
		return pinky;
	}

	public Inky getInky() {
		return inky;
	}

	public Clyde getClyde() {
		return clyde;
	}

}