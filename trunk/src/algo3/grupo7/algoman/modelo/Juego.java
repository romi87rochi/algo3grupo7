package algo3.grupo7.algoman.modelo;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

import algo3.grupo7.algoman.vista.VistaMapa;
import algo3.grupo7.algoman.vista.VistaPacman;
import algo3.grupo7.algoman.vista.VistaBlinky;
import algo3.grupo7.algoman.vista.VistaPinky;
import algo3.grupo7.algoman.vista.VistaInky;
import algo3.grupo7.algoman.vista.VistaClyde;
import java.util.Iterator;

import java.util.ArrayList;

public class Juego {
	
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
		
		puntaje = 0;
		finJuego = false;
		finNivel = true;
		nivel = 0;
		
		this.pacman= new Pacman(this);
		this.blinky = new Blinky(this, pacman);
		this.pinky = new Pinky(this, pacman);
		this.inky = new Inky(this, pacman);
		this.clyde = new Clyde(this, pacman);
        this.controladorPacman=new Teclado(pacman);
        this.controlador = new ControladorJuego(this); 

   		}

	public void iniciar() {		
		controlador.comenzar();
	}
	
	public void cargarMapa(Tablero mapatest){
		this.mapa=mapatest;
		mapa.cargarTablero();
	;
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

	/*Devuelve la instanacia del mapa segun el nivel*/
	private Tablero devolverMapaDelNivel(int nivel){
		switch (nivel){
		case 1:
		 return new MapaNivel4();
		case 2: 
		 return new MapaNivel2();
		case 3:
			return new MapaNivel3();
        default:
        	return new MapaNivel1();
		}	
	}
	
	public void nuevoNivel(int nivel) {
		if (this.nivel <= 4) {
   			if (nivel!=1) //si no lo es no es necesario desvincular el mapa xq es el unico q hubo
            mapa.desvincular();
			controlador.vaciarControlador();
			this.mapa= devolverMapaDelNivel(nivel) ;//el primer mapa ya esta cargado
			this.agregarDibujablesMapa();
			mapa.cargarTablero();
			this.agregarDibujablesPastillas();
			this.cargarControlador();
			this.agregarFruta();
			this.cantPastillasDelNivel =this.getMapa().getCantidadPuntos();
   			this.finNivel = false;
		}else{
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			e.printStackTrace();}
	        controlador.vaciarControlador();
		}

	}

	/*Obtiene la lista de frutas del mapa y las agrega  a la lista de objetos vivos ya que estan
	 * pueden cambiar de estado(puedesercomido o no) cuando se le aplique el metodo vivir
	 */
    private void agregarFruta(){
    	ArrayList<ObjetoVivo> listaFruta=this.mapa.getFrutas();
    	Iterator<ObjetoVivo> itListaFruta = listaFruta.iterator();
    	   while(itListaFruta.hasNext()){
    		   this.controlador.agregarObjetoVivo(itListaFruta.next());
    	   }
    }
	public Tablero getMapa() {
		return mapa;
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
	}

	/*
	 * Finaliza el juego cuando la cantidad de vidas de pacman es cero.
	 */
	public void finalizarJuego() {
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