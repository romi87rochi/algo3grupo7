package algo3.grupo7.algoman.modelo;
import java.util.ArrayList;
import java.util.Iterator;

import algo3.grupo7.algoman.vista.Circulo;
import algo3.grupo7.algoman.vista.VistaPastilla;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Casillero implements Posicionable{

        private ArrayList<Fantasma> fantasmas;
        private Personaje pacman;
        private ItemComible item;
        private boolean puedeSerVisitado;
        private Posicion posicion;
        private Tablero tablero;
		
        
        public boolean getPuedeSerVisitado() {
                return puedeSerVisitado;
        }

        /* El Casillero queda instanciado sin item ni personajes */
        public Casillero(Posicion posicion,Tablero tablero) {
                this.tablero=tablero;
        		fantasmas = new ArrayList<Fantasma>();
                item = null;
                pacman = null;
                puedeSerVisitado = false;
                this.posicion = posicion;
                
        }

        /* Agrega un nuevo fantasma al final de la lista */
        public void agregarFantasma(Personaje nuevoFantasma) {
                this.fantasmas.add((Fantasma) nuevoFantasma);
        }

        /* Agrega un pacman al casillero */
        public void agregarPacman(Personaje nuevoPacman) {
                this.pacman = nuevoPacman;
        }

        public void setItem(ItemComible nuevoItem) {
                /*si no hay item lo remueve de los dibujables para que en la proxima 
                 * simulacion no se dibuje esa pastilla*/
                if(nuevoItem==null)
                	tablero.removerDibujable(this);
                item = nuevoItem;
        }

        public Posicion getPosicion() {
                return this.posicion;
        }

        /* quita el item del casillero cuando este es comido por pacman */
        public void removerItem() {
                
                tablero.removerDibujable(this);
                item = null;
                
        }

        public ItemComible getItem() {
                return item;
        }

        /*
         * Quita un personaje de la lista, este metodo sera utilizado para que un
         * personaje pueda eliminar su posicion del casillero al desplazarse
         */
        public void removerFantasma(Personaje estePersonaje) {
                Iterator<Fantasma> itFantasmas = this.fantasmas.iterator();
                boolean encontrado = false;
                while (itFantasmas.hasNext()) {
                        if (itFantasmas.next() == estePersonaje) {
                                itFantasmas.remove();
                                encontrado = true;
                        }
                }
        }

        /*
         * Devuelve una lista con todos los fantasmas que se encuntren en un
         * casillero
         */
        public ArrayList<Fantasma> getFantasmas() {
                return this.fantasmas;
        }

        public void removerPacman(Personaje estePersonaje) {
                pacman = null;
        }

        public Personaje getPacman() {
                return pacman;
        }

        public Casillero getArriba(){
                Casillero arriba = null;
                Posicion  posArriba = null;
                posArriba = this.posicion.getArriba();
                arriba = this.tablero.getCasillero(posArriba);
                return arriba;
        }
        public Casillero getAbajo(){
                Casillero abajo = null;
                Posicion  posAbajo = null;
                posAbajo = this.posicion.getAbajo();
                abajo = this.tablero.getCasillero(posAbajo);
                return abajo;
        }
        
        public Casillero getIzquierda(){
                Casillero izquierda = null;
                Posicion  posIzquierda = null;
                posIzquierda = this.posicion.getIzquierda();
                izquierda = this.tablero.getCasillero(posIzquierda);
                return izquierda;
        }
        
        public Casillero getDerecha(){
                Casillero derecha = null;
                Posicion  posDerecha = null;
                posDerecha = this.posicion.getDerecha();
                derecha = this.tablero.getCasillero(posDerecha);
                return derecha;
        }
        
        public boolean puedeSerVisitado(){
                return puedeSerVisitado;
        }
        
        public boolean hayPacman(){
                return pacman!=null;
        }
        
        public boolean hayItem(){
                return item!=null;
        }

        public void setHacerCamino() {
                this.puedeSerVisitado=true;
        }
        
		
		public int getX() {			
			return (this.getPosicion().getPosX());
		}

		
		public int getY() {
			return (this.getPosicion().getPosY());
		}

		

}