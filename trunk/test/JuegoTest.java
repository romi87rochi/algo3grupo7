public class JuegoTest extends TestCase{

	Juego juego;

	
	public void setUp() throws Exception {
		super.setUp();
		fantasmas= new ArrayList;
		pacman=new Pacman;
		// mapas??

		juego = new Juego(fantasmas,pacman, mapas); 
	}


	public void testConstructor(){

		assertNotNull(juego);
}

	public void testPrimerNivel(){

		juego.nuevoNivel();
		assertEquals(1, juego.getNivel());
}
	
	public void testcambiaEstadoDeLosFantasmas(){
		
		juego.cambiaEstadoDeLosFantasmas();
		assertEquals(false, juego.getPacman().getEstado()); // si pacman comio puntoDePoder, no puede ser                                                                     //comido			
}

	public void testTerminaJuegoFalso(){
		
		assertTrue(juego.getCantItemsDelNivel>0);
		assertFalse(juego.isFinJuego());
		
}


	public void testComeItems(){


		itemsIniciales=juego.getCantidadItemsDelNivel();
		juego.itemComido();
		assertTrue(itemsIniciales>juego.getCantidadItemsDelNivel());
}


	public void testBajaVidaPacman(){

		vidasIniciales= juego.getVidasPackman();
		juego.decrementarVidaPackman();
		asserTrue(vidasIniciales > juego.getVidasPackman());

}


}