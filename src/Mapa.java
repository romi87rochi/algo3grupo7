
public class Mapa {
	private int FILAS = 200;
	private int COLUMNAS = 200;
	private int posiciones[][];
	private int cantPuntos;
	private int cantPower;
	private int cantFruta;

	public Mapa() {
		this.crearMapa();
	}

	private void cargarVacio (int y, int x){
//		Vacio
		// 1
		if (x >= 6   &&
			x <= 12  &&	
			x <= 183 && 
			x >= 177 &&
			y >= 6   &&
			y <= 12  
			){
			posiciones[x][y] = 2;
		}
		
		// 2
		if (y >= 6   &&
			y <= 12  &&
			y >= 174 &&
			y <= 168 &&
			x <= 183 &&
			x >= 177
			) {
			posiciones[x][y] = 2;
		}
		// 3
		if (x >= 6   &&
			x <= 12  &&	
			x <= 183 &&
			x >= 177 &&
			y >= 87  &&
			y <= 93  
			){
			posiciones[x][y] = 2;
		}
		// 4
		if (x >= 6 &&
			x <= 12 &&	
			x <= 183 &&
			x >= 177 &&
			y <= 183 &&
			y >= 177
			){
			posiciones[x][y] = 2;
		}
		// 5
		if (y >= 6   &&
			y <= 12  &&
		    y <= 174 &&
		    y >= 168 &&
		    x <= 12  &&
		    x >= 6
		    ){
			posiciones[x][y] = 2;
		}
		
	}
	private void cargarCamino (int y, int x){
		//		Camino
		// 1
		if (x >= 9 && x <= 180 && y == 9){
			posiciones[x][y] = 1;
		}
		
		// 2
		if (y >= 9 && y <= 171 && x == 180){
			posiciones[x][y] = 1;
		}
		// 3
		if (x >= 9 && x <= 180 && y == 90){
			posiciones[x][y] = 1;
		}
		// 4
		if (x >= 9 && x <= 180 && y == 180){
			posiciones[x][y] = 1;
		}
		// 5
		if (y >= 9 && y <= 171 && x == 9){
			posiciones[x][y] = 1;
		}
	}
	private void cargarPunto (int y, int x){
		int aux;
//		Pastilla
		// 3
		if (x >= 9 && x <= 180 && y == 90){
			aux = x %7;
			if (aux == 0){
				posiciones[x][y] = 3;
				this.adicionarPunto();
			}
		}
	}
	
	private void cargarPuntoPoder (int y, int x){
		
		if (x == 20 && y == 9){
			posiciones[x][y] = 5;
			this.adicionarPuntoDePoder();
		}
	}
	
	private void cargarFruta (int y, int x){
		
		if (x == 9 && y == 9){
			posiciones[x][y] = 4;
			this.adicionarFruta();
		}
	}
	
	private void crearMapa() {
		int y;
		
		for (int x = 0; x < FILAS; x++) {
			y = 0;
			for (y = 0; y < COLUMNAS; y++) {
			posiciones[x][y] = 0;
			this.cargarVacio(x,y);
			this.cargarCamino(x,y);
			this.cargarPunto(x,y);
			this.cargarPuntoPoder(x,y);
			this.cargarFruta(x,y);
				
			}
		}

	}

	public int[][] getPosiciones() {

		return this.posiciones;
	}
	
	public int getTipoPosicion(int x, int y){
		
		return this.posiciones[x][y];
	}


	public int getFilas() {

		return this.FILAS;
	}

	public int getColumnas() {

		return this.COLUMNAS;
	}

	

	private void adicionarPunto() {
		++this.cantPuntos;
	}
	
	private void adicionarFruta() {
		++this.cantFruta;
	}
	
	private void adicionarPuntoDePoder() {
		++cantPower;
	}


	public int getCantPuntos() {
		return cantPuntos;
	}
}
