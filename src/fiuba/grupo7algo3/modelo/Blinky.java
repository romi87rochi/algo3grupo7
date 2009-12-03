
public class Blinky extends Fantasma{
    
    private int velocidad;

    public Blinky(Juego nuevoJuego, Personaje pacman ){
            super( nuevoJuego,pacman);
            this.velocidad=1;
            int tipoEstrategia=1;
            this.estrategia= new Estrategia(this, pacman,tipoEstrategia);
    }
    
    protected void reubicar() {
            Casillero casilleroAux = this.getCasilleroActual();

            /*
             * mueve el fantasma al casillero original y lo borra del casillero en
             * que se encontraba
             */
            this.setCasilleroActual(this.getTablero().getCasilleroOrigenFantasma());
            this.getCasilleroActual().agregarFantasma(this);
            casilleroAux.removerFantasma(this);

    }
    public void vivir(){
            int pasos=0;
            
            while(pasos<this.velocidad){  //ver cuando cambia de nivel
                    
                    this.mover(estrategia.proximoCasillero());   //VER!!!!
                    pasos++;
            }
            }
            

}