package algo3.grupo7.algoman.modelo;
public class Posicion {
    private int posX;
    private int posY;
    private MatrizPosiciones matriz;
    

    public Posicion(int posicionX, int posicionY, MatrizPosiciones matriz){
            
            this.matriz = matriz;
            this.posX   = posicionX;
            this.posY   = posicionY;
            
    }
    public int getPosX(){
            return posX;
    }
    
    public int getPosY(){
            return posY;
    }
    
    public Posicion getIzquierda(){
            Posicion arriba = null;
            int posX = this.posX;
            int posY = this.posY;
            posX--;
            
            arriba = this.matriz.obtenerPosicion(posX,posY);
            return arriba;
    }
    
    public Posicion getDerecha(){
            Posicion abajo = null;
            int posX = this.posX;
            int posY = this.posY;
            posX++;
            abajo = this.matriz.obtenerPosicion(posX,posY);
            return abajo;
    }       
    
    public Posicion getArriba(){
            Posicion izquierda = null;
            int posX = this.posX;
            int posY = this.posY;
            posY--;
            izquierda = this.matriz.obtenerPosicion(posX,posY);
            return izquierda;
    }       

    public Posicion getAbajo(){
            Posicion derecha = null;
            int posX = this.posX;
            int posY = this.posY;
            posY++;
            derecha = this.matriz.obtenerPosicion(posX,posY);
            return derecha;
    }       
    
    
}