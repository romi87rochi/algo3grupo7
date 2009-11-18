package game;
import java.util.ArrayList;
import java.util.Iterator;

public class Casillero {

	private ArrayList listaPersonajes;
    private Item item;
    

 /* El Casillero queda instanciado sin item ni personajes*/
public Casillero(){
	listaPersonajes=new ArrayList(); 
  
}

/*Agrega un nuevo personaje al final de la lista*/
public void agregarPersonaje(Personaje nuevoPersonaje){
	this.listaPersonajes.add(nuevoPersonaje);
}

public void setItem(Item nuevoItem){
	item=nuevoItem;
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
public void removerPersonaje(Personaje estePersonaje){
	Iterator itListaPersonajes= listaPersonajes.iterator();
	boolean encontrado=false;
	  while (itListaPersonajes.hasNext() && !encontrado){
	       if (itListaPersonajes.next()==estePersonaje){
	    	   itListaPersonajes.remove();
	    	   encontrado=true;
	       }
      }
  }
}

