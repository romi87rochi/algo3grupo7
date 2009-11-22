
import java.util.ArrayList;
import java.util.Iterator;

public class Casillero {

	private ArrayList fantasmas;
	private Pacman pacman;
    private Item item;
    private boolean puedeSerVisitado;
    

 /* El Casillero queda instanciado sin item ni personajes*/
public Casillero(){
	fantasmas=new ArrayList(); 
	item=null;
	pacman=null;
	puedeSerVisitado=true;
  
}

/*Agrega un nuevo fantasma al final de la lista*/
public void agregarFantama(Personaje nuevoFantasma){
	this.fantasmas.add(nuevoPersonaje);
}

/*Agrega un pacman al casillero*/
public void agregarPacman(Personaje nuevoPacman){
	this.pacman=nuevoPacman;
}

public void setItem(Item nuevoItem){
	item=nuevoItem;
	
	celdaDer = this.celda.getDerecha();
	this.celda.Sacarme(this);
	celdaDer.agregame(this);
}



/*quita el item del casillero cuando este es comido por pacman*/
public void removerItem(){
    item=null;
}

public Item getItem(){
		return item;
}


/*Quita un personaje de la lista, este metodo sera utilizado para que un personaje
 * pueda eliminar su posicion del casillero al desplazarse
 */
public void removerFantasma(Personaje estePersonaje){
	Iterator itFantasmas= fantasmas.iterator();
	boolean encontrado=false;
	  while (fantasmas.hasNext() && !encontrado){
	       if (itFantasmas.next()==estePersonaje){
	    	   itFantasmas.remove();
	    	   encontrado=true;
	       }
      }
  }

/*Devuelve una lista con todos los fantasmas que se encuntren 
 * en un casillero
 */
public ArrayList getFantasmas(){
	return this.fantasmas;
}

public void removerPacman(Personaje estePersonaje){
	pacman=null;
}

public Pacman getPacman(){
	return pacman;
}

}

