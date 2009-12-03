

public class Juego {

    private Tablero tablero;
    private boolean finJuego;
    private int puntaje;
    private int cantPastillasDelNivel;
    private int nivel;
    private boolean finNivel;

    /*
     * El juego recibe una lista de fantasmas y otra de packman para que este
     * conozca a sus personajes. Mapas es un array de mapas predefinidos
     */
    public Juego(Tablero tablero) {

            this.tablero = tablero;
            //this.mapa = mapas;
            puntaje = 0;
            cantPastillasDelNivel=100;
            finJuego = false;
            finNivel=true;
            nivel = 0;
            this.iniciarJuego();

    }

    public void iniciarJuego() {
    		Mapa mapa=new Mapa();
            this.nuevoNivel(mapa);
            finNivel=false;
    }


    public void nuevoNivel(Mapa mapa){
            tablero.cargarTablero();
            cantPastillasDelNivel=mapa.getCantItems();
    }




    public Tablero getTablero() {
            return tablero;
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



    }