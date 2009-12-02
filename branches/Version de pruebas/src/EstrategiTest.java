import junit.framework.TestCase;


public class EstrategiTest extends TestCase {
	Mapa mapas;

	Juego juego;
	Posicion posPacman;
	Posicion posFan;
	Casillero casilleroPacman;
	Casillero casilleroFan;

	
	
	public void setUp(){
		mapas=null;
         
		juego = new Juego( mapas);
		MatrizPosiciones matpos=juego.getTablero().getMatrizPos();
		posPacman=new Posicion(3, 1, juego.getTablero().getMatrizPos());
		posFan=new Posicion(5, 1,juego.getTablero().getMatrizPos());
		casilleroPacman =juego.getTablero().getCasillero(posPacman);
		casilleroFan =juego.getTablero().getCasillero(posFan);
        
        
        //modifico los casilleros para que sen pared
    Casillero cas1=    juego.getTablero().getCasillero(new Posicion (0,0,matpos));
    Casillero cas2=    juego.getTablero().getCasillero(new Posicion (0,1,matpos));
    Casillero cas3=    juego.getTablero().getCasillero(new Posicion (0,2,matpos));
    Casillero cas4 =   juego.getTablero().getCasillero(new Posicion (0,3,matpos));
    Casillero cas5=    juego.getTablero().getCasillero(new Posicion (0,4,matpos));
    Casillero cas6=    juego.getTablero().getCasillero(new Posicion (0,5,matpos));
    Casillero cas7=    juego.getTablero().getCasillero(new Posicion (1,0,matpos));
    Casillero cas8 =   juego.getTablero().getCasillero(new Posicion (2,0,matpos));
    Casillero cas9=    juego.getTablero().getCasillero(new Posicion (3,0,matpos));
    Casillero cas10 =   juego.getTablero().getCasillero(new Posicion (4,0,matpos));
    Casillero cas11=    juego.getTablero().getCasillero(new Posicion (5,0,matpos));
    Casillero cas12=    juego.getTablero().getCasillero(new Posicion (6,0,matpos));
    Casillero cas13=    juego.getTablero().getCasillero(new Posicion (6,1,matpos));
    Casillero cas14 =   juego.getTablero().getCasillero(new Posicion (6,2,matpos));
    Casillero cas15=    juego.getTablero().getCasillero(new Posicion (6,3,matpos));
    Casillero cas16=    juego.getTablero().getCasillero(new Posicion (6,4,matpos));
    Casillero cas17=    juego.getTablero().getCasillero(new Posicion (6,5,matpos));
    Casillero cas18=    juego.getTablero().getCasillero(new Posicion (5,5,matpos));
    Casillero cas19 =   juego.getTablero().getCasillero(new Posicion (4,5,matpos));
    Casillero cas20=    juego.getTablero().getCasillero(new Posicion (3,5,matpos));
    Casillero cas21 =   juego.getTablero().getCasillero(new Posicion (2,5,matpos));
    Casillero cas22=    juego.getTablero().getCasillero(new Posicion (1,4,matpos));
    Casillero cas23=    juego.getTablero().getCasillero(new Posicion (5,4,matpos));
    Casillero cas24=    juego.getTablero().getCasillero(new Posicion (1,5,matpos));
    Casillero cas25 =   juego.getTablero().getCasillero(new Posicion (2,5,matpos));
    Casillero cas26=    juego.getTablero().getCasillero(new Posicion (0,1,matpos));
    //esta es la T de costado
    Casillero cas27=    juego.getTablero().getCasillero(new Posicion (2,2,matpos));
    Casillero cas28=    juego.getTablero().getCasillero(new Posicion (3,2,matpos));
    Casillero cas29 =   juego.getTablero().getCasillero(new Posicion (4,2,matpos));
    Casillero cas30=    juego.getTablero().getCasillero(new Posicion (3,3,matpos));
    
    
    cas1.setHacerPared();
    cas2.setHacerPared();
    cas3.setHacerPared();
    cas4.setHacerPared();
    cas5.setHacerPared();
    cas6.setHacerPared();
    cas7.setHacerPared();
    cas8.setHacerPared();
    cas9.setHacerPared();
    cas10.setHacerPared();
    cas11.setHacerPared();
    cas12.setHacerPared();
    cas13.setHacerPared();
    cas14.setHacerPared();
    cas15.setHacerPared();
    cas16.setHacerPared();
    cas17.setHacerPared();
    cas18.setHacerPared();
    cas19.setHacerPared();
    cas20.setHacerPared();
    cas21.setHacerPared();
    cas22.setHacerPared();
    cas23.setHacerPared();
    cas24.setHacerPared();
    cas25.setHacerPared();
    cas26.setHacerPared();
    cas27.setHacerPared();
    cas28.setHacerPared();
    cas29.setHacerPared();
    cas30.setHacerPared();

 
	}

	
public void testMover() {
		
		//setUp();
		
		
		Pacman pacman=new Pacman(juego,casilleroPacman);
		Blinky fantasma=new Blinky(juego,casilleroFan,pacman);
		casilleroFan.agregarFantasma(fantasma);
		
		
		casilleroPacman.agregarPacman(pacman);
		
		
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int lol=fantasma.getCasilleroActual().getPosicion().getPosX();
		int lol2=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int lol1=fantasma.getCasilleroActual().getPosicion().getPosX();
		int lol4=fantasma.getCasilleroActual().getPosicion().getPosY();
		
		
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int lolaa=fantasma.getCasilleroActual().getPosicion().getPosX();
		int lola=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int load1aa=fantasma.getCasilleroActual().getPosicion().getPosX();
		int lofdfl4afd=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int loaddfa1aa=fantasma.getCasilleroActual().getPosicion().getPosX();
		int lofdfdfl4afd=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int loadsadfa1aa=fantasma.getCasilleroActual().getPosicion().getPosX();
		int loofdfdfl4afd=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int lodaddfa1aa=fantasma.getCasilleroActual().getPosicion().getPosX();
		int lfdfl4afd=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int lodsadfa1aa=fantasma.getCasilleroActual().getPosicion().getPosX();
		int ldfofdfdfl4afd=fantasma.getCasilleroActual().getPosicion().getPosY();
		/////
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int l1=fantasma.getCasilleroActual().getPosicion().getPosX();
		int l2=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int l3=fantasma.getCasilleroActual().getPosicion().getPosX();
		int l4=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int l5=fantasma.getCasilleroActual().getPosicion().getPosX();
		int l6=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int l7=fantasma.getCasilleroActual().getPosicion().getPosX();
		int l8=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int l9=fantasma.getCasilleroActual().getPosicion().getPosX();
		int l10=fantasma.getCasilleroActual().getPosicion().getPosY();
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		int l11=fantasma.getCasilleroActual().getPosicion().getPosX();
		int l12=fantasma.getCasilleroActual().getPosicion().getPosY();
		for(int x=1; x<=50; x++){
			fantasma.vivir();
		}
		
		assertEquals(pacman.estaVivo(),false);
		//assertEquals(fantasma.getCasilleroActual(), juego.getTablero().getCasillero(posFan.getIzquierda()));
		//fantasma.mover(fantasma.getEstrategia().proximoCasillero());
	/*	assertEquals(fantasma.getCasilleroActual(), juego.getTablero().getCasillero(posFan.getArriba()));
		assertEquals(fantasma.getCasilleroActual(), juego.getTablero().getCasillero(posFan.getArriba()));
		fantasma.mover(fantasma.getEstrategia().proximoCasillero());
		assertEquals(fantasma.getCasilleroActual(), juego.getTablero().getCasillero(posFan.getArriba()));
		*/
}
}
