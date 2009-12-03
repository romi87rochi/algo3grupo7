
public class Main {
	public static void main(String[] lala){
		
		Mapa mapa=new Mapa();
		Juego juego=new Juego(mapa);
		Pacman pacman=new Pacman(juego);
		Fantasma fan1=new Blinky(juego,pacman);
		
		
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
		fan1.mover(fan1.getEstrategia().proximoCasillero());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosX());
		System.out.print(fan1.getCasilleroActual().getPosicion().getPosY());
		System.out.println();
	
		
	}

}
