package algo3.grupo7.algoman.modelo;

public class PuntoDePoder extends ItemComible {

	int tiempoDeEfecto;

	public PuntoDePoder(int nuevoPuntaje, int tiempoDeEfecto,
			Casillero casilleroActual) {
		super(nuevoPuntaje, true, casilleroActual,true);
		this.tiempoDeEfecto = tiempoDeEfecto;
	}

	public int getTiempDeEfecto() {
		return tiempoDeEfecto;
	}

}
