package algo3.grupo7.algoman.modelo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

import algo3.grupo7.algoman.vista.VistaPacman;
import algo3.grupo7.algoman.vista.VistaBlinky;
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
    private Blinky blinky;
    private ControladorJuego controlador;

    
    /*  El juego recibe una lista de fantasmas y otra de packman para que este
     * conozca a sus personajes. Mapas es un array de mapas predefinidos */
     
    public Juego() {

            this.tablero = new ArrayList<Tablero>();
            this.cargarMapas();
            puntaje = 0;
            cantPastillasDelNivel=100;
            finJuego = false;
            finNivel=true;
            nivel = 0;
            this.controlador=new ControladorJuego();
            this.mapa=tablero.get(0);
            this.pacman=new Pacman(this);
            this.blinky=new Blinky(this, this.pacman);
            this.nuevoNivel(this.nivel);
            this.cargarControlador();
           // this.iniciar();

    }

    private void cargarMapas() {
		MapaNivel4 mapaNivel4=new MapaNivel4();
		//MapaNivel1 mapaNivel1=new MapaNivel1();
		//MapaNivel2 mapaNivel2=new MapaNivel2();
		//MapaNivel3 mapaNivel3=new MapaNivel3();
		this.tablero.add(mapaNivel4);
		//this.tablero.add(mapaNivel1);
		//this.tablero.add(mapaNivel2);
		//this.tablero.add(mapaNivel3);
	}
    
    public void cargarMapa(Tablero mapa, int nivel){
    	this.tablero.add(nivel, mapa);
    	this.nuevoNivel(nivel);
      }

	public void iniciar() {
            finNivel=false; 
            controlador.comenzar();
    }

	public void pausar(){
	   this.controlador.detener();	
	}
	
	private void cargarControlador(){
      VistaPacman vistaPacman=new VistaPacman();
      vistaPacman.setPosicionable(pacman);
      VistaBlinky vistaBlinky=new VistaBlinky();
      vistaBlinky.setPosicionable(blinky);
      
        this.controlador.agregarObjetoVivo(pacman);
		this.controlador.agregarObjetoVivo(blinky);
		this.controlador.agregarDibujable(vistaPacman);
		this.controlador.agregarDibujable(vistaBlinky);
		this.controlador.setIntervaloSimulacion(10);
	}
   
	public void nuevoNivel(int nivel){
	   this.mapa=tablero.get(nivel);
	      
            tablero.get(nivel).cargarTablero();
              	this.pacman.reubicar();
            	this.blinky.reubicar();
               	nivel++;
     //       cantPastillasDelNivel=tablero.getCantItems();
    }

    public Tablero getMapa() {
	return mapa;
}

	public ArrayList<Tablero> getTablero() {
            return this.tablero;
    }

    public Pacman getPacman() {
		return pacman;
	}

	public Blinky getBlinky() {
		return blinky;
	}

	public boolean esFinJuego() {
            return finJuego;
    }

    public void setFinJuego(boolean finJuego) {
            this.finJuego = finJuego;
    }

    public int getPuntaje() {
            return puntaje;
    }


    public int getCantPastillasDelNivel() {
            return cantPastillasDelNivel;
    }

    /*Decrementa en una unidad la cantidad de items restantes del nivel actual cuando 
     * alguno de estos es comido
     */
    public void pastillaComida(){
            --cantPastillasDelNivel;
    }


    public int getNivel() {
            return nivel;
    }

    public void setNivel(int nivel) {
            this.nivel = nivel;
    }

    public boolean esFinNivel(){
            return finNivel;
    }
    
    
    public void finalizarNivel(){
            finNivel=true;
    }
    /*Finaliza el juego cuando la cantidad de vidas de packman
     * es cero.
     */
    public void finalizarJuego(){
            this.finJuego=true;
    }       
    
    public void adicionarPuntajeItem(ItemComible item){
            this.puntaje =+ item.getPuntaje();
    }
    
    public Juego getJuego(){
    	return this;
    }
    
 
    
    public ControladorJuego getControlador(){
    	return controlador;
    }
    }